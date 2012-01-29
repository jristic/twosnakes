package twosnakes;

import java.lang.Math;

public class SnakeCollision implements Event{

	private boolean col_status;
	private P1Snake s1, s2;
	private double collide_distance;
	private GameState state;
	
	public SnakeCollision(GameState state){
		this.state = state;
		col_status = false;
		collide_distance = 50.0;
		this.s1 = state.snake1;
		this.s2 = state.snake2;
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
	
	public boolean s1_eat_s2(){
		if(s1 == null || s2 == null){
			System.out.println("NULL CHECK FAIL");
			return false;
		}
		System.out.println("AGAGASG");
		double s1_x = s1.head.rPiv.x;
		double s1_y = s1.head.rPiv.y;
		double distance;
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
		
		double s2_tail_x = ( s2.tail.lPiv.x + s2.tail.rPiv.x)/2.0;
		double s2_tail_y = (s2.tail.lPiv.y + s2.tail.rPiv.y)/2.0;
		distance = Math.sqrt((s2_tail_x - s1_x)*(s2_tail_x - s1_x) + (s2_tail_y - s1_y)*(s2_tail_y - s1_y));
		if(distance <= collide_distance){
			s1.addSegments(1);
			s2.removeSegments(1);
			col_status = true;
		}
		
		return col_status;
	}
	
	public boolean s2_eat_s1(){
		double s2_x = s2.head.rPiv.x;
		double s2_y = s2.head.rPiv.y;
		double distance;
		
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
		if(distance <= collide_distance){
			s2.addSegments(1);
			s1.removeSegments(1);
		}
		return col_status;
	}

	@Override
	public boolean isCollide(P1Snake s) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
