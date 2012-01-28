package twosnakes;

public interface Item {
	public void setPosition(double newX, double newY);
	public void setValue(double newVal);
	public double[] getPosition();
	public double getValue();
	public void collision();
	public void strike();
	public void sound();
}
