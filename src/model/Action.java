/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Albex
 *
 */
public class Action {

	private SimpleSentence action;
	private ArrayList<Initiator> initiators;
	private ArrayList<Terminator> terminators;
	private Goal conditions;
	
	/**
	 * @param action
	 * @param initiators
	 * @param terminators
	 * @param condtions
	 */
	public Action(SimpleSentence action, ArrayList<Initiator> initiators, ArrayList<Terminator> terminators, Goal conditions) {
		this.action = action;
		this.initiators = initiators;
		this.terminators = terminators;
		this.conditions = conditions;
	}
	
	public String getName() {
		return this.action.getName();
	}
	
	public SimpleSentence getPredicate() {
		return this.action;
	}
	
	public ArrayList<Initiator> getInitiators() {
		return this.initiators;
	}
	
	public ArrayList<Terminator> getTerminators() {
		return this.terminators;
	}
	
	public ArrayList<SimpleSentence> actionsAllowed(RuleSet rules) throws CloneNotSupportedException {
		ArrayList<SimpleSentence> actions = new ArrayList<SimpleSentence>();
		
		if (this.conditions != null) {
			AbstractSolutionNode root = this.conditions.getSolver(rules, new SubstitutionSet());
			SubstitutionSet solution;
			
			while((solution = root.nextSolution()) != null) {
				actions.add((SimpleSentence) this.action.replaceVariables(solution));
			}
		} else {
			actions.add(this.action);
		}
		
		return actions;
	}
	
	public ArrayList<SimpleSentence> fluentsToInitiate(SimpleSentence event) throws CloneNotSupportedException {
		ArrayList<SimpleSentence> fluents = new ArrayList<SimpleSentence>();
		
		for(Initiator initiator : this.initiators) {
			fluents.add(initiator.getGroundFluent(event));
		}
		
		return fluents;
	}
	
	public ArrayList<SimpleSentence> fluentsToTerminate(SimpleSentence event) throws CloneNotSupportedException {
		ArrayList<SimpleSentence> fluents = new ArrayList<SimpleSentence>();
		
		for(Terminator terminator : this.terminators) {
			fluents.add(terminator.getGroundFluent(event));
		}
		
		return fluents;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String conditions = (this.conditions == null) ? "true" : this.conditions.toString();
		
		return "if (" + conditions + ") " + this.getName() + "=[" + this.initiators.toString() + ", " + this.terminators.toString() + "]";
	}

}
