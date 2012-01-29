package twosnakes;

import java.lang.Math;
import java.util.List;

public class SnakeCollision implements Event{

	private P1Snake s1, s2;
	private double collide_distance;
//	private GameState state;

	public SnakeCollision(GameState state){
//		this.state = state;
		collide_distance = 25.0;
//		this.s1 = state.snake1;
//		this.s2 = state.snake2;
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

	}

	public boolean s1_eat_s2(P1Snake s1, P1Snake s2){
		boolean status1 = false;
		if(s1 != null && s2 != null){
			double s1_x = s1.head.rPiv.x;
			double s1_y = s1.head.rPiv.y;
			double distance;
			/*
			for(int i = 0; i < s2.getBodyLeng(); i++){
				double s2_body_x = s2.bodyList.get(i).rPiv.x;
				double s2_body_y = s2.bodyList.get(i).rPiv.y;

				distance = Math.sqrt((s2_body_x - s1_x)*(s2_body_x - s1_x) 
						+ (s2_body_y - s1_y)*(s2_body_y - s1_y) );
				if(distance <= collide_distance){
					s1.addSegments(1);
					s2.removeSegments(1);
					col_status = true;
					return col_status;
				}
			}
			*/
			double s2_tail_x = ( s2.tail.lPiv.x + s2.tail.rPiv.x)/2.0;
			double s2_tail_y = (s2.tail.lPiv.y + s2.tail.rPiv.y)/2.0;
			distance = Math.sqrt((s2_tail_x - s1_x)*(s2_tail_x - s1_x) + (s2_tail_y - s1_y)*(s2_tail_y - s1_y));
			if( s2.bodyList.size() < 1)
				distance = 10000.0;
			if(distance <= collide_distance){
				if(s1.bodyList.size() >= 1 && s2.bodyList.size() >= 1){
					s1.change_head();
					s1.addSegments(1);
					s2.removeSegments(1);
					s1.set_speed(s1.get_speed()*0.9);
					s2.set_speed(s2.get_speed()*1.11);
					
				}
				status1 = true;
			}
		}
		return status1;
	}

	public boolean s2_eat_s1(P1Snake s1, P1Snake s2){
		double s2_x = s2.head.rPiv.x;
		double s2_y = s2.head.rPiv.y;
		double distance;
		boolean status2 = false;
		/*
		for(int i = 0; i < s1.getBodyLeng(); i++){
			double s1_body_x = s1.bodyList.get(i).rPiv.x;
			double s1_body_y = s1.bodyList.get(i).rPiv.y;

			distance = Math.sqrt((s1_body_x - s2_x)*(s1_body_x - s2_x) 
					+ (s1_body_y - s2_y)*(s1_body_y - s2_y) );
			if(distance <= collide_distance){
				s2.addSegments(1);
				s1.removeSegments(1);
				col_status = true;
			}
		}
		 */

		double s1_tail_x = s1.tail.lPiv.x;
		double s1_tail_y = s1.tail.lPiv.y;
		distance = Math.sqrt((s1_tail_x - s2_x)*(s1_tail_x - s2_x) + (s1_tail_y - s2_y)*(s1_tail_y - s2_y));
		if(s1.bodyList.size() < 1)
			distance = 10000.0;
		
		if(distance <= collide_distance){
			if(s1.bodyList.size() >= 1 && s2.bodyList.size() >= 1){
				s2.change_head();
				s2.addSegments(1);
				s1.removeSegments(1);
				s2.set_speed(s2.get_speed()*0.9);
				s1.set_speed(s1.get_speed()*1.11);
			}
			
			status2 = true;
		}
		return status2;
	}

	@Override
	public boolean isCollide(P1Snake s, List<Item> objects, List<Item> removings) {
		// TODO Auto-generated method stub
		return false;
	}


}
