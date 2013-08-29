package main;

import java.io.IOException;
import java.util.Scanner;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.fusesource.jansi.AnsiConsole;

import model.CycleHandler;
import model.Database;
import model.GoalsList;
import model.ReactiveRuleSet;
import model.Rule;
import controller.syntax.JLPSSyntaxLexer;
import controller.syntax.JLPSSyntaxParser;


public class JLPS {

	public JLPS() {
	}
	
	public static CharStream fileOpener(String path, boolean absolutePath) throws IOException {
		if (!absolutePath) {
			path = System.getProperty("user.dir") + path;
		}
		
		return new ANTLRFileStream(path);
	}
	
	public static void fileReader(CharStream fileStream) throws RecognitionException {
		JLPSSyntaxLexer lexer = new JLPSSyntaxLexer(fileStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		JLPSSyntaxParser parser = new JLPSSyntaxParser(tokenStream);
		boolean[] warnings = parser.file();
		
		if (warnings[0]) {
			AnsiConsole.out.println("\u001B[33m" + "/!\\ No initial facts defined" + "\u001B[37m");
		}
		if (warnings[1]) {
			AnsiConsole.out.println("\u001B[33m" + "/!\\ No intensional rules defined" + "\u001B[37m");
		}
		if (warnings[2]) {
			AnsiConsole.out.println("\u001B[33m" + "/!\\ No domain theory defined" + "\u001B[37m");
		}
		if (warnings[3]) {
			AnsiConsole.out.println("\u001B[33m" + "/!\\ No reactive rules defined" + "\u001B[37m");
		}
		if (warnings[4]) {
			AnsiConsole.out.println("\u001B[33m" + "/!\\ No goals defined" + "\u001B[37m");
		}
		if (warnings[5]) {
			AnsiConsole.out.println("\u001B[33m" + "/!\\ No initial events defined" + "\u001B[37m");
		}
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		try {
			fileReader(fileOpener(args[0], true));
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (RecognitionException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("INITIAL STATE\n----------------");
		Database.getInstance().printOut();
		System.out.println("Reactive rules: {\n" + ReactiveRuleSet.getInstance().toString() + "\n}\n");
		System.out.println("Events: \n" + CycleHandler.getInstance().getEvents());
		
		boolean carryOn = true;
		int i = 1;
		Scanner sc;
		
		while (carryOn) {
			CycleHandler.getInstance().handlerMethod("\nUPDATE " + i + "\n----------------");
			Database.getInstance().printOut();
			CycleHandler.getInstance().handlerMethod("\nFIRING " + i + "\n----------------");
			CycleHandler.getInstance().handlerMethod("\nSOLVING " + i + "\n----------------");
			System.out.println(GoalsList.getInstance().toString());
			System.out.println("Events: \n" + CycleHandler.getInstance().getEvents());
			
			sc = new Scanner(System.in);
			System.out.println("\n?????????????????????????????????\nState " + i + ". Would you like to carry on? [y/N]");
			String answer = sc.nextLine();
			i++;

			if (answer == null) {
				answer = "n";
			}
			if (answer.toLowerCase().equals("n")) {
				System.out.println("?????????????????????????????????\nEND");
				carryOn = false;
			} else {
				System.out.println("Would you like to add events? [y/N]");
				answer = sc.nextLine();
				
				if (answer == null) {
					answer = "n";
				}
				if (answer.toLowerCase().equals("y")) {
					while (true) {
						System.out.println("\nEnter one event (with a dot at the end) or if you are done, enter /");
						answer = sc.nextLine();
						if (answer.equals("/")) {
							System.out.println("?????????????????????????????????\n");
							System.out.println("New events set: \n" + CycleHandler.getInstance().getEvents());
							break;
						}
						JLPSSyntaxLexer lexer = new JLPSSyntaxLexer(new ANTLRStringStream(answer));
						TokenStream tokenStream = new CommonTokenStream(lexer);
						JLPSSyntaxParser parser = new JLPSSyntaxParser(tokenStream);
						try {
							Rule event = parser.rule();
							CycleHandler.getInstance().addEvent(event);
						} catch (RecognitionException e) {
							e.printStackTrace();
						}
					}
				} else {
					System.out.println("?????????????????????????????????\n");
				}
			}
		}
		
		/*Database.getInstance().printOut();
		System.out.println("Reactive rules: {\n" + ReactiveRuleSet.getInstance().toString() + "\n}\n");
		System.out.println("Events: \n" + CycleHandler.getInstance().getEvents());
		
		for(int i = 1; i < 8; i++) {
			CycleHandler.getInstance().handlerMethod("\nUPDATE " + i + "\n----------------");
			Database.getInstance().printOut();
			CycleHandler.getInstance().handlerMethod("\nFIRING " + i + "\n----------------");
			CycleHandler.getInstance().handlerMethod("\nSOLVING " + i + "\n----------------");
			System.out.println(GoalsList.getInstance().toString());
			System.out.println("Events: \n" + CycleHandler.getInstance().getEvents());
		}*/
	}

	//public static void philosopher() throws RemoteException {
		// Database {
		// Facts {
		/*SimpleSentence f1 = Interpreter.stringToSimpleSentence("available(f0)", null);
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
		// }*/
		/*// DSet {
		// {
		HashMap<String, Variable> variables = new HashMap<String, Variable>();
		SimpleSentence a1 = Interpreter.stringToSimpleSentence("pickupForks(F1, philosopher(I), F2)", variables);
		ArrayList<Terminator> terma1 = new ArrayList<Terminator>();
		terma1.add((Terminator) Interpreter.stringToDPost("terminates(pickupForks(F1, philosopher(I), F2), available(F1))", variables));
		terma1.add((Terminator) Interpreter.stringToDPost("terminates(pickupForks(F1, philosopher(I), F2), available(F2))", variables));
		Clause conda1 = Interpreter.stringToClause("available(F1) & available(F2)", variables);
		Clause confa1 = Interpreter.stringToAnd("!pickupForks(F2, philosopher(J), F3) & !pickupForks(F3, philosopher(K), F1)", variables);
		Action pickup = new Action(a1, new ArrayList<Initiator>(), terma1, conda1, confa1);
		// }
		// {
		variables = new HashMap<String, Variable>();
		SimpleSentence a2 = Interpreter.stringToSimpleSentence("putdownForks(F1, philosopher(I), F2)", variables);
		ArrayList<Initiator> inita2 = new ArrayList<Initiator>();
		inita2.add((Initiator) Interpreter.stringToDPost("initiates(putdownForks(F1, philosopher(I), F2), available(F1))", variables));
		inita2.add((Initiator) Interpreter.stringToDPost("initiates(putdownForks(F1, philosopher(I), F2), available(F2))", variables));
		Action putdown = new Action(a2, inita2, new ArrayList<Terminator>(), null, null);
		// }
		DSet D = new DSet(pickup, putdown);
		// }
		Database.getInstance().setdSet(D);
		// }*/
		/*// ReactiveRule {
		ReactiveRule rr1 = Interpreter.stringToReactiveRule("timeToEat(philosopher(I)) -> dine(philosopher(I))", null);
		ReactiveRuleSet.getInstance(rr1);
		// }*/
		/*// Goals {
		// {
		variables = new HashMap<String, Variable>();
		RuleSet definition = new RuleSet(Interpreter.stringToRule("dine(philosopher(I)) :- adjacent(F1, philosopher(I), F2) & pickupForks(F1, philosopher(I), F2) & putdownForks(F1, philosopher(I), F2)", variables));
		Goal dine = new Goal(definition.getRule(0).getHead(), definition);
		// }
		GoalSet set = new GoalSet(dine);
		GoalsList.getInstance(set);
		// }*/
		/*// Events {
		RuleSet events = new RuleSet(Interpreter.stringToRule("timeToEat(philosopher(0))", null),
				Interpreter.stringToRule("timeToEat(philosopher(1))", null),
				Interpreter.stringToRule("timeToEat(philosopher(2))", null),
				Interpreter.stringToRule("timeToEat(philosopher(3))", null),
				Interpreter.stringToRule("timeToEat(philosopher(4))", null));
		CycleHandler.getInstance().setEvents(events);
		//}*/
	//}
	
}
