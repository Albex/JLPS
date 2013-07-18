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
    
    public boolean isConstant(String string) {
    	string = string.replaceAll(" ", "");
    	
    	return string.matches("[a-z0-9][A-Za-z0-9_]*");
    }
    
    public Constant stringToConstant(String string) throws RemoteException {
    	string = string.replaceAll(" ", "");
    	Constant res;
    	
        if (this.isConstant(string)) {
            res = new Constant(string);

            return res;
        } else {
            throw new RemoteException("It is not a Constant-like string.");
        }
    }
    
    public boolean isVariable(String string) {
    	string = string.replaceAll(" ", "");
    	
    	return string.matches("[A-Z][A-Za-z0-9_]*");
    }
    
    public Variable stringToVariable(String string) throws RemoteException {
    	string = string.replaceAll(" ", "");
    	Variable res;
    	
        if (this.isVariable(string)) {
            res = new Variable(string);

            return res;
        } else {
            throw new RemoteException("It is not a Variable-like string.");
        }
    }
    
    /**
     * Checks if the input string is in the form of a Prolog predicate.
     * This string should have the form of 'someLettersOrNumbersOr_(aValue,anotherValue,AVariable,AnotherVariable)'.
     * See a Prolog documentation for more information about Prolog predicate.
     * This method is used to throw exceptions in <code>prologToPredicate</code>.
     * @param string to be checked whether it is a Prolog predicate or not.
     * @return true if it matches the general form of a Prolog predicate, otherwise false.
     */
    public boolean isSimpleSentence(String string) {
    	string = string.replaceAll(" ", "");
    	String[] strings = string.split("\\(|,|\\)");
        
        boolean predicateName = isConstant(strings[0]);
        
        boolean parameters = true;
        for(int i = 1; i < strings.length; i++) {
        	parameters = (isConstant(strings[i]) || isVariable(strings[i])) ? parameters : false;
        }

        return predicateName && parameters;
    }

    /**
     * Creates the <code>Predicate</code> object corresponding to the input string containing the Prolog declaration of the predicate.
     * @param string the Prolog version of the predicate to be saved.
     * @return a <code>Predicate</code> object. Then it will need to be stored in some place of the LPS framework.
     * @throws RemoteException if the string is not a Prolog predicate according to the <code>isProlog</code> method.
     */
    public SimpleSentence stringToSimpleSentence(String string) throws RemoteException {
    	string = string.replaceAll(" ", "");
    	SimpleSentence res;
        if (this.isSimpleSentence(string)) {
            String[] nameAndVar = string.split("\\(|,|\\)");
            Constant predicateName = new Constant(nameAndVar[0]);
            Unifiable[] parameters = new Unifiable[nameAndVar.length - 1];
            if (nameAndVar.length > 1) {
	            for (int i = 1; i < nameAndVar.length; i++) {
	                parameters[i-1] = (nameAndVar[i].matches("[A-Z].*")) ? new Variable(nameAndVar[i]) : new Constant(nameAndVar[i]);
	            }
	            res = new SimpleSentence(predicateName, parameters);
            } else {
            	res = new SimpleSentence(predicateName);
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
    	string = string.replaceAll(" ", ""); 
    	String[] strings = string.split("\\(");
    	String[] substrings = strings[2].split(",|\\)");
    	String[] substrings2 = strings[3].split(",|\\)");
		 
    	boolean declarationName = strings[0].equals("initiates") || strings[0].equals("terminates");
		
    	boolean eventName = isConstant(strings[1]);
		boolean eventParameters = true;
		for(int i = 0; i < substrings.length - 2; i++) {
			eventParameters = (isConstant(substrings[i]) || isVariable(substrings[i])) ? eventParameters : false;
		}
		 
		boolean predicateName = isConstant(substrings[substrings.length - 1]);
		boolean predicateParameters = true;
		for(int i = 0; i < substrings2.length - 1; i++) {
			predicateParameters = (isConstant(substrings2[i]) || isVariable(substrings2[i])) ? predicateParameters : false;
		}
		
		return declarationName && eventName && eventParameters && predicateName && predicateParameters;
    }
    
    /**
     * Creates a <code>DPostDeclaration</code> object of the input string which should be written as a Prolog-like DPost declaration.
     * 
     * @param string the Prolog-like syntax of the DPost declaration.
     * @return a <code>DPostDeclaration</code> object which will be either a <code>Initiator</code> object or a <code>Terminator</code> object.
     * It depends on the nature of the DPost declaration, whether it is an 'initiates' or 'a 'terminates'.
     * @throws RemoteException if the string is not a DPost declaration according to the method <code>isDPostDeclaration</code>.
     */
    public DPostDeclaration stringToDPost(String string) throws RemoteException {
    	string = string.replaceAll(" ", "");
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
    					parametersOfEvent[i-1] = v;
    					variablesOfEvent.put(event[i], v);
    				} else {
    					parametersOfEvent[i-1] = new Constant(event[i]);
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
    			for (int i = 2; i < predicate.length; i++) {
    				// Seeking if the variable is in the event ones and then adding an entry in the linkedVariables.
    				if (predicate[i].matches("[A-Z].*")) {
    					if (variablesOfEvent.containsKey(predicate[i])) {
    						parametersOfPredicate[i-2] = variablesOfEvent.get(predicate[i]);
    					} else {
    						parametersOfPredicate[i-2] = new Variable(predicate[i]);
    					}
    				} else {
						parametersOfPredicate[i-2] = new Constant(predicate[i]);
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
