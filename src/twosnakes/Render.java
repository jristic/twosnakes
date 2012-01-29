/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosnakes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author jovan
 */
public class Render
{
	BufferedImage bkg = null;
	
	double musicLoopTimer;
	boolean titleMusicStarted;
	
	//SoundPlayer player;
	//SoundPlayer player2;
	
	public Render(GameState state, JPanel panel)
	{
		this.panel = panel;
		this.state = state;
		// set up message font
		font = new Font("SansSerif", Font.BOLD, 24);
		metrics = panel.getFontMetrics(font);
		
		try 
		{
			bkg = ImageIO.read( new File("images/G_background.png") );
		}
		catch (IOException e)
		{}
		titleMusicStarted = false;
		
		//player = new SoundPlayer("sound/music01.mp3");
		//player2 = new SoundPlayer("sound/music1.mp3");
	}

	void paintScreen(Graphics g, Image dbImage)
	{
		try
		{
			if ((g != null) && (dbImage != null))
			{
				g.drawImage(dbImage, 0, 0, null);
			}
			Toolkit.getDefaultToolkit().sync();  // sync the display on some systems
			g.dispose();
		} catch (Exception e)
		{
			System.out.println("Graphics error: " + e);
		}
	}

	void drawStartMessage(Graphics dbg)
	{
		state.titleScreen.step();
		state.titleScreen.draw(dbg);
		
		/*
		if (!titleMusicStarted || System.currentTimeMillis() > musicLoopTimer + 15150)
		{
			player.playerInitialize();
			player.play();
			musicLoopTimer = System.currentTimeMillis();
			titleMusicStarted = true;
		}
		*/
	}

	void drawGameOverMessage(Graphics dbg)
	{
		dbg.setColor(Color.white);
		dbg.fillRect(0, 0, panel.getWidth(), panel.getHeight());
		String msg = "GAME OVER! Winner is: " + state.winner;
		int x = 50;
		int y = 100;
		dbg.setColor(Color.black);
		dbg.setFont(font);
		dbg.drawString(msg, x, y);
	}

	void drawGame(Graphics dbg)
	{
		/*
		if (titleMusicStarted)
		{
			player.pause();
			titleMusicStarted = false;
			musicLoopTimer = System.currentTimeMillis();
			player2.play();
		}
		*/
		dbg.drawImage(bkg, 0, 0, null);
		
		for(int i = 0; i < state.objects.size(); i++){
			if(state.objects.get(i) == null)
				break;
			state.objects.get(i).draw(dbg);
		}
		if (state.snake1 != null)
			state.snake1.draw(dbg);
		if (state.snake2 != null)
			state.snake2.draw(dbg);
		/*
		if (System.currentTimeMillis() > musicLoopTimer + 19140)
		{
			player2.playerInitialize();
			player2.play();
			musicLoopTimer = System.currentTimeMillis();
		}
		*/

	}

	private GameState state;
	private Font font;
	private FontMetrics metrics;
	private JPanel panel;
}
