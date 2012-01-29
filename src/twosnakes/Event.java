package twosnakes;

public interface Event {
	public void playSound();
	public void animation();
	public void updateSnake(Snake s, double timePassed);
	public boolean isCollide(P1Snake s);
}