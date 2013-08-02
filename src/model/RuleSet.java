/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * This class represents a table of truth. This can be the intensional clauses
 * of the database or any table of truth from which it is needed to create a
 * proof.
 * <p>
 * The rules are stored as {@code Rule} in an {@code ArrayList}.
 * 
 * @author Alexandre Camus
 * 
 */
public class RuleSet {

	private ArrayList<Rule> rules;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param rules
	 *            the rules of the set in an array or as independent arguments.
	 */
	public RuleSet(Rule... rules) {
		Rule[] rulesArray = rules;
		
		this.rules = new ArrayList<Rule>();
		
		for (int i = 0; i < rulesArray.length; i++) {
			this.rules.add(rulesArray[i]);
		}
	}
	
	/**
	 * Constructor of the class.
	 * 
	 * @param rules
	 *            an {@code ArrayList} object containing the rules of the set.
	 */
	public RuleSet(ArrayList<Rule> rules) {
		this.rules = rules;
	}
	
	/**
	 * Gets the standardized version of the rule number {@code index}. This uses
	 * the method {@link Rule#standardizeVariablesApart(Hashtable)
	 * standardizeVariablesApart()} on the rule at the specified index.
	 * 
	 * @param index
	 *            the position of the rule in the set.
	 * @return a {@code Rule} object representing the standardized rule which
	 *         was at the specified position.
	 */
	public Rule getRuleStandardizedApart(int index) {
		Rule rule = (Rule) rules.get(index).standardizeVariablesApart(new Hashtable<Variable, Variable>());
		
		return rule;
	}
	
	/**
	 * Gets the rule at the specified position.
	 * 
	 * @param index
	 *            the position of the rule
	 * @return the {@code Rule} object representing the specified rule.
	 */
	public Rule getRule(int index) {
		return this.rules.get(index);
	}
	
	/**
	 * Gets all the rules of the set.
	 * 
	 * @return an {@code ArrayList} object containing the rules of the set.
	 */
	public ArrayList<Rule> getRules() {
		return this.rules;
	}
	
	/**
	 * Gets the size of the set. The size of the set is simply the number of
	 * rules in the set.
	 * 
	 * @return the number of rules in the set.
	 */
	public int getRuleCount() {
		return this.rules.size();
	}
	
	/**
	 * Removes the specified rule from the set.
	 * 
	 * @param rule
	 *            the exact {@code Rule} object to remove.
	 */
	public void removeRule(Rule rule) {
		this.rules.remove(rule);
	}
	
	/**
	 * Removes the rule at the specified position from the set.
	 * 
	 * @param index
	 *            the position of the rule to remove.
	 */
	public void removeRule(int index) {
		this.rules.remove(index);
	}
	
	/**
	 * Adds all the rules that are in the specified {@code ArrayList}.
	 * 
	 * @param rules
	 *            the {@code ArrayList} object containing the rules to add.
	 */
	public void addRules(ArrayList<Rule> rules) {
		for(Rule rule : rules) {
			this.rules.add(rule);
		}
	}
	
	/**
	 * Adds the specified rule.
	 * 
	 * @param rule
	 *            the {@code Rule} object representing the rule to add.
	 */
	public void addRule(Rule rule) {
		this.rules.add(rule);
	}

	/**
	 * Returns the set in the form of:
	 * "{
	 * 	rule1
	 *  rule2
	 *  ...
	 * }".
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = null;

		for (PCExpression r : this.rules) {
			if (s == null) {
				s = r.toString() + "\n";
			} else {
				s += r.toString() + "\n";
			}
		}

		if (s == null) {
			
			return "true.";
		} else {
			
			return "{\n" + s + "}";
		}
	}
	
}
