package states;

import events.PlayEvent;
import events.StopEvent;
import events.TimerCompletedEvent;
import events.TimerTicksEvent;
import shows.Show;
import timer.Notifiable;
import timer.RewindTimer;

public class RewindingShowState extends PlayerState implements Notifiable {
	private int remainingTime;
	private Show show;
	private static RewindingShowState instance;
	private RewindTimer timer;

	private RewindingShowState() {

	}

	public static RewindingShowState instance() {
		if (instance == null) {
			instance = new RewindingShowState();
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
		PlayerContext.instance().changeCurrentState(ShowSelectedState.instance());
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
		timer = new RewindTimer(this, remainingTime, show.getRunningTime());
		PlayerContext.instance().playingShow(show.getName(), timer.getTimeValue(), show.getRunningTime());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}
}
