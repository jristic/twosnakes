package twosnakes;

import java.util.Random;
import java.lang.Math;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Mouse implements Item {
	
	static final float pixelsPerMs = 0.10f;
	
	private double value;
	private double[] position;
	private double speed;
	private final double acceleration = 1.1;
	private boolean visible;
	Vector target;
	boolean walking;
	long timeToNextWalk;
	Random r = new Random();

	public Mouse(double val, double x, double y){
		value = val;
		position = new double[2];
		position[0] = x;
		position[1] = y;
		speed = 1;
		visible = true;
		timeToNextWalk = r.nextInt(2000);
		walking = false;
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
		speed = newSpeed;
	}
	
	public double getSpeed(){
		return speed;
	}

	/**
	 * put this in loop to keep accelerate.
	 */
	public void accelerate(){
		speed *= acceleration;
	}
	
	public void setDirection(){
		int x = r.nextInt() % 2;
		int y = r.nextInt() % 2;
	}
	
	/**
	 * put this in loop to keep it moving and speeding.
	 */
	public void move(){
	}

	@Override
	public void eaten() {
		Event eating = new Eating();
		eating.playSound();
		eating.animation();
		visible = false;
	}

	@Override
	public void update(long gameTime)
	{
		if (walking)
		{
			Vector toDir = new Vector(target.x - position[0], target.y - position[0]);
		}
		else
		{
			if (timeToNextWalk > 0)
			{
				timeToNextWalk -= gameTime;
			}
			else
			{
				walking = true;
				target = new Vector(r.nextInt(1000)+50, r.nextInt(650)+10);
			}
		}
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
