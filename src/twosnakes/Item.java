package twosnakes;

import java.awt.Graphics;

public interface Item {
	public void setPosition(double newX, double newY);
	public void setValue(double newVal);
	public double[] getPosition();
	public double getValue();
	public void eaten();
	public void draw(Graphics g);
}
