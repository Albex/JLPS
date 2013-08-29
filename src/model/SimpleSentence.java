/**
 * 
 */
package model;

import java.util.Hashtable;

/**
 * This class represents predicates. It implements {@link Unifiable} and {@link Clause}.
 * 
 * @author Alexandre Camus
 * 
 */
public class SimpleSentence implements Unifiable, Clause {

	private Unifiable[] terms;
	private boolean isMatched = false;

	/**
	 * Constructor of the class.
	 * 
	 * @param predicateName
	 *            the {@code Constant} representing the name of the predicate
	 *            that is represented.
	 * @param args
	 *            the parameters of this predicate in an array or as independent
	 *            arguments.
	 */
	public SimpleSentence(Constant predicateName, Unifiable... args) {
		this.terms = new Unifiable[args.length + 1];
		this.terms[0] = predicateName;
		System.arraycopy(args, 0, this.terms, 1, args.length);
	}

	/**
	 * Constructor of the class.
	 * 
	 * @param args
	 *            the name and the parameters of this predicate in an array or
	 *            as independent arguments.
	 */
	private SimpleSentence(Unifiable... args) {
		this.terms = args;
	}

	/**
	 * Creates a solver which is a node in the tree proof. This is the version
	 * for the simple sentence.
	 * <p>
	 * This function is recursive over all objects that can be proved and
	 * creates the tree of proof for a clause.
	 * 
	 * @param rules
	 *            the {@code RuleSet} object containing the rules of knowledge.
	 * @param parentSolution
	 *            the solution known so far at the parent node.
	 * @return the node of the tree of proof.
	 * @see Clause#getSolver(RuleSet, SubstitutionSet)
	 */
	@Override
	public SimpleSentenceSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution, AbstractSolutionNode parentNode) {
		return new SimpleSentenceSolutionNode(this, rules, parentSolution, parentNode);
	}

	/**
	 * Gets the length which is the number of parameters plus the name of the
	 * simple sentence. It counts the number of {@code Constant} and
	 * {@code Variable} objects used to represent the simple sentence.
	 * 
	 * @return the number of parameters plus the name of the simple sentence.
	 */
	public int length() {
		return this.terms.length;
	}

	/**
	 * Gets the term at the specified index. The index is the position of the
	 * parameter.
	 * 
	 * @param index
	 *            the position of the parameter.
	 * @return the parameter at the specified position.
	 */
	public Unifiable getTerm(int index) {
		return this.terms[index];
	}

	/**
	 * Sets the terms to the new specified terms. The old terms and their number
	 * will be erase by this update. Terms can be specified as an array or as
	 * independent inputs.
	 * 
	 * @param terms
	 *            the new terms of the simple sentence. It can be an array or
	 *            independent inputs, one for each new term.
	 */
	@SuppressWarnings("unused")
	private void setTerms(Unifiable... terms) {
		this.terms = terms;
	}
	
	/**
	 * Gets the name of the simple sentence. It is the name of the predicate or
	 * the functor.
	 * 
	 * @return the name of the simple sentence.
	 * @see model.Unifiable#getName()
	 */
	public String getName() {
		return this.terms[0].toString();
	}
	
	/**
	 * Checks whether the name of the simple sentence matches so far a rule in the database.
	 * 
	 * @return true if so far the simple sentence's name matches a rule.
	 */
	public boolean isMatched() {
		return this.isMatched;
	}

	/**
	 * Replaces all the variables in the simple sentence according to the
	 * specified bindings.
	 * <p>
	 * This method is recursive over all {@link PCExpression} implementations.
	 * 
	 * @param s
	 *            the {@code SubstitutionSet} that contains the bindings of the
	 *            variables so far.
	 * @return a {@code SimpleSentence} object representing the bound simple
	 *         sentence.
	 * @see model.PCExpression#replaceVariables(model.SubstitutionSet)
	 */
	@Override
	public SimpleSentence replaceVariables(SubstitutionSet s) {
		// Create an array for new terms.
		Unifiable[] newTerms = new Unifiable[this.terms.length];
		
		// Replace each variable in the sentence
		for (int i = 0; i < this.terms.length; i++) {
			newTerms[i] = (Unifiable) this.terms[i].replaceVariables(s);
		}

		return new SimpleSentence(newTerms);
	}

	/**
	 * Standardizes the variables in order to be sure that there won't be any
	 * variable clashes.
	 * <p>
	 * This method is recursive over all {@code PCExpression} implementations.
	 * 
	 * @param newVars
	 *            is a parameter to save over the recursion all the variable
	 *            replacements done so far.
	 * @return a {@code SimpleSentence} object representing the standardized
	 *         simple sentence.
	 * @see model.PCExpression#standardizeVariablesApart(java.util.Hashtable)
	 */
	@Override
	public SimpleSentence standardizeVariablesApart(Hashtable<Variable, Variable> newVars) {
		// Create an array for new terms.
		Unifiable[] newTerms = new Unifiable[this.terms.length];

		// Standardize apart each term. Only variables will be affected.
		for (int i = 0; i < this.length(); i++) {
			newTerms[i] = (Unifiable) this.terms[i].standardizeVariablesApart(newVars);
		}

		return new SimpleSentence(newTerms);
	}

	/**
	 * Unifies the simple sentence with the specified {@code expr} expression
	 * given the bindings {@code s}. This tries to get or add bindings in order
	 * to make logically equivalent the simple sentence and the specified
	 * expression.
	 * <p>
	 * This method is recursive over all {@code Unifiable} implementations.
	 * 
	 * @param expr
	 *            an expression to unify with the simple sentence.
	 * @param s
	 *            the {@code SubstitutionSet} object representing the bindings
	 *            so far and/or the constraints applied.
	 * @return a {@code SubstitutionSet} object that contains all the bindings
	 *         needed to unify the simple sentence to the specified expression.
	 * @see model.Unifiable#unify(Unifiable, SubstitutionSet)
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
					
					// If a pair of argument can't be unified the whole can't be unified
					if (sNew == null) {
						
						return null;
					}
					this.isMatched = true;
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
	
	/**
	 * Checks if the simple sentence and the specified {@code expr} expression
	 * given the bindings {@code s} are equal. This tries to get bindings in
	 * order to make logically equivalent the simple sentence and the specified
	 * expression.
	 * <p>
	 * This method is recursive over all {@code Unifiable} implementations.
	 * 
	 * @param expr
	 *            an expression to unify with the expression.
	 * @param s
	 *            the {@code SubstitutionSet} object representing the bindings
	 *            so far and/or the constraints applied.
	 * @return true if the specified bindings make logically equivalent the
	 *         simple sentence and the specified one.
	 * @see model.Unifiable#equal(Unifiable, SubstitutionSet)
	 */
	public boolean equal(Unifiable expr, SubstitutionSet s) {
		// Case of a simple sentence
		if (expr instanceof SimpleSentence) {
			SimpleSentence s2 = (SimpleSentence) expr;

			// If they don't have the same length they can't be unified
			if (this.length() != s2.length()) {

				return false;
			} else {
				// Checking each argument if they can be unified
				for (int i = 0; i < this.length(); i++) {
					if (!this.getTerm(i).equal(s2.getTerm(i), s)) {
						
						return false;
					}
				}

				return true;
			}

		// Case of a variable: apply recursively the method
		} else if (expr instanceof Variable) {

			return expr.equal(this, s);

		// Otherwise (error or constant) they can't be unified
		} else {

			return false;
		}
	}

	/**
	 * Returns the simple sentence under the form of:
	 * "predicateName(parameter1, parameter2, ...)".
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = null;

		s = this.terms[0].toString() + "(";
		for (int i = 1; i < this.terms.length; i++) {
			if (i == this.terms.length - 1) {
				s += this.terms[i].toString();
			} else {
				s += this.terms[i].toString() + ", ";
			}
		}

		s += ")";

		return s;
	}

}
