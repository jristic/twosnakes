package twosnakes;

public class P1Snake implements Snake 
{
	class Head
	{
		private double headPicWidth = 0;
		private double headPicLeng = 0;
		private Vector rHeadPiv = new Vector();
		public Vector lHeadPiv = new Vector();
	}
	
	class Body
	{
		private double bodyPicWidth= 0;
	    private double bodyPicLeng= 0;
		private Vector bodyPiv = new Vector(); 
	}
	
	class Tail
	{
		// Init width and length with the picture size
		private Vector lTailPiv = new Vector();
		private Vector rTailPiv = new Vector();
		private final double tailPicWidth = 0;
		private final double tailPicLeng = 0;
	}
	
	private double speed = 0;
	
	public P1Snake(Vector head, Vector facing)
	{
		
	}
	@Override
	/**
	 * 
	 * @param distance
	 * @param left_or_right
	 */
	public void move(double distance, Vector direction) 
	{
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
	
	@Override
	public void set_speed() {
		this.speed = speed;
	}

}
