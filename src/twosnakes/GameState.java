/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosnakes;

import java.util.List;

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
	
	public List<Item> objects;
}
