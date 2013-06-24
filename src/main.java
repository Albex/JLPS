import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Predicate e1 = new Predicate("e1", null);
		Predicate e2 = new Predicate("e2", null);
		Predicate p1 = new Predicate("p1", null);
		Predicate p2 = new Predicate("p2", null);
		Predicate p3 = new Predicate("p3", null);
		/*ArrayList<Predicate> temp1 = new ArrayList<Predicate>(1);*/
		ArrayList<Predicate> temp2 = new ArrayList<Predicate>(1);
		ArrayList<Predicate> temp3 = new ArrayList<Predicate>(1);
		HashMap<String, ArrayList<Predicate>> db = new HashMap<String, ArrayList<Predicate>>();
		/*temp1.add(p1);*/
		temp2.add(p2);
		temp3.add(p3);
		/*db.put(p1.getName(), temp1);*/
		db.put(p2.getName(), temp2);
		db.put(p3.getName(), temp3);
		
		HashMap<String, Stack<Initiater>> initiaters = new HashMap<>(1);
		Stack<Initiater> stack1 = new Stack<>();
		Initiater dp1 = new Initiater(e1, p1, new Integer[0]);
		stack1.push(dp1);
		initiaters.put(e1.getName(), stack1);
		
		HashMap<String, Stack<Terminater>> terminaters = new HashMap<>(1);
		Stack<Terminater> stack2 = new Stack<>();
		Terminater dp2 = new Terminater(e1, p2, new Integer[0]);
		stack2.push(dp2);
		terminaters.put(e1.getName(), stack2);
		
		Database.getInstance(db, initiaters, terminaters);
		Database.getInstance().printOut();
		
		Stack<Predicate> events = new Stack<>();
		events.push(e1);
		events.push(e2);
		CycleHandler.getInstance().setEvents(events);
		CycleHandler.getInstance().handlerMethod("name");
		
		Database.getInstance().printOut();
	}

}
