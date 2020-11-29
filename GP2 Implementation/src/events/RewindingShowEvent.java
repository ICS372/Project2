package events;

/**
 * Represents the rewinding show event
 *
 */
public class RewindingShowEvent {
	private static RewindingShowEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private RewindingShowEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static RewindingShowEvent instance() {
		if (instance == null) {
			instance = new RewindingShowEvent();
		}
		return instance;
	}
}
