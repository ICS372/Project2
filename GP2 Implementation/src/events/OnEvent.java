package events;

/**
 * Represents the On event
 *
 */

public class OnEvent {
	private static OnEvent instance;

	/**
	 * Private for singleton
	 */
	private OnEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static OnEvent instance() {
		if (instance == null) {
			instance = new OnEvent();
		}
		return instance;
	}
}
