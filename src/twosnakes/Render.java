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
	BufferedImage line1, line2, line3;
	BufferedImage goBgd = null;
	
	double musicLoopTimer;
	boolean titleMusicStarted;
	boolean introStarted;
	long introStartTime;
	boolean sound1Played, sound2Played, sound3Played;
	
	SoundEffectPlayer player;
	SoundEffectPlayer player2, player3;
	
	public Render(GameState state, JPanel panel)
	{
		this.panel = panel;
		this.state = state;
		// set up message font
		font = new Font("SansSerif", Font.BOLD, 24);
		metrics = panel.getFontMetrics(font);
		introStarted = false;
		try 
		{
			bkg = ImageIO.read( new File("images/G_background.png") );
			line1 = ImageIO.read( new File("images/txt_two_snakes_enter.png") );
			line2 = ImageIO.read( new File("images/txt_one_snake_leaves.png") );
			line3 = ImageIO.read( new File("images/txt_eat_some_tail.png") );
		}
		catch (IOException e)
		{}
		titleMusicStarted = false;
		sound1Played = sound2Played = sound3Played = false;
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
	
	void drawIntroMessage(Graphics dbg, MainPanel mainPanel)
	{
		dbg.drawImage(bkg, 0, 0, null);
		if (!introStarted)
		{
			introStarted = true;
			introStartTime = System.currentTimeMillis();
		}
		
		if (System.currentTimeMillis() - introStartTime > 1500)
		{
			dbg.drawImage(line1, 640 - line1.getWidth()/2, 100, null);
			if (!sound1Played)
			{
				player.stop();
				player2.stop();
				player3 = new SoundEffectPlayer("sound/Snake_Countdown.wav");
				player3.play();
				sound1Played = true;
			}
		}
		if (System.currentTimeMillis() - introStartTime > 3000)
		{
			dbg.drawImage(line2, 640 - line2.getWidth()/2, 300, null);
			if (!sound2Played)
			{
				player3 = new SoundEffectPlayer("sound/Snake_Countdown.wav");
				player3.play();
				sound2Played = true;
			}
		}
		if (System.currentTimeMillis() - introStartTime > 4500)
		{
			dbg.drawImage(line3, 640 - line3.getWidth()/2, 500, null);
			if (!sound3Played)
			{
				player3 = new SoundEffectPlayer("sound/Snake_Go.wav");
				player3.play();
				sound3Played = true;
			}
		}
		if (System.currentTimeMillis() - introStartTime > 6000)
		{
			mainPanel.gameStarted = true;
			mainPanel.lastUpdateTime = System.currentTimeMillis();
			// Setup game elements
			mainPanel.setup.gameSetup();
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
//		dbg.setColor(Color.white);
//		dbg.fillRect(0, 0, panel.getWidth(), panel.getHeight());
//		String msg = "GAME OVER! Winner is: " + state.winner;
//		int x = 50;
//		int y = 100;
//		dbg.setColor(Color.white);
//		dbg.setFont(font);
//		dbg.drawString(msg, x, y);
	}
	

	void drawGame(Graphics dbg)
	{
		
		if (titleMusicStarted)
		{
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

	private GameState state;
	private Font font;
	private FontMetrics metrics;
	private JPanel panel;
}
