package gameTest;


public class Player extends MovingWorldObject {
	
	
	public Player(int width, int height, int xCoord, int yCoord) {
		super(width, height, xCoord, yCoord);
		// TODO Auto-generated constructor stub
	}

	/*public Player(){
		super(50,100,300,350,150);//width,height,x,y,mass
		//force = 10;
	}*/
	
	
	/*public void handlePlayer(WorldObject testObj){
		
		
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
		
		if(force.y != 0){
			acceleration.y = (double)force.y/mass;
			//System.out.println(force.y);
			velocity.y = Math.pow(acceleration.y, 2)/2;
			if(force.y<0)
				velocity.y *=-1;	
			if(force.y > 0){ force.y-=5;}
			else if(force.y < 0){force.y+=5;}
		}
		velocity.y -=0.5;
		position.y += velocity.y;
		
		
		
		if(force.x != 0){
			acceleration.x = (double)force.x/mass;
			velocity.x = Math.pow(acceleration.x, 2)/2;
			if(force.x<0)
				velocity.x *= -1;
			if(force.x > 0)
				force.x-=5;
			else if(force.x < 0)
				force.x+=5;
		}
		position.x += velocity.x;
	}
	
	public void moveUp(){
		//force.setY(500);
		velocity.y=50;
	}
	public void moveDown(){
		velocity.y=-50;
	}
	public void moveLeft(){
		velocity.x=-50;
	}
	public void moveRight(){
		velocity.x=-50;
	}*/
}
