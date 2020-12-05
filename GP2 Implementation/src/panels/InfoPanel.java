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

	public void off() {
		info.setText("Off");
	}

	public void noShowSelected() {
		info.setText("No show selected.. going idle in ");
	}

	public void showTimeLeft(int value) {
		info.appendText(value + "");
	}
}
