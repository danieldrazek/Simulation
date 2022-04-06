package pl.pp.simulation;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Grass {
    public static int size = 8;

    private double x;
    private double y;

    public Grass() {
        Random random = new Random();
        x = random.nextInt(ProgramData.maxWidth - size);
        y = random.nextInt(ProgramData.maxHeight - size);
    }


    public void draw(Graphics2D graphics2D) {
        Ellipse2D.Double hareEllipse = new Ellipse2D.Double(x, y, size, size);
        graphics2D.setPaint(new Color(49, 189, 31));
        graphics2D.fill(hareEllipse);
    }
}