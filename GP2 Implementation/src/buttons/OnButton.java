package buttons;

import events.OnEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

/**
 * This class represents the On button
 * 
 */
public class OnButton extends GUIButton {

	/**
	 * Creates the On button with the proper display
	 */
	public OnButton() {
		super("ON");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(OnEvent.instance());

	}

}
