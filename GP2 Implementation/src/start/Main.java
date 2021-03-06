package start;

import gui.GUIDisplay;
import gui.PlayerDisplay;
import javafx.application.Application;
import states.PlayerContext;
import timer.Clock;

/**
 * This program is the implementation of a remote control for a video player.
 * 
 * @author Shuja Uddin, Gina Bjork
 */
public class Main {

	public static void main(String[] args) {
		Clock.instance();
		new Thread() {
			@Override
			public void run() {
				Application.launch(GUIDisplay.class);
			}
		}.start();
		try {
			while (GUIDisplay.getInstance() == null) {
				Thread.sleep(1000);
			}
		} catch (InterruptedException ie) {
		}
		PlayerDisplay display = GUIDisplay.getInstance();
		PlayerContext.instance().setDisplay(display);
	}

}
