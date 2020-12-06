package buttons;

import events.RewindEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

public class RewindButton extends GUIButton {

	public RewindButton() {
		super("REWIND");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(RewindEvent.instance());
	}

}
