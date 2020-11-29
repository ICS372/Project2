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

public abstract class PlayerState {

	public void enter() {
	}

	public void leave() {
	}

	public void handleEvent(FastForwardEvent event) {
	}

	public void handleEvent(OffEvent event) {
	}

	public void handleEvent(OnEvent event) {
	}

	public void handleEvent(PauseEvent event) {
	}

	public void handleEvent(PlayEvent event) {
	}

	public void handleEvent(RewindEvent event) {
	}

	public void handleEvent(SelectEvent event) {
	}

	public void handleEvent(StopEvent event) {
	}

	public void handleEvent(TimerCompletedEvent event) {
	}

	public void handleEvent(TimerTicksEvent event) {
	}

}
