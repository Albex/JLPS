/**
 * This is an abstract class to represent the DPost declarations.
 * @author Albex
 *
 */
public abstract class DPostDeclaration {
	
	protected Predicate event;
	protected Predicate fluent;
	protected Integer[] linkedVariables;
	
	protected DPostDeclaration(Predicate event, Predicate fluent, Integer[] linkedVariables) {
		this.event = event;
		this.fluent = fluent;
		this.linkedVariables = linkedVariables;
	}

	public Predicate getEvent() {
		return this.event;
	}

	public Predicate getFluent() {
		return this.fluent;
	}
	
	public Predicate getGroundFluent(Predicate event) {
		Predicate groundFluent = fluent;
		for (int i=0; i < linkedVariables.length; i++) {
			int j = linkedVariables[i];
			groundFluent.getVariables()[j] = event.getVariables()[i];
		}
		
		return groundFluent;
	}
	
	@Override
	public abstract String toString();

}
