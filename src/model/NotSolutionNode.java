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
	 * @throws CloneNotSupportedException 
	 */
	public NotSolutionNode(Not goal, RuleSet rules, SubstitutionSet parentSolution) throws CloneNotSupportedException {
		super(goal, rules, parentSolution);
		this.tailSolutionNode = goal.getFirstOperand().getSolver(rules, parentSolution);
	}

	/* (non-Javadoc)
	 * @see model.AbstractSolutionNode#nextSolution()
	 */
	@Override
	public SubstitutionSet nextSolution() throws CloneNotSupportedException {
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
