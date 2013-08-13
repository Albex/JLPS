/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * This class represents actions. Actions are either predicates to reason with
 * or agents that create and delete fluents in the database.
 * 
 * @author Alexandre Camus
 * 
 */
public class Action {

	private SimpleSentence action;
	private ArrayList<Initiator> initiators;
	private ArrayList<Terminator> terminators;
	private Clause conditions;
	private Clause conflicts;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param action
	 *            the {@code SimpleSentence} object that is the generic
	 *            predicate representing the action.
	 * @param initiators
	 *            the {@code ArrayList} containing all the DPost declarations
	 *            that initiates fluents.
	 * @param terminators
	 *            the {@code ArrayList} containing all the DPost declarations
	 *            that terminates fluents.
	 * @param conditions
	 *            the preconditions that must be satisfied before performing the
	 *            action.
	 */
	public Action(SimpleSentence action, ArrayList<Initiator> initiators, ArrayList<Terminator> terminators, Clause conditions, Clause conflicts) {
		this.action = action;
		this.initiators = initiators;
		this.terminators = terminators;
		this.conditions = conditions;
		this.conflicts = conflicts;
	}
	
	/**
	 * Gets the name of the action. It is the name of the {@code SimpleSentence}
	 * predicate.
	 * 
	 * @return the name of {@code SimpleSentence} representing the action.
	 */
	public String getName() {
		return this.action.getName();
	}
	
	/**
	 * Gets the predicate representing the action. The predicate is represented
	 * as a {@code SimpleSentence}.
	 * 
	 * @return the {@code SimpleSentence} object representing the action.
	 */
	public SimpleSentence getPredicate() {
		return this.action;
	}
	
	/**
	 * Gets all the DPost declarations that initiates fluents. It is collected
	 * in an {@code ArrayList}.
	 * 
	 * @return the {@code ArrayList} containing the initiators of the action.
	 */
	public ArrayList<Initiator> getInitiators() {
		return this.initiators;
	}
	
	/**
	 * Gets all the DPost declarations that terminates fluents. It is collected
	 * in an {@code ArrayList}.
	 * 
	 * @return the {@code ArrayList} containing the terminators of the action.
	 */
	public ArrayList<Terminator> getTerminators() {
		return this.terminators;
	}
	
	/**
	 * Checks if the action can be performed. If this needs bindings for the
	 * variables of the action, it will return every version of the action with
	 * its allowed binding.
	 * <p>
	 * The method gets every solution for the conditions of the action and
	 * applies the bindings got to the generic {@code SimpleSentence}.
	 * 
	 * @param event
	 *            the bound action to test if it can be performed.
	 * @param rules
	 *            on which the conditions will be tested to get solutions and
	 *            bindings.
	 * @param events
	 *            the events that have been used to update the database.
	 * @param nextEvents
	 *            the events that will be perform during the next cycle so far.
	 * @return true if this bound action can be performed. False otherwise.
	 */
	public boolean actionsAllowed(SimpleSentence event, RuleSet rules, RuleSet events, RuleSet nextEvents) {
		SubstitutionSet bindings = this.action.unify(event, new SubstitutionSet());
		if (this.conditions != null) {
			Clause boundConditions = (Clause) this.conditions.replaceVariables(bindings);
			RuleSet conRules = rules;
			conRules.addRules(events.getRules());
			AbstractSolutionNode conditionsRoot = boundConditions.getSolver(conRules, new SubstitutionSet());
			
			if (conditionsRoot.nextSolution() == null) {

				return false;
			}
		}
		
		if (this.conflicts != null) {
			Clause boundConflicts = (Clause) this.conflicts.replaceVariables(bindings);
			RuleSet conRules = rules;
			conRules.addRules(nextEvents.getRules());
			AbstractSolutionNode conflictsRoot = boundConflicts.getSolver(conRules, new SubstitutionSet());
			
			if (conflictsRoot.nextSolution() == null) {

				return false;
			}
		}

		return true;
	}
	
	/**
	 * Gets all the fluents that will be initiated. It simply take all the
	 * initiators of the action, take every fluent they initiates and binds the
	 * fluents according to the event put in parameter.
	 * 
	 * @param event
	 *            the version of the action that is performed on the database.
	 * @return the {@code ArrayList} of the bound fluents according to the
	 *         parameter.
	 */
	public ArrayList<SimpleSentence> fluentsToInitiate(SimpleSentence event) {
		ArrayList<SimpleSentence> fluents = new ArrayList<SimpleSentence>();
		
		for(Initiator initiator : this.initiators) {
			fluents.add(initiator.getGroundFluent(event));
		}
		
		return fluents;
	}
	
	/**
	 * Gets all the fluents that will be terminated. It simply take all the
	 * terminators of the action, take every fluent they terminates and binds the
	 * fluents according to the event put in parameter.
	 * 
	 * @param event
	 *            the version of the action that is performed on the database.
	 * @return the {@code ArrayList} of the bound fluents according to the
	 *         parameter.
	 */
	public ArrayList<SimpleSentence> fluentsToTerminate(SimpleSentence event) {
		ArrayList<SimpleSentence> fluents = new ArrayList<SimpleSentence>();
		
		for(Terminator terminator : this.terminators) {
			fluents.add(terminator.getGroundFluent(event));
		}
		
		return fluents;
	}

	/**
	 * Returns the action under the form of:
	 * "if (conditions) actionName=[[initiators], [terminators]]"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String conditions = (this.conditions == null) ? "true" : this.conditions.toString();
		conditions += (this.conflicts == null) ? "" : " & " + this.conflicts.toString();
		
		return "if (" + conditions + ") " + this.getName() + "=[" + this.initiators.toString() + ", " + this.terminators.toString() + "]";
	}

}
