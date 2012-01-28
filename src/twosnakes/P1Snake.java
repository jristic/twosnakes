package twosnakes;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class P1Snake implements Snake 
{
	class Head
	{
		private Vector rPiv;
		public Vector lPiv;
	}
	
	class Body
	{
		private Vector rPiv;
		private Vector lPiv;
	}
	
	class Tail
	{
		private Vector rPiv;
		private Vector lPiv;
	}
	
	private double speed = 0;
	private Vector direction;
	private int girth;
	private Vector headSize, bodySize, tailSize;
	private Head head;
	private List<Body> body;
	private Tail tail;
	
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
