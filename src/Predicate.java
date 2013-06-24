
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