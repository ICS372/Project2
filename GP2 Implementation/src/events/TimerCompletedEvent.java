package events;

/**
 * Represents the Timer completed event
 *
 */
public class TimerCompletedEvent {
	private static TimerCompletedEvent instance;

	/**
	 * Private for singleton
	 * 
	 */
	private TimerCompletedEvent() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static TimerCompletedEvent instance() {
		if (instance == null) {
			instance = new TimerCompletedEvent();
		}
		return instance;
	}
}
