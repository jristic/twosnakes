package twosnakes;

import java.util.Random;
import java.awt.Graphics;
import java.lang.Math;

public class Turtle implements Item {
	
	private double value;
	private double[] position;
	private double speed = 1.0;
	private double[] direction;
	private double acceleration = 1.0;
	private boolean visible;
	Random r = new Random();

	public Turtle(double val, double x, double y){
		value = val;
		position[0] = x;
		position[1] = y;
		visible = true;
		direction = new double[2];
		
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
	public void setSpeed(double newSpeed){
		speed = Math.hypot(direction[0], direction[1]);
	}
	
	public double getSpeed(){
		return speed;
	}

	public void accelerate(){
		speed *= acceleration;
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
	
	public void move(){
		position[0] += direction[0];
		position[1] += direction[1];
	}
	@Override
	public void eaten() {
		// TODO Auto-generated method stub
		Eating e = new Eating();
		e.playSound();
		e.animation();
		visible = false;
	}
	
	@Override
	public void update(long gameTime)
	{
		
	}
		
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
