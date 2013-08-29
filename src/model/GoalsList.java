/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.fusesource.jansi.AnsiConsole;

/**
 * This is a singleton class that represents the goals list of the framework. It
 * contains the method to solve the goals.
 * <p>
 * The constructor is private as you must not use it. Instead use the
 * {@code getInstance()} method to get the only object of the class (or to
 * create it).
 * 
 * @author Alexandre Camus
 * @see #solveGoals(RuleSet)
 */
public class GoalsList {
	
	private RuleSet nextEvents;
	private GoalSet goalsDefinitions;
	private HashMap<Goal, ArrayList<AbstractSolutionNode>> goalsList;
	private static volatile GoalsList instance = null;

	/**
	 * Constructor of the class.
	 */
	private GoalsList() {
		this.goalsDefinitions = new GoalSet();
		this.goalsList = new HashMap<Goal, ArrayList<AbstractSolutionNode>>();
		this.nextEvents = new RuleSet();
	}
	
	/**
	 * This is the method to get an instance of the class.
	 * Use it as shown: {@code Database.getInstance()}
	 * 
	 * @return the only instance of the class {@code Database}.
	 */
	public final static GoalsList getInstance() {
		if (GoalsList.instance == null) {
			synchronized (GoalsList.class) {
				if (GoalsList.instance == null) {
					GoalsList.instance = new GoalsList();
				}
			}
		}

		return GoalsList.instance;
	}
	
	/**
	 * Sets the goals definitions set.
	 * 
	 * @param goalsDefinitions
	 *            the set containing all the goals definitions.
	 */
	public void setGoalsDefinitions(GoalSet goalsDefinitions) {
		this.goalsDefinitions = goalsDefinitions;
	}
	
	/**
	 * Gets the goals definitions set.
	 * 
	 * @return a {@code GoalSet} object containing all the goals definitions.
	 */
	public GoalSet getGoalsDefinitions() {
		return this.goalsDefinitions;
	}

	/**
	 * Adds the specified event to the list of events that will be performed
	 * during the next cycle.
	 * 
	 * @param event
	 *            the event to add.
	 */
	public void addNextEvent(SimpleSentence event) {
		if (event.getSolver(this.nextEvents, new SubstitutionSet(), null).nextSolution() == null) {
			this.nextEvents.addRule(new Rule(event));
		}
	}
	
	/**
	 * Adds the specified goal to the list of goals.
	 * 
	 * @param goal
	 *            the goal to add.
	 * @param ruleSet
	 *            the rules to use to build the tree of proof.
	 */
	public void addGoal(SimpleSentence goal, RuleSet ruleSet) {
		// Create the bound goal from the generic definition
		Goal completeGoal = new Goal(this.goalsDefinitions.getGoal(goal.getName()), goal);
		
		// Initialize the tree
		ArrayList<AbstractSolutionNode> tree = new ArrayList<AbstractSolutionNode>();
		while(completeGoal.hasNextDefinition()) {
			tree.add(completeGoal.getNextDefinition().getSolver(ruleSet, new SubstitutionSet(), null));
		}
		
		// Create an entry in the list of goals to solve
		this.goalsList.put(completeGoal, tree);
	}
	
	/**
	 * Solves the specified goal. It starts from the last node and carries on,
	 * hopping the new cycle will provide new materials for the proof.
	 * 
	 * @param goal
	 *            the goal to solve.
	 * @param ruleSet
	 *            the ruleSet to reset the tree with.
	 * @param events
	 *            the events that have been used to update the database.
	 * @return true if the goal is solved. False otherwise.
	 */
	public boolean solveGoal(Goal goal, RuleSet ruleSet, RuleSet events) {
		// Define the rules' set
		RuleSet rulesAndEvents = ruleSet;
		rulesAndEvents.addRules(events.getRules());
		
		for(Iterator<AbstractSolutionNode> tree = this.goalsList.get(goal).iterator(); tree.hasNext();) {
			// Get the leaf of the tree
			//AbstractSolutionNode leaf = this.goalsList.get(goal).get(0);
			AbstractSolutionNode leaf = tree.next();
			
			// Reset the leaf to the new ruleSet
			leaf.reset(leaf.getParentSolution(), rulesAndEvents);
			SubstitutionSet solution = leaf.nextSolution();
			leaf = leaf.getDeepestLeaf();
			this.goalsList.get(goal).set(0, leaf);
			
			// If there is a solution the goal is solved
			if (solution != null) {
				
				return true;
			}
			
			// If the leaf is a stuck and
			if (leaf instanceof AndSolutionNode) {
				AbstractSolutionNode head = ((AndSolutionNode) leaf).getHeadSolutionNode();
				if (head instanceof SimpleSentenceSolutionNode) {
					SimpleSentence simpleSentence = (SimpleSentence) head.getClause().replaceVariables(leaf.getParentSolution());
					switch (((SimpleSentenceSolutionNode) head).getType()) {
					case "fact":
						// Wait
						break;
					case "rule":
						// Delete the branch
						tree.remove();
						break;
					case "undefined": // It might be an action or a fact
					case "action":
					default:
						// Get the corresponding action
						Action action = Database.getInstance().getDSet().getAction(((SimpleSentence) simpleSentence).getName());
						
						// If it is an action add it to the next action to do
						if (action != null) {
							if (action.actionsAllowed((SimpleSentence) simpleSentence, ruleSet, events, this.nextEvents)) {
								this.addNextEvent((SimpleSentence) simpleSentence);
							}
							
							return false;
						}
						break;
					}
				}
			}
			
			// If the leaf is a stuck simple sentence
			if (leaf instanceof SimpleSentenceSolutionNode) {
				SimpleSentence simpleSentence = (SimpleSentence) leaf.getClause().replaceVariables(leaf.getParentSolution());
				
				switch (((SimpleSentenceSolutionNode) leaf).getType()) {
				case "fact":
					// Wait
					break;
				case "rule":
					// Delete the branch
					tree.remove();
					break;
				case "undefined": // It might be an action or a fact
				case "action":
				default:
					// Get the corresponding action
					Action action = Database.getInstance().getDSet().getAction(((SimpleSentence) simpleSentence).getName());
					
					// If it is an action add it to the next action to do
					if (action != null) {
						if (action.actionsAllowed((SimpleSentence) simpleSentence, ruleSet, events, this.nextEvents)) {
							this.addNextEvent((SimpleSentence) simpleSentence);
						}
						
						return false;
					}
					break;
				}
			}
						
		/*// Otherwise, according to the strategy, get the next definition to check.
			if (goal.hasNextDefinition()) {
				leaf = goal.getNextDefinition().getSolver(rulesAndEvents, new SubstitutionSet(), null);
				this.goalsList.get(goal).set(0, leaf);
				
				return solveGoal(goal, ruleSet, events);
			
			// If there is no other definition reset and wait for the next cycle
			} else {
				goal.reset();
				leaf = goal.getNextDefinition().getSolver(rulesAndEvents, new SubstitutionSet(), null);
				this.goalsList.get(goal).set(0, leaf);
				
				return false;
			}*/
		}
		
		// Check if there are still branches
		if (this.goalsList.get(goal).isEmpty()) {
			AnsiConsole.out.println("\u001B[33m" + "/!\\ The goal " + goal.getGoal() + " could not be resolved." + "\u001B[37m");
			
			return true;
		} else {
			
			return false;
		}
	}

	/**
	 * Solves all the goal in the list.
	 * 
	 * @param events
	 *            the events that have been performed during the cycle.
	 */
	public void solveGoals(RuleSet events) {
		RuleSet ruleSet = Database.getInstance().getRuleSet();
    	
    	Set<Goal> keys = this.goalsList.keySet();
    	for(Iterator<Goal> goals = keys.iterator(); goals.hasNext();) {
    		Goal goal = goals.next();
    		if (solveGoal(goal, ruleSet, events)) {
    			goals.remove();
    		}
    	}
    	
    	CycleHandler.getInstance().setEvents(this.nextEvents);
    	this.nextEvents.getRules().clear();
	}

	/**
	 * Returns the set in the form of:
	 * "{
	 * 	[definitionChosen] => [currentNode]
	 * }".
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String res = "{\n";
		
		for(Goal goal : this.goalsList.keySet()) {
			AbstractSolutionNode tree = this.goalsList.get(goal).get(0);
			res += "[" + goal.getGoal().toString() + " :- ";
			res += tree.getClause().toString() + "] => [";
			res += tree.getDeepestLeaf().getClause().replaceVariables(tree.getDeepestLeaf().getParentSolution()).toString() + "]\n";
		}
		
		res += "}";
		return res;
	}

}
