package events;

/**
 * Represents the Show selected event
 *
 */
public class ShowSelectedEvent {
	private static ShowSelectedEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private ShowSelectedEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static ShowSelectedEvent instance() {
		if (instance == null) {
			instance = new ShowSelectedEvent();
		}
		return instance;
	}
}
