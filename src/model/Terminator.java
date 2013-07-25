package model;

public class Terminator extends DPostDeclaration {

	public Terminator(SimpleSentence event, SimpleSentence fluent) {
		super(event, fluent);
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
