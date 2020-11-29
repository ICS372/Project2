package events;

/**
 * Represents the rewind event
 *
 */
public class RewindEvent {
	private static RewindEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private RewindEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static RewindEvent instance() {
		if (instance == null) {
			instance = new RewindEvent();
		}
		return instance;
	}
}
