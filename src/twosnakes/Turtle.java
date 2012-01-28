package twosnakes;

public class Turtle implements Item {
	
	private double value;
	private double[] position;

	public Turtle(double val, double x, double y){
		value = val;
		position[0] = x;
		position[1] = y;
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

}
