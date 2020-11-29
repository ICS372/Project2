package states;

import timer.Timer;

public class ShowCompletedState extends PlayerState {
	private static ShowCompletedState instance;
	private Timer timer;

	private ShowCompletedState() {

	}

	public static ShowCompletedState instance() {
		if (instance == null) {
			instance = new ShowCompletedState();
		}
		return instance;
	}
}
