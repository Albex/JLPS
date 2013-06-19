import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Database {

	private HashMap<String, ArrayList<Predicate>> database;
	private HashMap<String, Stack<DPostDeclaration>> initiaters;
	private HashMap<String, Stack<DPostDeclaration>> terminaters;
	private static volatile Database instance = null;
	
	private Database() {
		super();
		this.database = new HashMap<String,ArrayList<Predicate>>();
		this.initiaters = new HashMap<String,Stack<DPostDeclaration>>();
		this.terminaters = new HashMap<String,Stack<DPostDeclaration>>();
	}
	
	private Database(HashMap<String, ArrayList<Predicate>> initialDB, HashMap<String, Stack<DPostDeclaration>> iinit, HashMap<String, Stack<DPostDeclaration>> iterm) {
		super();
		this.database = initialDB;
		this.initiaters = iinit;
		this.terminaters = iterm;
	}
	
	public final static Database getInstance() {
		 if (Database.instance == null) {
			 synchronized(Database.class) {
				 if (Database.instance == null) {
					 Database.instance = new Database();
				 }
			 }
		 }
		 
		 return Database.instance;
	}
	
	public final static Database getInstance(HashMap<String, ArrayList<Predicate>> initialDB, HashMap<String, Stack<DPostDeclaration>> iinit, HashMap<String, Stack<DPostDeclaration>> iterm) {
		 if (Database.instance == null) {
			 synchronized(Database.class) {
				 if (Database.instance == null) {
					 Database.instance = new Database(initialDB, iinit, iterm);
				 }
			 }
		 }
		 
		 return Database.instance;
	}
	
	public final void printOut() {
		HashMap<String, ArrayList<Predicate>> db = this.database;
		HashMap<String, Stack<DPostDeclaration>> init = this.initiaters;
		HashMap<String, Stack<DPostDeclaration>> term = this.terminaters;
		System.out.println("DB:");
		System.out.println(db.toString());
		System.out.println("Init:");
		System.out.println(init.toString());
		System.out.println("Term:");
		System.out.println(term.toString());
	}

	public void updates(Stack<Predicate> events) {
		Stack<Predicate> copyEvents = events;
		while (!copyEvents.empty()) {
			/* determines the actions to be performed */
			Predicate currentEvent = copyEvents.pop();
			Stack<DPostDeclaration> fluentsToInitiate = (Stack<DPostDeclaration>) ((this.initiaters.get(currentEvent.getName()) != null) ? this.initiaters.get(currentEvent.getName()).clone() : new Stack<>());
			Stack<DPostDeclaration> fluentsToTerminate = (Stack<DPostDeclaration>) (this.terminaters.get(currentEvent.getName()) != null ? this.terminaters.get(currentEvent.getName()).clone() : new Stack<>());
			
			/* does the update */
			while (!fluentsToTerminate.empty()) {
				Predicate currentFluent = fluentsToTerminate.pop().getGroundFluent(currentEvent);
				this.database.get(currentFluent.getName()).remove(currentFluent);
				if (this.database.get(currentFluent.getName()).isEmpty()) {
					this.database.remove(currentFluent.getName());
				}
			}
			while (!fluentsToInitiate.empty()) {
				Predicate currentFluent = fluentsToInitiate.pop().getGroundFluent(currentEvent);
				System.out.println(currentFluent.getName());
				if (!this.database.containsKey(currentFluent.getName())) {
					ArrayList<Predicate> fluentList = new ArrayList<>();
					fluentList.add(currentFluent);
					this.database.put(currentFluent.getName(),fluentList);
				} else if (!this.database.get(currentFluent.getName()).contains(currentFluent)) {
					this.database.get(currentFluent.getName()).add(currentFluent);
				}
			}
			
		}
	}

}
