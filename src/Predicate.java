import java.util.Stack;


public class Predicate {

	private String name;
	private String[] variables;
	
	public Predicate(String name, String[] variables) {
		this.name = name;
		this.setVariables(variables);
	}

	public String getName() {
		return name;
	}

	public String[] getVariables() {
		return variables;
	}

	public void setVariables(String[] variables) {
		this.variables = variables;
	}

	public void setVariable(String variable, int index) {
		this.variables[index] = variable;
	}
	
	public boolean hasFreeVariables() {
		boolean res = false;
		for (int i = 0; i < this.variables.length; i++) {
			res = (this.variables[i] == null) ? true : false; 
		}
		
		return res;
	}
	
	public Stack<Integer> getFreeVariables() {
		Stack<Integer> freeVariables = new Stack<Integer>();
		for (int i = 0; i < this.variables.length; i++) {
			if (this.variables[i] == null) {
				freeVariables.push(i); 
			}
		}
		
		return freeVariables;
	}
	
	public boolean equals(Predicate otherPredicate) {
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
	
	public String toString() {
		String string;
		if (this.variables != null) {
			string = this.name + "(" + this.variables.toString() + ")";
		} else {
			string = this.name + "(" + ")";
		}
		
		return string;
	}
	
}
