package grail.compositeShapes.classes;

import grail.compositeShapes.interfaces.AngleInterface;
import grail.simpleShapes.classes.RotatingLine;
import grail.simpleShapes.interfaces.LineInterface;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags(Comp301Tags.ANGLE)
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"LeftLine", "RightLine"})
@EditablePropertyNames({})
public class Angle implements AngleInterface {
    private LineInterface leftLine;
    private LineInterface rightLine;
    private double radius;
    private double splitAngleDegrees;
    private double downDirectionDegrees;

    public Angle(int x, int y, double radius, double splitAngleDegrees, double downDirectionDegrees) {
        this.radius = radius;
        this.splitAngleDegrees = splitAngleDegrees;
        this.downDirectionDegrees = downDirectionDegrees;

        // downDirection determines what is "down" and the left and right lines are positioned splitAngle/2 to the left and right of the downDirection
        this.leftLine = new RotatingLine(x, y, radius, downDirectionDegrees - splitAngleDegrees / 2);
        this.rightLine = new RotatingLine(x, y, radius, downDirectionDegrees + splitAngleDegrees / 2);
    }

    @Override
    public LineInterface getLeftLine() {
        return this.leftLine;
    }

    @Override
    public LineInterface getRightLine() {
        return this.rightLine;
    }

    @Override
    public void move(int x, int y) {
        this.leftLine.move(x, y);
        this.rightLine.move(x, y);
    }

    @Override
    public void rotate(int angle) {
        this.leftLine.rotate(angle);
        this.rightLine.rotate(angle);
    }
}