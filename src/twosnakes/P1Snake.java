package twosnakes;

import java.awt.event.KeyEvent;

public class P1Snake implements Snake{
	
	

	class Head{
		private double headPicWidth = -10;
		private double headPicLeng = -10;
		private double[] rHeadPiv = new double [2];
		public double[] lHeadPiv = new double [2];
	}
	class Body{
		private double bodyPicWidth= -10;
	    private double bodyPicLeng= -10;
		private double[] bodyPiv = new double [2]; 
	}
	class Tail{
		// Init width and length with the picture size
		private double[] tailPiv = new double [2];
		private final double tailPicWidth = -10;
		private final double tailPicLeng = -10;
		
		public Tail(){
			tailPiv[0] = 0; //
			tailPiv[1] = 0.5*tailPicLeng;
		}
		
		
	}
	
	private double[] pivit;
	private double speed = 0.0;
	private final double move_per_click;
	private int num_clicks;
	private double[] vector; //this keeps track of the current angle that pivit is moving to.
	
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
		this.speed = speed;
	}

	@Override
	public double get_speed() {
		return this.speed;
	}
	
	public int get_click(KeyEvent ka){
		return this.num_clicks;
	}
	@Override
	public void set_speed() {
		
	}

}
