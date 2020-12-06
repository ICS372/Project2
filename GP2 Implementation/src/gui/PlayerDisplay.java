package gui;

public interface PlayerDisplay {

	public void off();

	public void noShowSelected(int time);

	public void idle();

	public void showSelected(String showName, int time, int showTime);

	public void playingShow(String showName, int time, int showTime);

	public void showCompleted(int time);
}
