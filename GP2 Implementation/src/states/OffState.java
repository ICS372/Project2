package states;

import events.OnEvent;

/**
 * Represents the Off state.
 *
 */
public class OffState extends PlayerState {
	private static OffState instance;

	/**
	 * Private for the singleton pattern
	 */
	private OffState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static OffState instance() {
		if (instance == null) {
			instance = new OffState();
		}
		return instance;
	}

	/**
	 * Process On event
	 */
	@Override
	public void handleEvent(OnEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
	}

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void enter() {
		PlayerContext.instance().playerOff();
	}
}
