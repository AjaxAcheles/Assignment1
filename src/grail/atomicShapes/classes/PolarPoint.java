package grail.atomicShapes.classes;

import grail.atomicShapes.interfaces.PointInterface;

public class PolarPoint implements PointInterface {
	private double radius;
	private double angleDegrees;
	
	public PolarPoint(double theRadius, double theAngleDegrees) {
		radius = theRadius;
		angleDegrees = theAngleDegrees;
	}
	
	public PolarPoint(int theX, int theY) {
		radius = Math.sqrt(theX * theX + theY * theY);
		angleDegrees = Math.toDegrees(Math.atan2(theY, theX));
	}
	
	@Override
	public int getX() {
		return (int) Math.round(radius * Math.cos(Math.toRadians(angleDegrees)));
	}
	
	@Override
	public int getY() {
		return (int) Math.round(radius * Math.sin(Math.toRadians(angleDegrees)));
	}
	
	@Override
	public double getAngle() {
		return angleDegrees;
	}
	
	@Override
	public double getRadius() {
		return radius;
	}
	
	@Override
	public void setX(int x) {
		int currentY = getY();
		radius = Math.sqrt(x * x + currentY * currentY);
		angleDegrees = Math.toDegrees(Math.atan2(currentY, x));
	}
	
	@Override
	public void setY(int y) {
		int currentX = getX();
		radius = Math.sqrt(currentX * currentX + y * y);
		angleDegrees = Math.toDegrees(Math.atan2(y, currentX));
	}
	
	@Override
	public void setRadius(double newRadius) {
		this.radius = newRadius;
	}
	
	@Override
	public void setAngle(double newAngleDegrees) {
		this.angleDegrees = newAngleDegrees;
	}
}