package states;

import events.FastForwardEvent;
import events.OnEvent;
import events.PauseEvent;
import events.PlayEvent;
import events.RewindEvent;
import events.StopEvent;

public class NoShowSelectedIdleState extends PlayerState {
	private static NoShowSelectedIdleState instance;

	private NoShowSelectedIdleState() {

	}

	public static NoShowSelectedIdleState instance() {
		if (instance == null) {
			instance = new NoShowSelectedIdleState();
		}
		return instance;
	}

	@Override
	public void handleEvent(FastForwardEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
	}

	@Override
	public void handleEvent(PauseEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
	}

	@Override
	public void handleEvent(PlayEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
	}

	@Override
	public void handleEvent(RewindEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
	}

	@Override
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
	}

	@Override
	public void handleEvent(OnEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
	}

	@Override
	public void enter() {
		PlayerContext.instance().idle();
	}
}
