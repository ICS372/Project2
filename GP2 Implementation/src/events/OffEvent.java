package events;

/**
 * Represents the Off event
 *
 */

public class OffEvent {
	private static OffEvent instance;

	/**
	 * Private for singleton
	 */
	private OffEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static OffEvent instance() {
		if (instance == null) {
			instance = new OffEvent();
		}
		return instance;
	}
}
