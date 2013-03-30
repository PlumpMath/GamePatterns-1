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
	
	public Intersects intersect(WorldObject obj){
		if(position.y+height > obj.position.y && position.y < obj.position.y &&
				position.x < obj.position.x+obj.width && position.x+width > obj.position.x){
			return Intersects.ABOVE;
		}
		if(position.y < obj.position.y+height && position.y + height > obj.position.y+height &&
				position.x < obj.position.x+obj.width && position.x+width > obj.position.x){
			return Intersects.BELOW;
		}
		else{
			return Intersects.NOWHERE;
		}
	}
	public int getWidht(){
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

}
