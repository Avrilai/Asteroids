package Asteroids;

import processing.core.PApplet;

/**
 * Created by Alex on 2/23/2016.
 */
public class Asteroid extends Floater {

    PApplet applet;
    int rotSpeed;

    public Asteroid(PApplet applet_, int rotSpeed_, int corners_, int[] xCorners_, int[] yCorners_, int color,
                    double centerX, double centerY, double dirX, double dirY, double pointDir)
    {
        super(applet_);
        rotSpeed = rotSpeed_;
        applet = applet_;
        corners = corners_;
        xCorners = xCorners_;
        yCorners = yCorners_;
        myColor = color;
        myCenterX = centerX;
        myCenterY = centerY;
        myDirectionX = dirX;
        myDirectionY = dirY;
        myPointDirection = pointDir;
    }

    public void move() {
        rotate(rotSpeed);
        super.move();
    }

    public void setColor(int c) {
        myColor = c;
    }

    public int getColor() {
        return myColor;
    }

    public void setX(int x) {
        myCenterX = x;
    }

    public int getX() {
        return (int) myCenterX;
    }

    public void setY(int y) {
        myCenterY = y;
    }

    public int getY() {
        return (int) myCenterY;
    }

    public void setDirectionX(double x) {
        myDirectionX = x;
    }

    public double getDirectionX() {
        return myDirectionX;
    }

    public void setDirectionY(double y) {
        myDirectionY = y;
    }

    public double getDirectionY() {
        return myDirectionY;
    }

    public void setPointDirection(int degrees) {
        myPointDirection = degrees;
    }

    public double getPointDirection() {
        return myPointDirection;
    }
}