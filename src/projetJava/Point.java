package projetJava;

public class Point {
	
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getX() {
		return this.x;
	}
	
	@Override
	public String toString() {
		return "x : " + this.x + ", y : " + this.y;
	}
}