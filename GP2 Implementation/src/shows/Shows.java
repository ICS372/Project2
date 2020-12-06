package shows;

import java.io.Serializable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class represents a collection of shows
 *
 */
public class Shows implements Serializable {
	private static final long serialVersionUID = 1L;
	private ObservableList<Show> shows = FXCollections.observableArrayList();
	private static Shows eventsInstance;

	/**
	 * Implementing a singleton class
	 */
	private Shows() {
	}

	/**
	 * Returns the singleton object
	 * 
	 * @return
	 */
	public static Shows instance() {
		if (eventsInstance == null) {
			eventsInstance = new Shows();
			eventsInstance.addShows();
		}
		return eventsInstance;
	}

	/**
	 * Getter
	 * 
	 * @return
	 */
	public ObservableList<Show> getShows() {
		return shows;
	}

	/**
	 * Creates a set of shows and adds them to the list
	 */
	private void addShows() {
		String[] names = { "N1", "N2", "N3", "N4", "N5" };
		int[] runningTimes = { 10, 20, 30, 40, 50 };
		for (int index = 0; index < names.length; index++) {
			shows.add(new Show(names[index], runningTimes[index]));
		}
	}
}
