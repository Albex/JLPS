/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Albex
 *
 */
public class DSet {

	ArrayList<Action> actions;
	
	/**
	 * 
	 */
	public DSet(Action... actions) {
		Action[] actionsArray = actions;
		
		this.actions = new ArrayList<Action>();
		
		for(Action action : actionsArray) {
			this.actions.add(action);
		}
	}
	
	public Action getAction(String eventName) {
		for(Action action : actions) {
			if (action.getPredicate().getName().equals(eventName)) {
				
				return action;
			}
		}
		
		return null;
	}

	/* (non-Javadoc)
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
