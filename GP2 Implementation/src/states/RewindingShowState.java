package states;

import events.PlayEvent;
import events.StopEvent;
import events.TimerCompletedEvent;
import events.TimerTicksEvent;
import timer.Notifiable;
import timer.Timer;

/**
 * Represents the Rewinding Show state.
 */
public class RewindingShowState extends PlayerState implements Notifiable {
	private int remainingTime;
	private static RewindingShowState instance;
	private Timer timer;

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
	 * Process timer ticks event
	 */
	@Override
	public void handleEvent(TimerTicksEvent event) {
		remainingTime += 2;
		PlayerContext.instance().playingShow(PlayerContext.instance().showName(), remainingTime,
				PlayerContext.instance().showRunningTime());
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
		PlayingShowState.instance().setRemainingTime(remainingTime);
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
		timer = new Timer(this, ((int) (PlayerContext.instance().showRunningTime() - remainingTime + 1) / 2));
		PlayerContext.instance().playingShow(PlayerContext.instance().showName(), remainingTime,
				PlayerContext.instance().showRunningTime());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}
}
