package gui;

import gui.panels.ButtonPanel;
import gui.panels.ShowInfoPanel;
import gui.panels.ShowSelectPanel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RemoteControl extends Application {
	private ButtonPanel buttonPanel;
	private ShowInfoPanel showInfo;
	private ShowSelectPanel showSelect;

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage arg0) throws Exception {
		arg0.setTitle("Remote Control");
		buttonPanel = new ButtonPanel();
		showSelect = new ShowSelectPanel();
		showInfo = new ShowInfoPanel();
		Text showTitle = new Text("Shows");
		HBox hBox = new HBox();
		hBox.getChildren().add(buttonPanel);
		VBox vBox = new VBox();
		vBox.getChildren().addAll(showInfo, showTitle, showSelect);
		hBox.getChildren().add(vBox);
		Scene scene = new Scene(hBox);
		arg0.setScene(scene);
		arg0.show();
	}

}
