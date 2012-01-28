package twosnakes;

import java.awt.Graphics;

public interface Snake {
	
	/**
	 * 
	 * @param distance 
	 * @param left_or_right left == false, right == false
	 */
	public void move(double timePassed);
	public void draw(Graphics g);
	public Vector getDirection();
	public void setDirection(Vector direction);
	public int getGirth();
	public void setGirth(int girth);
	public int getLength();
	public void addSegments(int num);
	
	public void set_speed(double speed);
	public double get_speed();
}
