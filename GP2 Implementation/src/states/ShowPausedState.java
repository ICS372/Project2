package states;

import events.PlayEvent;
import events.StopEvent;

public class ShowPausedState extends PlayerState {
	private int remainingTime;
	private static ShowPausedState instance;

	private ShowPausedState() {

	}

	public static ShowPausedState instance() {
		if (instance == null) {
			instance = new ShowPausedState();
		}
		return instance;
	}

	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}

	@Override
	public void handleEvent(PlayEvent event) {
		PlayingShowState.instance().setRemainingTime(remainingTime);
		PlayerContext.instance().changeCurrentState(PlayingShowState.instance());
	}

	@Override
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeCurrentState(ShowCompletedState.instance());
	}
}
