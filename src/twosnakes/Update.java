/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosnakes;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author jovan
 */
public class Update
{
	List<Event> events;
	
	public Update(GameState state)
	{
		events = new ArrayList<Event>();
		this.state = state;
		events.add(new Collision(this.state));
	}

	void processKeyPress(KeyEvent e)
	{
		//get the new direction vector based on which key (left or right) is pressed.
		Vector currentDirection = state.snake1.getDirection();
		double x = currentDirection.x;
		double y = currentDirection.y;
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			x = x + y/10.0;
			y = y - x/10.0;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			x = x - y/10.0;
			y = y + x/10.0;
		}
		state.snake1.setDirection(new Vector(x,y));
		
		if(e.getKeyCode() == KeyEvent.VK_A){
			System.out.println("Hi");
			state.snake1.addSegments(1);
			System.out.println(state.snake1.getBodyLeng());
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			System.out.println("Yo");
			state.snake1.removeSegments(1);
			System.out.println(state.snake1.getBodyLeng());
		}
	}

	void processKeyRelease(KeyEvent e)
	{

	}

	void gameUpdate(long timePassed)
	{
		if (state.snake1 == null)
			return;
		state.snake1.move(timePassed);
		
	}

	private GameState state;
}
