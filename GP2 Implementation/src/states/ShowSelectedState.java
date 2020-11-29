package states;

import events.PlayEvent;
import events.SelectEvent;
import events.TimerCompletedEvent;
import timer.Timer;

public class ShowSelectedState extends PlayerState {
	private static ShowSelectedState instance;
	private Timer timer;

	private ShowSelectedState() {

	}

	public static ShowSelectedState instance() {
		if (instance == null) {
			instance = new ShowSelectedState();
		}
		return instance;
	}

	@Override
	public void handleEvent(SelectEvent event) {

	}

	@Override
	public void handleEvent(TimerCompletedEvent event) {

	}

	@Override
	public void handleEvent(PlayEvent event) {

	}
}
