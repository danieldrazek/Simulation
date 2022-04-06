package pl.pp.simulation;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Hare {
    public static int size = 10;
    public static int maxSpeed = 10;
    public static int maxX = ProgramData.maxWidth - size;
    public static int maxY = ProgramData.maxHeight - size;
    private static Random random = new Random();

    private double x;
    private double y;

    private double speed;
    private double speedAngle;

    public Hare() {
        x = random.nextInt(maxX);
        y = random.nextInt(maxY);
        speed = random.nextInt(maxSpeed);
        speedAngle = random.nextInt(360);
    }


    public void draw(Graphics2D graphics2D) {
        Ellipse2D.Double hareEllipse = new Ellipse2D.Double(x, y, size, size);
        graphics2D.setPaint(Color.DARK_GRAY);
        graphics2D.fill(hareEllipse);
    }

    public void move() {
        changeSpeed();

        x += deltaX();
        y += deltaY();

        if (x < 0) {
            x = 0;
            speed = 0;
            speedAngle = 0;
        }

        if (y < 0) {
            y = 0;
            speed = 0;
            speedAngle = 90;
        }

        if (x > maxX) {
            x = maxX;
            speed = 0;
            speedAngle = 180;
        }

        if (y > maxY) {
            y = maxY;
            speed = 0;
            speedAngle = 270;
        }
    }

    public void changeSpeed() {
        int deltaSpeed = random.nextInt(5) - 2;
        int deltaAngle = random.nextInt(21) - 10;

        speed += deltaSpeed;
        speedAngle += deltaAngle;

        if (speed > maxSpeed) {
            speed = maxSpeed;
        }

        if (speed < 0) {
            speed = 0;
        }
    }

    private double deltaX() {
        return speed*Math.cos(Math.toRadians(speedAngle));
    }

    private double deltaY() {
        return speed*Math.sin(Math.toRadians(speedAngle));
    }
}