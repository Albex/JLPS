import java.util.Arrays;


public class Initiator extends DPostDeclaration {

	public Initiator(Predicate event, Predicate fluent, Integer[] linkedVariables, Predicate condition) {
		super(event, fluent, linkedVariables, condition);
	}
	
	/**
	 * This method writes the initiator in the Prolog-like way.
	 * initiates(event, fluent).
	 */
	@Override
	public String toString() {
		String string;
		string = "initiates(" + this.event.toString() + ", " + this.fluent.toString() +")";
		string += "\n" + Arrays.toString(this.linkedVariables);
		
		return string;
	}

}
