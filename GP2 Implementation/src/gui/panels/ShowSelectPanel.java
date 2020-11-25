package gui.panels;

import javafx.scene.control.ListView;
import model.Shows;

public class ShowSelectPanel extends ListView {
	public ShowSelectPanel() {
		super(Shows.instance().getShows());
	}
}
