/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosnakes;

/**
 *
 * @author jovan
 */
public class GameState
{	
	public GameState()
	{
		titleScreen = new TitleScreen();
	}
	
	public TitleScreen titleScreen;
	public Snake snake1;
	public Snake snake2;
}
