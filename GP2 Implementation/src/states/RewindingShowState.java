package states;

import timer.Timer;

public class RewindingShowState extends PlayerState {
	private static RewindingShowState instance;
	private Timer timer;

	private RewindingShowState() {

	}

	public static RewindingShowState instance() {
		if (instance == null) {
			instance = new RewindingShowState();
		}
		return instance;
	}
}
