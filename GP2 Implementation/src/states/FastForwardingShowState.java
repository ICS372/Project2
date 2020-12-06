package states;

import events.PlayEvent;
import events.StopEvent;
import events.TimerCompletedEvent;
import events.TimerTicksEvent;
import shows.Show;
import timer.FastForwardTimer;
import timer.Notifiable;

/**
 * Represents the Fast Forwarding state.
 *
 */
public class FastForwardingShowState extends PlayerState implements Notifiable {
	private int remainingTime;
	private Show show;
	private static FastForwardingShowState instance;
	private FastForwardTimer timer;

	/**
	 * Private for the singleton pattern
	 */
	private FastForwardingShowState() {

	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static FastForwardingShowState instance() {
		if (instance == null) {
			instance = new FastForwardingShowState();
		}
		return instance;
	}

	/**
	 * Sets the remaining time
	 * 
	 * @param remainingTime
	 */
	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}

	/**
	 * Sets the show
	 * 
	 * @param show
	 */
	public void setShow(Show show) {
		this.show = show;
	}

	/**
	 * Process clock tick event
	 */
	@Override
	public void handleEvent(TimerTicksEvent event) {
		PlayerContext.instance().playingShow(show.getName(), timer.getTimeValue(), show.getRunningTime());
	}

	/**
	 * Process timer completed event
	 */
	@Override
	public void handleEvent(TimerCompletedEvent event) {
		PlayerContext.instance().changeCurrentState(ShowCompletedState.instance());
	}

	/**
	 * Process the play event
	 */
	@Override
	public void handleEvent(PlayEvent event) {
		PlayingShowState.instance().setRemainingTime(timer.getTimeValue());
		PlayerContext.instance().changeCurrentState(PlayingShowState.instance());
	}

	/**
	 * Process the stop event
	 */
	@Override
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeCurrentState(ShowCompletedState.instance());
	}

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void enter() {
		timer = new FastForwardTimer(this, remainingTime);
		PlayerContext.instance().playingShow(show.getName(), timer.getTimeValue(), show.getRunningTime());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
