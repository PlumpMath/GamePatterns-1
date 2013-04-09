package gameTest;

public class Vector {
	private Position pos1, pos2;
	
	public Vector (Position pos1, Position pos2){
		this.pos1 = new Position(pos1.x, pos1.y);
		this.pos2 = new Position(pos2.x, pos2.y);
	}
	
	public Vector(double x1, double y1, double x2, double y2){
		pos1 = new Position(x1, y1);
		pos2 = new Position(x2, y2);
	}
	public void setPosition1(double x, double y){
		pos1.x = x;
		pos1.y = y;
	}
	public void setPosition1(Position pos){
		pos1 = pos;
	}
	public void setPosition2(double x, double y){
		pos2.x = x;
		pos2.y = y;
	}
	public void setPosition2(Position pos){
		pos2 = pos;
	}
	public Position getPosition1(){
		return pos1;
	}
	public Position getPosition2(){
		return pos2;
	}
	
}
