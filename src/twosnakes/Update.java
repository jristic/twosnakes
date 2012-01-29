/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosnakes;

import java.awt.event.KeyEvent;

/**
 *
 * @author jovan
 */
public class Update
{
	public Update(GameState state)
	{
		this.state = state;
	}
	
	void processKeyPress(KeyEvent e)
	{
		
	}

	void processKeyRelease(KeyEvent e)
	{
		
	}

	void gameUpdate(long timePassed)
	{
		state.snake1.move(timePassed);
	}
	
	private GameState state;
}
