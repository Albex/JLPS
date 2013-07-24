/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Albex
 *
 */
public class FactSet {
	
	private HashMap<String, ArrayList<SimpleSentence>> facts;

	/**
	 * 
	 */
	public FactSet(SimpleSentence... facts) {
		SimpleSentence[] factsArray = facts;
		
		this.facts = new HashMap<String, ArrayList<SimpleSentence>>();
		
		for (int i = 0; i < factsArray.length; i++) {
			if (!this.facts.containsKey(factsArray[i].getName())) {
				this.facts.put(factsArray[i].getName(), new ArrayList<SimpleSentence>());
			}
			this.facts.get(factsArray[i].getName()).add(factsArray[i]);
		}
	}
	
	public HashMap<String, ArrayList<SimpleSentence>> getFacts() {
		return this.facts;
	}
	
	public ArrayList<SimpleSentence> getFact(String name) {
		return this.facts.get(name);
	}
	
	public void removeFacts(Unifiable fact) {
		for(Iterator<SimpleSentence> facts = this.facts.get(fact.getName()).iterator(); facts.hasNext();) {
			Unifiable currentFact = facts.next();
			
			if (fact.unify(currentFact, new SubstitutionSet()) != null) {
				facts.remove();
			}
		}
		
		if (this.facts.get(fact.getName()).size() == 0) {
			this.facts.remove(fact.getName());
		}
	}
	
	public boolean isTrue(Unifiable fact) {
		boolean exists = false;
		
		for (Unifiable currentFact : this.facts.get(fact.getName())) {
			if (fact.unify(currentFact, new SubstitutionSet()) != null) {
				exists = true;
			}
		}
		
		return exists;
	}
	
	public void addFact(SimpleSentence fact) {
		if (!this.facts.containsKey(fact.getName())) {
			this.facts.put(fact.getName(), new ArrayList<SimpleSentence>());
		}
		
		if (!isTrue(fact)) {
			this.facts.get(fact.getName()).add(fact);
		}
	}
	
	public String toString() {
		return "Facts: " + this.facts.toString();
	}
	
	public RuleSet toRuleSet() {
		ArrayList<Rule> rulesArray = new ArrayList<Rule>();
		ArrayList<SimpleSentence> factsArray = new ArrayList<SimpleSentence>();
		
		Collection<ArrayList<SimpleSentence>> facts = this.facts.values();
		for(ArrayList<SimpleSentence> iterator : facts) {
			factsArray.addAll(iterator);
		}
		
		for(SimpleSentence fact : factsArray) {
			rulesArray.add(new Rule(fact));
		}
		
		return new RuleSet(rulesArray);
	}

}
