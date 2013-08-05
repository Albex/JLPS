/**
 * 
 */
package model;

import java.util.Hashtable;

/**
 * This class represents equal clauses. It is a binary operator. It extends
 * {@link Clause}.
 * <p>
 * Equal clauses are useless as the use of constants or identical variables
 * replaces it. The purpose of this class is to represent negative equalities.
 * 
 * @author Alexandre Camus
 * 
 */
public class Equal implements Clause {
	
	Variable operand1;
	Unifiable operand2;

	/**
	 * Constructor of the class
	 * 
	 * @param operand1
	 *            the left operand of the equal sentence. It must be a variable.
	 * @param operand2
	 *            the right operand of the equal sentence.
	 */
	public Equal(Variable operand1, Unifiable operand2) {
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	/**
	 * Gets the left operand of the equal sentence.
	 * 
	 * @return the left operand of the equal sentence.
	 */
	public Variable getOperand1() {
		return this.operand1;
	}
	
	/**
	 * Gets the right operand of the equal sentence.
	 * 
	 * @return the right operand of the equal sentence.
	 */
	public Unifiable getOperand2() {
		return this.operand2;
	}

	/**
	 * Creates a solver which is a node in the tree proof. This is the version
	 * for the equality.
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
	public AbstractSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution) {
		return new EqualSolutionNode(this, rules, parentSolution);
	}

	/**
	 * Replaces all the variables in the variable according to the specified
	 * bindings. This returns the clause to which the variable has been bound.
	 * <p>
	 * This method is recursive over all {@link PCExpression} implementations.
	 * This is a terminal case.
	 * 
	 * @param s
	 *            the {@code SubstitutionSet} that contains the bindings of the
	 *            variables so far.
	 * @return a {@code Equal} object representing the bound equality.
	 * @see model.PCExpression#replaceVariables(model.SubstitutionSet)
	 */
	@Override
	public Equal replaceVariables(SubstitutionSet s) {
		Variable newOperand1 = (Variable) this.operand1.replaceVariables(s);
		Unifiable newOperand2 = (Unifiable) this.operand2.replaceVariables(s);
		
		return new Equal(newOperand1, newOperand2);
	}

	/**
	 * Standardizes the variables in order to be sure that there won't be any
	 * variable clashes. This returns a copy of the variable but with a
	 * different id.
	 * <p>
	 * This method is recursive over all {@code PCExpression} implementations.
	 * This is a terminal case.
	 * 
	 * @param newVars
	 *            is a parameter to save over the recursion all the variable
	 *            replacements done so far.
	 * @return a {@code Equal} object representing the standardized equality.
	 * @see model.PCExpression#standardizeVariablesApart(java.util.Hashtable)
	 */
	@Override
	public Equal standardizeVariablesApart(Hashtable<Variable, Variable> newVars) {
		Variable newOperand1 = (Variable) this.operand1.standardizeVariablesApart(newVars);
		Unifiable newOperand2 = (Unifiable) this.operand2.standardizeVariablesApart(newVars);
		
		return new Equal(newOperand1, newOperand2);
	}
	
	/**
	 * Returns the negative clause under the form of:
	 * "operand1 == operand2".
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.operand1.toString() + " == " + this.operand2.toString();
	}

}
