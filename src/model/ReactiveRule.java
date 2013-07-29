/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * This class represents the reactive rules of a LPS framework.
 * 
 * @author Alexandre Camus
 * 
 */
public class ReactiveRule implements PCExpression {

	private Goal conditions;
	private SimpleSentence goal;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param conditions
	 *            the conditions of the reactive rule. This is the left part of
	 *            the implication.
	 * @param goal
	 *            the goal to fire if the conditions are true. This is the right
	 *            part of the implication.
	 */
	public ReactiveRule(Goal conditions, SimpleSentence goal) {
		this.conditions = conditions;
		this.goal = goal;
	}
	
	/**
	 * Fires the goals of the rule. Each goal represents a different bindings of
	 * the variables of the conditions that make it true.
	 * 
	 * @param database
	 *            the table of truth to which the conditions are submitted to be
	 *            checked.
	 * @return an {@code ArrayList} object containing all the goals created.
	 */
	public ArrayList<Unifiable> fireRule(RuleSet database) {
		ArrayList<Unifiable> goals = new ArrayList<Unifiable>();
		ReactiveRule standardizedRule = this.standardizeVariablesApart(new Hashtable<Variable, Variable>());
		AbstractSolutionNode root = standardizedRule.conditions.getSolver(database, new SubstitutionSet());
		SubstitutionSet solution;
		
		while((solution = root.nextSolution()) != null) {
			goals.add((Unifiable) standardizedRule.goal.replaceVariables(solution));
		}
		
		return goals;
			
	}

	/**
	 * Replaces all the variables in the reactive rule according to the
	 * specified bindings.
	 * <p>
	 * This method is recursive over all {@link PCExpression} implementations.
	 * 
	 * @param s
	 *            the {@code SubstitutionSet} that contains the bindings of the
	 *            variables so far.
	 * @return a {@code ReactiveRule} object representing the bound reactive
	 *         rule.
	 * @see model.PCExpression#replaceVariables(model.SubstitutionSet)
	 */
	@Override
	public ReactiveRule replaceVariables(SubstitutionSet s) {
		// Create the bound goal
		SimpleSentence newGoal = this.goal.replaceVariables(s);
		
		// If the conditions of this rule isn't null, create the bound one
		Goal newConditions = null;
		if (this.conditions != null) {
			newConditions = (Goal) this.conditions.replaceVariables(s);
		}
		
		// Create the bound reactive rule
		ReactiveRule newRule = new ReactiveRule(newConditions, newGoal);
		
		return newRule;
	}

	/**
	 * Standardizes the variables in order to be sure that there won't be any
	 * variable clashes.
	 * <p>
	 * This method is recursive over all {@code PCExpression} implementations.
	 * 
	 * @param newVars
	 *            is a parameter to save over the recursion all the variable
	 *            replacements done so far.
	 * @return a {@code ReactiveRule} object representing the standardized
	 *         reactive rule.
	 * @see model.PCExpression#standardizeVariablesApart(java.util.Hashtable)
	 */
	@Override
	public ReactiveRule standardizeVariablesApart(Hashtable<Variable, Variable> newVars) {
		// Create the standardized goal
		SimpleSentence newGoal = this.goal.standardizeVariablesApart(newVars);
		
		// If the conditions of this rule isn't null, create the standardized one
		Goal newConditions = null;
		if (this.conditions != null) {
			newConditions = (Goal) this.conditions.standardizeVariablesApart(newVars);
		}
		
		// Create the standardized reactive rule
		ReactiveRule newRule = new ReactiveRule(newConditions, newGoal);
		
		return newRule;
	}
	
	/**
	 * Returns the reactive rule in the form of:
	 * "(conditions) -> goal".
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "(" + this.conditions.toString() + ") -> " + this.goal.toString();
	}

}
