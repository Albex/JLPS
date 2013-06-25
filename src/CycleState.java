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
     * @param STATE_CONTEXT is the <tt>CycleHandler</tt> that owns the state.
     * @param NAME
     */
    void handlerMethod(final CycleHandler STATE_CONTEXT, final String NAME);
	
}
