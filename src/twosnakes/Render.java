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
		throw new UnsupportedOperationException("Not yet implemented");
	}

	void drawGameOverMessage(Graphics dbg)
	{
		throw new UnsupportedOperationException("Not yet implemented");
	}

	void drawGame(Graphics dbg)
	{
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	private Font font;
	private FontMetrics metrics;
	private JPanel panel;
}
