package twosnakes;

public interface Event {
	public void playSound(Sound s);
	public void animation(Animation a);
	public void updateSnake(Snake s);
}