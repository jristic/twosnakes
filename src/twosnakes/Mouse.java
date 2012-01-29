package twosnakes;

import java.util.Random;
import java.lang.Math;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Mouse implements Item {

	private double value;
	private double[] position;
	private double speed;
	private final double acceleration = 1.1;
	private double[] direction;
	private boolean visible;
	Random r = new Random();

	public Mouse(double val, double x, double y){
		value = val;
		position[0] = x;
		position[1] = y;
		speed = 0.0;
		direction = new double[2];
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
		// TODO Auto-generated method stub
		return this.position;
	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}
	
	public void setSpeed(double newSpeed){
		speed = Math.hypot(direction[0], direction[1]);
	}
	
	public double getSpeed(){
		return speed;
	}

	/**
	 * put this in loop to keep accelerate.
	 */
	public void accelerate(){
		speed *= acceleration;
		direction[0] *= acceleration;
		direction[1] *= acceleration;
	}
	
	public void setDirection(){
		int x = r.nextInt() % 2;
		int y = r.nextInt() % 2;
		
		direction[0] = r.nextDouble();
		direction[1] = r.nextDouble();
		
		//change the direction if the value of x is negative
		if(x == 1)
			direction[0] *= -1;
		if(y == 1)
			direction[1] *= -1;
	}
	
	/**
	 * put this in loop to keep it moving and speeding.
	 */
	public void move(){
		position[0] += direction[0];
		position[1] += direction[1];
	}

	@Override
	public void eaten() {
		Event eating = new Eating();
		eating.playSound();
		eating.animation();
		visible = false;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
