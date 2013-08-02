/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * This class represents the set where all goals are defined.
 * <p>
 * The goals are stored as {@code Goal} objects in a {@code ArrayList}.
 * 
 * @author Alexandre Camus
 * 
 */
public class GoalSet {

ArrayList<Goal> goals;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param goals
	 *            an array of the goals to be stored in the set or each goal
	 *            as a parameter.
	 */
	public GoalSet(Goal... goals) {
		Goal[] goalsArray = goals;
		
		this.goals = new ArrayList<Goal>();
		
		for(Goal goal : goalsArray) {
			this.goals.add(goal);
		}
	}
	
	/**
	 * Gets the goal corresponding to the specified name.
	 * 
	 * @param goalName the name of the goal to get.
	 * @return the goal as an {@code Goal} object.
	 */
	public Goal getGoal(String goalName) {
		for(Goal goal : this.goals) {
			if (goal.getGoal().getName().equals(goalName)) {
				
				return goal;
			}
		}
		
		return null;
	}
	
	/**
	 * Returns the set in the form of:
	 * "Goals set:
	 *  {
	 *  Goal.toString()
	 *  Goal.toString()
	 *  }
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String string = new String("Goals set: \n{\n");
		String delimiter = "";
		for (Goal goal : this.goals) {
			string += delimiter + goal.toString();
			delimiter = "\n";
		}
		
		return string + "\n}";
	}

}