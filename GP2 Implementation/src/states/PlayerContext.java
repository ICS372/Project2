package states;

import events.FastForwardEvent;
import events.OffEvent;
import events.OnEvent;
import events.PauseEvent;
import events.PlayEvent;
import events.RewindEvent;
import events.SelectEvent;
import events.StopEvent;
import events.TimerCompletedEvent;
import events.TimerTicksEvent;
import panels.InfoPanel;

public class PlayerContext {
	private InfoPanel infoPanel;
	private PlayerState currentState;
	private static PlayerContext instance;

	private PlayerContext() {
		currentState = OffState.instance();
	}

	public static PlayerContext instance() {
		if (instance == null) {
			instance = new PlayerContext();
		}
		return instance;
	}

	public void changeCurrentState(PlayerState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	public void handleEvent(FastForwardEvent event) {
		// TODO Auto-generated method stub

	}

	public void handleEvent(OffEvent event) {
		PlayerContext.instance().changeCurrentState(OffState.instance());
	}

	public void handleEvent(OnEvent event) {
		// TODO Auto-generated method stub

	}

	public void handleEvent(PauseEvent event) {
		// TODO Auto-generated method stub

	}

	public void handleEvent(PlayEvent event) {
		// TODO Auto-generated method stub

	}

	public void handleEvent(RewindEvent event) {
		// TODO Auto-generated method stub

	}

	public void handleEvent(SelectEvent event) {
		// TODO Auto-generated method stub

	}

	public void handleEvent(StopEvent event) {
		// TODO Auto-generated method stub

	}

	public void handleEvent(TimerCompletedEvent event) {
		// TODO Auto-generated method stub

	}

	public void handleEvent(TimerTicksEvent event) {
		// TODO Auto-generated method stub

	}

	public void playerOff() {
		infoPanel.off();
	}

	public void noShowSelected() {
		infoPanel.noShowSelected();
	}

	public void showTimeLeft(int time) {
		infoPanel.showTimeLeft(time);
	}
}
