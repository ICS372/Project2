package states;

import events.FastForwardEvent;
import events.PauseEvent;
import events.RewindEvent;
import events.StopEvent;
import events.TimerCompletedEvent;
import events.TimerTicksEvent;
import shows.Show;
import timer.Notifiable;
import timer.Timer;

public class PlayingShowState extends PlayerState implements Notifiable {
	private Show show;
	private int remainingTime;
	private static PlayingShowState instance;
	private Timer timer;

	private PlayingShowState() {

	}

	public static PlayingShowState instance() {
		if (instance == null) {
			instance = new PlayingShowState();
		}
		return instance;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
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
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeCurrentState(ShowCompletedState.instance());
	}

	@Override
	public void handleEvent(PauseEvent event) {
		ShowPausedState.instance().setRemainingTime(timer.getTimeValue());
		PlayerContext.instance().changeCurrentState(ShowPausedState.instance());
	}

	@Override
	public void handleEvent(RewindEvent event) {
		RewindingShowState.instance().setRemainingTime(timer.getTimeValue());
		RewindingShowState.instance().setShow(show);
		PlayerContext.instance().changeCurrentState(RewindingShowState.instance());
	}

	@Override
	public void handleEvent(FastForwardEvent event) {
		FastForwardingShowState.instance().setRemainingTime(timer.getTimeValue());
		FastForwardingShowState.instance().setShow(show);
		PlayerContext.instance().changeCurrentState(FastForwardingShowState.instance());
	}

	@Override
	public void enter() {
		timer = new Timer(this, remainingTime);
		PlayerContext.instance().playingShow(show.getName(), timer.getTimeValue(), show.getRunningTime());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}
}
