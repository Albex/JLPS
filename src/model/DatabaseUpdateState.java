package model;
import java.util.Stack;

/**
 * This class implements the CycleState interface.
 * It performs the update of the database.
 * @author Albex
 * @see CycleState
 * @see Database
 */
class DatabaseUpdateState implements CycleState {
	
	/**
	 * Empty constructor of the class.
	 */
	public DatabaseUpdateState() {
	}

	/**
	 * This is the implementation of the <code>handlerMethod</code>.
	 * Here it performs the update of the database.
	 * @see CycleHandler
	 */
	@Override
    public void handlerMethod(final CycleHandler STATE_CONTEXT, final String NAME) {
		updates(STATE_CONTEXT.getEvents());
    }

	/**
	 * This is the private action of the state.
	 * It cannot be used except in the context of the <code>handlerMethod</code>.
	 * Here this is the update of the database.
	 * @param events contains the events triggered during the previous cycle.
	 * @see Database#updates(Stack)
	 */
	private void updates(Stack<Predicate> events) {
		Database.getInstance().updates(events);
	}
}
