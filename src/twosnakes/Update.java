/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosnakes;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


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
	Random r = new Random();
	private GameState state;

	public Update(GameState state)
	{
		snake1Left = snake1Right = snake2Left = snake2Right = false;
		events = new ArrayList<Event>();
		this.state = state;
		events.add(0,new Collision(this.state));
		events.add(1,new SnakeCollision(this.state));
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
			state.snake1.addSegments(1);
		}
		if(e.getKeyCode() == KeyEvent.VK_X){
			state.snake1.removeSegments(1);
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
		//TODO
		if(state.snake1 != null && state.snake2 != null){

			if( events.get(0).isCollide(state.snake1) ){
				int item_val = r.nextInt(4);
				if(item_val == 0){ //add apple
					state.objects.add(new Apple(5, Math.floor((r.nextDouble()*1280)),  Math.floor((r.nextDouble()*720))));
				}
				else if(item_val == 1){ //add mouse

				}
				else if(item_val == 2){ //add turtle

				}
				else if(item_val == 3){ //add apple
					state.objects.add(new Apple(5, Math.floor((r.nextDouble()*1280)),  Math.floor((r.nextDouble()*720))));
				}
			}
			if( events.get(0).isCollide(state.snake2) ){
				int item_val = r.nextInt(4);
				if(item_val == 0){ //add apple
					state.objects.add(new Apple(5, Math.floor((r.nextDouble()*1280)),  Math.floor((r.nextDouble()*720))));
				}
				else if(item_val == 1){ //add mouse

				}
				else if(item_val == 2){ //add turtle

				}
				else if(item_val == 3){ //add apple
					state.objects.add(new Apple(5, Math.floor((r.nextDouble()*1280)),  Math.floor((r.nextDouble()*720))));
				}
			}

			if( events.get(1).s1_eat_s2() ){
				System.out.println("adaf");
			}
		}

		for (Item item : state.objects)
		{
			item.update(timePassed);
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
			
			double xDir = state.snake1.getDirection().x;
			double yDir = state.snake1.getDirection().y;
			if(Collision.isOutOfBoundX(state.snake1))
			{
				if((xDir == 1 || xDir == -1)&&yDir==0)
				{
					xDir *= -1;
					yDir = 0.3;
				}
				else
					xDir *=-1;
				Vector newDir = new Vector(xDir,yDir);
				state.snake1.setDirection(newDir);
			}

			if(Collision.isOutOfBoundY(state.snake1))
			{
				if((yDir == 1 || yDir== -1)&&xDir==0)
				{
					yDir *= -1;
					xDir = 0.3;
				}
				else 
					yDir *=-1;
				Vector newDir = new Vector(xDir,yDir);
				state.snake1.setDirection(newDir);
			}
		}

		if (state.snake2 != null)
		{	
			double xDir = state.snake2.getDirection().x;
			double yDir = state.snake2.getDirection().y;
			state.snake2.move(timePassed);

			if(Collision.isOutOfBoundX(state.snake2))
			{
				if((xDir == 1 || xDir == -1)&&yDir==0)
				{
					xDir *= -1;
					yDir = 0.3;
				}
				else 
					xDir *=-1;
				Vector newDir = new Vector(xDir,yDir);
				state.snake2.setDirection(newDir);
			}

			if(Collision.isOutOfBoundY(state.snake2))
			{
				if((yDir == 1 || yDir== -1)&&xDir==0)
				{
					yDir *= -1;
					xDir = 0.3;
				}
				else 
					yDir *=-1;
				Vector newDir = new Vector(xDir,yDir);
				state.snake2.setDirection(newDir);
			}
		}
	}
}
