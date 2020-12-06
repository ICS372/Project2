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

/**
 * Represents the Show Completed state.
 */
public class ShowCompletedState extends PlayerState implements Notifiable {
	private static ShowCompletedState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private ShowCompletedState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static ShowCompletedState instance() {
		if (instance == null) {
			instance = new ShowCompletedState();
		}
		return instance;
	}

	/**
	 * Process on event
	 */
	@Override
	public void handleEvent(OnEvent event) {
		timer.setTimeValue(10);
	}

	/**
	 * Process select event
	 */
	@Override
	public void handleEvent(SelectEvent event) {
		ShowSelectedState.instance().setShow(event.getShow());
		PlayingShowState.instance().setShow(event.getShow());
		PlayingShowState.instance().setRemainingTime(event.getShow().getRunningTime());
		PlayerContext.instance().changeCurrentState(ShowSelectedState.instance());
	}

	/**
	 * Process play event
	 */
	@Override
	public void handleEvent(PlayEvent event) {
		PlayerContext.instance().changeCurrentState(PlayingShowState.instance());
	}

	/**
	 * Process timer ticks event
	 */
	@Override
	public void handleEvent(TimerTicksEvent event) {
		PlayerContext.instance().showCompleted(timer.getTimeValue());
	}

	/**
	 * Process timer completed event
	 */
	@Override
	public void handleEvent(TimerCompletedEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedIdleState.instance());
	}

	/**
	 * Process stop event
	 */
	@Override
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
	}

	/**
	 * Process pause event
	 */
	@Override
	public void handleEvent(PauseEvent event) {
		timer.setTimeValue(10);
	}

	/**
	 * Process fast forward event
	 */
	@Override
	public void handleEvent(FastForwardEvent event) {
		timer.setTimeValue(10);
	}

	/**
	 * Process rewind event
	 */
	@Override
	public void handleEvent(RewindEvent event) {
		timer.setTimeValue(10);
	}

	/**
	 * initialize the state
	 * 
	 */
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
