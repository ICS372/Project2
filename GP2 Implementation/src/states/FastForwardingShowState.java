package states;

import timer.Timer;

public class FastForwardingShowState extends PlayerState {
	private static FastForwardingShowState instance;
	private Timer timer;

	private FastForwardingShowState() {

	}

	public static FastForwardingShowState instance() {
		if (instance == null) {
			instance = new FastForwardingShowState();
		}
		return instance;
	}
}
