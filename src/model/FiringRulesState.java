package model;

import java.util.ArrayList;

class FiringRulesState implements CycleState {
	
    @Override
    public void handlerMethod(final CycleHandler STATE_CONTEXT, final String NAME) {
    	this.fireRules();
    }

    public void fireRules() {
    	RuleSet ruleSet = Database.getInstance().getRuleSet();
    	ArrayList<Unifiable> goals = ReactiveRuleSet.getInstance().fireRules(ruleSet);
    	System.out.println(goals);
    }
    
}