/**
 * 
 */
package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Albex
 *
 */
public class GoalsList {
	
	private RuleSet nextEvents;
	private GoalSet goalsDefinitions;
	private HashMap<Goal, AbstractSolutionNode> goalsList;
	private static volatile GoalsList instance = null;

	/**
	 * 
	 */
	private GoalsList() {
		this.goalsDefinitions = new GoalSet();
		this.goalsList = new HashMap<Goal, AbstractSolutionNode>();
		this.nextEvents = new RuleSet();
	}
	
	/**
	 * 
	 */
	private GoalsList(GoalSet goalsDefinitions, RuleSet nextEvents) {
		this.goalsDefinitions = goalsDefinitions;
		this.goalsList = new HashMap<Goal, AbstractSolutionNode>();
		this.nextEvents = nextEvents;
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
	 * This is the method to get an instance of the class.
	 * Use it as shown: {@code Database.getInstance()}
	 * 
	 * @return the only instance of the class {@code Database}.
	 */
	public final static GoalsList getInstance(GoalSet goalsDefinitions, RuleSet nextEvents) {
		if (GoalsList.instance == null) {
			synchronized (GoalsList.class) {
				if (GoalsList.instance == null) {
					GoalsList.instance = new GoalsList(goalsDefinitions, nextEvents);
				}
			}
		}

		return GoalsList.instance;
	}
	
	public void addNextEvent(SimpleSentence event) {
		if (this.nextEvents.getRuleCount() == 0 || event.getSolver(this.nextEvents, new SubstitutionSet()) == null) {
			this.nextEvents.addRule(new Rule(event));
		}
	}
	
	public void addGoal(SimpleSentence goal, RuleSet ruleSet) {
		// Create the bound goal from the generic definition
		Goal completeGoal = new Goal(this.goalsDefinitions.getGoal(goal.getName()), goal);
		
		// Get the next definition of the goal, which is the first one
		Clause definition = completeGoal.getNextDefinition();
		
		// Create an entry in the list of goals to solve
		this.goalsList.put(completeGoal, definition.getSolver(ruleSet, new SubstitutionSet()));
	}
	
	public void solveGoal(Iterator<Goal> goals, RuleSet ruleSet) {
		Goal goal = goals.next();
		AbstractSolutionNode root = this.goalsList.get(goal);
		AbstractSolutionNode leaf = root.getDeepestLeaf();
		leaf.reset(leaf.getParentSolution(), ruleSet);
		SubstitutionSet solution = leaf.nextSolution();
		
		// If there is a solution the goal is solved
		if (solution != null) {
			goals.remove();
			
			return;
		}
			
		// If the leaf is a stuck and
		if (leaf instanceof AndSolutionNode) {
			Clause simpleSentence = ((AndSolutionNode) leaf).getHeadSolutionNode().getClause();
			if (simpleSentence instanceof SimpleSentence) {
				Action action = Database.getInstance().getDSet().getAction(((SimpleSentence) simpleSentence).getName());
				
				// If it is an action add it to the next action to do
				if (action != null) {
					this.addNextEvent((SimpleSentence) simpleSentence);
					
					return;
				}
			}
		}
		
		// If the leaf is a stuck simple sentence
		if (leaf instanceof SimpleSentenceSolutionNode) {
			SimpleSentence simpleSentence = (SimpleSentence) leaf.getClause();
			Action action = Database.getInstance().getDSet().getAction(simpleSentence.getName());
			
			// If it is an action add it to the next action to do
			if (action != null) {
				if (action.actionsAllowed(simpleSentence, ruleSet)) {
					this.addNextEvent(simpleSentence);
				}
				
				return;
			}
		}
					
		// Otherwise, according to the strategy, get the next definition to check.
		if (goal.hasNextDefinition()) {
			root = goal.getNextDefinition().getSolver(ruleSet, new SubstitutionSet());
			this.goalsList.put(goal, root);
			solveGoal(goals, ruleSet);
			
			return;
		
		// If there is no other definition reset and wait for the next cycle
		} else {
			goal.reset();
			root = goal.getNextDefinition().getSolver(ruleSet, new SubstitutionSet());
			this.goalsList.put(goal, root);
			
			return;
		}
	}

	public void solveGoals(RuleSet events) {
		RuleSet ruleSet = Database.getInstance().getRuleSet();
    	ruleSet.addRules(events.getRules());
    	
    	Set<Goal> keys = this.goalsList.keySet();
    	for(Iterator<Goal> goals = keys.iterator(); goals.hasNext();) {
    		solveGoal(goals, ruleSet);
    	}
    	
    	CycleHandler.getInstance().setEvents(nextEvents);
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.goalsList.toString();
	}
	

}
