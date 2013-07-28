/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * This singleton class represents the set of all reactive rules of the LPS
 * framework.
 * <p>
 * The reactive rules are stored as {@code ReactiveRule} in an {@code ArrayList}.
 * <p>
 * The constructor is private as you must not use it. Instead use the
 * {@code getInstance()} method to get the only object of the class (or to
 * create it).
 * 
 * @author Alexandre Camus
 * 
 */
public class ReactiveRuleSet {
	
	ArrayList<ReactiveRule> reactiveRules;
	private static volatile ReactiveRuleSet instance = null;

	/**
	 * Constructor of the class. It is private as it must not be
	 * called. Use the method {@code getInstance()} instead.
	 */
	private ReactiveRuleSet(ReactiveRule... reactiveRules) {
		ReactiveRule[] rulesArray = reactiveRules;
		
		this.reactiveRules = new ArrayList<ReactiveRule>();
		
		for (int i = 0; i < rulesArray.length; i++) {
			this.reactiveRules.add(rulesArray[i]);
		}
	}
	
	/**
	 * This is the method to get an instance of the class.
	 * Use it as shown: {@code ReactiveRuleSet.getInstance()}
	 * 
	 * @return the only instance of the class {@code ReactiveRuleSet}.
	 */
	public final static ReactiveRuleSet getInstance(ReactiveRule... reactiveRules) {
		if (ReactiveRuleSet.instance == null) {
			synchronized (ReactiveRuleSet.class) {
				if (ReactiveRuleSet.instance == null) {
					ReactiveRuleSet.instance = new ReactiveRuleSet(reactiveRules);
				}
			}
		}

		return ReactiveRuleSet.instance;
	}
	
	/**
	 * Fires all the reactive rules it contains thanks to there own
	 * {@link ReactiveRule#fireRule(RuleSet) fireRule()} method. It returns all
	 * the goals in order to push them into the list of the goals to solve.
	 * 
	 * @param ruleSet
	 *            the table of truth to which the conditions are submitted to be
	 *            checked.
	 * @return an {@code ArrayList} object containing all the fired goals.
	 */
	public ArrayList<Unifiable> fireRules(RuleSet ruleSet) {
		ArrayList<Unifiable> goals = new ArrayList<Unifiable>();
		
		for(ReactiveRule rule : this.reactiveRules) {
			goals.addAll(rule.fireRule(ruleSet));
		}
		
		return goals;
	}
	
	/**
	 * Returns the set in the form of:
	 * "Reactive rules: [(conditions) -> goal, (conditions) -> goal, ...]".
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.reactiveRules.toString();
	}

}
