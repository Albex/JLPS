/**
 * 
 */
package model;

import java.util.Hashtable;

/**
 * @author Albex
 *
 */
public class RuleSet {

	private Rule[] rules;
	
	/**
	 * 
	 */
	public RuleSet(Rule... rules) {
		this.rules = rules;
	}
	
	public Rule getRuleStandardizedApart(int index) throws CloneNotSupportedException {
		Rule rule = (Rule) rules[index].standardizeVariablesApart(new Hashtable<Variable, Variable>());
		
		return rule;
	}
	
	public Rule getRule(int index) {
		return this.rules[index];
	}
	
	public int getRuleCount() {
		return this.rules.length;
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
