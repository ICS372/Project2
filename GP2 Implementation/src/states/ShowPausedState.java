package states;

import timer.Timer;

public class ShowPausedState extends PlayerState {
	private static ShowPausedState instance;
	private Timer timer;

	private ShowPausedState() {

	}

	public static ShowPausedState instance() {
		if (instance == null) {
			instance = new ShowPausedState();
		}
		return instance;
	}
}
