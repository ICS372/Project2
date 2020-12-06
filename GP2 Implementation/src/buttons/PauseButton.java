package buttons;

import events.PauseEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

public class PauseButton extends GUIButton {

	public PauseButton() {
		super("PAUSE");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(PauseEvent.instance());
	}

}
