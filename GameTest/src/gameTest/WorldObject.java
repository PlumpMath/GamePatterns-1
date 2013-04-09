/**
 * 
 */
package gameTest;


/**
 * @author Myggan
 *
 */
public abstract class WorldObject {

	protected int width;
	protected int height;
	protected Position position;
	
	public WorldObject(int width, int height, double xCoord, double yCoord){
		this.width = width;
		this.height = height;
		this.position = new Position(xCoord, yCoord);
		//this.position.setX(xCoord);
		//this.position.setY(yCoord);
	}
	public static boolean intersects(WorldObject obj1, WorldObject obj2){
		return intersectsX(obj1, obj2) || intersectsY(obj1, obj2);
	}
	
	public static boolean intersectsY(WorldObject obj1, WorldObject obj2){
		//The y axis with constant x to project the objects on
		double constantX = obj1.position.x;
		Vector vectorObj1;
		Vector vectorObj2;
		//Project obj1 on y-axis
		vectorObj1 = new Vector(constantX, obj1.getYCoord(), constantX, obj1.getYCoord()+obj1.getHeight());
		//Project obj2 on y-axis
		vectorObj2 = new Vector(constantX, obj2.getYCoord(), constantX, obj2.getYCoord()+obj2.getHeight());
		//largest number will always be position 2
		if(vectorObj1.getPosition1().getY() > vectorObj2.getPosition2().getY() || 
				vectorObj2.getPosition1().getY() > vectorObj1.getPosition2().getY()){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static boolean intersectsX(WorldObject obj1, WorldObject obj2){
		//The x axis with constant y to project the objects on
		double constantY = obj1.position.y;
		Vector vectorObj1;
		Vector vectorObj2;
		//Project obj1 on y-axis
		vectorObj1 = new Vector(obj1.getXCoord(), constantY, obj1.getXCoord()+obj1.getWidth(), constantY);
		//Project obj2 on y-axis
		vectorObj2 = new Vector(obj2.getXCoord(), constantY, obj2.getXCoord()+obj2.getWidth(), constantY);
		//largest number will always be position 2
		if(vectorObj1.getPosition1().getX() > vectorObj2.getPosition2().getX() || 
				vectorObj2.getPosition1().getX() > vectorObj1.getPosition2().getX()){
			return false;
		}
		else{
			return true;
		}
	}
		
		
	/*public static int intersectsWhere(WorldObject obj1, WorldObject obj2){
		if(obj1.position.y+obj1.height > obj2.position.y && obj1.position.y < obj2.position.y &&
				obj1.position.x < obj2.position.x+obj2.width && obj1.position.x+obj1.width > obj2.position.x){
			return 1;//ovan
		}
		if(obj1.position.y < obj2.position.y+height && position.y + height > obj2.position.y+height &&
				position.x < obj2.position.x+obj2.width && position.x+width > obj2.position.x){
			return 1;//under
		}
		else{
			return 0;
		}
	}*/
	/*public Intersects intersect(WorldObject obj){
		if(position.y+height >= obj.position.y && position.y <= obj.position.y &&
				position.x < obj.position.x+obj.width && position.x+width > obj.position.x){
			return Intersects.ABOVE;
		}
		if(position.y <= obj.position.y+obj.height && position.y + height >= obj.position.y+obj.height &&
				position.x < obj.position.x+obj.width && position.x+width > obj.position.x){
			return Intersects.BELOW;
		}
		else{
			return Intersects.NOWHERE;
		}
	}*/
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public double getXCoord(){
		return position.getX();
	}
	public double getYCoord(){
		return position.getY();
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setXCoord(int xCoord){
		this.position.x = xCoord;
	}

}
