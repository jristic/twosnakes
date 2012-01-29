package twosnakes;

public class Collision implements Event{

	private double collision_distance;
//	Sound collision = new SoundPlayer(" ");
	private GameState state;
	private boolean col_status;
	
	public Collision(GameState state){
		collision_distance = 5.0;
		this.state = state;
		col_status = false;
	}
	
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
	
	public boolean isCollide(P1Snake s){
		Vector s_vector = s.head.rPiv;
		double x1 = s_vector.x;
		double y1 = s_vector.y;
		
		for(int i =0; i <state.objects.size(); i++){
			Item item = state.objects.get(i);
			double x2 = item.getPosition()[0];
			double y2 = item.getPosition()[1];
			double distance = Math.sqrt((x2-x1)*(x2-x1) + (y2 - y1)*(y2 - y1));
			if(item.getClass() == Apple.class){
				collision_distance = 30.0;
			}
			else if(item.getClass() == Turtle.class){
				collision_distance = 3.0;
			}
			else if(item.getClass() == Mouse.class){
				collision_distance = 2.0;
			}
			else{
				collision_distance = 0.0;
			}
			
			if(distance <= collision_distance){
				state.objects.remove(i);
				s.addSegments(1);
				col_status = true;
			}
		}
		return col_status;
	}
	
	public static boolean isOutOfBoundX(P1Snake snake1)
	    {
		boolean result = false;
		Vector s_vector = snake1.head.rPiv;
		double x1 = s_vector.x;
		if (x1>=1280||x1<=0)
			result = true;
		return result;
		}
	
	public static boolean isOutOfBoundY(P1Snake s)
    {
	boolean result = false;
	Vector s_vector = s.head.rPiv;
	double y1 = s_vector.y;
	if(y1>=720||y1<=0)
		result = true;
	return result;
	}
}
