package main;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import model.Action;
import model.Clause;
import model.CycleHandler;
import model.DSet;
import model.Database;
import model.FactSet;
import model.Goal;
import model.GoalSet;
import model.GoalsList;
import model.Initiator;
import model.ReactiveRule;
import model.ReactiveRuleSet;
import model.Rule;
import model.RuleSet;
import model.SimpleSentence;
import model.Terminator;
import model.Variable;
import controller.Interpreter;


public class main {

	public main() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*try {
			SimpleSentence r1 = Interpreter.stringToSimpleSentence("p2(1)", null);
			SimpleSentence r2 = Interpreter.stringToSimpleSentence("p2(2)", null);
			SimpleSentence r3 = Interpreter.stringToSimpleSentence("p3(d(X))", null);
			FactSet db = new FactSet(r1, r2, r3);
			
			Initiator i1 = (Initiator) Interpreter.stringToDPost("initiates(e1(X), p1(X))", null);
			ArrayList<Initiator> initiators = new ArrayList<Initiator>();
			initiators.add(i1);
			Terminator t1 = (Terminator) Interpreter.stringToDPost("terminates(e1(X), p2(Y))", null);
			ArrayList<Terminator> terminators = new ArrayList<Terminator>();
			terminators.add(t1);
			Clause conditions = Interpreter.stringToSimpleSentence("p3(d(X))", null);
			Action e1 = new Action(Interpreter.stringToSimpleSentence("e1(X)", null), initiators, terminators, conditions, null);
			
			Database.getInstance(db, new RuleSet(), new DSet(e1));
			Database.getInstance().printOut();
			
			ArrayList<Rule> events = new ArrayList<Rule>();
			events.add(new Rule(Interpreter.stringToSimpleSentence("e1(2)", null)));
			events.add(new Rule(Interpreter.stringToSimpleSentence("e2()", null)));
			
			System.out.println(new RuleSet(events));
			
			ReactiveRule rule = Interpreter.stringToReactiveRule("p1(X) & e1(Y) & !(X == Y) & !(p2() & e2()) -> g1(X)", null);
			ReactiveRuleSet.getInstance(rule);
			
			RuleSet definition = new RuleSet(Interpreter.stringToRule("g1(X) :- e1(3)", null));
			Goal g1 = new Goal(definition.getRule(0).getHead(), definition);
			GoalSet set = new GoalSet(g1);
			GoalsList.getInstance(set);
			
			CycleHandler.getInstance().setEvents(new RuleSet(events));
			
			CycleHandler.getInstance().handlerMethod("update");
			
			Database.getInstance().printOut();
			
			System.out.println("Reactive rules :" + ReactiveRuleSet.getInstance().toString() + "\n");
			
			CycleHandler.getInstance().handlerMethod("firing");
			
			CycleHandler.getInstance().handlerMethod("solving");
			
			System.out.println(GoalsList.getInstance().toString());
			
			System.out.println("\n" + CycleHandler.getInstance().getEvents() + "\n");
			
			CycleHandler.getInstance().handlerMethod("update");
			
			Database.getInstance().printOut();
			
			CycleHandler.getInstance().handlerMethod("firing");
			
			CycleHandler.getInstance().handlerMethod("solving");
			
			System.out.println(GoalsList.getInstance().toString());
			
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		}*/
		
		try {
			philosopher();
			Database.getInstance().printOut();
			System.out.println("Reactive rules: {\n" + ReactiveRuleSet.getInstance().toString() + "\n}\n");
			System.out.println("Events: \n" + CycleHandler.getInstance().getEvents());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for(int i = 1; i < 8; i++) {
			CycleHandler.getInstance().handlerMethod("\nUPDATE " + i);
			Database.getInstance().printOut();
			CycleHandler.getInstance().handlerMethod("\nFIRING " + i);
			CycleHandler.getInstance().handlerMethod("\nSOLVING " + i);
			System.out.println(GoalsList.getInstance().toString());
			System.out.println("Events: \n" + CycleHandler.getInstance().getEvents());
		}
	}

	public static void philosopher() throws RemoteException {
		// Database {
		// Facts {
		SimpleSentence f1 = Interpreter.stringToSimpleSentence("available(f0)", null);
		SimpleSentence f2 = Interpreter.stringToSimpleSentence("available(f1)", null);
		SimpleSentence f3 = Interpreter.stringToSimpleSentence("available(f2)", null);
		SimpleSentence f4 = Interpreter.stringToSimpleSentence("available(f3)", null);
		SimpleSentence f5 = Interpreter.stringToSimpleSentence("available(f4)", null);
		FactSet S = new FactSet(f1, f2, f3, f4, f5);
		// }
		// Rules {
		Rule r1 = Interpreter.stringToRule("adjacent(f0, philosopher(0), f1)", null);
		Rule r2 = Interpreter.stringToRule("adjacent(f1, philosopher(1), f2)", null);
		Rule r3 = Interpreter.stringToRule("adjacent(f2, philosopher(2), f3)", null);
		Rule r4 = Interpreter.stringToRule("adjacent(f3, philosopher(3), f4)", null);
		Rule r5 = Interpreter.stringToRule("adjacent(f4, philosopher(4), f0)", null);
		RuleSet L = new RuleSet(r1, r2, r3, r4, r5);
		// }
		// DSet {
		// {
		HashMap<String, Variable> variables = new HashMap<String, Variable>();
		SimpleSentence a1 = Interpreter.stringToSimpleSentence("pickupFork(F1, philosopher(I), F2)", variables);
		ArrayList<Terminator> terma1 = new ArrayList<Terminator>();
		terma1.add((Terminator) Interpreter.stringToDPost("terminates(pickupFork(F1, philosopher(I), F2), available(F1))", variables));
		terma1.add((Terminator) Interpreter.stringToDPost("terminates(pickupFork(F1, philosopher(I), F2), available(F2))", variables));
		Clause conda1 = Interpreter.stringToClause("available(F1) & available(F2)", variables);
		Clause confa1 = Interpreter.stringToAnd("!pickupFork(F2, philosopher(J), F3) & !pickupFork(F3, philosopher(J), F1)", variables);
		Action pickup = new Action(a1, new ArrayList<Initiator>(), terma1, conda1, confa1);
		// }
		// {
		variables = new HashMap<String, Variable>();
		SimpleSentence a2 = Interpreter.stringToSimpleSentence("putdownFork(F1, philosopher(I), F2)", variables);
		ArrayList<Initiator> inita2 = new ArrayList<Initiator>();
		inita2.add((Initiator) Interpreter.stringToDPost("initiates(putdownFork(F1, philosopher(I), F2), available(F1))", variables));
		inita2.add((Initiator) Interpreter.stringToDPost("initiates(putdownFork(F1, philosopher(I), F2), available(F2))", variables));
		Action putdown = new Action(a2, inita2, new ArrayList<Terminator>(), null, null);
		// }
		DSet D = new DSet(pickup, putdown);
		// }
		Database.getInstance(S, L, D);
		// }
		// ReactiveRule {
		ReactiveRule rr1 = Interpreter.stringToReactiveRule("timeToEat(philosopher(I)) -> dine(philosopher(I))", null);
		ReactiveRuleSet.getInstance(rr1);
		// }
		// Goals {
		// {
		variables = new HashMap<String, Variable>();
		RuleSet definition = new RuleSet(Interpreter.stringToRule("dine(philosopher(I)) :- adjacent(F1, philosopher(I), F2) & pickupFork(F1, philosopher(I), F2) & putdownFork(F1, philosopher(I), F2)", variables));
		Goal dine = new Goal(definition.getRule(0).getHead(), definition);
		// }
		GoalSet set = new GoalSet(dine);
		GoalsList.getInstance(set);
		// }
		// Events {
		RuleSet events = new RuleSet(Interpreter.stringToRule("timeToEat(philosopher(0))", null),
				Interpreter.stringToRule("timeToEat(philosopher(1))", null),
				Interpreter.stringToRule("timeToEat(philosopher(2))", null),
				Interpreter.stringToRule("timeToEat(philosopher(3))", null),
				Interpreter.stringToRule("timeToEat(philosopher(4))", null));
		CycleHandler.getInstance().setEvents(events);
		//}
	}
	
}
