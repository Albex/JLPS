/**
 * 
 */
package model;

/**
 * @author Albex
 *
 */
public class Not extends AbstractOperator {

	/**
	 * @param operands
	 */
	public Not(Goal operands) {
		super(operands);
	}

	/* (non-Javadoc)
	 * @see model.Goal#getSolver(model.RuleSet, model.SubstitutionSet)
	 */
	@Override
	public AbstractSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution) throws CloneNotSupportedException {
		return new NotSolutionNode(this, rules, parentSolution);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "!(" + this.getFirstOperand().toString() + ")";
	}
	
}
