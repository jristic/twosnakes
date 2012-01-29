/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosnakes;

import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author jovan
 */
public class Render
{
	public Render(GameState state, JPanel panel)
	{
		this.panel = panel;
		this.state = state;
		// set up message font
		font = new Font("SansSerif", Font.BOLD, 24);
		metrics = panel.getFontMetrics(font);
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
		dbg.setColor(Color.white);
		dbg.fillRect(0, 0, panel.getWidth(), panel.getHeight());
		String msg = "TWO SNAKES ENTER ONE SNAKE LEAVES!";
		int x = 50;
		int y = 100;
		dbg.setColor(Color.red);
		dbg.setFont(font);
		dbg.drawString(msg, x, y);
	}

	void drawGameOverMessage(Graphics dbg)
	{
		throw new UnsupportedOperationException("Not yet implemented");
	}

	void drawGame(Graphics dbg)
	{
		dbg.setColor(Color.black);
		dbg.fillRect(0, 0, panel.getWidth(), panel.getHeight());
		state.snake1.draw(dbg);
	}
	
	private GameState state;
	private Font font;
	private FontMetrics metrics;
	private JPanel panel;
}
