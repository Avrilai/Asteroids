package Asteroids;

/**
 * Created by Alex on 2/23/2016.
 */

import processing.core.PApplet;

import java.util.List;
import java.util.ArrayList;

public class AsteroidsGame extends PApplet {
    //your variable declarations here
    private int counter = 0;
    private int counter2 = 0;
    private SpaceShip ship;
    private Stars stars;
    private List<Bullet> bullets;

    private int[] xCorners = {-20, 20, -20};
    private int[] yCorners = {-14, 0, 14};


    //private Asteroid[] astArray;
    private List<Asteroid> astArray;
    int[] colors = {0xFFFF4000, 0xFFFF0000, 0xFFFF0000, 0xFF0000FF, 0xFF990000};


    private boolean up, left, right, hyperspace, shoot, addAst;

    public static void main(String[] args) {
        PApplet.main(new String[]{"Asteroids.AsteroidsGame"});
    }

    public void setup() {
        //size(1600, 900);

        ship = new SpaceShip(this, 3, xCorners, yCorners, 255, 800, 450, 0, 0, 0);
        //rockets = new SpaceShip(this, 3, xCorners, yCorners, 255, 800, 450, 0, 0, 0);
        stars = new Stars(this);
        bullets = new ArrayList<Bullet>();

        astArray = new ArrayList<Asteroid>();

        for (int i = 0; i < 30; i++) {
            int color = colors[i % 5];
            int[] astCornersX = new int[10];
            int[] astCornersY = new int[10];
            astArray.add(new Asteroid(this, (int) (Math.random() * 3), 10, shapeX(astCornersX),
                    shapeY(astCornersY), colors[(int) Math.random() * 4],
                    Math.random() * 1600, Math.random() * 900,
                    Math.random() * 6 - 3, Math.random() * 6 - 3, Math.random() * 360));
        }

        //bullets = new Bullet(this, ship);

    }

    public void settings() {
        size(1600, 900);
    }

    public void draw() {
        //your code here
        background(0);
        stars.show();
        ship.show();

        for (int i = 0; i < astArray.size(); i++) {
            Asteroid asteroid = astArray.get(i);
            asteroid.show();
            asteroid.move();

            if (dist(ship.getX(), ship.getY(), asteroid.getX(), asteroid.getY()) < 50) {
                astArray.remove(i);
                ship.setX(800);
                ship.setY(450);
                ship.setDirectionX(ship.getDirectionX() / 1000);  //stops ship
                ship.setDirectionY(ship.getDirectionY() / 1000);

            }
            for (int b = 0; b < bullets.size(); b++) {
                if (dist(bullets.get(b).getX(), bullets.get(b).getY(), asteroid.getX(), asteroid.getY()) < 40) {
                    astArray.remove(i);
                    bullets.remove(bullets.get(b));
                }
            }
        }

        if (up) {
            ship.accelerate(0.2);
        } else {
            ship.setDirectionX(ship.getDirectionX() / 1.01);
            ship.setDirectionY(ship.getDirectionY() / 1.01);
        }
        if (left) {
            ship.rotate(-10);
        }
        if (right) {
            ship.rotate(10);
        }
        if (hyperspace) {
            ship.setX((int) (Math.random() * 1600));
            ship.setY((int) (Math.random() * 900));
            ship.setDirectionX(ship.getDirectionX() / 100);  //stops ship
            ship.setDirectionY(ship.getDirectionY() / 100);
            ship.setPointDirection((int) (Math.random() * 360));
        }

        if (addAst) {
            astArray.add(new Asteroid(this, (int) (Math.random() * 3), 10, xCorners,
                    yCorners, colors[(int) Math.random() * 4],
                    Math.random() * 1600, Math.random() * 900,
                    Math.random() * 6 - 3, Math.random() * 6 - 3, Math.random() * 360));
        }


        for (Bullet bullet : bullets) {
            bullet.show();
            bullet.move();
        }

        ship.move();
        counter++;


        if (counter == 10) {
            for (int i = 0; i < astArray.size(); i++) {
                astArray.get(i).setColor(colors[i % 5]);
            }
        }
        counter %= 10;

        if (counter2 >= 15 && shoot) {
            bullets.add(new Bullet(this, ship));
            counter2 = 0;
        }
        counter2++;

    }

    public void keyPressed() {
        if (keyCode == UP) {
            up = true;
        }
        if (keyCode == LEFT) {
            left = true;
        }
        if (keyCode == RIGHT) {
            right = true;
        }
        if (key == 'h' || key == 'H') {
            hyperspace = true;
        }
        if (key == ' ') {
            shoot = true;
        }
        if (key == 'a') {
            addAst = true;
        }
    }

    public void keyReleased() {
        if (keyCode == UP) {
            up = false;
        }
        if (keyCode == LEFT) {
            left = false;
        }
        if (keyCode == RIGHT) {
            right = false;
        }
        if (key == 'h') {
            hyperspace = false;
        }
        if (key == ' ') {
            shoot = false;
        }
        if (key == 'a') {
            addAst = false;
        }

    }

    private static int[] shapeX(int[] x) {
        for (int i = 0; i < 10; i++) {
            if (i == 0 || i == 9) {
                x[i] = (int) (Math.random() * 20) - 65;
            }
            if (i == 1 || i == 8) {
                x[i] = (int) (Math.random() * 15) - 40;
            }
            if (i == 2 || i == 7) {
                x[i] = (int) (Math.random() * 20) - 10;
            }
            if (i == 3 || i == 6) {
                x[i] = (int) (Math.random() * 15) + 25;
            }
            if (i == 4 || i == 5) {
                x[i] = (int) (Math.random() * 20) + 45;
            }
        }
        return x;
    }

    private static int[] shapeY(int[] y) {
        for (int i = 0; i < 10; i++) {
            if (i == 0 || i == 4) {
                y[i] = (int) (Math.random() * 10) - 10;
            }
            if (i == 1 || i == 3) {
                y[i] = (int) (Math.random() * 15) - 25;
            }
            if (i == 2) {
                y[i] = (int) (Math.random() * 10) - 35;
            }
            if (i == 5 || i == 9) {
                y[i] = (int) (Math.random() * 10);
            }
            if (i == 6 || i == 8) {
                y[i] = (int) (Math.random() * 15) + 10;
            }
            if (i == 7) {
                y[i] = (int) (Math.random() * 10) + 25;
            }
        }
        return y;
    }

}