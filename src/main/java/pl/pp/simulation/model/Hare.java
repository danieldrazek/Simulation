package pl.pp.simulation.model;

import pl.pp.simulation.utils.ProgramData;
import pl.pp.simulation.utils.Utils;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static pl.pp.simulation.utils.ProgramData.hareList;
import static pl.pp.simulation.utils.Utils.getDistance;
import static pl.pp.simulation.utils.Utils.multiple;

public class Hare {
    public static int size = 10;
    public static int maxSpeed = 10;
    public static int visibility = 40;
    public static int minimumDesireForParenthood = 50;
    public static int maxX = ProgramData.maxWidth - size;
    public static int maxY = ProgramData.maxHeight - size;
    private static Random random = new Random();

    private double x;
    private double y;

    private double speed;
    private double speedAngle;
    private int desireForParenthood;

    public Hare() {
        x = random.nextInt(maxX);
        y = random.nextInt(maxY);
        speed = random.nextInt(maxSpeed);
        speedAngle = random.nextInt(360);
        desireForParenthood = minimumDesireForParenthood;
    }

    public Hare(double x, double y) {
        this.x = x;
        this.y = y;
        speed = 0;
        speedAngle = random.nextInt(360);
        desireForParenthood = 0;
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

        validatePosition();

        desireForParenthood++;
    }

    private void validatePosition() {
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

    private void changeSpeed() {
        if (desireForParenthood >= minimumDesireForParenthood && getVisibleHares().size() > 0) {
            adjustSpeedToNearesHare();
        } else {
            randomChangeSpeed();
        }
    }

    private void adjustSpeedToNearesHare() {
        Hare nearestHare = Collections.min(getVisibleHares(), Comparator.comparingDouble((Hare hare) -> getDistance(this, hare)));
        double distance = Utils.getDistance(nearestHare, this);

        if (distance < size) {
            multiple(this, nearestHare);
        }

        speed++;
        speedAngle = getAngleTo(nearestHare);

        if (speed > maxSpeed) {
            speed = maxSpeed;
        }

        if (speed > distance) {
            speed = distance;
        }
    }

    public void randomChangeSpeed() {
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

    public List<Hare> getVisibleHares() {
        return hareList.stream()
                .filter(hare -> hare != this && getDistance(this, hare) <= visibility)
                .collect(Collectors.toList());
    }

    public double getAngleTo(Hare hare) {
        double deltaX = hare.getX() - x;
        double deltaY = hare.getY() - y;

        return Math.toDegrees(Math.atan2(deltaY, deltaX));
    }

    public void clearDesireForParenthood() {
        desireForParenthood = 0;
    }

    private double deltaX() {
        return speed*Math.cos(Math.toRadians(speedAngle));
    }

    private double deltaY() {
        return speed*Math.sin(Math.toRadians(speedAngle));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}