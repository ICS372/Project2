package events;

/**
 * Represents the Select event
 *
 */
public class SelectEvent {
	private static SelectEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private SelectEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static SelectEvent instance() {
		if (instance == null) {
			instance = new SelectEvent();
		}
		return instance;
	}
}
