package states;

import events.FastForwardEvent;
import events.OnEvent;
import events.PauseEvent;
import events.PlayEvent;
import events.RewindEvent;
import events.StopEvent;
import timer.Timer;

/**
 * Represents the Show Selected Idle state.
 */
public class ShowSelectedIdleState extends PlayerState {
	private static ShowSelectedIdleState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private ShowSelectedIdleState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static ShowSelectedIdleState instance() {
		if (instance == null) {
			instance = new ShowSelectedIdleState();
		}
		return instance;
	}

	/**
	 * Process fast forward event
	 */
	@Override
	public void handleEvent(FastForwardEvent event) {
		PlayerContext.instance().changeCurrentState(ShowSelectedState.instance());
	}

	/**
	 * Process pause event
	 */
	@Override
	public void handleEvent(PauseEvent event) {
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
	 * Process rewind event
	 */
	@Override
	public void handleEvent(RewindEvent event) {
		PlayerContext.instance().changeCurrentState(ShowSelectedState.instance());
	}

	/**
	 * Process stop event
	 */
	@Override
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeCurrentState(ShowSelectedState.instance());
	}

	/**
	 * Process on event
	 */
	@Override
	public void handleEvent(OnEvent event) {
		PlayerContext.instance().changeCurrentState(ShowSelectedState.instance());
	}

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void enter() {
		PlayerContext.instance().idle();
	}
}
