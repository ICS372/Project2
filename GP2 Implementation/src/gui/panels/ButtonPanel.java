package gui.panels;

import gui.controller.buttons.FFButton;
import gui.controller.buttons.OffButton;
import gui.controller.buttons.OnButton;
import gui.controller.buttons.PauseButton;
import gui.controller.buttons.PlayButton;
import gui.controller.buttons.RewindButton;
import gui.controller.buttons.StopButton;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ButtonPanel extends VBox {
	private Button onButton;
	private Button offButton;
	private Button playButton;
	private Button stopButton;
	private Button pauseButton;
	private Button ffButton;
	private Button rewindButton;

	public ButtonPanel() {
		onButton = new OnButton();
		offButton = new OffButton();
		playButton = new PlayButton();
		stopButton = new StopButton();
		pauseButton = new PauseButton();
		ffButton = new FFButton();
		rewindButton = new RewindButton();
		setPrefHeight(onButton.getHeight() * 12);
		setSpacing(5);
		this.getChildren().addAll(onButton, offButton, playButton, stopButton, pauseButton, ffButton, rewindButton);
		setPadding(new Insets(10, 10, 10, 10));
	}
}
