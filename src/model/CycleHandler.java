package model;

/**
 * Singleton class that handle the cycles of an LPS framework. Only called by
 * the static method {@code getInstance()}.
 * 
 * @see #getInstance()
 * @author Alexandre Camus
 */
public final class CycleHandler {

	private static volatile CycleHandler instance = null;
	
	private CycleState myState;
	private RuleSet events;
	
	/**
	 * Constructor of the class. To be not used by itself as the class is a
	 * singleton. Use the specific method {@code getInstance()} instead.
	 * 
	 * @see #getInstance()
	 */
	private CycleHandler() {
        setState(new DatabaseUpdateState());
    }
	
	/**
	 * Gets the only object of this singleton class. Use it as a static method.
	 * 
	 * @return instance the only object of this class. If the object was not
	 *         already created it will create it.
	 */
	public final static CycleHandler getInstance() {
		 if (CycleHandler.instance == null) {
			 synchronized(CycleHandler.class) {
				 if (CycleHandler.instance == null) {
					 CycleHandler.instance = new CycleHandler();
				 }
			 }
		 }
		 
		 return CycleHandler.instance;
	}
	
	/**
	 * Sets the state from which the {@code CycleHandler} will call the
	 * {@link #handlerMethod(String) handlerMethod}
	 * <p>
	 * This allows states to terminate and send a request to the
	 * {@code CycleHandler} to go to the specified and next state.
	 * 
	 * @param NEW_STATE
	 *            the next step of the cycle.
	 */
	public void setState(final CycleState NEW_STATE) {
		myState = NEW_STATE;
	}
	
	/**
	 * Sends the request to the current state to operate its behavior.
	 * <p>
	 * This method should be the only way to perform the action of a state. It
	 * calls the {@link CycleState#handlerMethod(CycleHandler, String, RuleSet)
	 * handlerMethod()} of the interface {@code CycleState} which every state
	 * implements.
	 * 
	 * @param NAME
	 *            the name of the step. It has no use except to debug.
	 */
	public void handlerMethod(final String NAME) {
		System.out.println(NAME);
		myState.handlerMethod(this, NAME, events);
	}
	
	/**
	 * Gets the events/actions that have been decided to be performed during the
	 * previous cycle.
	 * <p>
	 * See a LPS documentation for more details on cycles and actions/events.
	 * 
	 * @return an object {@code RuleSet} containing the events triggered during
	 *         the last cycle.
	 */
	public RuleSet getEvents() {
		return events;
	}
	
	/**
	 * Sets the events/actions that have been decided to be performed during the
	 * previous cycle.
	 * <p>
	 * This method is basically used by a cycle during its final step to prepare
	 * the next cycle.
	 * <p>
	 * See a LPS documentation for more details on cycles and actions/events.
	 * 
	 * @param events
	 *            the events under the form of a {@code RuleSet} object,
	 *            triggered during the last cycle.
	 */
	public void setEvents(RuleSet events) {
		if (this.events == null) {
			this.events = new RuleSet();
		} else {
		this.events.getRules().clear();
		}
		this.events.addRules(events.getRules());
	}

}