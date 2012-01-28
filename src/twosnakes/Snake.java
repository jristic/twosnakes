package twosnakes;

public interface Snake {
	
	/**
	 * 
	 * @param distance 
	 * @param left_or_right left == false, right == false
	 */
	public void move(double distance, Vector direction);
	public void get_longer();
	public void get_shorter();
	public void get_fat();
	public void get_skinny();
}
