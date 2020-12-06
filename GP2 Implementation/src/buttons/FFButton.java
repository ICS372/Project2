package buttons;

/**
 * This class represents the Fast Forward button 
 * 
 */
import events.FastForwardEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

public class FFButton extends GUIButton {

	/**
	 * Creates the fast forward button with the proper display
	 * 
	 */
	public FFButton() {
		super("FF");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(FastForwardEvent.instance());
	}

}
