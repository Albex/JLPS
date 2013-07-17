package model;
/**
 * This is the interface to implement in order to add steps to the cycle.
 * Currently there are three steps.
 * @author Albex
 * @see CycleHandler
 */
interface CycleState {

	/**
     * Handler method for the state name.
     * Override it to allow the step to act.
     * @param STATE_CONTEXT is the <code>CycleHandler</code> that owns the state.
     * @param NAME
	 * @throws CloneNotSupportedException 
     */
    void handlerMethod(final CycleHandler STATE_CONTEXT, final String NAME) throws CloneNotSupportedException;
	
}
