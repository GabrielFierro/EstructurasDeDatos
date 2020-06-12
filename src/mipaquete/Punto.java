package mipaquete;

public class Punto {
	
	private double x;
	private double y;
	
	// Constructor
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// Interfaz
	public double getX() {
		return this.x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
}
