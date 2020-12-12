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
 * Represents the No Show Selected state.
 *
 */
public class NoShowSelectedState extends PlayerState implements Notifiable {
	private static NoShowSelectedState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private NoShowSelectedState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static NoShowSelectedState instance() {
		if (instance == null) {
			instance = new NoShowSelectedState();
		}
		return instance;
	}

	/**
	 * Process On event
	 */
	@Override
	public void handleEvent(OnEvent event) {
		timer.setTimeValue(10);
	}

	/**
	 * Process Play event
	 */
	@Override
	public void handleEvent(PlayEvent event) {
		timer.setTimeValue(10);
	}

	/**
	 * Process Stop event
	 */
	@Override
	public void handleEvent(StopEvent event) {
		timer.setTimeValue(10);
	}

	/**
	 * Process Pause event
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
	 * Process select event
	 */
	@Override
	public void handleEvent(SelectEvent event) {
		PlayerContext.instance().setShow(event.getShow());
		PlayerContext.instance().changeCurrentState(ShowSelectedState.instance());
	}

	/**
	 * Process timer ticks event
	 */
	@Override
	public void handleEvent(TimerTicksEvent event) {
		PlayerContext.instance().noShowSelected(timer.getTimeValue());
	}

	/**
	 * Process timer completed event
	 */
	@Override
	public void handleEvent(TimerCompletedEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedIdleState.instance());
	}

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 10);
		PlayerContext.instance().noShowSelected(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		PlayerContext.instance().noShowSelected(0);
	}
}
