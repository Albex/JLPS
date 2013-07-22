package main;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Stack;

import model.CycleHandler;
import model.Database;
import model.Initiator;
import model.Rule;
import model.RuleSet;
import model.SimpleSentence;
import model.SubstitutionSet;
import model.Terminator;

import controller.Interpreter;


public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        try {
			Rule r1 = new Rule(Interpreter.getInstance().stringToSimpleSentence("p2(1)"));
			Rule r2 = new Rule(Interpreter.getInstance().stringToSimpleSentence("p2(2)"));
			Rule r3 = new Rule(Interpreter.getInstance().stringToSimpleSentence("p3()"));
			RuleSet db = new RuleSet(r1, r2, r3);
			
			Initiator i1 = (Initiator) Interpreter.getInstance().stringToDPost("initiates(e1(X), p1(X))");
			HashMap<String, Stack<Initiator>> initiators = new HashMap<String, Stack<Initiator>>();
			Stack<Initiator> tempi = new Stack<Initiator>();
			tempi.push(i1);
			initiators.put("e1", tempi);
			Terminator t1 = (Terminator) Interpreter.getInstance().stringToDPost("terminates(e1(X), p2(Y))");
			HashMap<String, Stack<Terminator>> terminators = new HashMap<String, Stack<Terminator>>();
			Stack<Terminator> tempt = new Stack<Terminator>();
			tempt.push(t1);
			terminators.put("e1", tempt);
			
			Database.getInstance(db, new RuleSet(), initiators, terminators);
			Database.getInstance().printOut();
			
			Stack<SimpleSentence> events = new Stack<SimpleSentence>();
			events.push(Interpreter.getInstance().stringToSimpleSentence("e1(2)"));
			events.push(Interpreter.getInstance().stringToSimpleSentence("e2()"));
			
			CycleHandler.getInstance().setEvents(events);
			
			try {
				CycleHandler.getInstance().handlerMethod("name");
			} catch (CloneNotSupportedException e) {
				System.out.println(e.getMessage());
			}
			
			Database.getInstance().printOut();
			
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		}
	}

}
