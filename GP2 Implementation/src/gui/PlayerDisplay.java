package gui;

/**
 * This class specifies what the display system should do.
 */
public interface PlayerDisplay {

	/**
	 * indicate that the player is off
	 */
	public void off();

	/**
	 * indicate that a show has not been selected
	 */
	public void noShowSelected(int time);

	/**
	 * indicate idle
	 */
	public void idle();

	/**
	 * indicate that a show has been selected
	 */
	public void showSelected(String showName, int time, int showTime);

	/**
	 * indicate that show is playing
	 */
	public void playingShow(String showName, int time, int showTime);

	/**
	 * indicate that show has ended
	 */
	public void showCompleted(int time);
}
