package gui.controller.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public abstract class GUIButton extends Button implements EventHandler<ActionEvent> {

	public GUIButton(String label) {
		super(label);
		setPrefWidth(150);
		setPrefHeight(20);
		setPadding(new Insets(10, 30, 10, 30));
		setOnAction((EventHandler<ActionEvent>) this);
	}

	@Override
	public abstract void handle(ActionEvent event);
}
