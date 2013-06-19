import java.util.Stack;

public final class CycleHandler {

	private static volatile CycleHandler instance = null;
	private CycleState myState;
	private Stack<Predicate> events;
	
	private CycleHandler() {
        super();
        setState(new DatabaseUpdateState());
    }
	
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
	 * @param NEW_STATE
	 */
	public void setState(final CycleState NEW_STATE) {
		myState = NEW_STATE;
	}
	
	/**
	 * Writer method
	 * @param NAME
	 */
	public void handlerMethod(final String NAME) {
		myState.handlerMethod(this, NAME);
	}

	public Stack<Predicate> getEvents() {
		return events;
	}

	public void setEvents(Stack<Predicate> events) {
		this.events = events;
	}

}