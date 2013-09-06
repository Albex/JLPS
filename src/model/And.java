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
	 * Constructor of the class.
	 * 
	 * @param operands
	 *            the operands of the and-operator in an array or as independent
	 *            variables.
	 */
	public And(Clause... operands) {
		super(operands);
	}

	/**
	 * Constructor of the class.
	 * 
	 * @param operands
	 *            the operands of the and-operator in an {@code ArrayList}
	 *            object.
	 */
	public And(ArrayList<Clause> operands) {
		super(operands);
	}
	
	/**
	 * Generic constructor of the object. It allows the methods of the abstract
	 * class {@code AbstractOperator} to create the correct object very easily.
	 * 
	 * @param operands
	 *            the operands of the and-operator in an {@code ArrayList}
	 *            object.
	 * 
	 * @see model.AbstractOperator#create(java.util.ArrayList)
	 */
	@Override
	protected And create(ArrayList<Clause> operands) {
		return new And(operands);
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
	 * @param parentNode
	 *            the parent node in the tree.
	 * @return the node of the tree of proof.
	 * @see Clause#getSolver(RuleSet, SubstitutionSet, AbstractSolutionNode)
	 */
	@Override
	public AndSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution, AbstractSolutionNode parentNode) {
		return new AndSolutionNode(this, rules, parentSolution, parentNode);
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
