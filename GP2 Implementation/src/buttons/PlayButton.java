package buttons;

import events.PlayEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

public class PlayButton extends GUIButton {

	public PlayButton() {
		super("PLAY");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(PlayEvent.instance());
	}

}
