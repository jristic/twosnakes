/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosnakes;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author jovan
 */
public class Setup
{

	private Random r;
	public Setup(GameState state)
	{
		r = new Random();
		state.objects = new ArrayList<Item>();
		this.state = state;
	}

	void gameSetup()
	{
		Vector headPos = new Vector(800,500);
		Vector facing = new Vector(-1,0);
		Vector headSize = new Vector(70,70);
		Vector bodySize = new Vector(50,38);
		Vector tailSize = new Vector(84,38);
		state.snake1 = new P1Snake(headPos, facing, headSize, bodySize, tailSize, "images/s01_heads.png", "images/s1_body.png", "images/s01_tail.png");
		
		headPos = new Vector(600,300);
		facing = new Vector(1,0);
		headSize = new Vector(70,70);
		bodySize = new Vector(50,38);
		tailSize = new Vector(84,38);
		state.snake2 = new P1Snake(headPos, facing, headSize, bodySize, tailSize, "images/s02_heads.png", "images/s2_body.png", "images/s02_tail.png");
		
		state.objects.add( new Apple(5, Math.floor((r.nextDouble()*1280)),  Math.floor((r.nextDouble()*720))));
		state.objects.add( new Mouse(1, 100, 100) );
		state.objects.add( new Turtle(1, 100, 600) );
	}
	
	private GameState state;
}
