package events;

import shows.Show;

/**
 * Represents the Select event
 *
 */
public class SelectEvent {
	private Show show;

	/**
	 * Private for singleton
	 * 
	 */
	public SelectEvent(Show show) {
		this.show = show;
	}

	public Show getShow() {
		return this.show;
	}
}
