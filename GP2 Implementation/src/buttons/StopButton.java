package buttons;

import events.StopEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

/**
 * This class represents the Stop button
 * 
 */
public class StopButton extends GUIButton {

	/**
	 * Creates the stop button with the proper display
	 */
	public StopButton() {
		super("STOP");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(StopEvent.instance());
	}

}
