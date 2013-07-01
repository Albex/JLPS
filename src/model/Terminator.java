package model;

public class Terminator extends DPostDeclaration {

	public Terminator(Predicate event, Predicate fluent, Integer[] linkedVariables, Predicate condition) {
		super(event, fluent, linkedVariables, condition);
	}
	
	/**
	 * This method writes the terminator in the Prolog-like way.
	 * terminates(event, fluent).
	 */
	@Override
	public String toString() {
		String string;
		string = "terminates(" + this.event.toString() + ", " + this.fluent.toString() + ")";
		
		return string;
	}

}
