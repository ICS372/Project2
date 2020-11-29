package events;

/**
 * Represents the paused show event
 *
 */
public class PausedShowEvent {
	private static PausedShowEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private PausedShowEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static PausedShowEvent instance() {
		if (instance == null) {
			instance = new PausedShowEvent();
		}
		return instance;
	}
}