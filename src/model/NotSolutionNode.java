/**
 * 
 */
package model;

/**
 * This class represents a negative node in the tree of proof.
 * A solution node is a node in a tree of proof.
 * 
 * @author Alexandre Camus
 * 
 */
public class NotSolutionNode extends AbstractSolutionNode {

	private AbstractSolutionNode tailSolutionNode = null;
	private boolean solutionFlag = false;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param goal
	 *            the negative clause to be proved by this subtree.
	 * @param rules
	 *            the rules representing context of the proof.
	 * @param parentSolution
	 *            the solution of the parent node in the tree of proof.
	 */
	public NotSolutionNode(Not goal, RuleSet rules, SubstitutionSet parentSolution) {
		super(goal, rules, parentSolution);
		this.tailSolutionNode = goal.getFirstOperand().getSolver(rules, parentSolution);
	}

	/**
	 * Creates the next solution for the negative clause of the node. If no solution
	 * exists, it will create a solution. Otherwise it will get a different
	 * solution or return {@code null} if there no other different solution.
	 * 
	 * @return a {@code SubstitutionSet} object representing the bindings of the
	 *         next solution or {@code null} if there is no next solution.
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
