package twosnakes;

public class Apple implements Item {
	
	private double value;
	private double[] position;
	private boolean visible;
	Sound s = new SoundPlayer(filename); //TODO filename must be substituted for proper audio filename
	
	public Apple(double val, double x, double y){
		value = val;
		position[0] = x;
		position[1] = y;
		visible = true;
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
	public void collision() {
		strike();
		sound();
		visible = false;
	}

	@Override
	public void strike() {
		
	}

	@Override
	public void sound() {
		s.playSound();
	}

}
