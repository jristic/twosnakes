package twosnakes;

public class Collision implements Event{

	Sound collision = new SoundPlayer(" ");
	@Override
	public void playSound() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void animation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSnake(Snake s, double timePassed) {
		// TODO Auto-generated method stub
		s.move(timePassed);
	}
	
}
