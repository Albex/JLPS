/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * This class represents and-clauses. It is a n-ary operator. It extends
 * {@link AbstractOperator}.
 * 
 * @author Alexandre Camus
 * 
 */
public class And extends AbstractOperator {
	
	/**
	 * Empty constructor of the class. This has no use except for the methods
	 * {@link AbstractOperator#standardizeVariablesApart(java.util.Hashtable)
	 * standardizeVariablesApart()} and
	 * {@link AbstractOperator#replaceVariables(SubstitutionSet)
	 * replaceVariables()}.
	 */
	public And() {
	}

	/**
	 * Constructor of the class.
	 * 
	 * @param operands
	 *            the operands of the and-operator in an array or as independent
	 *            variables.
	 */
	public And(Goal... operands) {
		super(operands);
	}

	/**
	 * Constructor of the class.
	 * 
	 * @param operands
	 *            the operands of the and-operator in an {@code ArrayList}
	 *            object.
	 */
	public And(ArrayList<Goal> operands) {
		super(operands);
	}

	/**
	 * Creates a solver which is a node in the tree proof. This is the version
	 * for the and operator.
	 * <p>
	 * This function is recursive over all objects that can be proved and
	 * creates the tree of proof for a clause.
	 * 
	 * @param rules
	 *            the {@code RuleSet} object containing the rules of knowledge.
	 * @param parentSolution
	 *            the solution known so far at the parent node.
	 * @return the node of the tree of proof.
	 * @see Goal#getSolver(RuleSet, SubstitutionSet)
	 * @throws CloneNotSupportedException
	 */
	@Override
	public AndSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution) throws CloneNotSupportedException {
		return new AndSolutionNode(this, rules, parentSolution);
	}

	/**
	 * Returns the and-clause under the form of:
	 * "operand1 & operand2 & ...".
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String res = new String();
		for (int i = 0; i < this.operandCount() - 1; i++) {
			res += this.getOperand(i).toString() + " & ";
		}
		res += this.getOperand(this.operandCount() - 1);
		
		return res;
	}

}
