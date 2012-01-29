package twosnakes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class P1Snake implements Snake 
{
	static final float pixelsPerMs = 0.03f;
	static final float maxUpdateLength = 30;
	
	class Head
	{
		public Vector rPiv;
		public Vector lPiv;
	}
	
	class Body
	{
		public Vector rPiv;
		private Vector lPiv;
	}
	
	class Tail
	{
		public Vector rPiv;
		public Vector lPiv;
	}
	
	private double speed;
	private Vector direction;
	private int girth;
	public Vector headSize, bodySize, tailSize;
	public Head head;
	public ArrayList<Body> bodyList;
	public Tail tail;
	
	public P1Snake(Vector headPos, Vector facing, Vector headSize, Vector bodySize, Vector tailSize)
	{
		this.headSize = headSize;
		this.bodySize = bodySize;
		this.tailSize = tailSize;
		head = new Head();
		head.rPiv = new Vector(headPos);
		facing.normalize();
		direction = new Vector(facing);
		Vector back = new Vector(facing.x * -1, facing.y * -1);
		head.lPiv = new Vector(headPos, back.x * headSize.x, back.y * headSize.y);
		Body segment = new Body();
		segment.rPiv = new Vector(head.lPiv);
		segment.lPiv = new Vector(segment.rPiv, back.x * bodySize.x, back.y * bodySize.y);
		bodyList = new ArrayList<Body>();
		bodyList.add(0, segment);
		tail = new Tail();
		tail.rPiv = new Vector(segment.lPiv);
		tail.lPiv = new Vector(tail.rPiv, back.x * tailSize.x, back.y * tailSize.y);
		this.speed = 1;
	}

	@Override
	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform transform = new AffineTransform();
		BufferedImage img = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
		Vector right = new Vector(1,0);
		
		// Draw head
		try
		{
			img = ImageIO.read( new File("images/s01_head_closed.png") );
		}
		catch (Exception e)
		{
		}
		transform.translate(head.lPiv.x, head.lPiv.y - headSize.y/2);
		Vector dir = new Vector(head.rPiv.x - head.lPiv.x, head.rPiv.y - head.lPiv.y);
		dir.normalize();
		double value = Math.atan2(dir.x, dir.y);
		transform.rotate(-(value - Math.PI/2), 0, headSize.y/2);
		g2d.drawImage(img, transform, null);
		
		// Draw body
		try
		{
			img = ImageIO.read( new File("images/s1_body.png") );
		}
		catch (Exception e)
		{
		}
		for (Body body : bodyList)
		{
			transform = new AffineTransform();
			transform.translate((body.rPiv.x + body.lPiv.x)/2, (body.rPiv.y+body.lPiv.y)/2);
			g2d.drawImage(img, transform, null);
		}
		
		// Draw tail
		transform = new AffineTransform();
		try
		{
			img = ImageIO.read( new File("images/s01_tail.png") );
		}
		catch (Exception e)
		{
		}
		transform.translate((tail.rPiv.x + tail.lPiv.x)/2, (tail.rPiv.y+tail.lPiv.y)/2);
		g2d.drawImage(img, transform, null);
	}
	
	@Override
	public void move(double timePassed) 
	{
		if (timePassed > maxUpdateLength)
			timePassed = maxUpdateLength;
		// Move the head forward.
		Vector prevRLoc = new Vector(head.rPiv);
		Vector prevLLoc = new Vector(head.lPiv);
		head.rPiv.translate(direction.x * speed * timePassed * pixelsPerMs, direction.y * speed * timePassed * pixelsPerMs);
		head.lPiv.translate(direction.x * speed * timePassed * pixelsPerMs, direction.y * speed * timePassed * pixelsPerMs);
		for (Body body : bodyList)
		{
			Vector prevBodyRLoc = body.rPiv.copy();
			Body currBody = bodyList.get(i);
			double temp = currBody.rPiv.x;
			// This is for the right pivot
			currBody.rPiv.x = nextRSpotX;
			nextRSpotX = temp;
			temp = currBody.rPiv.y;
			currBody.rPiv.y = nextRSpotY;
			nextRSpotY = temp;
			// this is for the left pivot
			currBody.lPiv.x = nextLSpotX;
			nextLSpotX = temp;
			temp = currBody.lPiv.y;
			currBody.lPiv.y = nextLSpotY;
			nextLSpotY = temp;
		}
		Vector moved = new Vector(prevLLoc.x -  tail.rPiv.x, prevLLoc.y - tail.rPiv.y);
		tail.rPiv.x = nextRSpotX;
		tail.rPiv.y = nextRSpotY;
		tail.lPiv.x = nextLSpotX;
		tail.lPiv.y = nextLSpotY;
		
	}
	
	@Override
	public void setDirection(Vector direction)
	{
		this.direction = new Vector(direction);
		direction.normalize();
		// Update the head based on the new direction
		head.rPiv = new Vector(head.lPiv, direction.x * headSize.x, direction.y * headSize.y);
	}

	@Override
	public Vector getDirection()
	{
		return direction;
	}

	@Override
	public int getGirth()
	{
		return girth;
	}

	@Override
	public void setGirth(int girth)
	{
		this.girth = girth;
	}
	
	@Override
	public int getLength()
	{
		return bodyList.size();
	}
	
	@Override
	public void addSegments(int num)
	{
		Body newSeg = new Body();
		newSeg.rPiv = new Vector(tail.rPiv);
		newSeg.lPiv = new Vector();
		double tailVecX = tail.lPiv.x - tail.rPiv.x;
		double tailVecY = tail.lPiv.y - tail.rPiv.y;
		newSeg.lPiv.x = newSeg.rPiv.x + ((tailVecX) * (bodySize.x/tailSize.x));
		newSeg.lPiv.y = newSeg.rPiv.y + ((tailVecY) * (bodySize.y/tailSize.y));
		tail.rPiv = newSeg.lPiv;
		tail.lPiv.x = tail.rPiv.x - (newSeg.rPiv.x-newSeg.lPiv.x) ;
		tail.lPiv.y = tail.rPiv.y + (newSeg.rPiv.y-newSeg.lPiv.y);
		bodyList.add(newSeg);
	}
	@Override
	public void removeSegments(int num)
	{
		int secondLastInd = bodyList.size()-3; 
		Body secondLast = bodyList.get(secondLastInd);
		int lastSegInd = bodyList.size()-2; 
		Body lastSeg = bodyList.get(lastSegInd);
		lastSeg.rPiv = new Vector(secondLast.lPiv);
		lastSeg.lPiv = new Vector(tail.lPiv);
		
		bodyList.remove(bodyList.size()-1);
	}
	
	// for debug
	@Override
	public int getBodyLeng(){
		return this.bodyList.size();
	}
	
	@Override
	public void set_speed(double speed) {
		this.speed = speed;
	}

	@Override
	public double get_speed() {
		return this.speed;
	}
	
	private Vector vectorLerp(float weight, Vector vec1, Vector vec2)
	{
		return new Vector( weight*vec1.x + (1-weight)*vec2.x, weight*vec1.y + (1-weight)*vec2.y);
	}
}
