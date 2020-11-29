package events;

/**
 * Represents the Show completed event
 *
 */
public class ShowCompletedEvent {
	private static ShowCompletedEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private ShowCompletedEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static ShowCompletedEvent instance() {
		if (instance == null) {
			instance = new ShowCompletedEvent();
		}
		return instance;
	}
}
