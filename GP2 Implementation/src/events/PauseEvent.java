package events;

/**
 * Represents the pause event
 *
 */
public class PauseEvent {
	private static PauseEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private PauseEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static PauseEvent instance() {
		if (instance == null) {
			instance = new PauseEvent();
		}
		return instance;
	}
}