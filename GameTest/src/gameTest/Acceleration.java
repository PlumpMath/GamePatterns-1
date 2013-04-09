package gameTest;

public class Acceleration {
	protected double x;
	protected double y;
	protected double start;
	
	public Acceleration(double x, double y, double start){
		this.x = x;
		this.y = y;
		this.start = start;
	}
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public double getStart(){
		return start;
	}
}
