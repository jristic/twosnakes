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
	public P1Snake snake1;
	public P1Snake snake2;
	public String winner = "";
	
	public List<Item> objects;
}
