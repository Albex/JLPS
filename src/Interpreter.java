import java.rmi.RemoteException;
import java.util.Arrays;

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
	
    private Interpreter() {
    	super();
    }

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
    
    public boolean isProlog(String string) {
        boolean res = false;
        if (string.matches("[^(,|\\(|\\))]*\\(([^(,|\\(|\\))]+(,[^(,|\\(|\\))]+)*)*\\)")) {
            res = true;
        }

        return res;
    }

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
            System.out.println(res.toString());

            return res;
        } else {
            throw new RemoteException("It is not a Prolog-like predicate.");
        }
    }
    
    public boolean isDPostDeclaration(String string) {
    	boolean res = false;
    	if (string.matches("[^(,|\\(|\\))]*\\([^(,|\\(|\\))]*\\(([^(,|\\(|\\))]+(,[^(,|\\(|\\))]+)*)*\\),([^(,|\\(|\\))]*\\(([^(,|\\(|\\))]+(,[^(,|\\(|\\))]+)*)*\\))\\)")) {
            res = true;
        }
    	
    	return res;
    }
    
    public DPostDeclaration prologToDPost(String string) throws RemoteException {
    	DPostDeclaration res=null;
    	if (this.isDPostDeclaration(string)) {
    		String name = string.split("\\(")[0];
    		string = string.replaceFirst(name + "\\(", "");
    		System.out.println(string);
    		
    		return res;
    	} else {
    		throw new RemoteException("It is not a DPost declaration.");
    	}
    	
    }
}
