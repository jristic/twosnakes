package twosnakes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class P1Snake implements Snake 
{
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
	public List<Body> body;
	public Tail tail;
	
	public P1Snake(Vector headPos, Vector facing, Vector headSize, Vector bodySize, Vector tailSize)
	{
		this.headSize = headSize;
		this.bodySize = bodySize;
		this.tailSize = tailSize;
		head = new Head();
		head.rPiv = new Vector(headPos);
		facing.normalize();
		head.lPiv = new Vector(headPos, facing.x * headSize.x, facing.y * headSize.y);
		Body segment = new Body();
		segment.rPiv = new Vector(head.lPiv);
		segment.lPiv = new Vector(segment.rPiv, facing.x * bodySize.x, facing.y * bodySize.y);
		body = new ArrayList<Body>();
		body.add(0, segment);
		tail = new Tail();
		tail.rPiv = new Vector(segment.lPiv);
		tail.lPiv = new Vector(tail.rPiv, facing.x * tailSize.x, facing.y * tailSize.y);
		this.speed = 1;
	}

	@Override
	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform transform = new AffineTransform();
		// Draw head
		BufferedImage img = new BufferedImage((int)headSize.x, (int)headSize.y, BufferedImage.TYPE_INT_ARGB);
		transform.translate((head.rPiv.x + head.lPiv.x)/2, (head.rPiv.y+head.lPiv.y)/2);
		g2d.drawImage(img, transform, null);
	}
	
	@Override
	public void move(double timePassed) 
	{
		// Code to move all the segments here
	}
	
	@Override
	public void setDirection(Vector direction)
	{
		this.direction = direction;
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
		return body.size();
	}
	
	@Override
	public void addSegments(int num)
	{
		
	}
	
	@Override
	public void set_speed(double speed) {
		this.speed = speed;
	}

	@Override
	public double get_speed() {
		return this.speed;
	}
}
