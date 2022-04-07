package pl.pp.simulation.model;

public class Organism {

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
}