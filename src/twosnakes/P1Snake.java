package twosnakes;

import java.awt.event.KeyEvent;

public class P1Snake implements Snake{

	class Head{
		
	}
	class Body{
		
	}
	class Tail{
		
	}
	
	private double[] pivit;
	private double speed = 0.0;
	private final double move_per_click;
	private int num_clicks;
	private double[] vector; //this keeps track of the current angle that picit is moving to.
	
	public P1Snake(){
		move_per_click = 1.0;
		
		vector = new double[1];
		vector[0] = 0.0;
		vector[1] = 1.0;
		
	}
	@Override
	/**
	 * 
	 * @param distance
	 * @param left_or_right
	 */
	public void move(int distance, boolean left_or_right) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void get_longer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void get_shorter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void get_fat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void get_skinny() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param speed this overloads the set_speed from the interface
	 */
	public void set_speed(double speed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double get_speed() {
		// TODO Auto-generated method stub
		return this.speed;
	}
	
	public int get_click(KeyEvent ka){
		return this.num_clicks;
	}
	@Override
	public void set_speed() {
		
		
	}

}
