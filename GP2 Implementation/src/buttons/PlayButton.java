package buttons;

import events.PlayEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

/**
 * This class represents the Play button
 * 
 */
public class PlayButton extends GUIButton {

	/**
	 * Creates the Play button with the proper display
	 */
	public PlayButton() {
		super("PLAY");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(PlayEvent.instance());
	}

}
