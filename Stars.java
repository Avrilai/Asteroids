package Asteroids;

/**
 * Created by Alex on 2/23/2016.
 */
import processing.core.PApplet;
public class Stars
{
    PApplet applet;
    private float[] starsX = new float[75];
    private float[] starsY = new float[75];

    public Stars(PApplet applet_)
    {
        applet = applet_;
        starsX = new float[75];
        starsY = new float[75]; //random positions for 75 stars
        for (int i = 0; i < 75; i++)
        {
            starsX[i] = (float)Math.random() * 1600;
            starsY[i] = (float)Math.random() * 900;
        }
    }

    public void show()
    {
        applet.fill(255, 255, 255);
        for (int i = 0; i < starsX.length; i++)
        {
            applet.ellipse(starsX[i], starsY[i], 5, 5);
        }
    }


}
