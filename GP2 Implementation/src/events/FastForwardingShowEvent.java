package events;

/**
 * Represents the fast forwarding show event
 *
 */
public class FastForwardingShowEvent {
	private static FastForwardingShowEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private FastForwardingShowEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static FastForwardingShowEvent instance() {
		if (instance == null) {
			instance = new FastForwardingShowEvent();
		}
		return instance;
	}
}
