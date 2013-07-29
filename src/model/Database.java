package model;
import java.util.ArrayList;

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
	 * This is the second constructor of the class that allows to initiate the
	 * database. It is private as it must not be called. Use the method
	 * {@code getInstance(FactSet, RuleSet, DSet)} instead.
	 * 
	 * @see #getInstance(FactSet, RuleSet, DSet)
	 * @param initialFacts
	 *            contains the initial facts.
	 * @param initialRules
	 *            contains the initial rules.
	 * @param dSet
	 *            contains all the actions definitions.
	 */
	private Database(FactSet initialFacts, RuleSet initialRules, DSet dSet) {
		this.factsDatabase = initialFacts;
		this.rulesDatabase = initialRules;
		this.dSet = dSet;
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
	 * This is the second method to get an instance of the class. It allows one
	 * to initiate all the attributes of the class.
	 * 
	 * @return the only instance of the class {@code Database}.
	 * @param initialFacts
	 *            contains the initial facts.
	 * @param initialRules
	 *            contains the initial rules.
	 * @param dSet
	 *            contains all the actions definitions.
	 */
	public final static Database getInstance(FactSet initialFacts, RuleSet initialRules, DSet dSet) {
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

	/**
	 * Creates a {@code RuleSet} object that represents the state of the entire
	 * database (intensional and extensional).
	 * 
	 * @return a {@code RuleSet} object containing all the rules of the
	 *         database.
	 */
	public RuleSet getRuleSet() {
		RuleSet ruleSet = this.factsDatabase.toRuleSet();
		ruleSet.addRules(this.rulesDatabase.getRules());
		
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
