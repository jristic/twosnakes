package twosnakes;

public class Mouse implements Item {

	private double value;
	private double[] position;
	
	public Mouse(double val, double x, double y){
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
		// TODO Auto-generated method stub
		return this.position;
	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

}
