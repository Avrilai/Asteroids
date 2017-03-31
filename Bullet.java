package Asteroids;
import processing.core.PApplet;
/**
 * Created by Alex on 3/4/2016.
 */
public class Bullet extends Floater {
    //private int myCenterX, myCenterY;
    //private double myPointDirection, myDirectionX, myDirectionY;
    private int color = 0xFFFF0000; //0xFFFE2E9A;

    public Bullet(PApplet applet, SpaceShip ship){
        super(applet);
        myCenterX = ship.getX();
        myCenterY = ship.getY();
        myPointDirection = ship.getPointDirection();
        double dRadians = myPointDirection * (Math.PI / 180);
        myDirectionX = 5 * Math.cos(dRadians) + ship.getDirectionX();
        myDirectionY = 5 * Math.sin(dRadians) + ship.getDirectionY();

    }

    public void show() {
        applet.fill(color);
        //applet.ellipseMode(applet.CENTER);
        applet.ellipse((float)myCenterX, (float)myCenterY, 10, 10);
    }

    public void move ()   //move the floater in the current direction of travel
    {
        //change the x and y coordinates by myDirectionX and myDirectionY
        myCenterX += 2 * myDirectionX;
        myCenterY += 2 * myDirectionY;
    }


    public void setX(int x)
    {
        myCenterX = x;
    }

    public int getX()
    {
        return (int)myCenterX;
    }

    public void setY(int y)
    {
        myCenterY = y;
    }

    public int getY()
    {
        return (int)myCenterY;
    }

    public void setDirectionX(double x)
    {
        myDirectionX = x;
    }

    public double getDirectionX()
    {
        return myDirectionX;
    }

    public void setDirectionY(double y)
    {
        myDirectionY = y;
    }

    public double getDirectionY()
    {
        return myDirectionY;
    }

    public void setPointDirection(int degrees)
    {
        myPointDirection = degrees;
    }

    public double getPointDirection()
    {
        return myPointDirection;
    }
}
