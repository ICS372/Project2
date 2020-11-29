package states;

import timer.Timer;

public class ShowSelectedIdleState extends PlayerState {
	private static ShowSelectedIdleState instance;
	private Timer timer;

	private ShowSelectedIdleState() {

	}

	public static ShowSelectedIdleState instance() {
		if (instance == null) {
			instance = new ShowSelectedIdleState();
		}
		return instance;
	}
}
