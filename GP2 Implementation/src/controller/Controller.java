/**
 * 
 *            Redistribution and use with or without modification, are permitted
 *            provided that the following conditions are met:
 *
 *            - the use is for academic purpose only - Redistributions of source
 *            code must retain the above copyright notice, this list of
 *            conditions and the following disclaimer. - The name of Brahma Dathan 
 *            may not be used to endorse or promote
 *            products derived from this software without specific prior written
 *            permission.
 *
 *            The author does not make any claims regarding the correctness of
 *            the code in this module and are not responsible for any loss or
 *            damage resulting from its use.
 */
package controller;

import events.FastForwardEvent;
import events.OffEvent;
import events.OnEvent;
import events.PauseEvent;
import events.PlayEvent;
import events.RewindEvent;
import events.SelectEvent;
import events.StopEvent;
import events.TimerCompletedEvent;
import events.TimerTicksEvent;

/**
 * This represents the controller functionality.
 * 
 * @author Brahma Dathan
 *
 */
public interface Controller {
	/**
	 * What to do when a line is to be created.
	 * 
	 * @param event represents the click on the button
	 */
	public void handleEvent(FastForwardEvent event);

	/**
	 * What to do when mouse enters the drawing panel.
	 * 
	 * @param event represents the entry of the mouse
	 */
	public void handleEvent(OffEvent event);

	/**
	 * What to do when mouse exits the drawing panel.
	 * 
	 * @param event represents the exit of the mouse
	 */
	public void handleEvent(OnEvent event);

	/**
	 * What to do when mouse is clicked with control down.
	 * 
	 * @param event represents the click of the mouse with control down
	 */
	public void handleEvent(PauseEvent event);

	/**
	 * What to do when the Enter key is pressed with shift down.
	 * 
	 * @param event represents the Enter key press with shift down
	 */
	public void handleEvent(PlayEvent event);

	/**
	 * What to do when mouse is clicked.
	 * 
	 * @param event represents the click of the mouse
	 */
	public void handleEvent(RewindEvent event);

	/**
	 * What to do when a polygon is to be created.
	 * 
	 * @param event represents the click on the button
	 */
	public void handleEvent(SelectEvent event);

	/**
	 * What to do when a label is to be created.
	 * 
	 * @param event represents the click on the button
	 */
	public void handleEvent(StopEvent event);

	/**
	 * What to do when a character is typed.
	 * 
	 * @param event represents the typing of the key
	 */
	public void handleEvent(TimerCompletedEvent event);

	/**
	 * What to do when backspace key is pressed.
	 * 
	 * @param event represents the pressing of the key
	 */
	public void handleEvent(TimerTicksEvent event);
}
