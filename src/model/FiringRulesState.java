package model;

import java.util.ArrayList;

class FiringRulesState implements CycleState {
	
    @Override
    public void handlerMethod(final CycleHandler STATE_CONTEXT, final String NAME, RuleSet events) {
    	this.fireRules(events);
    }

    public void fireRules(RuleSet events) {
    	RuleSet ruleSet = Database.getInstance().getRuleSet();
    	
    	ruleSet.addRules(events.getRules());
    	ArrayList<Unifiable> goals = ReactiveRuleSet.getInstance().fireRules(ruleSet);
    	System.out.println(goals);
    }
    
}