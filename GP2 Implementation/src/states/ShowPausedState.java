package states;

import events.PlayEvent;
import events.StopEvent;

/**
 * Represents the Show Paused state.
 */
public class ShowPausedState extends PlayerState {
	private int remainingTime;
	private static ShowPausedState instance;

	/**
	 * Private for the singleton pattern
	 */
	private ShowPausedState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static ShowPausedState instance() {
		if (instance == null) {
			instance = new ShowPausedState();
		}
		return instance;
	}

	/**
	 * Setting the remaining time
	 */
	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}

	/**
	 * Process play event
	 */
	@Override
	public void handleEvent(PlayEvent event) {
		PlayingShowState.instance().setRemainingTime(remainingTime);
		PlayerContext.instance().changeCurrentState(PlayingShowState.instance());
	}

	/**
	 * Process stop event
	 */
	@Override
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeCurrentState(ShowCompletedState.instance());
	}
}
