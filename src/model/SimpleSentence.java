/**
 * 
 */
package model;

import java.util.Hashtable;

/**
 * @author Albex
 * 
 */
public class SimpleSentence implements Unifiable, Goal, Cloneable {

	protected Unifiable[] terms;

	/**
	 * 
	 */
	public SimpleSentence(Constant predicateName, Unifiable... args) {
		this.terms = new Unifiable[args.length + 1];
		this.terms[0] = predicateName;
		System.arraycopy(args, 0, this.terms, 1, args.length);
	}

	private SimpleSentence(Unifiable... args) {
		this.terms = args;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.Goal#getSolver(model.RuleSet, model.SubstitutionSet)
	 * 
	 */
	@Override
	public AbstractSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution) {
		return new SimpleSentenceSolutionNode(this, rules, parentSolution);
	}

	public int length() {
		return this.terms.length;
	}

	public Unifiable getTerm(int index) {
		return this.terms[index];
	}

	@SuppressWarnings("unused")
	private void setTerms(Unifiable... terms) {
		this.terms = terms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.PCExpression#replaceVariables(model.SubstitutionSet)
	 * 
	 */
	@Override
	public PCExpression replaceVariables(SubstitutionSet s) throws CloneNotSupportedException {
		// Create an array for new terms.
		Unifiable[] newTerms = new Unifiable[this.terms.length];
		
		// Replace each variable in the sentence
		for (int i = 0; i < this.terms.length; i++) {
			newTerms[i] = (Unifiable) this.terms[i].replaceVariables(s);
		}

		return new SimpleSentence(newTerms);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.PCExpression#standardizeVariablesApart(java.util.Hashtable)
	 */
	@Override
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) throws CloneNotSupportedException {
		// Create an array for new terms.
		Unifiable[] newTerms = new Unifiable[this.terms.length];

		// Standardize apart each term. Only variables will be affected.
		for (int i = 0; i < this.length(); i++) {
			newTerms[i] = (Unifiable) this.terms[i].standardizeVariablesApart(newVars);
		}

		return new SimpleSentence(newTerms);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.Unifiable#unfiy()
	 */
	@Override
	public SubstitutionSet unify(Unifiable expr, SubstitutionSet s) {
		// Case of a simple sentence
		if (expr instanceof SimpleSentence) {
			SimpleSentence s2 = (SimpleSentence) expr;

			// If they don't have the same length they can't be unified
			if (this.length() != s2.length()) {

				return null;
			} else {
				SubstitutionSet sNew = new SubstitutionSet(s);

				// Checking each argument if they can be unified
				for (int i = 0; i < this.length(); i++) {
					sNew = this.getTerm(i).unify(s2.getTerm(i), sNew);
					// If they a pair of argument can't be unified the whole can't be unified
					if (sNew == null) {

						return null;
					}
				}

				return sNew;
			}

		// Case of a variable: apply recursively the method
		} else if (expr instanceof Variable) {

			return expr.unify(this, s);

		// Otherwise (error or constant) they can't be unified
		} else {

			return null;
		}
	}

	@Override
	public String toString() {
		String s = null;

		s = this.terms[0].toString() + "(";
		for (int i = 1; i < this.terms.length - 1; i++) {
			s += this.terms[i].toString() + ",";
		}

		s += this.terms[this.terms.length - 1].toString() + ")";

		return s;
	}

}
