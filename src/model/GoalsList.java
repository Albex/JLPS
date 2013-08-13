/**
 * 
 */
package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

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
	private HashMap<Goal, AbstractSolutionNode> goalsList;
	private static volatile GoalsList instance = null;

	/**
	 * Constructor of the class.
	 */
	private GoalsList() {
		this.goalsDefinitions = new GoalSet();
		this.goalsList = new HashMap<Goal, AbstractSolutionNode>();
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
		if (event.getSolver(this.nextEvents, new SubstitutionSet()).nextSolution() == null) {
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
		
		// Get the next definition of the goal, which is the first one
		Clause definition = completeGoal.getNextDefinition();
		
		// Create an entry in the list of goals to solve
		this.goalsList.put(completeGoal, definition.getSolver(ruleSet, new SubstitutionSet()));
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
		RuleSet rulesAndEvents = ruleSet;
		rulesAndEvents.addRules(events.getRules());
		AbstractSolutionNode root = this.goalsList.get(goal);
		AbstractSolutionNode leaf = root.getDeepestLeaf();
		leaf.reset(leaf.getParentSolution(), rulesAndEvents);
		SubstitutionSet solution = leaf.nextSolution();
		leaf = leaf.getDeepestLeaf();
		root.setDeepestLeaf(leaf);
		
		// If there is a solution the goal is solved
		if (solution != null) {
			
			return true;
		}
		
		// If the leaf is a stuck and
		if (leaf instanceof AndSolutionNode) {
			Clause simpleSentence = (Clause) ((AndSolutionNode) leaf).getHeadSolutionNode().getClause().replaceVariables(leaf.getParentSolution());
			if (simpleSentence instanceof SimpleSentence) {
				Action action = Database.getInstance().getDSet().getAction(((SimpleSentence) simpleSentence).getName());
				
				// If it is an action add it to the next action to do
				if (action != null) {
					if (action.actionsAllowed((SimpleSentence) simpleSentence, ruleSet, events, this.nextEvents)) {
						this.addNextEvent((SimpleSentence) simpleSentence);
					}
					
					return false;
				}
			}
		}
		
		// If the leaf is a stuck simple sentence
		if (leaf instanceof SimpleSentenceSolutionNode) {
			SimpleSentence simpleSentence = (SimpleSentence) leaf.getClause().replaceVariables(leaf.getParentSolution());
			Action action = Database.getInstance().getDSet().getAction(simpleSentence.getName());
			
			// If it is an action add it to the next action to do
			if (action != null) {
				if (action.actionsAllowed(simpleSentence, ruleSet, events, this.nextEvents)) {
					this.addNextEvent(simpleSentence);
				}
				
				return false;
			}
		}
					
		// Otherwise, according to the strategy, get the next definition to check.
		if (goal.hasNextDefinition()) {
			root = goal.getNextDefinition().getSolver(rulesAndEvents, new SubstitutionSet());
			this.goalsList.put(goal, root);
			
			return solveGoal(goal, ruleSet, events);
		
		// If there is no other definition reset and wait for the next cycle
		} else {
			goal.reset();
			root = goal.getNextDefinition().getSolver(rulesAndEvents, new SubstitutionSet());
			this.goalsList.put(goal, root);
			
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
			AbstractSolutionNode tree = this.goalsList.get(goal);
			res += "[" + goal.getGoal().toString() + " :- ";
			res += tree.getClause().toString() + "] => [";
			res += tree.getDeepestLeaf().getClause().replaceVariables(tree.getDeepestLeaf().getParentSolution()).toString() + "]\n";
		}
		
		res += "}";
		return res;
	}

}
