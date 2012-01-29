package twosnakes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements WindowListener
{

	private static int DEFAULT_FPS = 80;
	public static MainPanel bp; // where the game is drawn

	public Main(int period)
	{
		super("Two Snakes");
		makeGUI(period);
		addWindowListener(this);
		pack();
		setResizable(false);
		setVisible(true);
	}

	private void makeGUI(int period)
	{
		Container c = getContentPane();    // default BorderLayout used
		bp = new MainPanel(this, period);
		c.add(bp, "Center");
	}

	// ----------------- window listener methods -------------
	public void windowActivated(WindowEvent e)
	{
		bp.resumeGame();
	}

	public void windowDeactivated(WindowEvent e)
	{
		bp.pauseGame();
	}

	public void windowDeiconified(WindowEvent e)
	{
		bp.resumeGame();
	}

	public void windowIconified(WindowEvent e)
	{
		bp.pauseGame();
	}

	public void windowClosing(WindowEvent e)
	{
		bp.stopGame();
	}

	public void windowClosed(WindowEvent e)
	{
	}

	public void windowOpened(WindowEvent e)
	{
	}

	// ----------------------------------------------------
	public static void main(String args[])
	{
		int fps = DEFAULT_FPS;
		if (args.length != 0)
		{
			fps = Integer.parseInt(args[0]);
		}

		int period = (int) 1000.0 / fps;
		System.out.println("fps: " + fps + "; period: " + period + " ms");

		new Main(period);    // ms
	}
}
