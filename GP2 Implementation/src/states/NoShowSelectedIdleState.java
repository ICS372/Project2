package states;

import events.FastForwardEvent;
import events.OnEvent;
import events.PauseEvent;
import events.PlayEvent;
import events.RewindEvent;
import events.StopEvent;

/**
 * Represents the No Show Selected Idle state.
 *
 */
public class NoShowSelectedIdleState extends PlayerState {
	private static NoShowSelectedIdleState instance;

	/**
	 * Private for the singleton pattern
	 */
	private NoShowSelectedIdleState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static NoShowSelectedIdleState instance() {
		if (instance == null) {
			instance = new NoShowSelectedIdleState();
		}
		return instance;
	}

	/**
	 * Process fast forward event
	 */
	@Override
	public void handleEvent(FastForwardEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
	}

	/**
	 * Process pause event
	 */
	@Override
	public void handleEvent(PauseEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
	}

	/**
	 * Process play event
	 */
	@Override
	public void handleEvent(PlayEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
	}

	/**
	 * Process rewind event
	 */
	@Override
	public void handleEvent(RewindEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
	}

	/**
	 * Process stop event
	 */
	@Override
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
	}

	/**
	 * Process on event
	 */
	@Override
	public void handleEvent(OnEvent event) {
		PlayerContext.instance().changeCurrentState(NoShowSelectedState.instance());
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
