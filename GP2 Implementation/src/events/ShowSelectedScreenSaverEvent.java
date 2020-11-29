package events;

/**
 * Represents the show selected and screen saver event
 *
 */
public class ShowSelectedScreenSaverEvent {
	private static ShowSelectedScreenSaverEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private ShowSelectedScreenSaverEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static ShowSelectedScreenSaverEvent instance() {
		if (instance == null) {
			instance = new ShowSelectedScreenSaverEvent();
		}
		return instance;
	}
}
