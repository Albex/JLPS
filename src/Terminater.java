
public class Terminater extends DPostDeclaration {

	public Terminater(Predicate event, Predicate fluent, Integer[] linkedVariables) {
		super(event, fluent, linkedVariables);
	}
	
	@Override
	public String toString() {
		String string;
		string = "terminates(" + this.event.toString() + ", " + this.fluent.toString() + ")";
		
		return string;
	}

}
