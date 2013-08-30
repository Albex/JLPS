package model;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is a singleton class that represents the database of the framework. It
 * contains the method to update itself.
 * <p>
 * The constructor is private as you must not use it. Instead use the
 * {@code getInstance()} method to get the only object of the class (or to
 * create it).
 * 
 * @author Alexandre Camus
 * @see #updates(RuleSet)
 */
public class Database {

	private FactSet factsDatabase;
	private RuleSet rulesDatabase;
	private DSet dSet;
	private HashMap<String, Integer> limits;
	private static volatile Database instance = null;

	/**
	 * Constructor of the class. It is private as it must not be
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
	 * This is the method to get an instance of the class.
	 * Use it as shown: {@code Database.getInstance()}
	 * 
	 * @return the only instance of the class {@code Database}.
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
	 * Sets the facts of the database.
	 * 
	 * @param factsDatabase
	 *            the facts of the database to set
	 */
	public void setFactsDatabase(FactSet factsDatabase) {
		this.factsDatabase = factsDatabase;
	}

	/**
	 * Sets the rules of the database.
	 * 
	 * @param rulesDatabase
	 *            the rules of the database to set
	 */
	public void setRulesDatabase(RuleSet rulesDatabase) {
		this.rulesDatabase = rulesDatabase;
	}
	
	public void setLimits(HashMap<String,Integer> limits) {
		this.limits = limits;
	}
	
	public HashMap<String, Integer> getLimits() {
		return this.limits;
	}

	/**
	 * Adds rules to the database.
	 * 
	 * @param rules
	 *            the rules to add to the database.
	 */
	public void addRulesDatabase(ArrayList<Rule> rules) {
		this.rulesDatabase.addRules(rules);
	}

	/**
	 * Sets the domain theory of the database.
	 * 
	 * @param dSet
	 *            the D set of the database to set
	 */
	public void setdSet(DSet dSet) {
		this.dSet = dSet;
	}

	/**
	 * Gets the D set of the database.
	 * 
	 * @return a {@code DSet} object representing the D set of the database.
	 */
	public DSet getDSet() {
		return this.dSet;
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

	/**
	 * Creates a {@code RuleSet} object that represents the state of the entire
	 * database (intensional and extensional).
	 * 
	 * @return a {@code RuleSet} object containing all the rules of the
	 *         database.
	 */
	public RuleSet getRuleSet() {
		RuleSet ruleSet = this.factsDatabase.toRuleSet();
		ruleSet.setExtensional(ruleSet.getRuleCount());
		ruleSet.addRules(this.rulesDatabase.getRules());
		ruleSet.setIntensional(ruleSet.getRuleCount());
		
		return ruleSet;
	}
	
	/**
	 * Updates the database when the step cycle asks so. This should be only
	 * used by a {@code CycleState} implementation.
	 * 
	 * @param events
	 *            the events that have been triggered during the previous cycle.
	 * @see DatabaseUpdateState
	 */
	public void updates(RuleSet events) {
		RuleSet rules = this.getRuleSet();
		rules.addRules(events.getRules());
		
		ArrayList<SimpleSentence> fluentsToInitiate = new ArrayList<SimpleSentence>();
		ArrayList<SimpleSentence> fluentsToTerminate = new ArrayList<SimpleSentence>();

		for(Rule currentEvent : events.getRules()) {
			// Get the action to perform
			Action action = this.dSet.getAction(currentEvent.getHead().getName());
			
			if(action != null) {
				// Get the update to perform
				ArrayList<SimpleSentence> fluents = action.fluentsToInitiate(currentEvent.getHead(), rules);
				if (fluents != null) {
					fluentsToInitiate.addAll(fluents);
				}
				fluents = action.fluentsToTerminate(currentEvent.getHead(), rules);
				if (fluents != null) {
					fluentsToTerminate.addAll(fluents);
				}
			}
		}
		
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
