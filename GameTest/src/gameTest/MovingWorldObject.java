package gameTest;


public abstract class MovingWorldObject extends WorldObject{
	protected Velocity velocity;
	protected Acceleration acceleration;
	private StatusY statusY;
	private StatusX statusX; 
	
	public MovingWorldObject(int width, int height, int xCoord, int yCoord){
		super(width, height, xCoord, yCoord);
		velocity = new Velocity(0.0, 0.0);
		acceleration = new Acceleration(0.0, 0.0, 0.05);
		statusY = StatusY.AIR;
		statusX = StatusX.STILL;
	}
	
	public void handleMovingWorldObject(WorldObject testObj){
		
		//System.out.println(intersect(testObj));
		if( statusY == StatusY.AIR || Intersects.BELOW != intersect(testObj)){
			acceleration.y += acceleration.start;
			velocity.y -= acceleration.y;	
			position.y += velocity.y;
		}
		if(Intersects.BELOW == intersect(testObj)){
			statusY = StatusY.GROUND;
			acceleration.y=0;
			velocity.y=0;
			position.y = testObj.position.y+height;
		}
		System.out.println(statusX);
		if(velocity.x > 1 && statusX == StatusX.RIGHTRELEASED && statusY != StatusY.AIR){
			acceleration.x += acceleration.start;
			velocity.x-= acceleration.x;
		}
		else if(velocity.x < -1 && statusX == StatusX.LEFTRELEASED && statusY != StatusY.AIR){
			acceleration.x += acceleration.start;
			velocity.x+= acceleration.x;
		}
		else if(statusX != statusX.LEFTHOLD && statusX != statusX.RIGHTHOLD && statusY != StatusY.AIR){
			statusX = StatusX.STILL;
			acceleration.x=0;
			velocity.x=0;
		}
		position.x += velocity.x;
	}
	
	public void moveUp(){
		if(statusY != StatusY.AIR){
			statusY = StatusY.AIR;
			velocity.y=20;
			position.y +=1;
		}
	}
	public void moveDown(){
		statusY = StatusY.AIR;
		position.y -=100;
	}
	public void moveLeft(){
		statusX = StatusX.LEFTHOLD;
		acceleration.x=acceleration.start;
		velocity.x=-10;
	}
	public void leftStop(){
		statusX = StatusX.LEFTRELEASED;
	}
	public void moveRight(){
		statusX = StatusX.RIGHTHOLD;
		acceleration.x=acceleration.start;
		velocity.x=10;
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
