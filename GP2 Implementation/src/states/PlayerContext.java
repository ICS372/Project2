package states;

import events.FastForwardEvent;
import events.OffEvent;
import events.OnEvent;
import events.PauseEvent;
import events.PlayEvent;
import events.RewindEvent;
import events.SelectEvent;
import events.StopEvent;
import gui.PlayerDisplay;

public class PlayerContext {
	private PlayerDisplay display;
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

	public void initialize() {
		instance.changeCurrentState(OffState.instance());
	}

	public void setDisplay(PlayerDisplay display) {
		this.display = display;
	}

	public void handleEvent(FastForwardEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(OffEvent event) {
		PlayerContext.instance().changeCurrentState(OffState.instance());
	}

	public void handleEvent(OnEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(PauseEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(PlayEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(RewindEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(SelectEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(StopEvent event) {
		currentState.handleEvent(event);
	}

	public void playerOff() {
		display.off();
	}

	public void noShowSelected(int time) {
		display.noShowSelected(time);
	}

	public void idle() {
		display.idle();
	}

	public void showSelected(String showName, int time, int showTime) {
		display.showSelected(showName, time, showTime);
	}

	public void playingShow(String showName, int time, int showTime) {
		display.playingShow(showName, time, showTime);
	}

	public void showCompleted(int time) {
		display.showCompleted(time);
	}
}
