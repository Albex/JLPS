/**
 * 
 */
package model;

/**
 * @author Albex
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
	 * 
	 */
	public AbstractSolutionNode(Goal goal, RuleSet rules, SubstitutionSet parentSolution) {
		this.rules = rules;
		this.parentSolution = parentSolution;
		this.goal = goal;
	}
	
	public abstract SubstitutionSet nextSolution() throws CloneNotSupportedException;
	
	protected void reset(SubstitutionSet newParentSolution) {
		this.parentSolution = newParentSolution;
		this.ruleNumber = 0;
	}
	
	public boolean hasNextRule() {
		return this.ruleNumber < this.rules.getRuleCount();
	}
	
	public Rule nextRule() throws CloneNotSupportedException {
		if (this.hasNextRule()) {
			this.currentRule = this.rules.getRuleStandardizedApart(this.ruleNumber++);
		} else {
			this.currentRule = null;
		}
		
		return this.currentRule;
	}
	
	public SubstitutionSet getParentSolution() {
		return this.parentSolution;
	}
	
	public RuleSet getRuleSet() {
		return this.rules;
	}
	
	public Rule getCurrentRule(){
		return this.currentRule;
	}
	
	public Goal getGoal(){
		return this.goal;
	}
	
}
