package panels;

import javafx.scene.control.ListView;
import shows.Shows;

public class ShowSelectPanel extends ListView {
	public ShowSelectPanel() {
		super(Shows.instance().getShows());
	}
}
