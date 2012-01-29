/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosnakes;

import java.util.Random;

/**
 *
 * @author jovan
 */
public class Setup
{

	Random r = new Random();
	Setup(GameState state)
	{
		this.state = state;
	}

	void gameSetup()
	{
		Vector headPos = new Vector(600,300);
		Vector facing = new Vector(1,0);
		Vector headSize = new Vector(83,70);
		Vector bodySize = new Vector(60,38);
		Vector tailSize = new Vector(84,38);
		state.snake1 = new P1Snake(headPos, facing, headSize, bodySize, tailSize);
		
		headPos = new Vector(800,500);
		facing = new Vector(-1,0);
		headSize = new Vector(83,70);
		bodySize = new Vector(60,38);
		tailSize = new Vector(84,38);
		state.snake2 = new P1Snake(headPos, facing, headSize, bodySize, tailSize);
		
		state.ap1 = new Apple(5, Math.floor((r.nextDouble()*1280)),  Math.floor((r.nextDouble()*720)));
	}
	
	private GameState state;
}
