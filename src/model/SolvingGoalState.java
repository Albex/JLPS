package model;


/**
 * This class implements the {@code CycleState} interface. It tries to solves
 * the goals and updates the actions that will be performed during the next
 * cycle.
 * 
 * @author Alexandre Camus
 * @see CycleState
 */
class SolvingGoalState implements CycleState {

	/**
	 * This is the implementation of the
	 * {@link CycleState#handlerMethod(CycleHandler, String, RuleSet)
	 * CycleState#handlerMethod()}. Here it tries to solves the goals and
	 * updates the actions that will be performed during the next cycle.
	 * 
	 * @param STATE_CONTEXT
	 *            the manager of the state which is here the only instance of
	 *            {@code CycleHandler}.
	 * @param NAME
	 *            the name of the step. It has no use except to debug.
	 * @param events
	 *            an object {@code RuleSet} that contains the events/actions
	 *            that will be or have been performed during the very cycle.
	 * @see CycleState#handlerMethod(CycleHandler, String, RuleSet)
	 */
	@Override
	public void handlerMethod(CycleHandler STATE_CONTEXT, String NAME, RuleSet events) {
		solveGoals(events);
		STATE_CONTEXT.setState(new DatabaseUpdateState());
	}
	
	private void solveGoals(RuleSet events) {
		RuleSet ruleSet = Database.getInstance().getRuleSet();
		
		GoalsList.getInstance().solveGoals(ruleSet, events);
	}

}
