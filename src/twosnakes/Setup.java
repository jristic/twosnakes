/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosnakes;

/**
 *
 * @author jovan
 */
public class Setup
{

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
	}
	
	private GameState state;
}
