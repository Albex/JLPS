/**
 * 
 */
package model;

/**
 * This class is the abstract class that gathers all the solution-node classes.
 * A solution node is a node in a tree of proof.
 * 
 * @author Alexandre Camus
 * 
 */
public abstract class AbstractSolutionNode {

	private RuleSet rules;
	private Rule currentRule = null;
	private Goal goal = null;
	public static int nodesCreated = 0;
	
	// saving the parent solution allows backtracking to the original state
	private SubstitutionSet parentSolution;
	
	//These variables allow the solution node to iterate over the rule set.
	private int ruleNumber = 0;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param goal
	 *            the clause to be proved by this subtree.
	 * @param rules
	 *            the rules representing context of the proof.
	 * @param parentSolution
	 *            the solution of the parent node in the tree of proof.
	 */
	public AbstractSolutionNode(Goal goal, RuleSet rules, SubstitutionSet parentSolution) {
		this.rules = rules;
		this.parentSolution = parentSolution;
		this.goal = goal;
	}
	
	/**
	 * Creates the next solution for the clause of the node. If no solution
	 * exists, it will create a solution. Otherwise it will get a different
	 * solution or return {@code null} if there no other different solution.
	 * 
	 * @return a {@code SubstitutionSet} object representing the bindings of the
	 *         next solution or {@code null} if there is no next solution.
	 */
	public abstract SubstitutionSet nextSolution();
	
	/**
	 * Resets the node with the specified parent solution. The subtree will then
	 * need to be rebuilt.
	 * 
	 * @param newParentSolution
	 *            the new parent solution to use to create the new subtree.
	 */
	protected void reset(SubstitutionSet newParentSolution) {
		this.parentSolution = newParentSolution;
		this.ruleNumber = 0;
	}
	
	/**
	 * Checks if there is another rule in the context rules.
	 * 
	 * @return true if the current rule number is strictly below the number of
	 *         rules.
	 */
	public boolean hasNextRule() {
		return this.ruleNumber < this.rules.getRuleCount();
	}
	
	/**
	 * Gets the next rule to work with.
	 * 
	 * @return a {@code Rule} object representing the next rule.
	 */
	public Rule nextRule() {
		if (this.hasNextRule()) {
			this.currentRule = this.rules.getRuleStandardizedApart(this.ruleNumber++);
		} else {
			this.currentRule = null;
		}
		
		return this.currentRule;
	}
	
	/**
	 * Gets the parent solution.
	 * 
	 * @return a {@code SubstitutionSet} object that represents the parent
	 *         solution.
	 */
	public SubstitutionSet getParentSolution() {
		return this.parentSolution;
	}
	
	/**
	 * Gets the context rules of the tree.
	 * 
	 * @return a {@code RuleSet} object containing the context rules.
	 */
	public RuleSet getRuleSet() {
		return this.rules;
	}
	
	/**
	 * Gets the rule on which the node is currently working.
	 * 
	 * @return a {@code Rule} object representing the current rule.
	 */
	public Rule getCurrentRule(){
		return this.currentRule;
	}
	
	/**
	 * Get the clause to prove in the context rules.
	 * 
	 * @return a {@code Goal} object representing the clause to prove.
	 */
	public Goal getGoal() {
		return this.goal;
	}
	
}
