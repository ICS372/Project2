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

/**
 * This is a super class for all states
 */
public abstract class PlayerState {

	/**
	 * Initializes the state
	 */
	public void enter() {
	}

	/**
	 * Performs any necessary clean up while leaving the state
	 */
	public void leave() {
	}

	/**
	 * Process Fast forward request
	 */
	public void handleEvent(FastForwardEvent event) {
	}

	/**
	 * Process off request
	 */
	public void handleEvent(OffEvent event) {
	}

	/**
	 * Process on request
	 */
	public void handleEvent(OnEvent event) {
	}

	/**
	 * Process pause request
	 */
	public void handleEvent(PauseEvent event) {
	}

	/**
	 * Process play request
	 */
	public void handleEvent(PlayEvent event) {
	}

	/**
	 * Process rewind request
	 */
	public void handleEvent(RewindEvent event) {
	}

	/**
	 * Process select request
	 */
	public void handleEvent(SelectEvent event) {
	}

	/**
	 * Process stop request
	 */
	public void handleEvent(StopEvent event) {
	}

	/**
	 * Process clock tick generates the timer completed event
	 */
	public void handleEvent(TimerCompletedEvent event) {
	}

	/**
	 * Process clock tick generates the timer ticks event
	 */
	public void handleEvent(TimerTicksEvent event) {
	}

}
