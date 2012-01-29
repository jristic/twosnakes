package twosnakes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Turtle implements Item {
	
	static final float pixelsPerMs = 0.05f;
	
	private double value;
	private double[] position;
	private double speed;
	Vector target;
	boolean walking;
	long timeToNextWalk;
	BufferedImage image;
	Animator anim;
	Random r = new Random();
	SoundPlayer player;

	public Turtle(double val, double x, double y){
		value = val;
		position = new double[2];
		position[0] = x;
		position[1] = y;
		speed = 1;

		timeToNextWalk = r.nextInt(2000);
		walking = false;
		anim = new Animator();
		anim.startAnimation("images/turtle.png", 10, 3, false);
		player = new SoundPlayer("sound/Turtle Eaten.mp3");
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
	}
	
	public void setDirection(){
	}
	
	/**
	 * put this in loop to keep it moving and speeding.
	 */
	public void move(){
	}

	@Override
	public void eaten() {
//		Event eating = new Eating();
//		eating.playSound();
//		eating.animation();
		player.playerInitialize();
		player.play();
	}

	@Override
	public void update(long gameTime)
	{
		if (walking)
		{
			Vector toDir = new Vector(target.x - position[0], target.y - position[1]);
			toDir.normalize();
			position[0] += toDir.x * speed * pixelsPerMs * gameTime;
			position[1] += toDir.y * speed * pixelsPerMs * gameTime;
			if (toDir.x >= 0 && target.x - position[0] <= 0)
			{
				walking = false;
				timeToNextWalk = r.nextInt(2000);
			}
			else if (toDir.x < 0 && target.x - position[0] > 0)
			{
				walking = false;
				timeToNextWalk = r.nextInt(2000);
			}
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
	public void draw(Graphics g) 
	{
		Graphics2D g2d = (Graphics2D)g;
		image = anim.getFrame(0);
		g2d.drawImage(image, (int)position[0] - image.getWidth()/2, (int)position[1] - image.getHeight()/2, null);
	}
}
