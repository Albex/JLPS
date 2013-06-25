import java.util.Stack;

class DatabaseUpdateState implements CycleState {
	
	public DatabaseUpdateState() {
		
	}

	@Override
    public void handlerMethod(final CycleHandler STATE_CONTEXT, final String NAME) {
		updates(STATE_CONTEXT.getEvents());
    }

	private void updates(Stack<Predicate> events) {
		Database.getInstance().updates(events);
	}
}
