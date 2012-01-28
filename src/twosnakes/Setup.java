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
		Vector headPos = new Vector(100,100);
		Vector facing = new Vector(1,0);
		Vector size = new Vector(50,20);
		state.snake1 = new P1Snake(headPos, facing, size, size, size);
	}
	
	private GameState state;
}
