package events;

/**
 * Represents the play event
 *
 */
public class PlayEvent {
	private static PlayEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private PlayEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static PlayEvent instance() {
		if (instance == null) {
			instance = new PlayEvent();
		}
		return instance;
	}
}
