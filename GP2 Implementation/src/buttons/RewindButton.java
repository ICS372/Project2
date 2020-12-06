package buttons;

import events.RewindEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

/**
 * This class represents the Rewind button
 * 
 */
public class RewindButton extends GUIButton {

	/**
	 * Creates the rewind button with the proper display
	 */
	public RewindButton() {
		super("REWIND");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(RewindEvent.instance());
	}

}
