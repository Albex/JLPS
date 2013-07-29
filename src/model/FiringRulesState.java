package model;

import java.util.ArrayList;

/**
 * This class implements the {@code CycleState} interface. It fires the
 * reactive rules and get the new goals to solve.
 * 
 * @author Alexandre Camus
 * @see CycleState
 * @see ReactiveRuleSet
 */
class FiringRulesState implements CycleState {
	
	/**
	 * Empty constructor of the class.
	 */
	public FiringRulesState() {
	}
	
    /**
     * This is the implementation of the
	 * {@link CycleState#handlerMethod(CycleHandler, String, RuleSet)
	 * CycleState#handlerMethod()}. Here it fires the
	 * reactive rules and gets the new goals to solve.
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
    public void handlerMethod(final CycleHandler STATE_CONTEXT, final String NAME, RuleSet events) {
    	this.fireRules(events);
    }

	/**
	 * This is the private action of the state. It cannot be used except in the
	 * context of the {@code handlerMethod()}. Here this fires the reactive
	 * rules and gets the new goals to solve.
	 * 
	 * @param events
	 * @see ReactiveRuleSet#fireRules(RuleSet)
	 * @see #handlerMethod(CycleHandler, String, RuleSet)
	 */
    private void fireRules(RuleSet events) {
    	RuleSet ruleSet = Database.getInstance().getRuleSet();
    	ruleSet.addRules(events.getRules());
    	
    	ArrayList<String> eventsName = new ArrayList<String>();
    	for (Rule event : events.getRules()) {
    		eventsName.add(event.getHead().getName());
    	}
    	
    	ArrayList<Unifiable> goals = ReactiveRuleSet.getInstance().fireRules(ruleSet, eventsName);
    	System.out.println(goals);
    }
    
}