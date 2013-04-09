package gameTest;


public class Player extends MovingWorldObject {
	
	
	public Player(int width, int height, int xCoord, int yCoord) {
		super(width, height, xCoord, yCoord);
		// TODO Auto-generated constructor stub
	}
	
	/*public void KeepInsideWorldBorders(double left, double right){
		if(position.x <= left){
			velocity.x = acceleration.x = 0;
			position.x = 0;
		}
		else if (position.x + width >= right){
			velocity.x = acceleration.x = 0;
			position.x = right-width;
		}
	}*/
}
