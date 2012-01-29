package twosnakes;

public interface Event {
	public void playSound();
	public void animation();
	public void updateSnake(Snake s, double timePassed);
	public boolean isCollide(P1Snake s);
	public boolean s1_eat_s2();
	public boolean s2_eat_s1();
}