package panels;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 * This class represents the info panel
 *
 */
public class InfoPanel extends VBox {
	private TextArea info;

	/**
	 * Represents info panel
	 */
	public InfoPanel() {
		info = new TextArea();
		info.setEditable(false);
		this.getChildren().add(info);
	}

	/**
	 * Set text to the info panel
	 * 
	 * @param text String
	 */
	public void setText(String text) {
		info.setText(text);
	}
}
