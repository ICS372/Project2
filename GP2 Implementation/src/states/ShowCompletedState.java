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
import timer.Notifiable;
import timer.Timer;

public class ShowCompletedState extends PlayerState implements Notifiable {
	private static ShowCompletedState instance;
	private Timer timer;

	private ShowCompletedState() {

	}

	public static ShowCompletedState instance() {
		if (instance == null) {
			instance = new ShowCompletedState();
		}
		return instance;
	}

	@Override
	public void handleEvent(OnEvent event) {
		timer.setTimeValue(10);
	}

	@Override
	public void handleEvent(SelectEvent event) {
		ShowSelectedState.instance().setShow(event.getShow());
		PlayingShowState.instance().setShow(event.getShow());
		PlayingShowState.instance().setRemainingTime(event.getShow().getRunningTime());
		PlayerContext.instance().changeCurrentState(ShowSelectedState.instance());
	}

	@Override
	public void handleEvent(PlayEvent event) {
		PlayerContext.instance().changeCurrentState(PlayingShowState.instance());
	}

	@Override
	public void handleEvent(TimerTicksEvent event) {
		PlayerContext.instance().showCompleted(timer.getTimeValue());
	}

	@Override
	public void handleEvent(TimerCompletedEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedIdleState.instance());
	}

	@Override
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
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
		PlayerContext.instance().showCompleted(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		PlayerContext.instance().showCompleted(0);
	}

}
