package states;

import events.SelectEvent;
import events.TimerCompletedEvent;
import timer.Notifiable;
import timer.Timer;

public class NoShowSelectedState extends PlayerState implements Notifiable {
	private static NoShowSelectedState instance;
	private Timer timer;

	private NoShowSelectedState() {
	}

	public static NoShowSelectedState instance() {
		if (instance == null) {
			instance = new NoShowSelectedState();
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
	public void enter() {
		timer = new Timer(this, 10);
		PlayerContext.instance().noShowSelected();
		PlayerContext.instance().showTimeLeft(timer.getTimeValue());
	}
}
