package buttons;

import events.FastForwardEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

public class FFButton extends GUIButton {

	public FFButton() {
		super("FF");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(FastForwardEvent.instance());
	}

}
