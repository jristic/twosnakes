package twosnakes;

import java.util.ArrayList;
import java.util.List;

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

	public boolean isCollide(P1Snake s, List<Item> objects, List<Item> removings){
		Vector s_vector = s.head.rPiv;
		double x1 = s_vector.x;
		double y1 = s_vector.y;
		col_status = false;

		for(int i =0; i <objects.size(); i++){
			Item item = objects.get(i);
			double x2 = item.getPosition()[0];
			double y2 = item.getPosition()[1];
			double distance = Math.sqrt((x2-x1)*(x2-x1) + (y2 - y1)*(y2 - y1));
			
			if(item.getClass() == Apple.class){
				collision_distance = 30.0;
				
				if(distance <= collision_distance){
					objects.get(i).eaten();
					if(s.bodyList.size() > 0){
						s.addSegments(1);
						s.change_head();
					}
					s.set_speed(s.get_speed()*0.9);
					col_status = true;
					//state.objects.remove(i);
					removings.add(objects.get(i));
				}
			}
			else if(item.getClass() == Turtle.class){
				collision_distance = 30.0;
				
				if(distance <= collision_distance){
					objects.get(i).eaten();
					s.change_head();
					s.set_speed(s.get_speed()*0.75);
					col_status = true;
					//state.objects.remove(i);
					removings.add(objects.get(i));
				}
			}
			else if(item.getClass() == Mouse.class){
				collision_distance = 30.0;
				
				if(distance <= collision_distance){
					objects.get(i).eaten();
					s.change_head();
					s.set_speed(s.get_speed()*1.333);
					col_status = true;
					//state.objects.remove(i);
					removings.add(objects.get(i));
				}
			}
			else{
				collision_distance = 0.0;
			}
		}
		return col_status;
	}

	public static boolean isOutOfBoundX(P1Snake snake1)
	{
		boolean result = false;
		Vector s_vector = snake1.head.rPiv;
		double x1 = s_vector.x;
		if (x1>=1300||x1<=-20)
			result = true;
		return result;
	}

	public static boolean isOutOfBoundY(P1Snake s)
	{
		boolean result = false;
		Vector s_vector = s.head.rPiv;
		double y1 = s_vector.y;
		if(y1>=740||y1<=-20)
			result = true;
		return result;
	}

	@Override
	public boolean s1_eat_s2(P1Snake s1, P1Snake s2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean s2_eat_s1(P1Snake s1, P1Snake s2) {
		// TODO Auto-generated method stub
		return false;
	}
}
