package events;

/**
 * Represents the Stop event
 *
 */
public class StopEvent {
	private static StopEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private StopEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static StopEvent instance() {
		if (instance == null) {
			instance = new StopEvent();
		}
		return instance;
	}
}
