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
	private Goal conditions;
	
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
	public Action(SimpleSentence action, ArrayList<Initiator> initiators, ArrayList<Terminator> terminators, Goal conditions) {
		this.action = action;
		this.initiators = initiators;
		this.terminators = terminators;
		this.conditions = conditions;
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
	 * @param rules
	 *            on which the conditions will be tested to get solutions and
	 *            bindings.
	 * @return the {@code ArrayList} that contains every version of the action.
	 *         If there is no solution, it will be empty (but not null).
	 */
	public ArrayList<SimpleSentence> actionsAllowed(RuleSet rules) {
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
		
		return "if (" + conditions + ") " + this.getName() + "=[" + this.initiators.toString() + ", " + this.terminators.toString() + "]";
	}

}
