package gameTest;


public abstract class MovingWorldObject extends WorldObject{
	protected Velocity velocity;
	protected Acceleration acceleration;
	protected StatusY statusY;
	protected StatusX statusX; 
	
	
	public MovingWorldObject(int width, int height, int xCoord, int yCoord){
		super(width, height, xCoord, yCoord);
		velocity = new Velocity(0.0, 0.0);
		acceleration = new Acceleration(0.0, 0.0, 0.05);
		statusY = StatusY.FALL;
		statusX = StatusX.STILL;
	}
	
	public void handleMovingWorldObject(WorldObject testObj){
		
		//if (testObj.getWidht()>=2300)
		//	System.out.println(intersect(testObj));
//		System.out.println(statusY);
//		System.out.println(position.y);
		if(statusY == StatusY.GROUND){
			if(!intersects(this,testObj)){//!intersectsY(this, testObj) && !intersectsX(this, testObj)){
				statusY = StatusY.FALL;
			}
			
		}
		else if(statusY == StatusY.JUMP){// && !intersectsY(this, testObj) && !intersectsX(this, testObj)){
			System.out.println("ska flya");
				acceleration.y += acceleration.start;
				velocity.y -= acceleration.y;	
				position.y += velocity.y;
				if(velocity.y < 0){
					statusY = StatusY.FALL;
				}
		}
		else if(statusY == StatusY.FALL && !intersects(this, testObj)){
			acceleration.y += acceleration.start;
			velocity.y -= acceleration.y;	
			position.y += velocity.y;
		}
		else if(intersectsX(this, testObj) && intersectsY(this, testObj)){
			System.out.println("ska stanna");
			statusY = StatusY.GROUND;
			acceleration.y=0;
			velocity.y=0;
			position.y = testObj.position.y+height-1;
		}
		
		
		/*if(statusY==StatusY.GROUND && !intersectsX(this, testObj) && !intersectsY(this, testObj)){
			statusY = StatusY.AIR;
			acceleration.y = acceleration.start;
		}*/
		
		/*System.out.println(statusY);*/
		/*
		 * Changes the players position if he is in the air
		 */
		//checks the case when the player is jumping
		/*if( statusY == StatusY.AIR || Intersects.BELOW != intersect(testObj)){
			acceleration.y += acceleration.start;
			velocity.y -= acceleration.y;	
			position.y += velocity.y;
		}
		//Checks the case when there is ground under the player

		if(Intersects.BELOW == intersect(testObj)){
			System.out.println("stannar");
			statusY = StatusY.GROUND;
			acceleration.y=0;
			velocity.y=0;
			position.y = testObj.position.y+height-1;
		}*/
		//checks the case when the player has walked of the ground
		/*if(statusY == StatusY.GROUND && Intersects.BELOW == intersect(testObj)){
			statusY = StatusY.AIR;
			acceleration.y = acceleration.start;
			velocity.y -= acceleration.y;	
			position.y += velocity.y;
		}*/
		
		
		//System.out.println(statusX);
		/*
		 * Changes the players x-position depending on keys pressed
		 */
		if(velocity.x > 1 && statusX == StatusX.RIGHTRELEASED){
			acceleration.x += acceleration.start;
			velocity.x-= acceleration.x;
		}
		else if(velocity.x < -1 && statusX == StatusX.LEFTRELEASED){
			acceleration.x += acceleration.start;
			velocity.x+= acceleration.x;
		}
		else if(statusX != statusX.LEFTHOLD && statusX != statusX.RIGHTHOLD){
			statusX = StatusX.STILL;
			acceleration.x=0;
			velocity.x=0;
		}
		position.x += velocity.x;
	}
	
	public boolean isOnGround(WorldObject obj){
		if(position.y > obj.position.y+height && position.y < obj.position.y+height+5 &&
				position.x < obj.position.x+obj.width && position.x+width > obj.position.x){
			return true;
		}
		return false;
	}
	
	public void moveUp(){
		if(statusY == StatusY.GROUND){
			statusY = StatusY.JUMP;
			velocity.y=20;
			position.y +=5;
		}
	}
	public void moveDown(){
		statusY = StatusY.FALL;
		position.y -=10;
	}
	public void moveLeft(){
		statusX = StatusX.LEFTHOLD;
		acceleration.x=acceleration.start;
		velocity.x=-3;
	}
	public void leftStop(){
		statusX = StatusX.LEFTRELEASED;
	}
	public void moveRight(){
		statusX = StatusX.RIGHTHOLD;
		acceleration.x=acceleration.start;
		velocity.x=3;
	}
	public void rightStop(){
		statusX = StatusX.RIGHTRELEASED;
	}
	
	public StatusY getStatusY(){
		return statusY;
	}
	public StatusX getStatusX(){
		return statusX;
	}
}
