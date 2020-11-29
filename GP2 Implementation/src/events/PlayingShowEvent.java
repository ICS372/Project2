package events;

/**
 * Represents the playing show event
 *
 */
public class PlayingShowEvent {
	private static PlayingShowEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private PlayingShowEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static PlayingShowEvent instance() {
		if (instance == null) {
			instance = new PlayingShowEvent();
		}
		return instance;
	}
}
