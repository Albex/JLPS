import java.rmi.RemoteException;
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
		Predicate e1 = new Predicate("e1", new String[1]);
		Predicate e1b = new Predicate("e1", new String[1]);
		Predicate e2 = new Predicate("e2", null);
		Predicate p1 = new Predicate("p1", new String[1]);
		Predicate p2 = new Predicate("p2", new String[1]);
		Predicate p2b = new Predicate("p2", new String[1]);
		p2b.setVariable("1", 0);
		Predicate p2t = new Predicate("p2", new String[1]);
		p2t.setVariable("2", 0);
		Predicate p3 = new Predicate("p3", null);
		/*ArrayList<Predicate> temp1 = new ArrayList<Predicate>(1);*/
		ArrayList<Predicate> temp2 = new ArrayList<Predicate>(1);
		ArrayList<Predicate> temp3 = new ArrayList<Predicate>(1);
		HashMap<String, ArrayList<Predicate>> db = new HashMap<String, ArrayList<Predicate>>();
		/*temp1.add(p1);*/
		temp2.add(p2b);
		temp2.add(p2t);
		temp3.add(p3);
		/*db.put(p1.getName(), temp1);*/
		db.put(p2.getName(), temp2);
		db.put(p3.getName(), temp3);
		
		HashMap<String, Stack<Initiator>> initiators = new HashMap<String, Stack<Initiator>>(1);
		Stack<Initiator> stack1 = new Stack<Initiator>();
		Integer[] lkVar = { 0 };
		Initiator dp1 = new Initiator(e1, p1, lkVar, null);
		stack1.push(dp1);
		initiators.put(e1.getName(), stack1);
		
		HashMap<String, Stack<Terminator>> terminators = new HashMap<String, Stack<Terminator>>(1);
		Stack<Terminator> stack2 = new Stack<Terminator>();
		Terminator dp2 = new Terminator(e1, p2, new Integer[0], null);
		stack2.push(dp2);
		terminators.put(e1.getName(), stack2);
		
		Database.getInstance(db, initiators, terminators);
		Database.getInstance().printOut();
		
		Stack<Predicate> events = new Stack<Predicate>();
		e1b.setVariable("2", 0);
		events.push(e1b);
		events.push(e2);
		CycleHandler.getInstance().setEvents(events);
		System.out.println(CycleHandler.getInstance().getEvents().toString());
		CycleHandler.getInstance().handlerMethod("name");
		
		Database.getInstance().printOut();
		System.out.println(p2.equals(p2b));
        try{
            System.out.println(Interpreter.getInstance().prologToPredicate("test()").toString());
            System.out.println(Interpreter.getInstance().prologToDPost("initiates(a(X,Y),v(Y,X))").toString());
        }
        catch(RemoteException err) {
            System.out.println(err.getMessage());
        }
	}

}
