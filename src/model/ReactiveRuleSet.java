/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Albex
 *
 */
public class ReactiveRuleSet {
	
	ArrayList<ReactiveRule> reactiveRules;
	private static volatile ReactiveRuleSet instance = null;

	/**
	 * 
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
	
	public ArrayList<Unifiable> fireRules(RuleSet ruleSet) {
		ArrayList<Unifiable> goals = new ArrayList<Unifiable>();
		
		for(ReactiveRule rule : this.reactiveRules) {
			goals.addAll(rule.fireRule(ruleSet));
		}
		
		return goals;
	}
	
	public String toString() {
		return this.reactiveRules.toString();
	}

}
