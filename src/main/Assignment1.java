package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.compositeShapes.interfaces.AngleInterface;
import grail.compositeShapes.interfaces.AvatarInterface;
import grail.compositeShapes.interfaces.BridgeSceneInterface;
import grail.compositeShapes.classes.Angle;
import grail.compositeShapes.classes.Avatar;
import grail.compositeShapes.classes.BridgeScene;
import grail.simpleShapes.classes.RotatingLine;
import grail.simpleShapes.interfaces.LineInterface;
import grail.simpleShapes.classes.Image;
import grail.simpleShapes.interfaces.ImageInterface;
import util.misc.ThreadSupport;

public class Assignment1 {
    
    private static final int EDITOR_WIDTH = 1000;
    private static final int EDITOR_HEIGHT = 500;
    
    private static final int PAUSE_TIME_SHORT = 2000;
    private static final int PAUSE_TIME_MEDIUM = 3000;
    private static final int PAUSE_TIME_LONG = 5000;
    private static final int PAUSE_TIME_ANIMATION = 30;
    private static final int PAUSE_TIME_SLOW = 1000;
    
    private static final int IMAGE_MOVE_STEP = 5;
    
    private static final int ANIMATION_STEP = 1;
    private static final int ANIMATION_TARGET_X = 300;
    private static final int ANIMATION_TARGET_Y = 300;
    
    private static final int WALKING_CYCLE_FRAMES = 80;
    private static final double FULL_CIRCLE_DEGREES = 360.0;
    private static final double RIGHT_ANGLE_DEGREES = 90.0;
    private static final double HALF_CYCLE_DEGREES = 180.0;
    
    public static void main(String[] args) {
        // animateLine("Avatar");
        demonstrateBridgeScene();
    }

    public static void demonstrateBridgeScene() {
        BridgeSceneInterface bridgeScene = new BridgeScene();
        OEFrame editor = ObjectEditor.edit(bridgeScene);
        editor.setSize(EDITOR_WIDTH, EDITOR_HEIGHT);
    }
    
    public static void animateLine(String mode) {
        if (mode == "Line") {
            LineInterface testLine = new RotatingLine(100, 100, 20, 0); 
            OEFrame editor = ObjectEditor.edit(testLine);
            editor.refresh();
            ThreadSupport.sleep(PAUSE_TIME_LONG);

            testLine.rotate(90);
            editor.refresh();
            ThreadSupport.sleep(PAUSE_TIME_SHORT);

            testLine.rotate(-90);
            editor.refresh();
        }

        if (mode == "RotatingLine") {
            LineInterface testLine = new RotatingLine(0, 0, 100, 0); 
            OEFrame editor = ObjectEditor.edit(testLine);

            int nextY = testLine.getY() + ANIMATION_STEP;
            int nextX = testLine.getX() + ANIMATION_STEP;
            while (nextY <= ANIMATION_TARGET_Y && nextX <= ANIMATION_TARGET_X) {
                testLine.setX(nextX);
                testLine.setY(nextY);
                testLine.rotate(ANIMATION_STEP);
                editor.refresh();
                ThreadSupport.sleep(PAUSE_TIME_ANIMATION);
                nextX = testLine.getX() + ANIMATION_STEP;
                nextY = testLine.getY() + ANIMATION_STEP;
            }
    
            testLine.setX(ANIMATION_TARGET_X);
            testLine.setY(ANIMATION_TARGET_Y);
            editor.refresh();
    
            while (true) {
                testLine.rotate(ANIMATION_STEP);
                ThreadSupport.sleep(PAUSE_TIME_ANIMATION);
                editor.refresh();
            }
        }

        else if (mode == "Image") {
            ImageInterface testImage = new Image(100, 100, 100, 100, "Test", "images/arthur.jpg");
            OEFrame editor = ObjectEditor.edit(testImage);

            while (true) {
                testImage.setX(testImage.getX() + IMAGE_MOVE_STEP);
                testImage.setY(testImage.getY() + IMAGE_MOVE_STEP);
                ThreadSupport.sleep(PAUSE_TIME_SLOW);
                editor.refresh();
            }
        }

        else if (mode == "Avatar") {
            AvatarInterface testAvatar = new Avatar(200, 200, "Hello!", "images/arthur.jpg");
            OEFrame editor = ObjectEditor.edit(testAvatar);
            ThreadSupport.sleep(PAUSE_TIME_MEDIUM);
            
            testAvatar.move(300, 300);
            editor.refresh();
            ThreadSupport.sleep(PAUSE_TIME_MEDIUM);
            
            testAvatar.rotate(RIGHT_ANGLE_DEGREES);
            editor.refresh();
        }

        else if (mode == "Angle") {
            AngleInterface testAngle = new Angle(100, 100, 50, RIGHT_ANGLE_DEGREES, RIGHT_ANGLE_DEGREES);
            OEFrame editor = ObjectEditor.edit(testAngle);
            editor.refresh();
        }

        else if (mode == "WalkingLegs") {
            AngleInterface testLegs = new Angle(200, 400, 100, RIGHT_ANGLE_DEGREES, RIGHT_ANGLE_DEGREES);

            OEFrame editor = ObjectEditor.edit(testLegs);

            double omegaDeg = FULL_CIRCLE_DEGREES / WALKING_CYCLE_FRAMES;
            double swingAmplitude = ANIMATION_STEP / (100.0 * omegaDeg);

            int frame = 0;
            while (true) {
                testLegs.move(ANIMATION_STEP, 0);

                double phaseDeg = (frame % WALKING_CYCLE_FRAMES) * omegaDeg;

                double leftAngleDeg = RIGHT_ANGLE_DEGREES + swingAmplitude * Math.sin(Math.toRadians(phaseDeg));
                double rightAngleDeg = RIGHT_ANGLE_DEGREES + swingAmplitude * Math.sin(Math.toRadians(phaseDeg + HALF_CYCLE_DEGREES));

                testLegs.getLeftLine().setAngle(leftAngleDeg);
                testLegs.getRightLine().setAngle(rightAngleDeg);

                editor.refresh();
                ThreadSupport.sleep(PAUSE_TIME_ANIMATION);
                frame++;
            }
        }
    }
}