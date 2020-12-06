package states;

import events.PlayEvent;
import events.StopEvent;
import events.TimerCompletedEvent;
import events.TimerTicksEvent;
import shows.Show;
import timer.FastForwardTimer;
import timer.Notifiable;

public class FastForwardingShowState extends PlayerState implements Notifiable {
	private int remainingTime;
	private Show show;
	private static FastForwardingShowState instance;
	private FastForwardTimer timer;

	private FastForwardingShowState() {

	}

	public static FastForwardingShowState instance() {
		if (instance == null) {
			instance = new FastForwardingShowState();
		}
		return instance;
	}

	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	@Override
	public void handleEvent(TimerTicksEvent event) {
		PlayerContext.instance().playingShow(show.getName(), timer.getTimeValue(), show.getRunningTime());
	}

	@Override
	public void handleEvent(TimerCompletedEvent event) {
		PlayerContext.instance().changeCurrentState(ShowCompletedState.instance());
	}

	@Override
	public void handleEvent(PlayEvent event) {
		PlayingShowState.instance().setRemainingTime(timer.getTimeValue());
		PlayerContext.instance().changeCurrentState(PlayingShowState.instance());
	}

	@Override
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeCurrentState(ShowCompletedState.instance());
	}

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
