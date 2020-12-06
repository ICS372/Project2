package states;

import events.PlayEvent;
import events.StopEvent;
import events.TimerCompletedEvent;
import events.TimerTicksEvent;
import shows.Show;
import timer.Notifiable;
import timer.RewindTimer;

/**
 * Represents the Rewinding Show state.
 */
public class RewindingShowState extends PlayerState implements Notifiable {
	private int remainingTime;
	private Show show;
	private static RewindingShowState instance;
	private RewindTimer timer;

	/**
	 * Private for the singleton pattern
	 */
	private RewindingShowState() {

	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static RewindingShowState instance() {
		if (instance == null) {
			instance = new RewindingShowState();
		}
		return instance;
	}

	/**
	 * Setting the remaining time
	 * 
	 * @param remainingTime
	 */
	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}

	/**
	 * Setting a show
	 * 
	 * @param show
	 */
	public void setShow(Show show) {
		this.show = show;
	}

	/**
	 * Process timer ticks event
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
		PlayerContext.instance().changeCurrentState(ShowSelectedState.instance());
	}

	/**
	 * Process play event
	 */
	@Override
	public void handleEvent(PlayEvent event) {
		PlayingShowState.instance().setRemainingTime(timer.getTimeValue());
		PlayerContext.instance().changeCurrentState(PlayingShowState.instance());
	}

	/**
	 * Process stop event
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
		timer = new RewindTimer(this, remainingTime, show.getRunningTime());
		PlayerContext.instance().playingShow(show.getName(), timer.getTimeValue(), show.getRunningTime());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}
}
