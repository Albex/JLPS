package model;

/**
 * This is the class that represents the initiators among the DPost
 * declarations. It extends {@link DPostDeclaration}.
 * 
 * @author Alexandre Camus
 * 
 */
public class Initiator extends DPostDeclaration {

	/**
	 * Constructor of the class.
	 * 
	 * @param event
	 *            that is defined by this initiator.
	 * @param fluent
	 *            that is initiates by this initiator.
	 */
	public Initiator(SimpleSentence event, SimpleSentence fluent) {
		super(event, fluent);
	}
	
	/**
	 * Returns the initiator in the form of:
	 * "initiates(event, fluent)".
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String string;
		string = "initiates(" + this.event.toString() + ", " + this.fluent.toString() +")";
		
		return string;
	}

}
