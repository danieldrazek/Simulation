package pl.pp.simulation.model;

import java.awt.*;

public abstract class Organism {

    protected double x;
    protected double y;

    public Organism() {
    }

    public Organism(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public abstract void draw(Graphics2D graphics2D);


}