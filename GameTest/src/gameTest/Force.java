package gameTest;

public class Force {
	protected int x;
	protected int y;
	
	public Force(){
		x = 0;
		y = 0;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setX(int x){
		this.x = x;
	}
	public int getY(){
		return y;
	}
	public int getX(){
		return x;
	}
}
