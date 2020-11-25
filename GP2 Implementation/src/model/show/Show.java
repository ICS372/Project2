package model.show;

/**
 * Implements a single show
 * 
 * @author Brahma Dathan
 *
 */

public class Show {
	private String name;
	private int runningTime;

	/**
	 * Creates a Show with the given name and running time
	 * 
	 * @param name        the name of the show
	 * @param runningTime the running time in seconds
	 */
	public Show(String name, int runningTime) {
		this.name = name;
		this.runningTime = runningTime;
	}

	public String getName() {
		return name;
	}

	public int getRunningTime() {
		return runningTime;
	}

	@Override
	public String toString() {
		return name + " " + runningTime + " seconds";
	}
}
