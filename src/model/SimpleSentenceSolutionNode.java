/**
 * 
 */
package model;

/**
 * @author Albex
 *
 */
public class SimpleSentenceSolutionNode extends AbstractSolutionNode {

	private AbstractSolutionNode child = null;
	
	/**
	 * @param goal
	 * @param rules
	 * @param parentSolution
	 */
	public SimpleSentenceSolutionNode(SimpleSentence goal, RuleSet rules, SubstitutionSet parentSolution) {
		super(goal, rules, parentSolution);
	}

	/* (non-Javadoc)
	 * @see model.AbstractSolutionNode#nextSolution()
	 */
	@Override
	public SubstitutionSet nextSolution() throws CloneNotSupportedException {
		SubstitutionSet solution;
		
		// If there is a child in the proof tree, try to get an alternative solution
		if (this.child != null) {
			solution = this.child.nextSolution();
			if (solution != null) {
				
				return solution;
			}
		} 
		
		// If the previous try fails, this proof tree has no alternate solution.
		// Create a new one by deleting the current child.
		this.child = null;
		
		Rule rule;
		
		// Then try to find a new solution for the current node
		while (this.hasNextRule() == true) {
			// Get a rule
			rule = this.nextRule();
			
			SimpleSentence head = rule.getHead();
			
			// Unify its head
			solution = ((SimpleSentence) this.getGoal()).unify(head, this.getParentSolution());
			
			// If there is a solution to the unification
			if (solution != null) {
				// Get the body of the rule
				Goal tail = rule.getBody();
				
				// If there is no body, solution is the whole solution
				if (tail == null) {
					
					return solution;
				}
				
				// Otherwise create a node for the body of the rule and get a new solution for this new node
				this.child = tail.getSolver(this.getRuleSet(), solution);
				SubstitutionSet childSolution = this.child.nextSolution();
				
				// If the new node has a solution return it
				if (childSolution != null) {
					
					return childSolution;
				}
			}
		}
		
		// If there is no solution for the current node after trying with every rule
		// Fail and return null
		return null;
	}

}
