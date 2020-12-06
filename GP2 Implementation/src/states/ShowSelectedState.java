package states;

import events.FastForwardEvent;
import events.OnEvent;
import events.PauseEvent;
import events.PlayEvent;
import events.RewindEvent;
import events.SelectEvent;
import events.StopEvent;
import events.TimerCompletedEvent;
import events.TimerTicksEvent;
import shows.Show;
import timer.Notifiable;
import timer.Timer;

public class ShowSelectedState extends PlayerState implements Notifiable {
	private Show show;
	private static ShowSelectedState instance;
	private Timer timer;

	private ShowSelectedState() {

	}

	public static ShowSelectedState instance() {
		if (instance == null) {
			instance = new ShowSelectedState();
		}
		return instance;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	@Override
	public void handleEvent(OnEvent event) {
		timer.setTimeValue(10);
	}

	@Override
	public void handleEvent(SelectEvent event) {
		setShow(event.getShow());
		PlayingShowState.instance().setShow(show);
		PlayingShowState.instance().setRemainingTime(show.getRunningTime());
		timer.setTimeValue(10);
		PlayerContext.instance().showSelected(show.getName(), timer.getTimeValue(), show.getRunningTime());
	}

	@Override
	public void handleEvent(TimerTicksEvent event) {
		PlayerContext.instance().showSelected(show.getName(), timer.getTimeValue(), show.getRunningTime());
	}

	@Override
	public void handleEvent(TimerCompletedEvent event) {
		PlayerContext.instance().changeCurrentState(ShowSelectedIdleState.instance());
	}

	@Override
	public void handleEvent(PlayEvent event) {
		PlayerContext.instance().changeCurrentState(PlayingShowState.instance());
	}

	@Override
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeCurrentState(ShowCompletedState.instance());
	}

	@Override
	public void handleEvent(PauseEvent event) {
		timer.setTimeValue(10);
	}

	@Override
	public void handleEvent(FastForwardEvent event) {
		timer.setTimeValue(10);
	}

	@Override
	public void handleEvent(RewindEvent event) {
		timer.setTimeValue(10);
	}

	@Override
	public void enter() {
		timer = new Timer(this, 10);
		PlayerContext.instance().showSelected(show.getName(), timer.getTimeValue(), show.getRunningTime());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		PlayerContext.instance().showSelected(show.getName(), 0, show.getRunningTime());
	}
}
