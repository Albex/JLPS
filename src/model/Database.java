package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * This is a singleton class that represents the database of the framework. It
 * contains the method to update itself.
 * 
 * The constructor is private as you must not use it.
 * Instead use the getInstance method to get the only object of the class (or to create it).
 * 
 * It has three private attributes.
 * @author Albex
 * @see #updates(Stack)
 */
public class Database {

	private HashMap<String, ArrayList<Predicate>> database;
	private HashMap<String, Stack<Initiator>> initiators;
	private HashMap<String, Stack<Terminator>> terminators;
	private static volatile Database instance = null;

	/**
	 * This the constructor of the class. It is private as it must not be
	 * called. Use the method <code>getInstance()</code> instead.
	 * 
	 * @see #getInstance()
	 */
	private Database() {
		super();
		this.database = new HashMap<String, ArrayList<Predicate>>();
		this.initiators = new HashMap<String, Stack<Initiator>>();
		this.terminators = new HashMap<String, Stack<Terminator>>();
	}

	/**
	 * This is the second constructor of the class that allows to initiate the
	 * database. It is private as it must not be called. Use the method
	 * <code>getInstance(initialDB, initialInitiators, initialTerminators)</code> instead.
	 * 
	 * @see #getInstance(HashMap, HashMap, HashMap)
	 * @param initialDB
	 *            is the initial database.
	 * @param initialInitiators
	 *            contains all the initiators of the actions or events.
	 * @param initialTerminators
	 *            contains all the terminators of the actions or events.
	 */
	private Database(HashMap<String, ArrayList<Predicate>> initialDB,
			HashMap<String, Stack<Initiator>> initialInitiators,
			HashMap<String, Stack<Terminator>> initialTerminators) {
		super();
		this.database = initialDB;
		this.initiators = initialInitiators;
		this.terminators = initialTerminators;
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
			HashMap<String, ArrayList<Predicate>> initialDB,
			HashMap<String, Stack<Initiator>> initialInitiators,
			HashMap<String, Stack<Terminator>> initialTerminators) {
		if (Database.instance == null) {
			synchronized (Database.class) {
				if (Database.instance == null) {
					Database.instance = new Database(initialDB, initialInitiators, initialTerminators);
				}
			}
		}

		return Database.instance;
	}

	/**
	 * This method display the state of the database in the console.
	 */
	public final void printOut() {
		HashMap<String, ArrayList<Predicate>> db = this.database;
		HashMap<String, Stack<Initiator>> init = this.initiators;
		HashMap<String, Stack<Terminator>> term = this.terminators;
		System.out.println("DB:");
		System.out.println(db.toString());
		System.out.println("Initiators:");
		System.out.println(init.toString());
		System.out.println("Terminators:");
		System.out.println(term.toString());
		System.out.println("");
	}

	/**
	 * This is the method that updates the database when the step cycle asks so.
	 * This should be only used by a <code>CycleState</code> implementation.
	 * 
	 * @param events
	 *            the events that have been triggered during the previous cycle.
	 * @see DatabaseUpdateState
	 */
	@SuppressWarnings("unchecked")
	public void updates(Stack<Predicate> events) {
		Stack<Predicate> copyEvents = (Stack<Predicate>) events.clone();
		while (!copyEvents.empty()) {
			/* determines the actions to be performed */
			Predicate currentEvent = copyEvents.pop();
			Stack<Initiator> fluentsToInitiate = 
					(Stack<Initiator>) ((this.initiators.get(currentEvent.getName()) != null) ?
							this.initiators.get(currentEvent.getName()).clone() : new Stack<Initiator>());
			Stack<Terminator> fluentsToTerminate = 
					(Stack<Terminator>) (this.terminators.get(currentEvent.getName()) != null ?
							this.terminators.get(currentEvent.getName()).clone() : new Stack<Terminator>());

			/* does the update */
			while (!fluentsToTerminate.empty()) {
				Terminator currentTerminator = fluentsToTerminate.pop();
				
				//if (currentTerminator.getCondition() == null 
					//	&& this.database.get(currentTerminator.getCondition().getName()) != null
						//&& this.database.get(currentTerminator.getCondition().getName())
							//	.contains(currentTerminator.getCondition())) {
					Predicate currentFluent = currentTerminator.getGroundFluent(currentEvent);
					while (this.database.get(currentFluent.getName()).remove(currentFluent)) {}
					
					if (this.database.get(currentFluent.getName()).isEmpty()) {
						this.database.remove(currentFluent.getName());
					}
				//}
			}
			while (!fluentsToInitiate.empty()) {
				Initiator currentInitiator = fluentsToInitiate.pop();
				
				//if (currentInitiator.getCondition() == null
					//	&& this.database.get(currentInitiator.getCondition().getName()) != null
						//&& this.database.get(currentInitiator.getCondition().getName())
							//	.contains(currentInitiator.getCondition())) {
					Predicate currentFluent = currentInitiator.getGroundFluent(currentEvent);
				
					if (!this.database.containsKey(currentFluent.getName())) {
						ArrayList<Predicate> fluentList = new ArrayList<Predicate>();
						fluentList.add(currentFluent);
						this.database.put(currentFluent.getName(), fluentList);
					} else if (!this.database.get(currentFluent.getName()).contains(currentFluent)) {
						this.database.get(currentFluent.getName()).add(currentFluent);
					}
				//}
			}

		}
	}

}
