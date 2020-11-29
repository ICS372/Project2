package states;

import timer.Timer;

public class PlayingShowState extends PlayerState {
	private static PlayingShowState instance;
	private Timer timer;

	private PlayingShowState() {

	}

	public static PlayingShowState instance() {
		if (instance == null) {
			instance = new PlayingShowState();
		}
		return instance;
	}
}
