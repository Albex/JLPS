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
			System.out.println("\n?????????????????????????????????\nState " + i + ". Would you like to carry on? [Y/n]");
			String answer = sc.nextLine();
			i++;

			if (answer == null) {
				answer = "y";
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
	}

}
