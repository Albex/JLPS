package main;
import java.rmi.RemoteException;
import java.util.ArrayList;

import model.Action;
import model.And;
import model.CycleHandler;
import model.DSet;
import model.Database;
import model.FactSet;
import model.Goal;
import model.Initiator;
import model.ReactiveRule;
import model.ReactiveRuleSet;
import model.Rule;
import model.RuleSet;
import model.SimpleSentence;
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
			SimpleSentence r1 = Interpreter.getInstance().stringToSimpleSentence("p2(1)", null);
			SimpleSentence r2 = Interpreter.getInstance().stringToSimpleSentence("p2(2)", null);
			SimpleSentence r3 = Interpreter.getInstance().stringToSimpleSentence("p3(d(X))", null);
			FactSet db = new FactSet(r1, r2, r3);
			
			Initiator i1 = (Initiator) Interpreter.getInstance().stringToDPost("initiates(e1(X), p1(X))", null);
			ArrayList<Initiator> initiators = new ArrayList<Initiator>();
			initiators.add(i1);
			Terminator t1 = (Terminator) Interpreter.getInstance().stringToDPost("terminates(e1(X), p2(Y))", null);
			ArrayList<Terminator> terminators = new ArrayList<Terminator>();
			terminators.add(t1);
			Action e1 = new Action(Interpreter.getInstance().stringToSimpleSentence("e1(X)", null), initiators, terminators, null);
			
			Database.getInstance(db, new RuleSet(), new DSet(e1));
			Database.getInstance().printOut();
			
			ArrayList<Rule> events = new ArrayList<Rule>();
			events.add(new Rule(Interpreter.getInstance().stringToSimpleSentence("e1(2)", null)));
			events.add(new Rule(Interpreter.getInstance().stringToSimpleSentence("e2()", null)));
			
			System.out.println(new RuleSet(events));
			
			ReactiveRule rule = Interpreter.getInstance().stringToReactiveRule("p1(X) & !p2() & e1(X) -> g1(X)", null);
			ReactiveRuleSet.getInstance(rule);
			System.out.println("Reactive rules :" + ReactiveRuleSet.getInstance().toString() + "\n");
			
			CycleHandler.getInstance().setEvents(new RuleSet(events));
			
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
