package gui.panels;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class ShowInfoPanel extends VBox {
	private TextArea showInfo;

	public ShowInfoPanel() {
		showInfo = new TextArea();
		showInfo.setEditable(false);
		this.getChildren().add(showInfo);
	}
}
