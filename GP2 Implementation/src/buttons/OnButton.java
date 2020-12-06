package buttons;

import events.OnEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

public class OnButton extends GUIButton {

	public OnButton() {
		super("ON");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(OnEvent.instance());

	}

}
