/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Albex
 *
 */
public class And extends AbstractOperator {

	/**
	 * @param operands
	 */
	public And(Goal... operands) {
		super(operands);
	}

	/**
	 * @param operands
	 */
	public And(ArrayList<Goal> operands) {
		super(operands);
	}

	/* (non-Javadoc)
	 * @see model.Goal#getSolver(model.RuleSet, model.SubstitutionSet)
	 */
	@Override
	public AbstractSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution) throws CloneNotSupportedException {
		return new AndSolutionNode(this, rules, parentSolution);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String res = new String("AND(");
		for (int i = 0; i < this.operandCount() - 1; i++) {
			res += this.getOperand(i).toString() + ",";
		}
		res += this.getOperand(this.operandCount() - 1) + ")";
		
		return res;
	}

}
