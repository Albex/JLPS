import java.util.Stack;

/**
 * This class represents any predicates, clauses, actions or events.
 * @author Albex
 */
public class Predicate {

	private String name;
	private String[] variables;
	
	/**
	 * Constructor.
	 * @param name	the name of the predicate.
	 * @param variables	the array of the variables of the predicate. If the variable is ground, 
	 * specify its value. If not, define it as null.
	 */
	public Predicate(String name, String[] variables) {
		this.name = name;
		this.setVariables(variables);
	}
	
	/**
	 * Getter of the <code>name</code> attribute.
	 * @return the name of the predicate.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter of the <code>variables</code> attribute.
	 * @return an arrays containing the values (or <code>null</code> if no value) of the variables.
	 */
	public String[] getVariables() {
		return variables;
	}
	
	/**
	 * Setter of the <code>variables</code> attribute.
	 * @param variables the values (or <code>null</code> if no value) of the variables of the clause.
	 */
	public void setVariables(String[] variables) {
		this.variables = variables;
	}
	/**
	 * Setter of one of the predicate's variables.
	 * @param variable the value (or <code>null</code> otherwise) of the variable.
	 * @param index position of the variable.
	 */
	public void setVariable(String variable, int index) {
		this.variables[index] = variable;
	}
	
	/**
	 * Checks if the predicate still contains free variables.
	 * @return true if there is at least one free variable.
	 */
	public boolean hasFreeVariables() {
		boolean res = false;
		for (int i = 0; i < this.variables.length; i++) {
			res = (this.variables[i] == null) ? true : false; 
		}
		
		return res;
	}
	
	/**
	 * Gets the free variables (<code>null</code>) of the predicates.
	 * @return all the free variables of the predicates in a <code>Stack</code>.
	 * @see Stack
	 */
	public Stack<Integer> getFreeVariables() {
		Stack<Integer> freeVariables = new Stack<Integer>();
		for (int i = 0; i < this.variables.length; i++) {
			if (this.variables[i] == null) {
				freeVariables.push(i); 
			}
		}
		
		return freeVariables;
	}
	
	/**
	 * Checks if two predicates are equal.
	 * Two predicates are equal if they have the same name and their variables are equal.
	 * Two variables are equal if they have the same value or if one or both of them are not ground
	 * (<code>null</code>).
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Predicate))return false;
	    Predicate otherPredicate = (Predicate)other;

		boolean res = true;
		if (this.name == otherPredicate.getName()) {
			for (int i = 0; i < this.variables.length; i++) {
				if (this.variables[i] != otherPredicate.getVariables()[i] && this.variables[i] != null && otherPredicate.getVariables()[i] != null) {
					res = false;
				}
			}
		} else {
			res = false;
		}
		
		return res;
	}
	
	/**
	 * This method writes the predicate in the Prolog-like way.
	 */
	@Override
	public String toString() {
		String string;
		if (this.variables != null) {
			String stringVariables = this.variables[0];
			for (int i = 1; i < this.variables.length; i++) {
				stringVariables += "," + this.variables[i];
			}
			string = this.name + "(" + stringVariables + ")";
		} else {
			string = this.name + "(" + ")";
		}
		
		return string;
	}
	
}
