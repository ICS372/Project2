package gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import panels.ButtonPanel;
import panels.InfoPanel;
import panels.ShowSelectPanel;
import states.PlayerContext;

/**
 * GUI to implement the remote control for a video player interface.
 *
 */
public class GUIDisplay extends Application implements PlayerDisplay {
	private ButtonPanel buttonPanel;
	private InfoPanel showInfo;
	private ShowSelectPanel showSelect;
	private static PlayerDisplay display;
	private PlayerContext playerContext;

	public static PlayerDisplay getInstance() {
		return display;
	}

	/**
	 * Sets up the interface
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		playerContext = PlayerContext.instance();
		playerContext.setDisplay(this);
		display = this;

		buttonPanel = new ButtonPanel();
		showSelect = new ShowSelectPanel();
		showInfo = new InfoPanel();

		Text showTitle = new Text("Shows");
		HBox hBox = new HBox();
		hBox.getChildren().add(buttonPanel);
		VBox vBox = new VBox();
		vBox.getChildren().addAll(showInfo, showTitle, showSelect);
		hBox.getChildren().add(vBox);
		playerContext.initialize();
		Scene scene = new Scene(hBox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Show Player");
		try {
			while (playerContext == null) {
				Thread.sleep(1000);
			}
		} catch (Exception e) {

		}
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

	/**
	 * Indicate that the remote is off
	 */
	public void off() {
		showInfo.setText("Off");
	}

	/**
	 * Indicate that the show is not selected
	 */
	public void noShowSelected(int time) {
		showInfo.setText("No show selected.\nGoing idle in " + time);
	}

	/**
	 * Indicate idle
	 */
	public void idle() {
		showInfo.setText("IDLE | Press any button on the left panel to resume.");
	}

	/**
	 * Indicate that the show is selected
	 */
	public void showSelected(String showName, int time, int showTime) {
		showInfo.setText(showName + " " + showTime + "/" + showTime
				+ ".\nPress Play to begin, Stop to end.\nGoing idle in " + time);
	}

	/**
	 * Indicate that the show is playing
	 */
	public void playingShow(String showName, int time, int showTime) {
		showInfo.setText(showName + " : " + time + "/" + showTime);
	}

	/**
	 * Indicate that the show is completed
	 */
	public void showCompleted(int time) {
		showInfo.setText(
				"Show completed.\nPress Stop to deselect, Play to watch again, or you may select another show.\nGoing idle in "
						+ time);
	}

}
