package twosnakes;

public interface Snake {
	
	/**
	 * 
	 * @param distance 
	 * @param left_or_right left == false, right == false
	 */
	public void move(int distance, boolean left_or_right);
	public void get_longer();
	public void get_shorter();
	public void get_fat();
	public void get_skinny();
	
	public void set_speed();
	public double get_speed();
}
