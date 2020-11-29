package events;

/**
 * Represents the No show selected and screen saver event
 *
 */
public class NoShowSelectedScreenSaverEvent {
	private static NoShowSelectedScreenSaverEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private NoShowSelectedScreenSaverEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static NoShowSelectedScreenSaverEvent instance() {
		if (instance == null) {
			instance = new NoShowSelectedScreenSaverEvent();
		}
		return instance;
	}
}
