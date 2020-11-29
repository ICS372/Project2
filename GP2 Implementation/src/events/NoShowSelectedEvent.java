package events;

/**
 * Represents the No Show Selected event
 *
 */

public class NoShowSelectedEvent {
	private static NoShowSelectedEvent instance;

	/**
	 * Private for singleton
	 */
	private NoShowSelectedEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static NoShowSelectedEvent instance() {
		if (instance == null) {
			instance = new NoShowSelectedEvent();
		}
		return instance;
	}
}
