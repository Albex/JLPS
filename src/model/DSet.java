/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * This class represents the D set of the database. This is where all the
 * actions are defined.
 * <p>
 * The actions are stored as {@code Action} objects in a {@code ArrayList}.
 * 
 * @author Alexandre Camus
 * 
 */
public class DSet {

	ArrayList<Action> actions;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param actions
	 *            an array of the actions to be stored in the set or each action
	 *            as a parameter.
	 */
	public DSet(Action... actions) {
		Action[] actionsArray = actions;
		
		this.actions = new ArrayList<Action>();
		
		for(Action action : actionsArray) {
			this.actions.add(action);
		}
	}
	
	/**
	 * Gets the action corresponding to the specified name.
	 * 
	 * @param eventName the name of the action to get.
	 * @return the action as an {@code Action} object.
	 */
	public Action getAction(String eventName) {
		for(Action action : actions) {
			if (action.getPredicate().getName().equals(eventName)) {
				
				return action;
			}
		}
		
		return null;
	}

	/**
	 * Returns the set in the form of:
	 * "D set:
	 *  {
	 *  Action.toString()
	 *  Action.toString()
	 *  }
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String string = new String("D set: \n{\n");
		String delimiter = "";
		for (Action action : actions) {
			string += delimiter + action.toString();
			delimiter = "\n";
		}
		
		return string + "\n}";
	}
	
}
