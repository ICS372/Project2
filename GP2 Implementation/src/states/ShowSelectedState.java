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
 * Represents the Show Selected state.
 */
public class ShowSelectedState extends PlayerState implements Notifiable {
	private static ShowSelectedState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private ShowSelectedState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static ShowSelectedState instance() {
		if (instance == null) {
			instance = new ShowSelectedState();
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
		PlayerContext.instance().setShow(event.getShow());
		timer.setTimeValue(10);
		PlayerContext.instance().showSelected(PlayerContext.instance().showName(), timer.getTimeValue(),
				PlayerContext.instance().showRunningTime());
	}

	/**
	 * Process timer ticks event
	 */
	@Override
	public void handleEvent(TimerTicksEvent event) {
		PlayerContext.instance().showSelected(PlayerContext.instance().showName(), timer.getTimeValue(),
				PlayerContext.instance().showRunningTime());
	}

	/**
	 * Process timer completed event
	 */
	@Override
	public void handleEvent(TimerCompletedEvent event) {
		PlayerContext.instance().changeCurrentState(ShowSelectedIdleState.instance());
	}

	/**
	 * Process play event
	 */
	@Override
	public void handleEvent(PlayEvent event) {
		PlayingShowState.instance().setRemainingTime(PlayerContext.instance().showRunningTime());
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
		PlayerContext.instance().showSelected(PlayerContext.instance().showName(), timer.getTimeValue(),
				PlayerContext.instance().showRunningTime());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}
}
