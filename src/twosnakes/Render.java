/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosnakes;

import java.awt.*;
import java.awt.List;
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
	BufferedImage goBgd = null;
	
	double musicLoopTimer;
	boolean titleMusicStarted;
	boolean gameMusicStarted;
	
	SoundEffectPlayer player;
	SoundEffectPlayer player2;
	SoundEffectPlayer player3;
	
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
		
		player = new SoundEffectPlayer("sound/music01mono.wav");
		player2 = new SoundEffectPlayer("sound/music2mono.wav");
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
		
		
		if (!titleMusicStarted || System.currentTimeMillis() > musicLoopTimer + 10860)
		{
			player = new SoundEffectPlayer("sound/music01mono.wav");
			player.play();
			musicLoopTimer = System.currentTimeMillis();
			titleMusicStarted = true;
		}
		
	}
	

	void drawGame(Graphics dbg)
	{
		if (titleMusicStarted)
		{
			gameMusicStarted = true;
			player.stop();
			titleMusicStarted = false;
			musicLoopTimer = System.currentTimeMillis();
			player2.play();
		}
		
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
		
		if (System.currentTimeMillis() > musicLoopTimer + 9500)
		{
			//player2.playerInitialize();
			player2 = new SoundEffectPlayer("sound/music2mono.wav");
			player2.play();
			musicLoopTimer = System.currentTimeMillis();
		}
		

	}
	
	void drawGameOverMessage(Graphics dbg)
	{
		try {
			bkg = ImageIO.read( new File("images/E_background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbg.drawImage(bkg, 0, 0, null);
			try {
				if (state.winner == "Player 1")
					goBgd = ImageIO.read(new File("images/txt_green_snake_wins.png"));
				else if(state.winner == "Player 2")
					goBgd = ImageIO.read(new File("images/txt_red_snake_wins.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		dbg.drawImage(goBgd, 0, 75, null);
// ----------------------------------GOVER Music to be completed-------------------------------------------------------------
		if (gameMusicStarted || System.currentTimeMillis() > musicLoopTimer + 10860)
		{
			player2.stop();
			gameMusicStarted = false;
			player = new SoundEffectPlayer("sound/music01mono.wav");
			player.play(); // Need to change to Player3
			musicLoopTimer = System.currentTimeMillis();
		}
// ----------------------------------GOVERMusic-------------------------------------------------------------
	}

	private GameState state;
	private Font font;
	private FontMetrics metrics;
	private JPanel panel;
}
