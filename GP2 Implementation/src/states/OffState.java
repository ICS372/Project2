package states;

import events.OnEvent;

public class OffState extends PlayerState {
	private static OffState instance;

	private OffState() {

	}

	public static OffState instance() {
		if (instance == null) {
			instance = new OffState();
		}
		return instance;
	}

	@Override
	public void handleEvent(OnEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
	}

	@Override
	public void enter() {
		PlayerContext.instance().playerOff();
	}
}
