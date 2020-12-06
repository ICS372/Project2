package buttons;

import events.StopEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

public class StopButton extends GUIButton {

	public StopButton() {
		super("STOP");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(StopEvent.instance());
	}

}
