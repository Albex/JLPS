/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @author Albex
 *
 */
public class RuleSet {

	private ArrayList<Rule> rules;
	
	/**
	 * 
	 */
	public RuleSet(Rule... rules) {
		Rule[] rulesArray = rules;
		
		this.rules = new ArrayList<Rule>();
		
		for (int i = 0; i < rulesArray.length; i++) {
			this.rules.add(rulesArray[i]);
		}
		
	}
	
	public Rule getRuleStandardizedApart(int index) throws CloneNotSupportedException {
		Rule rule = (Rule) rules.get(index).standardizeVariablesApart(new Hashtable<Variable, Variable>());
		
		return rule;
	}
	
	public Rule getRule(int index) {
		return this.rules.get(index);
	}
	
	public ArrayList<Rule> getRules() {
		return this.rules;
	}
	
	public int getRuleCount() {
		return this.rules.size();
	}
	
	public void removeRule(Rule rule) {
		this.rules.remove(rule);
	}
	
	public void removeRule(int index) {
		this.rules.remove(index);
	}
	
	public void addRule(Rule rule) {
		this.rules.add(rule);
	}

	/*
	 * (non-Javadoc)
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
