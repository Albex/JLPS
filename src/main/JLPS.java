package main;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
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
import controller.syntax.JLPSSyntaxParser.file_return;


public class JLPS {

	public JLPS() {
	}
	
	public static CharStream fileOpener(String path, boolean absolutePath) throws IOException {
		if (!absolutePath) {
			path = System.getProperty("user.dir") + path;
		}
		
		return new ANTLRFileStream(path);
	}
	
	public static void fileReader(CharStream fileStream, HashSet<String> facts, HashSet<String> actions) throws RecognitionException {
		JLPSSyntaxLexer lexer = new JLPSSyntaxLexer(fileStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		JLPSSyntaxParser parser = new JLPSSyntaxParser(tokenStream);
		file_return returns = parser.file();
		boolean[] warnings = returns.w;
		facts.addAll(returns.facts);
		actions.addAll(returns.actions);
		
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
	
	private static void limitUserInitialization(HashSet<String> facts, HashSet<String> actions, Scanner sc) {
		HashMap<String, Integer> limits = new HashMap<String, Integer>();
		if (facts != null) {
			AnsiConsole.out.println("\u001B[36m\n?????????????????????????????????\nWhat default waiting limit should be used for fluents? [2]\u001B[37m");
			String answer = sc.nextLine();
			
			if (answer.equals("")) {
				answer = "2";
			}
			
			int defaultLimit = Integer.parseInt(answer);
			int limit;
			
			for(String fact : facts) {
				AnsiConsole.out.println("\u001B[36m" + "What waiting limit should be used for fluent named '" + fact +"'? [" + defaultLimit + "]\u001B[37m");
				answer = sc.nextLine();
				if (answer.equals("")) {
					limit = defaultLimit;
				} else {
					limit = Integer.parseInt(answer);
				}
				limits.put(fact, limit);
			}
		}
		
		if (actions != null) {
			AnsiConsole.out.println("\u001B[36m"+"What default waiting limit should be used for actions? [2]\u001B[37m");
			String answer = sc.nextLine();
			
			if (answer.equals("")) {
				answer = "2";
			}
			
			int defaultLimit = Integer.parseInt(answer);
			int limit;
			
			for(String action : actions) {
				AnsiConsole.out.println("\u001B[36m"+"What waiting limit should be used for action named '" + action +"'? [" + defaultLimit + "]\u001B[37m");
				answer = sc.nextLine();
				if (answer.equals("")) {
					limit = defaultLimit;
				} else {
					limit = Integer.parseInt(answer);
				}
				limits.put(action, limit);
			}
			AnsiConsole.out.println("\u001B[36m"+"?????????????????????????????????\n\u001B[37m");
		}
		Database.getInstance().setLimits(limits);
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		HashSet<String> facts = new HashSet<String>();
		HashSet<String> actions  = new HashSet<String>();
		try {
			fileReader(fileOpener(args[0], true), facts, actions);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (RecognitionException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("INITIAL STATE\n----------------");
		System.out.println(Database.getInstance().toString() + "\n");
		System.out.println(Database.getInstance().getDSet().toString() + "\n");
		System.out.println("Reactive rules: {\n" + ReactiveRuleSet.getInstance().toString() + "\n}\n");
		System.out.println("Events: \n" + CycleHandler.getInstance().getEvents());
		
		Scanner sc;
		sc = new Scanner(System.in);
		limitUserInitialization(facts, actions, sc);
		
		boolean carryOn = true;
		int i = 1;
		
		while (carryOn) {
			CycleHandler.getInstance().handlerMethod("\nUPDATE " + i + "\n----------------");
			System.out.println(Database.getInstance().toString());
			CycleHandler.getInstance().handlerMethod("\nFIRING " + i + "\n----------------");
			CycleHandler.getInstance().handlerMethod("\nSOLVING " + i + "\n----------------");
			System.out.println(GoalsList.getInstance().toString());
			System.out.println("Events: \n" + CycleHandler.getInstance().getEvents());
			
			AnsiConsole.out.println("\u001B[36m\n?????????????????????????????????\nNext State: " + (i+1) + ". Would you like to carry on? [Y/n]\u001B[37m");
			String answer = sc.nextLine();
			i++;

			if (answer.equals("")) {
				answer = "y";
			}
			if (answer.toLowerCase().equals("n")) {
				AnsiConsole.out.println("\u001B[36m"+"?????????????????????????????????\n\u001B[37m" +"END");
				carryOn = false;
			} else {
				AnsiConsole.out.println("\u001B[36m"+"Would you like to add events? [y/N]\u001B[37m");
				answer = sc.nextLine();
				
				if (answer.equals("")) {
					answer = "n";
				}
				if (answer.toLowerCase().equals("y")) {
					while (true) {
						AnsiConsole.out.println("\u001B[36m"+"\nEnter one event (with a dot at the end) or if you are done, enter /\u001B[37m");
						answer = sc.nextLine();
						if (answer.equals("/")) {
							AnsiConsole.out.println("\u001B[36m"+"?????????????????????????????????\n\u001B[37m");
							AnsiConsole.out.println("New events set: \n" + CycleHandler.getInstance().getEvents());
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
					AnsiConsole.out.println("\u001B[36m?????????????????????????????????\n\u001B[37m");
				}
			}
		}
	}

}
