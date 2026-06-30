package grail.atomicShapes.classes;

import grail.atomicShapes.interfaces.PointInterface;

public class CartesianPoint implements PointInterface {
    private int x;
    private int y;

    public CartesianPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() { 
        return x; 
    }
    @Override
    public int getY() { 
        return y; 
    }
    
    @Override
    public double getAngle() { 
        return Math.toDegrees(Math.atan2(y, x)); 
    }
    @Override
    public double getRadius() { 
        return Math.sqrt(x * x + y * y); 
    }
    
    @Override
    public void setX(int x) {
        this.x = x;
    }
    
    @Override
    public void setY(int y) {
        this.y = y;
    }
}