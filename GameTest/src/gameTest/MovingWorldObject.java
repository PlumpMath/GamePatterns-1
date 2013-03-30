package gameTest;

public abstract class MovingWorldObject extends WorldObject{
	protected Velocity velocity;
	protected Acceleration acceleration;
	
	public MovingWorldObject(int width, int height, int xCoord, int yCoord){
		super(width, height, xCoord, yCoord);
		velocity = new Velocity(0.0, 0.0);
		acceleration = new Acceleration(0.0, 0.0, 0.05);
	}
	
public void handleMovingWorldObject(WorldObject testObj){
		
		System.out.println(intersect(testObj));
		if(Placed.BELOW != intersect(testObj)){
			acceleration.y += acceleration.start;
			velocity.y -= acceleration.y;	
			position.y += velocity.y;
		}
		else{
			acceleration.y=0;
			velocity.y=0;
			position.y = testObj.position.y+height-0.1;
		}
		position.x += velocity.x;
		if(velocity.x > 0.1)
			velocity.x-=1;
		else if(velocity.x < -0.1)
			velocity.x+=1;
		
	}
	
	public void moveUp(){
		velocity.y=50;
	}
	public void moveDown(){
		velocity.y=-50;
	}
	public void moveLeft(){
		velocity.x=-10;
	}
	public void moveRight(){
		velocity.x=10;
	}
}
