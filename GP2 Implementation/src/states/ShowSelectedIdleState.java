package states;

import events.FastForwardEvent;
import events.OnEvent;
import events.PauseEvent;
import events.PlayEvent;
import events.RewindEvent;
import events.StopEvent;
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

	@Override
	public void handleEvent(FastForwardEvent event) {
		PlayerContext.instance().changeCurrentState(ShowSelectedState.instance());
	}

	@Override
	public void handleEvent(PauseEvent event) {
		PlayerContext.instance().changeCurrentState(ShowSelectedState.instance());
	}

	@Override
	public void handleEvent(PlayEvent event) {
		PlayerContext.instance().changeCurrentState(PlayingShowState.instance());
	}

	@Override
	public void handleEvent(RewindEvent event) {
		PlayerContext.instance().changeCurrentState(ShowSelectedState.instance());
	}

	@Override
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeCurrentState(ShowSelectedState.instance());
	}

	@Override
	public void handleEvent(OnEvent event) {
		PlayerContext.instance().changeCurrentState(ShowSelectedState.instance());
	}

	@Override
	public void enter() {
		PlayerContext.instance().idle();
	}
}
