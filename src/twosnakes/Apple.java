package twosnakes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Koh
 *
 */
public class Apple implements Item {
	
	private double value;
	private double[] position;
	private int visible;
	
	public Apple(double val, double x, double y){
		value = val;
		position = new double[2];
		position[0] = x;
		position[1] = y;
		visible = 0; //0:regular apple. 1:eaten apple
	}

	@Override
	public void setPosition(double newX, double newY) {
		position[0] = newX;
		position[1] = newY;
	}

	@Override
	public void setValue(double newVal) {
		value = newVal;
	}

	@Override
	public double[] getPosition() {
		return this.position;
	}

	@Override
	public double getValue() {
		return this.value;

	}

	@Override
	/**
	 * delete the item when collision happens.
	 */
	public void eaten() {
		Event e = new Eating();
		e.playSound();
		e.animation();
		visible = 1;
	}

	@Override
	public void draw(Graphics g) {
		//Graphics2D g2d = (Graphics2D)g;
		//AffineTransform transform = new AffineTransform();
		BufferedImage img = new BufferedImage(5, 5, BufferedImage.TYPE_INT_ARGB);
		Animator an = new Animator();
		an.startAnimation("images/apple.png", 0, 2, false);
		try {
			img = ImageIO.read( new File("images/apple.png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(an.getFrame(visible), (int)position[0], (int)position[1], null);
	}

}
