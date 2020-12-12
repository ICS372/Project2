package states;

import events.PlayEvent;
import events.StopEvent;
import events.TimerCompletedEvent;
import events.TimerTicksEvent;
import timer.Notifiable;
import timer.Timer;

/**
 * Represents the Fast Forwarding state.
 *
 */
public class FastForwardingShowState extends PlayerState implements Notifiable {
	private int remainingTime;
	private static FastForwardingShowState instance;
	private Timer timer;

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
	 * Process clock tick event
	 */
	@Override
	public void handleEvent(TimerTicksEvent event) {
		remainingTime -= 2;
		PlayerContext.instance().playingShow(PlayerContext.instance().showName(), remainingTime,
				PlayerContext.instance().showRunningTime());
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
		PlayingShowState.instance().setRemainingTime(remainingTime);
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
		timer = new Timer(this, (remainingTime + 1) / 2);
		PlayerContext.instance().playingShow(PlayerContext.instance().showName(), remainingTime,
				PlayerContext.instance().showRunningTime());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
