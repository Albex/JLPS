/**
 * 
 */
package model;

/**
 * @author Albex
 *
 */
public class AndSolutionNode extends AbstractSolutionNode {

	private AbstractSolutionNode headSolutionNode = null;
	private AbstractSolutionNode tailSolutionNode = null;
	
	private AbstractOperator operatorTail = null;
	
	/**
	 * @param goal
	 * @param rules
	 * @param parentSolution
	 * @throws CloneNotSupportedException 
	 */
	public AndSolutionNode(And goal, RuleSet rules, SubstitutionSet parentSolution) throws CloneNotSupportedException {
		super(goal, rules, parentSolution);
		this.headSolutionNode = goal.getFirstOperand().getSolver(rules, parentSolution);
		this.operatorTail = goal.getOperatorTail();
	}
	
	protected AbstractSolutionNode getHeadSolutionNode() {
		return this.headSolutionNode;
	}
	
	protected AbstractSolutionNode getTailSolutionNode() {
		return this.tailSolutionNode;
	}

	/* (non-Javadoc)
	 * @see model.AbstractSolutionNode#nextSolution()
	 */
	@Override
	public SubstitutionSet nextSolution() throws CloneNotSupportedException {
		SubstitutionSet solution;
		
		// First try to create a new solution with the same head solution but a different tail solution
		if (this.tailSolutionNode != null) {
			solution = tailSolutionNode.nextSolution();
			if (solution != null) {
				
				return solution;
			}
		}
		
		// If there are no new solutions with the previous try,
		// try to get an alternative head solution and then one corresponding tail solution		
		while ((solution = this.headSolutionNode.nextSolution()) != null) {
			// If there is no tail, the head solution is the complete solution
			if (this.operatorTail.isEmpty()) {
				
				return solution;
				
			// Otherwise it creates a new solution node for the tail with the parent substitution set.
			// And then get a solution with this substitution set. If it is not null it returns it. 
			} else {
				this.tailSolutionNode = this.operatorTail.getSolver(this.getRuleSet(), solution);
				SubstitutionSet tailSolution = this.tailSolutionNode.nextSolution();
				if (tailSolution != null) {
					
					return tailSolution;
				}
			}
		}
		
		// If both above cases fail, there is no solution
		return null;
	}

}
