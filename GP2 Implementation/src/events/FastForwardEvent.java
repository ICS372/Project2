package events;

/**
 * Represents the fast forward event
 *
 */
public class FastForwardEvent {
	private static FastForwardEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private FastForwardEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static FastForwardEvent instance() {
		if (instance == null) {
			instance = new FastForwardEvent();
		}
		return instance;
	}
}
