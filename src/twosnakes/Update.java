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
	static final int timeBetweenPivotsMs = 60;

	List<Event> events;
	boolean snake1Left, snake1Right, snake2Left, snake2Right;
	long lastSnake1PivotTime, lastSnake2PivotTime;

	public Update(GameState state)
	{
		snake1Left = snake1Right = snake2Left = snake2Right = false;
		events = new ArrayList<Event>();
		this.state = state;
		events.add(new Collision(this.state));
		events.add(new SnakeCollision(this.state.snake1, this.state.snake2));
	}

	void processKeyPress(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			snake1Left = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			snake1Right = true;
		}

		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			snake2Left = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) 
		{
			snake2Right = true;
		}

		if(e.getKeyCode() == KeyEvent.VK_Z){
			System.out.println("Hi");
			state.snake1.addSegments(1);
			System.out.println(state.snake1.getBodyLeng());
		}
		if(e.getKeyCode() == KeyEvent.VK_X){
			System.out.println("Yo");
			state.snake1.removeSegments(1);
			System.out.println(state.snake1.getBodyLeng());
		}
	}

	void processKeyRelease(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			snake1Left = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			snake1Right = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			snake2Left = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) 
		{
			snake2Right = false;
		}
	}

	void gameUpdate(long timePassed)
	{
		for(int i =0; i < events.size(); i++){
			if(events.get(i).getClass() == Collision.class){
				//TODO
				if(state.snake1 != null && state.snake2 != null){
					
					events.get(i).isCollide(state.snake1);
					events.get(i).isCollide(state.snake2);
					
				}
			}
			else if(events.get(i).getClass() == SnakeCollision.class){
				//TODO 
			}
		}

		if (state.snake1 != null)
		{
			// get the new direction vector based on which key (left or right) is pressed.
			Vector currentDirection = state.snake1.getDirection();
			double x = currentDirection.x;
			double y = currentDirection.y;
			if (snake1Left && System.currentTimeMillis() - lastSnake1PivotTime > timeBetweenPivotsMs)
			{
				x = x + y/10.0;
				y = y - x/10.0;
				lastSnake1PivotTime = System.currentTimeMillis();
			}
			else if (snake1Right && System.currentTimeMillis() - lastSnake1PivotTime > timeBetweenPivotsMs)
			{
				x = x - y/10.0;
				y = y + x/10.0;
				lastSnake1PivotTime = System.currentTimeMillis();
			}
			state.snake1.setDirection(new Vector(x,y));
		}

		if (state.snake2 != null)
		{
			//get the new direction vector based on which key (left or right) is pressed.
			Vector currentDirection = state.snake2.getDirection();
			double x = currentDirection.x;
			double y = currentDirection.y;
			if (snake2Left && System.currentTimeMillis() - lastSnake2PivotTime > timeBetweenPivotsMs)
			{
				x = x + y/10.0;
				y = y - x/10.0;
				lastSnake2PivotTime = System.currentTimeMillis();
			}
			else if (snake2Right && System.currentTimeMillis() - lastSnake2PivotTime > timeBetweenPivotsMs) 
			{
				x = x - y/10.0;
				y = y + x/10.0;
				lastSnake2PivotTime = System.currentTimeMillis();
			}
			state.snake2.setDirection(new Vector(x,y));
		}

		if (state.snake1 != null)
		{
			state.snake1.move(timePassed);
		}
		if (state.snake2 != null)
		{
			state.snake2.move(timePassed);
		}

	}

	private GameState state;
}
