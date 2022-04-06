package pl.pp.simulation;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Hare {
    public static int size = 10;

    private double x;
    private double y;

    public Hare() {
        Random random = new Random();
        x = random.nextInt(ProgramData.maxWidth - size);
        y = random.nextInt(ProgramData.maxHeight - size);
    }


    public void draw(Graphics2D graphics2D) {
        Ellipse2D.Double hareEllipse = new Ellipse2D.Double(x, y, size, size);
        graphics2D.setPaint(Color.DARK_GRAY);
        graphics2D.fill(hareEllipse);
    }
}