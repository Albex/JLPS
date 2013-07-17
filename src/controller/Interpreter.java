package controller;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.HashMap;

import model.Constant;
import model.DPostDeclaration;
import model.Initiator;
import model.Predicate;
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
public class Interpreter {

	private static volatile Interpreter instance = null;
	
	/**
	 * Constructor of the class. To be not used by itself as the class is a singleton.
	 * Use the specific method <code>getInstance</code> instead.
	 * @see #getInstance()
	 */
    private Interpreter() {
    	super();
    }

    /**
     * Gets the only object of this singleton class.
     * Use it as a static method.
     * @return instance the only object of this class. If the object was not already created it will create it.
     */
    public final static Interpreter getInstance() {
    	if (Interpreter.instance == null) {
			 synchronized(Interpreter.class) {
				 if (Interpreter.instance == null) {
					 Interpreter.instance = new Interpreter();
				 }
			 }
		 }
		 
		 return Interpreter.instance;
    }
    
    /**
     * Checks if the input string is in the form of a Prolog predicate.
     * This string should have the form of 'someLettersOrNumbersOr_(aValue,anotherValue,AVariable,AnotherVariable)'.
     * See a Prolog documentation for more information about Prolog predicate.
     * This method is used to throw exceptions in <code>prologToPredicate</code>.
     * @param string to be checked whether it is a Prolog predicate or not.
     * @return true if it matches the general form of a Prolog predicate, otherwise false.
     */
    public boolean isProlog(String string) {
        boolean res = false;
        if (string.matches("[^(,|\\(|\\))]*\\(([^(,|\\(|\\))]+(,[^(,|\\(|\\))]+)*)*\\)")) {
            res = true;
        }

        return res;
    }

    /**
     * Creates the <code>Predicate</code> object corresponding to the input string containing the Prolog declaration of the predicate.
     * @param string the Prolog version of the predicate to be saved.
     * @return a <code>Predicate</code> object. Then it will need to be stored in some place of the LPS framework.
     * @throws RemoteException if the string is not a Prolog predicate according to the <code>isProlog</code> method.
     */
    public Predicate prologToPredicate(String string) throws RemoteException {
        Predicate res;
        if (this.isProlog(string)) {
            String[] nameAndVar = string.split("\\(|,|\\)");
            if (nameAndVar.length > 1) {
	            for (int i = 1; i < nameAndVar.length; i++) {
	                nameAndVar[i] = (nameAndVar[i].matches("[A-Z].*")) ? null : nameAndVar[i];
	            }
	            res = new Predicate(nameAndVar[0], Arrays.copyOfRange(nameAndVar, 1, nameAndVar.length));
            } else {
            	res = new Predicate(nameAndVar[0], null);
            }

            return res;
        } else {
            throw new RemoteException("It is not a Prolog-like predicate.");
        }
    }
    
    /**
     * Checks whether the input string is a Prolog-like DPost declaration or not.
     * You might need to have a look at an LPS documentation.
     * This method is used to throw exceptions in <code>prologToDPost</code>.
     * @param string to be checked whether or not it matches the Prolog-like syntax.
     * @return true if the string is a DPost declaration, otherwise false.
     */
    public boolean isDPostDeclaration(String string) {
    	boolean res = false;
    	if (string.matches("[^(,|\\(|\\))]*\\([^(,|\\(|\\))]*\\(([^(,|\\(|\\))]+(,[^(,|\\(|\\))]+)*)*\\),([^(,|\\(|\\))]*\\(([^(,|\\(|\\))]+(,[^(,|\\(|\\))]+)*)*\\))\\)")) {
            res = true;
        }
    	
    	return res;
    }
    
    /**
     * Creates a <code>DPostDeclaration</code> object of the input string which should be written as a Prolog-like DPost declaration.
     * 
     * @param string the Prolog-like syntax of the DPost declaration.
     * @return a <code>DPostDeclaration</code> object which will be either a <code>Initiator</code> object or a <code>Terminator</code> object.
     * It depends on the nature of the DPost declaration, whether it is an 'initiates' or 'a 'terminates'.
     * @throws RemoteException if the string is not a DPost declaration according to the method <code>isDPostDeclaration</code>.
     */
    public DPostDeclaration prologToDPost(String string) throws RemoteException {
    	DPostDeclaration res;
    	
    	if (this.isDPostDeclaration(string)) {
    		// Getting whether it is an initiator or a terminator.
    		String name = string.split("\\(")[0];
    		string = string.replaceFirst(name + "\\(", "");
    		
    		// Getting the first argument of the declaration (the event) and then storing names of variables to create linkedVariables.
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
    					parametersOfEvent[i] = v;
    					variablesOfEvent.put(event[i], v);
    				} else {
    					parametersOfEvent[i] = new Constant(event[i]);
    				}
	            }
    			e = new SimpleSentence(eventName, parametersOfEvent);
    		} else {
    			e = new SimpleSentence(eventName);
    		}
    		
    		// Getting the second argument, the fluent. And creating linkedVariables.
    		String[] predicate = string.split("\\)")[1].split("\\(|,");
    		Unifiable[] parametersOfPredicate = new Unifiable[predicate.length - 2];
    		SimpleSentence p;
    		Constant predicateName = new Constant(predicate[1]);
    		if (predicate.length > 2) {
    			for (int i = 1; i < predicate.length; i++) {
    				// Seeking if the variable is in the event ones and then adding an entry in the linkedVariables.
    				if (predicate[i].matches("[A-Z].*")) {
    					if (variablesOfEvent.containsKey(predicate[i])) {
    						parametersOfPredicate[i] = variablesOfEvent.get(predicate[i]);
    					} else {
    						parametersOfPredicate[i] = new Constant(predicate[i]);
    					}
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
				throw new RemoteException("It is not a DPost declaration, it should start with 'initiates' or 'terminates'");
			}
    		
    		return res;
    	} else {
    		throw new RemoteException("It is not a DPost declaration.");
    	}
    	
    }
}
