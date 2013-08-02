/**
 * 
 */
package model;

/**
 * This class represents goals. Goals are macro predicates that needs
 * definitions.
 * 
 * @author Alexandre Camus
 * 
 */
public class Goal {

	private SimpleSentence goal;
	private RuleSet definitions;
	private int nextDefinition;

	/**
	 * Constructor of the class
	 * 
	 * @param goal
	 *            the predicate form of the goal.
	 * @param definitions
	 *            the definitions of the goal.
	 */
	public Goal(SimpleSentence goal, RuleSet definitions) {
		this.goal = goal;
		this.definitions = definitions;
		this.nextDefinition = 0;
	}
	
	/**
	 * Constructor of the class
	 * 
	 * @param goal
	 *            the predicate form of the goal.
	 * @param definitions
	 *            the definitions of the goal.
	 */
	public Goal(Goal genericGoal, SimpleSentence goal) {
		this.goal = goal;
		this.nextDefinition = 0;
		this.definitions = new RuleSet();
		
		for(Rule definition : genericGoal.definitions.getRules()) {
			SubstitutionSet bindings = genericGoal.goal.unify(goal, new SubstitutionSet());
			this.definitions.addRule(definition.replaceVariables(bindings));
		}
	}

	/**
	 * Gets the name of the goal. It is the name of the {@code SimpleSentence}
	 * predicate.
	 * 
	 * @return the name of {@code SimpleSentence} representing the goal.
	 */
	public String getName() {
		return this.goal.getName();
	}
	
	/**
	 * Gets the predicate form of the goal.
	 * 
	 * @return a {@code SimpleSentence} object representing the goal.
	 */
	public SimpleSentence getGoal() {
		return this.goal;
	}
	
	public boolean hasNextDefinition() {
		return this.nextDefinition < this.definitions.getRuleCount();
	}

	/**
	 * Gets the next definition of the goal and binds it to the bindings implied
	 * by the specified goal.
	 * 
	 * @param boundGoal
	 *            the bound goal for which the definition is needed.
	 * @return a {@code PCExpression} object representing the definition. If
	 *         there is no next definition, returns {@code null}.
	 */
	public Clause getNextDefinition() {
		if (hasNextDefinition()) {
			// Get the rule
			Rule rule = this.definitions.getRule(nextDefinition);
			// Next rule to get update
			updateNextRule();
			// Get the bindings to do
			SubstitutionSet bindings = rule.getHead().unify(this.goal, new SubstitutionSet());
			// Apply these bindings
			Clause boundDefinition = (Clause) rule.getBody().replaceVariables(bindings);
	
			return boundDefinition;
		} else {
			
			return null;
		}
	}
	
	/**
	 * Updates the next rule to get. This is the method to modify in order to
	 * apply different strategies when choosing a definition of a goal.
	 * <p>
	 * For now the strategy is very simple: take the definitions in the order of
	 * declaration.
	 */
	public void updateNextRule() {
		this.nextDefinition++;
	}
	
	/**
	 * Resets the next rule to get. This is the method to modify in order to
	 * apply different strategies when every definition has been tried.
	 * <p>
	 * For now the strategy is very simple: restart from the beginning.
	 */
	public void reset() {
		this.nextDefinition = 0;
	}
	
	/**
	 * Returns the goal under the form of:
	 * "{
	 *  goal :- def1.
	 *  goal :- def2.
	 * }"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.definitions.toString();
	}
	
}
