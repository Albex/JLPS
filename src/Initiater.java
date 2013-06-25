
public class Initiater extends DPostDeclaration {

	public Initiater(Predicate event, Predicate fluent, Integer[] linkedVariables) {
		super(event, fluent, linkedVariables);
	}
	
	@Override
	public String toString() {
		String string;
		string = "initiates(" + this.event.toString() + ", " + this.fluent.toString() +")";
		
		return string;
	}

}
