package panels;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class InfoPanel extends VBox {
	private TextArea info;

	public InfoPanel() {
		info = new TextArea();
		info.setEditable(false);
		this.getChildren().add(info);
	}

	public void setText(String text) {
		info.setText(text);
	}
}
