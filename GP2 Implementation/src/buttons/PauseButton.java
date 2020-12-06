package buttons;

import events.PauseEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

/**
 * This class represents the Pause button
 * 
 */
public class PauseButton extends GUIButton {

	/**
	 * Creates the Pause button with the proper display
	 */
	public PauseButton() {
		super("PAUSE");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(PauseEvent.instance());
	}

}
