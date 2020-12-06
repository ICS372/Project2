package buttons;

import events.OffEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

public class OffButton extends GUIButton {

	public OffButton() {
		super("OFF");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(OffEvent.instance());
	}

}
