/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Albex
 *
 */
public class ReactiveRule {

	private Goal conditions;
	private Unifiable goal;
	
	/**
	 * 
	 */
	public ReactiveRule(Goal conditions, Unifiable goal) {
		this.conditions = conditions;
		this.goal = goal;
	}
	
	public ArrayList<Unifiable> fireRule(RuleSet database) {
		try {
			ArrayList<Unifiable> goals = new ArrayList<Unifiable>();
			AbstractSolutionNode root = this.conditions.getSolver(database, new SubstitutionSet());
			SubstitutionSet solution;
			
			while((solution = root.nextSolution()) != null) {
				goals.add((Unifiable) this.goal.replaceVariables(solution));
			}
			
			return goals;
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String toString() {
		return this.conditions.toString() + " -> " + this.goal.toString();
	}

}
