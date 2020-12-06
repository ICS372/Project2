package shows;

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

	/**
	 * Gets name of show
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets running time of show
	 * 
	 * @return
	 */
	public int getRunningTime() {
		return runningTime;
	}

	@Override
	public String toString() {
		return name + " " + runningTime + " seconds";
	}
}
