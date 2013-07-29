/**
 * 
 */
package model;

/**
 * @author Albex
 *
 */
public class NotSolutionNode extends AbstractSolutionNode {

	private AbstractSolutionNode tailSolutionNode = null;
	private boolean solutionFlag = false;
	
	/**
	 * @param goal
	 * @param rules
	 * @param parentSolution
	 */
	public NotSolutionNode(Not goal, RuleSet rules, SubstitutionSet parentSolution) {
		super(goal, rules, parentSolution);
		this.tailSolutionNode = goal.getFirstOperand().getSolver(rules, parentSolution);
	}

	/* (non-Javadoc)
	 * @see model.AbstractSolutionNode#nextSolution()
	 */
	@Override
	public SubstitutionSet nextSolution() {
		if (this.solutionFlag) {
			
			return null;
		} else {
			this.solutionFlag = true;
		}
		
		if (this.tailSolutionNode.nextSolution() != null) {
			
			return null;
		} else {

			return new SubstitutionSet();
		}
	}

}
