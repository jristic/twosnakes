/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosnakes;

/**
 *
 * @author jovan
 */
public class Vector
{
	public Vector()
	{
		this.x = this.y = 0;
	}
	
	public Vector(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector(Vector toCopy)
	{
		this.x = toCopy.x;
		this.y = toCopy.y;
	}
	
	public Vector(Vector vec, double xoffset, double yoffset)
	{
		this.x = vec.x + xoffset;
		this.y = vec.y + yoffset;
	}
	
	public void normalize()
	{
		double length = Math.sqrt(x*x + y*y);
		x /= length;
		y /= length;
	}
	
	public double dot(Vector vec)
	{
		return this.x * vec.x + this.y * vec.y;
	}
	
	
	public double x, y;
}
