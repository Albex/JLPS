package main;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import model.AbstractOperator;
import model.CycleHandler;
import model.Database;
import model.FactSet;
import model.Goal;
import model.Initiator;
import model.ReactiveRule;
import model.ReactiveRuleSet;
import model.Rule;
import model.RuleSet;
import model.SimpleSentence;
import model.SubstitutionSet;
import model.Terminator;
import model.Unifiable;
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
			SimpleSentence r1 = Interpreter.getInstance().stringToSimpleSentence("p2(1)");
			SimpleSentence r2 = Interpreter.getInstance().stringToSimpleSentence("p2(2)");
			SimpleSentence r3 = Interpreter.getInstance().stringToSimpleSentence("p3()");
			FactSet db = new FactSet(r1, r2, r3);
			
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
			
			System.out.println(events);
			
			Goal conditions = Interpreter.getInstance().stringToGoal("p1(X) & !p2()");
			ReactiveRule rule = new ReactiveRule(conditions, (Unifiable) Interpreter.getInstance().stringToSimpleSentence("g1(X)"));
			ReactiveRuleSet.getInstance(rule);
			System.out.println("Reactive rules :" + ReactiveRuleSet.getInstance().toString() + "\n");
			
			CycleHandler.getInstance().setEvents(events);
			
			try {
				CycleHandler.getInstance().handlerMethod("name");
			} catch (CloneNotSupportedException e) {
				System.out.println(e.getMessage());
			}
			
			Database.getInstance().printOut();
			
			try {
				CycleHandler.getInstance().handlerMethod("name");
			} catch (CloneNotSupportedException e) {
				System.out.println(e.getMessage());
			}
			
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		}
	}

}
