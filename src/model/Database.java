package model;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is a singleton class that represents the database of the framework. It
 * contains the method to update itself.
 * 
 * The constructor is private as you must not use it.
 * Instead use the getInstance method to get the only object of the class (or to create it).
 * 
 * It has three private attributes.
 * @author Albex
 * @see #updates(ArrayList)
 */
public class Database {

	private FactSet factsDatabase;
	private RuleSet rulesDatabase;
	private DSet dSet;
	private static volatile Database instance = null;

	/**
	 * This the constructor of the class. It is private as it must not be
	 * called. Use the method {@code getInstance()} instead.
	 * 
	 * @see #getInstance()
	 */
	private Database() {
		this.factsDatabase = new FactSet();
		this.rulesDatabase = new RuleSet();
		this.dSet = new DSet();
	}

	/**
	 * This is the second constructor of the class that allows to initiate the
	 * database. It is private as it must not be called. Use the method
	 * <code>getInstance(initialDB, initialInitiators, initialTerminators)</code> instead.
	 * 
	 * @see #getInstance(RuleSet, HashMap, HashMap)
	 * @param initialDB
	 *            is the initial database.
	 * @param initialInitiators
	 *            contains all the initiators of the actions or events.
	 * @param initialTerminators
	 *            contains all the terminators of the actions or events.
	 */
	private Database(FactSet initialFacts, RuleSet initialRules, DSet dSet) {
		this.factsDatabase = initialFacts;
		this.rulesDatabase = initialRules;
		this.dSet = dSet;
	}

	/**
	 * This is the method to get an instance of the class.
	 * Use it as shown: <code>Database.getInstance()</code>
	 * 
	 * @return the only instance of the class <code>Database</code>.
	 */
	public final static Database getInstance() {
		if (Database.instance == null) {
			synchronized (Database.class) {
				if (Database.instance == null) {
					Database.instance = new Database();
				}
			}
		}

		return Database.instance;
	}

	/**
	 * This is the second method to get an instance of the class. It allows one
	 * to initiate all the attributes of the class.
	 * 
	 * @return the only instance of the class <code>Database</code>.
	 * @param initialDB
	 *            is the initial database.
	 * @param initialInitiators
	 *            contains all the initiators of the actions or events.
	 * @param initialTerminators
	 *            contains all the terminators of the actions or events.
	 */
	public final static Database getInstance(
			FactSet initialFacts, RuleSet initialRules, DSet dSet) {
		if (Database.instance == null) {
			synchronized (Database.class) {
				if (Database.instance == null) {
					Database.instance = new Database(initialFacts, initialRules, dSet);
				}
			}
		}

		return Database.instance;
	}

	/**
	 * This method display the state of the database in the console.
	 */
	public final void printOut() {
		FactSet facts = this.factsDatabase;
		RuleSet rules = this.rulesDatabase;
		DSet dSet = this.dSet;
		System.out.println("DB:");
		System.out.println(facts.toString());
		System.out.print("Rules: ");
		System.out.println(rules.toString());
		System.out.println(dSet.toString());
		System.out.println("");
	}

	public RuleSet getRuleSet() {
		RuleSet ruleSet = this.factsDatabase.toRuleSet();
		ruleSet.addRules(this.rulesDatabase.getRules());
		
		return ruleSet;
	}
	
	/**
	 * This is the method that updates the database when the step cycle asks so.
	 * This should be only used by a <code>CycleState</code> implementation.
	 * 
	 * @param events
	 *            the events that have been triggered during the previous cycle.
	 * @see DatabaseUpdateState
	 */
	public void updates(RuleSet events) throws CloneNotSupportedException {

		for(Rule currentEvent : events.getRules()) {
			// Get the action to perform
			Action action = this.dSet.getAction(currentEvent.getHead().getName());
			
			if(action != null) {
				// Get the update to perform
				ArrayList<SimpleSentence> fluentsToInitiate = action.fluentsToInitiate(currentEvent.getHead());
				ArrayList<SimpleSentence> fluentsToTerminate = action.fluentsToTerminate(currentEvent.getHead());
				
				// Do the update
				// First the terminations
				for (SimpleSentence currentFluent : fluentsToTerminate) {
					this.factsDatabase.removeFacts(currentFluent);
				}
				
				// Then the initiations
				for (SimpleSentence currentFluent : fluentsToInitiate) {
					this.factsDatabase.addFact(currentFluent);
				}
			}
		}
	}

}
