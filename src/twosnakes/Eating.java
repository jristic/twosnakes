package twosnakes;

public class Eating implements Event{

	Sound eaten_sound = new SoundPlayer(" "); //audio file name need to be inserted.
	@Override
	public void playSound() {
		eaten_sound.playSound();
	}

	@Override
	public void animation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSnake(Snake s, double passedTime) {
		// TODO Auto-generated method stub
		s.move(passedTime);
	}

}
