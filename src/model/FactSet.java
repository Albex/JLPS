/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * This class represents the updatable part of the database. This is the
 * extensional clauses of the database.
 * <p>
 * The facts are stored as {@code SimpleSentence} in a {@code HashMap} sorted by
 * name.
 * 
 * @author Alexandre Camus
 * 
 */
public class FactSet {
	
	private HashMap<String, ArrayList<SimpleSentence>> facts;

	/**
	 * Constructor of the class.
	 * 
	 * @param facts
	 *            an array of the facts to be stored in the set or each fact as
	 *            a parameter.
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
	
	/**
	 * Gets the facts.
	 * 
	 * @return the {@code HashMap} containing all the facts.
	 */
	public HashMap<String, ArrayList<SimpleSentence>> getFacts() {
		return this.facts;
	}
	
	/**
	 * Gets the facts corresponding to the name of the parameter.
	 * 
	 * @param name
	 *            the name of the facts to get.
	 * @return an {@code ArrayList} of the facts of the name {@code name}
	 *         existing in the set.
	 */
	public ArrayList<SimpleSentence> getFact(String name) {
		return this.facts.get(name);
	}
	
	/**
	 * Removes the fact specified in the parameter.
	 * 
	 * @param fact
	 *            the fact to remove.
	 */
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
	
	/**
	 * Checks if the specified fact can be made true in the set.
	 * <p>
	 * The test is done thanks to the
	 * {@link Unifiable#unify(Unifiable, SubstitutionSet) unify()} function.
	 * 
	 * @param fact
	 *            that is checked if it is true in the set.
	 * @return true if it true in the set, otherwise false.
	 */
	public boolean isTrue(Unifiable fact) {
		boolean exists = false;
		
		for (Unifiable currentFact : this.facts.get(fact.getName())) {
			if (fact.unify(currentFact, new SubstitutionSet()) != null) {
				exists = true;
			}
		}
		
		return exists;
	}
	
	/**
	 * Adds the specified fact to the set, if the fact is not already true
	 * according to the method {@link #isTrue(Unifiable) isTrue()}.
	 * 
	 * @param fact
	 *            to add in the set.
	 */
	public void addFact(SimpleSentence fact) {
		if (!this.facts.containsKey(fact.getName())) {
			this.facts.put(fact.getName(), new ArrayList<SimpleSentence>());
		}
		
		if (!isTrue(fact)) {
			this.facts.get(fact.getName()).add(fact);
		}
	}
	
	/**
	 * Returns the set in the form of:
	 * "Facts: {factName=[factsOfThisName], otherName=[othersFacts]}".
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Facts: " + this.facts.toString();
	}
	
	/**
	 * Creates a {@code RuleSet} object containing the facts as its rules.
	 * 
	 * @return the {@code RuleSet} containing the facts.
	 */
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
