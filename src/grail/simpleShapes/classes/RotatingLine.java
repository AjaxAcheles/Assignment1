package grail.simpleShapes.classes;

import grail.atomicShapes.classes.CartesianPoint;
import grail.atomicShapes.classes.PolarPoint;
import grail.atomicShapes.interfaces.PointInterface;
import grail.simpleShapes.interfaces.LineInterface;
import tags301.Comp301Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.LINE_PATTERN)
@Tags(Comp301Tags.ROTATING_LINE)
public class RotatingLine implements LineInterface {
    
    private static final int DEFAULT_X = 100;
    private static final int DEFAULT_Y = 100;
    private static final double DEFAULT_RADIUS = 50.0;
    private static final double DEFAULT_ANGLE_DEGREES = 45.0;
    
    private PointInterface startPoint;
    private PolarPoint endPoint;
    private double angleDegrees;

    public RotatingLine() {
        this(DEFAULT_X, DEFAULT_Y, DEFAULT_RADIUS, DEFAULT_ANGLE_DEGREES);
    }
    
    /**
     * @param startX    x-coordinate of start point
     * @param startY    y-coordinate of start point
     * @param radius    length of the line
     * @param angle     angle in degrees
     */
    public RotatingLine(int startX, int startY, double radius, double angle) {
        this.startPoint = new CartesianPoint(startX, startY);
        this.angleDegrees = angle;
        this.endPoint = new PolarPoint(radius, angle);
    }

    @Override
    public int getX() {
        return startPoint.getX();
    }
    
    @Override
    public int getY() {
        return startPoint.getY();
    }

    @Override
    public void setX(int x) {
        startPoint.setX(x);
    }

    @Override
    public void setY(int y) {
        startPoint.setY(y);
    }

    @Override
    public int getWidth() {
        return endPoint.getX();
    }
    
    @Override
    public int getHeight() {
        return endPoint.getY();
    }

    @Override
    public double getRadius() {
        return endPoint.getRadius();
    }
    
    @Override
    public double getAngle() {
        return this.angleDegrees;
    }

    @Override
    public void setRadius(double newRadius) {
        this.endPoint.setRadius(newRadius);
    }

    @Override
    public PointInterface getEnd() {
        return this.endPoint;
    }

    @Override
    public void setAngle(double newAngle) {
        this.angleDegrees = newAngle;
        this.endPoint.setAngle(newAngle);
    }

    @Override
    public void rotate(int units) {
        this.angleDegrees += units;
        this.endPoint.setAngle(this.angleDegrees);
    }

    @Override
    public void move(int moveX, int moveY) {
        int newX = this.startPoint.getX() + moveX;
        int newY = this.startPoint.getY() + moveY;
        this.startPoint.setX(newX);
        this.startPoint.setY(newY);
    }
    
    @Override
    public void scale(double scaleMultiplier) {
        this.setRadius(this.getRadius() * scaleMultiplier);
    }
}