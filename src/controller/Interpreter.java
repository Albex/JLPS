package controller;
import java.rmi.RemoteException;
import java.util.HashMap;

import model.Constant;
import model.DPostDeclaration;
import model.Initiator;
import model.SimpleSentence;
import model.Terminator;
import model.Unifiable;
import model.Variable;

/**
 * This is the controller class.
 * It is a singleton. Do not use the constructor.
 * Use the getInstance() method instead which gives you the instance of the class.
 * It translates Prolog-like declaration into objects for the program.
 * @author Albex
 *
 */
/**
 * @author Albex
 *
 */
public class Interpreter {

	private static volatile Interpreter instance = null;
	
	/**
	 * Constructor of the class. To be not used by itself as the class is a
	 * singleton. Use the specific method <code>getInstance</code> instead.
	 * 
	 * @see #getInstance()
	 */
	private Interpreter() {
		super();
	}

	/**
	 * Gets the only object of this singleton class. Use it as a static method.
	 * 
	 * @return instance the only object of this class. If the object was not
	 *         already created it will create it.
	 */
	public final static Interpreter getInstance() {
		if (Interpreter.instance == null) {
			synchronized (Interpreter.class) {
				if (Interpreter.instance == null) {
					Interpreter.instance = new Interpreter();
				}
			}
		}

		return Interpreter.instance;
	}
    
	/**
	 * Checks whether the input string matches the constant pattern. A constant
	 * must start with a number or a non-capital letter. It is a alpha-numeric
	 * word and can have the symbol _.
	 * 
	 * This method is used to throw exceptions in {@link #stringToConstant(String)}.
	 * 
	 * @param string
	 *            that is the constant
	 * @return true if the string correspond to the constant pattern.
	 */
	public boolean isConstant(String string) {
		// Delete all the spaces before checking any matching
		string = string.replaceAll(" ", "");

		return string.matches("[a-z0-9][A-Za-z0-9_]*");
	}
    
	/**
	 * Converts the input string into a <code>Constant<code> object.
	 * The input string should be a constant.
	 * 
	 * @param string
	 *            to be convert into the <code>Constant<code> object
	 * @return the <code>Constant<code> object representing the constant string
	 *         input.
	 * @throws RemoteException
	 *             if the input does not correspond to a constant according to
	 *             the method <code>isConstant<code>
	 * @see Constant
	 * @see #isConstant(String)
	 */
	public Constant stringToConstant(String string) throws RemoteException {
		// Delete any spaces before converting
		string = string.replaceAll(" ", "");
		
		// Create the Constant to be returned
		Constant res;

		if (this.isConstant(string)) {
			res = new Constant(string);

			return res;
		} else {
			throw new RemoteException("It is not a Constant-like string.");
		}
	}
    
    
	/**
	 * Checks whether the input string matches the variable pattern. A variable
	 * must start a capital letter. It is a alpha-numeric word and can have the
	 * symbol _.
	 * 
	 * This method is used to throw exceptions in {@link #stringToVariable(String)}.
	 * 
	 * @param string
	 *            that is the variable
	 * @return true if the string correspond to the variable pattern.
	 */
	public boolean isVariable(String string) {
		// Delete all the spaces before checking any matching
		string = string.replaceAll(" ", "");

		return string.matches("[A-Z][A-Za-z0-9_]*");
	}
    
	/**
	 * Converts the input string into a <code>Variable<code> object.
	 * The input string should be a variable.
	 * 
	 * @param string
	 *            to be convert into the <code>Variable<code> object
	 * @return the <code>Variable<code> object representing the variable string
	 *         input.
	 * @throws RemoteException
	 *             if the input does not correspond to a constant according to
	 *             the method <code>isVariable<code>
	 * @see Variable
	 * @see #isVariable(String)
	 */
	public Variable stringToVariable(String string) throws RemoteException {
		// Delete any spaces before converting
		string = string.replaceAll(" ", "");
		
		// Create the Variable to be returned
		Variable res;

		if (this.isVariable(string)) {
			res = new Variable(string);

			return res;
		} else {
			throw new RemoteException("It is not a Variable-like string.");
		}
	}
    
	/**
	 * Checks whether the input string matches the simple sentence pattern. It
	 * is a predicate or an event. This string has the form of:
	 * 'constant(parameters)' where 'parameters' are variables or constants
	 * separate by a comma. Constants and variables are checks thanks to their
	 * own methods: {@link #isConstant(String)} and {@link #isVariable(String)}.
	 * 
	 * See a Prolog documentation for more information about Prolog predicate.
	 * This method is used to throw exceptions in {@link #stringToSimpleSentence(String)}
	 * .
	 * 
	 * @param string
	 *            to be checked whether it is a simple sentence or not.
	 * @return true if it matches the general form of a simple sentence,
	 *         otherwise false.
	 * @see <a href="http://en.wikipedia.org/wiki/Prolog">Prolog
	 *      documentation</a>
	 */
	public boolean isSimpleSentence(String string) {
		// Delete all the spaces before checking any matching
		string = string.replaceAll(" ", "");
		
		// TODO check the position of the parenthesis and the commas
		
		// Split the string to get the name and the parameters of the sentence
		String[] strings = string.split("\\(|,|\\)");

		// Check if the name is a constant
		boolean predicateName = isConstant(strings[0]);

		// Check if the parameters are variables or constants
		boolean parameters = true;
		for (int i = 1; i < strings.length; i++) {
			parameters = (isConstant(strings[i]) || isVariable(strings[i])) ? parameters
					: false;
		}

		return predicateName && parameters;
	}

	/**
	 * Converts the input string into a {@code SimpleSentence} object. The input
	 * string should be a simple sentence.
	 * 
	 * @param string
	 *            to be convert into the {@code SimpleSentence} object.
	 * @return the {@code SimpleSentence} object representing the simple
	 *         sentence string input.
	 * @throws RemoteException
	 *             if the input does not correspond to a constant according to
	 *             the method {@code isSimpleSentence}
	 * @see SimpleSentence
	 * @see #isSimpleSentence(String)
	 */
	public SimpleSentence stringToSimpleSentence(String string) throws RemoteException {
		// Delete any spaces before converting
		string = string.replaceAll(" ", "");

		// Create the SimpleSentence to be returned
		SimpleSentence res;

		if (this.isSimpleSentence(string)) {
			// Split the string to get the name and the parameters of the sentence
			String[] nameAndVar = string.split("\\(|,|\\)");

			// Get the name in first position
			Constant predicateName = new Constant(nameAndVar[0]);

			// If there is at least one parameter
			if (nameAndVar.length > 1) {
				// Create an array that will contain the parameters
				Unifiable[] parameters = new Unifiable[nameAndVar.length - 1];

				// Fill the new array
				for (int i = 1; i < nameAndVar.length; i++) {
					// Create a variable or a constant
					parameters[i - 1] = (isVariable(nameAndVar[i])) ? new Variable(nameAndVar[i]) : new Constant(nameAndVar[i]);
				}

				// Initialize the result
				res = new SimpleSentence(predicateName, parameters);

			// If there is no parameter
			} else {
				res = new SimpleSentence(predicateName);
			}

			return res;
		} else {
			throw new RemoteException("It is not a Prolog-like predicate.");
		}
	}
    
	/**
	 * Checks whether the input string matches the DPost declaration pattern. A
	 * DPost declaration is a simple sentence which name is 'initiates' or
	 * 'terminates'. It has two parameters: an event which is a simple sentence
	 * and a fluent which is also a simple sentence.
	 * 
	 * This method is used to throw exceptions in {@link #stringToDPost(String)}.
	 * 
	 * See a LPS documentation for more details on DPost declaration.
	 * 
	 * @param string
	 *            to be checked whether or not it matches the DPost declaration
	 *            syntax.
	 * @return true if the string is a DPost declaration, otherwise false.
	 */
	public boolean isDPostDeclaration(String string) {
		// Delete all the spaces before checking any matching
		string = string.replaceAll(" ", "");
		
		// Split the string to get the name and the parameters of the declaration
		String[] strings = string.split("\\(");

		// Check if the name is initiates or terminates
		boolean declarationName = strings[0].equals("initiates") || strings[0].equals("terminates");
		
		// Check if there is a comma between the two parameters
		boolean comma = string.charAt(string.indexOf(')') + 1) == ',';

		boolean event;
		boolean predicate;
		// Check if the first parameter is an event
		// and the second a fluent. Both simple sentence
		try {
			event = isSimpleSentence(string.substring(string.indexOf('(') + 1,
					string.indexOf(')') + 1));
			predicate = isSimpleSentence(string.substring(
					string.indexOf(')') + 2, string.lastIndexOf(')')));

			return declarationName && event && predicate && comma;
		
		// This is the case where parenthesis and comma are bad placed
		} catch (StringIndexOutOfBoundsException e) {

			return false;
		}
	}
    
	/**
	 * Converts the input string into a {@code DPostDeclaration} object. The
	 * input string should be a DPost declaration. It creates an
	 * {@code Initiator} or a {@code Terminator} object depending on the input.
	 * 
	 * @param string
	 *            to be convert into the {@code DPostDeclaration} object.
	 * @return the {@code DPostDeclaration} object representing the simple
	 *         sentence string input. It will be either a {@code Initiator}
	 *         object or an {@code Terminator} object.
	 * @throws RemoteException
	 *             if the input does not correspond to a constant according to
	 *             the method {@code isDPostDeclaration}
	 * @see SimpleSentence
	 * @see #isSimpleSentence(String)
	 */
	public DPostDeclaration stringToDPost(String string) throws RemoteException {
		// Delete any spaces before converting
		string = string.replaceAll(" ", "");
		
		DPostDeclaration res;

		if (this.isDPostDeclaration(string)) {
			// Get whether it is an initiator or a terminator.
			String name = string.split("\\(")[0];
			string = string.replaceFirst(name + "\\(", "");

			// Get the first argument of the declaration (the event) and
			// then storing names of variables to create linkedVariables.
			String[] event = string.split("\\)")[0].split("\\(|,");
			Unifiable[] parametersOfEvent = new Unifiable[event.length - 1];
			HashMap<String, Variable> variablesOfEvent = new HashMap<String, Variable>();
			SimpleSentence e;
			Constant eventName = new Constant(event[0]);
			if (event.length > 1) {
				// Create each variable.
				for (int i = 1; i < event.length; i++) {
					if (event[i].matches("[A-Z].*")) {
						Variable v = new Variable(event[i]);
						parametersOfEvent[i - 1] = v;
						variablesOfEvent.put(event[i], v);
					} else {
						parametersOfEvent[i - 1] = new Constant(event[i]);
					}
				}
				e = new SimpleSentence(eventName, parametersOfEvent);
			} else {
				e = new SimpleSentence(eventName);
			}

			// Get the second argument, the fluent.
			String[] predicate = string.split("\\)")[1].split("\\(|,");
			Unifiable[] parametersOfPredicate = new Unifiable[predicate.length - 2];
			SimpleSentence p;
			Constant predicateName = new Constant(predicate[1]);
			if (predicate.length > 2) {
				for (int i = 2; i < predicate.length; i++) {
					// Seek if the variable is in the event ones and then
					// add an entry in the linkedVariables.
					if (predicate[i].matches("[A-Z].*")) {
						if (variablesOfEvent.containsKey(predicate[i])) {
							parametersOfPredicate[i - 2] = variablesOfEvent.get(predicate[i]);
						} else {
							parametersOfPredicate[i - 2] = new Variable(predicate[i]);
						}
					} else {
						parametersOfPredicate[i - 2] = new Constant(predicate[i]);
					}
				}
				p = new SimpleSentence(predicateName, parametersOfPredicate);
			} else {
				p = new SimpleSentence(predicateName);
			}

			// Creating the DPostDeclaration object
			switch (name) {
			case "initiates":
				res = new Initiator(e, p, null);
				break;
			case "terminates":
				res = new Terminator(e, p, null);
				break;
			default:
				throw new RemoteException(
						"It is not a DPost declaration, it should start with 'initiates' or 'terminates'");
			}

			return res;
		} else {
			throw new RemoteException("It is not a DPost declaration.");
		}

	}
}
