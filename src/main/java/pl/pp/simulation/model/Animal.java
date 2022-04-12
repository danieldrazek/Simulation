package pl.pp.simulation.model;

import pl.pp.simulation.utils.ProgramData;
import pl.pp.simulation.utils.Utils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static pl.pp.simulation.utils.Utils.getDistance;

public abstract class Animal extends Organism {
    public static int size = 10;
    public static int minDesireForParenthood = 50;
    public static int minHunger = 50;
    public static int deathlyHunger = 200;
    public static int reducingHungerByGrass = 100;
    public static int reducingHungerByHare = 300;
    public static int maxX = ProgramData.maxWidth - size;
    public static int maxY = ProgramData.maxHeight - size;
    private static final Random random = new Random();

    protected double speed;
    protected double speedAngle;
    protected int desireForParenthood;
    protected int hunger;
    public int maxSpeed = 10;
    public int visibility = 40;

    public Animal() {
        init();
        x = random.nextInt(maxX);
        y = random.nextInt(maxY);
        speed = random.nextInt(maxSpeed);
        speedAngle = random.nextInt(360);
        desireForParenthood = minDesireForParenthood;
        hunger = 0;
    }

    public Animal(double x, double y) {           //nowy zwierzak
        init();
        this.x = x;
        this.y = y;
        speed = 0;
        speedAngle = random.nextInt(360);
        desireForParenthood = 0;
        hunger = minHunger * 2;
    }

    public abstract void init();

    public void move() {        //porusznie sie zajecy
        changeSpeed();

        x += deltaX();
        y += deltaY();

        validatePosition();

        desireForParenthood++;
        hunger++;
    }

    public abstract void changeSpeed();

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

    public void randomChangeSpeed() {
        int deltaSpeed = random.nextInt(5) - 2;     //zakres -2 do 2
        int deltaAngle = random.nextInt(21) - 10;   //zakres -10 do 10

        speed += deltaSpeed;
        speedAngle += deltaAngle;

        if (speed > maxSpeed) {
            speed = maxSpeed;
        }

        if (speed < 0) {
            speed = 0;
        }
    }

    protected void adjustSpeedTo(Organism organism) {
        double distance = Utils.getDistance(organism, this);        //pobieram dystans

        speed++;
        speedAngle = getAngleTo(organism);

        if (speed > maxSpeed) {
            speed = maxSpeed;
        }

        if (speed > distance) {
            speed = distance;
        }
    }

    protected void runAwayFrom(Organism organism) {
        speed++;
        speedAngle = getAngleTo(organism) + 180;

        if (speed > maxSpeed) {
            speed = maxSpeed;
        }
    }

    public List<Fox> getVisibleFoxes() {        //lista widocznych zajacow
        return Foxes.foxList.stream()
                .filter(fox -> fox != this && getDistance(this, fox) <= visibility)
                .collect(Collectors.toList());
    }

    public List<Hare> getVisibleHares() {        //lista widocznych zajacow
        return Hares.hareList.stream()
                .filter(hare -> hare != this && getDistance(this, hare) <= visibility)
                .collect(Collectors.toList());
    }

    public List<Grass> getVisibleGrass() {        //lista widocznych zajacow
        return GrassUtils.grassList.stream()
                .filter(grass -> getDistance(this, grass) <= visibility)
                .collect(Collectors.toList());
    }

    public double getAngleTo(Organism organism) {
        double deltaX = organism.getX() - x;
        double deltaY = organism.getY() - y;

        return Math.toDegrees(Math.atan2(deltaY, deltaX));  //radiany zamieniam na stopnie
    }

    public void clearDesireForParenthood() {
        desireForParenthood = 0;
    }

    private double deltaX() {
        return speed * Math.cos(Math.toRadians(speedAngle));
    }

    private double deltaY() {
        return speed * Math.sin(Math.toRadians(speedAngle));
    }
}
