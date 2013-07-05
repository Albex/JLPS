/**
 * 
 */
package model;

import java.util.Hashtable;


/**
 * @author Albex
 *
 */
public class Rule implements PCExpression, Cloneable {

	private SimpleSentence head;
	private Goal body;
	
	/**
	 * 
	 */
	public Rule(SimpleSentence head) {
		this(head, null);
	}

	public Rule(SimpleSentence head, Goal body) {
		this.head = head;
		this.body = body;
	}
	
	/**
	 * @return
	 */
	public SimpleSentence getHead() {
		return this.head;
	}
	
	public Goal getBody() {
		return this.body;
	}

	/* (non-Javadoc)
	 * @see model.PCExpression#replaceVariables(model.SubstitutionSet)
	 */
	@Override
	public PCExpression replaceVariables(SubstitutionSet s) throws CloneNotSupportedException {
		// Create the bound head
		SimpleSentence newHead = (SimpleSentence) this.getHead().replaceVariables(s);
		
		// If the body of this rule isn't null, create the bound one
		Goal newBody = null;
		if (this.getBody() != null) {
			newBody = (Goal) this.getBody().replaceVariables(s);
		}
		
		// Create the bound rule
		Rule newRule = (Rule) this.clone();
		newRule.head = newHead;
		newRule.body = newBody;
		
		return newRule;
	}

	/* (non-Javadoc)
	 * @see model.PCExpression#standardizeVariablesApart(java.util.Hashtable)
	 */
	@Override
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) throws CloneNotSupportedException {
		// Create the standardized head
		SimpleSentence newHead = (SimpleSentence) this.getHead().standardizeVariablesApart(newVars);
		
		// If the body of this rule isn't null, create the standardized one
		Goal newBody = null;
		if (this.getBody() != null) {
			newBody = (Goal) this.getBody().standardizeVariablesApart(newVars);
		}
		
		// Create the standardized rule
		Rule newRule = (Rule) this.clone();
		newRule.head = newHead;
		newRule.body = newBody;
		
		return newRule;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (this.body == null) {
			return this.head.toString() + ".";
		} else {
			return this.head.toString() + " :- " + this.body.toString() + ".";
		}
	}
	
}
