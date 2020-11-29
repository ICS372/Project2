package timer;

import events.TimerCompletedEvent;
import events.TimerTicksEvent;

/**
 * An entity that can be notified of timing events
 * 
 * @author Brahma Dathan
 *
 */
public interface Notifiable {
	/**
	 * Process timer ticks
	 */
	public void handleEvent(TimerTicksEvent event);

	/**
	 * Process timer runs out event
	 */
	public void handleEvent(TimerCompletedEvent event);
}
