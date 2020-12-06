package panels;

import events.SelectEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import shows.Show;
import shows.Shows;
import states.PlayerContext;

/**
 * This class represents the show selected panel
 */
public class ShowSelectPanel extends ListView {
	public ShowSelectPanel() {
		super(Shows.instance().getShows());
		setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				Show show = (Show) getSelectionModel().getSelectedItem();
				PlayerContext.instance().handleEvent(new SelectEvent(show));
			}
		});
	}
}
