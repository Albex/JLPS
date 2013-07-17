package model;
/**
 * This is an abstract class to represent the DPost declarations.
 * @author Albex
 *
 */
public abstract class DPostDeclaration {
	
	protected SimpleSentence event;
	protected SimpleSentence fluent;
	protected AbstractOperator condition;
	
	/**
	 * Constructor of the object.
	 * @param event is the general form of event (with often free variables).
	 * @param fluent is also the general form fluent. It is the terminated or created by the event.
	 * @param linkedVariables mapped the fluent variables to the event ones to link variables and
	 * pass their values.
	 * @param condition is the condition to be satisfied before performing the effect of the event.
	 */
	protected DPostDeclaration(SimpleSentence event, SimpleSentence fluent, AbstractOperator condition) {
		this.event = event;
		this.fluent = fluent;
		this.condition = condition;
	}

	/**
	 * Getter method for the event attribute.
	 * @return the event contained in the declaration.
	 */
	public SimpleSentence getEvent() {
		return this.event;
	}

	/**
	 * Getter method for the fluent attribute.
	 * @return the fluent contained in the declaration.
	 */
	public SimpleSentence getFluent() {
		return this.fluent;
	}
	
	/**
	 * Getter method for the condition attribute.
	 * @return the condition to be satisfied before performing the effect of the event.
	 */
	public AbstractOperator getCondition() {	
		return this.condition;
	}
	
	/**
	 * This method is used to apply certain values to the variable of the event
	 * and to pass these values to the fluent according to the linked variables.
	 * @param event is an external event defined by this declaration.
	 * @return a fluent with all the values needed according to the linked variables.
	 */
	public SimpleSentence getGroundFluent(SimpleSentence event) throws CloneNotSupportedException {
		SubstitutionSet variablesBinding = event.unify(this.event, new SubstitutionSet());
		SimpleSentence groundFluent = (SimpleSentence) fluent.replaceVariables(variablesBinding);
		
		return groundFluent;
	}
	
	/**
	 * Abstract method to implement in subclasses.
	 */
	@Override
	public abstract String toString();

}
