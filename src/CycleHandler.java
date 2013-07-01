import java.util.Stack;

/**
 * Singleton class that handle the cycles of an LPS framework.
 * Only called by the static method <code>getInstance()</code>.
 * @see 	#getInstance()
 * @author 	Albex
 */
public final class CycleHandler {

	private static volatile CycleHandler instance = null;
	private CycleState myState;
	private Stack<Predicate> events;
	
	/**
	 * This the constructor of the class.
	 * It is private as it must not be called.
	 * Use the method <code>getInstance()</code> instead.
	 * @see #getInstance()
	 */
	private CycleHandler() {
        super();
        setState(new DatabaseUpdateState());
    }
	
	/**
	 * This is the method to get an instance of the class.
	 * @return	the only instance of the class <code>CycleHandler</code>.
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
	 * Setter method for the state.
	 * Normally only called by classes implementing the State interface.
	 * @param NEW_STATE the next step of the cycle.
	 */
	public void setState(final CycleState NEW_STATE) {
		myState = NEW_STATE;
	}
	
	/**
	 * Handler method called at each step of a cycle.
	 * @param NAME the name of the step.
	 */
	public void handlerMethod(final String NAME) {
		myState.handlerMethod(this, NAME);
	}
	
	/**
	 * Getter method of the events attribute.
	 * @return the list of events triggered during the last cycle.
	 */
	public Stack<Predicate> getEvents() {
		return events;
	}
	
	/**
	 * Setter method of the events attribute.
	 * @param events the events triggered during the last cycle.
	 */
	public void setEvents(Stack<Predicate> events) {
		this.events = events;
	}

}