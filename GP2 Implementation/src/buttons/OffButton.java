package buttons;

import events.OffEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

/**
 * This class represents the Off button
 * 
 */
public class OffButton extends GUIButton {

	/**
	 * Creates off button with proper the display
	 */
	public OffButton() {
		super("OFF");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(OffEvent.instance());
	}

}
