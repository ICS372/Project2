package states;

import events.FastForwardEvent;
import events.OffEvent;
import events.OnEvent;
import events.PauseEvent;
import events.PlayEvent;
import events.RewindEvent;
import events.SelectEvent;
import events.StopEvent;
import gui.PlayerDisplay;

/**
 * This class is observer and stores the context info for states
 *
 */
public class PlayerContext {
	private PlayerDisplay display;
	private PlayerState currentState;
	private static PlayerContext instance;

	/**
	 * Make it a singleton
	 */
	private PlayerContext() {
		currentState = OffState.instance();
	}

	/**
	 * Return the instance
	 * 
	 * @return the object
	 */
	public static PlayerContext instance() {
		if (instance == null) {
			instance = new PlayerContext();
		}
		return instance;
	}

	/**
	 * Change current state
	 * 
	 * @param nextState
	 */
	public void changeCurrentState(PlayerState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	/**
	 * Lets off state be the starting state adds the object as an observable
	 */
	public void initialize() {
		instance.changeCurrentState(OffState.instance());
	}

	/**
	 * Get reference of display, since this one could change
	 * 
	 * @param display
	 */
	public void setDisplay(PlayerDisplay display) {
		this.display = display;
	}

	/**
	 * Process fast forward request
	 */
	public void handleEvent(FastForwardEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Process off request
	 */
	public void handleEvent(OffEvent event) {
		PlayerContext.instance().changeCurrentState(OffState.instance());
	}

	/**
	 * Process on request
	 */
	public void handleEvent(OnEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Process pause request
	 */
	public void handleEvent(PauseEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Process play request
	 */
	public void handleEvent(PlayEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Process rewind request
	 */
	public void handleEvent(RewindEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Process select request
	 */
	public void handleEvent(SelectEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * Process stop request
	 */
	public void handleEvent(StopEvent event) {
		currentState.handleEvent(event);
	}

	/**
	 * This method invokes the right method. This helps protect the states from
	 * changes to the way the system utilizes the state changes.
	 */
	public void playerOff() {
		display.off();
	}

	/**
	 * This method invokes the right method. This helps protect the states from
	 * changes to the way the system utilizes the state changes.
	 */
	public void noShowSelected(int time) {
		display.noShowSelected(time);
	}

	/**
	 * This method invokes the right method. This helps protect the states from
	 * changes to the way the system utilizes the state changes.
	 */
	public void idle() {
		display.idle();
	}

	/**
	 * This method invokes the right method. This helps protect the states from
	 * changes to the way the system utilizes the state changes.
	 * 
	 * @param showName, time, showTime
	 */
	public void showSelected(String showName, int time, int showTime) {
		display.showSelected(showName, time, showTime);
	}

	/**
	 * This method invokes the right method. This helps protect the states from
	 * changes to the way the system utilizes the state changes.
	 * 
	 * @param showName, time, showTime
	 */
	public void playingShow(String showName, int time, int showTime) {
		display.playingShow(showName, time, showTime);
	}

	/**
	 * This method invokes the right method. This helps protect the states from
	 * changes to the way the system utilizes the state changes.
	 * 
	 * @param time
	 */
	public void showCompleted(int time) {
		display.showCompleted(time);
	}
}
