package pl.pp.simulation;

import javax.swing.*;
import java.awt.*;

import static pl.pp.simulation.ProgramData.grassList;
import static pl.pp.simulation.ProgramData.hareList;

public class MyComponent extends JComponent {


    public MyComponent() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        Toolkit.getDefaultToolkit().sync();
        Graphics2D graphics2D = (Graphics2D) g;


        Rectangle limit = new Rectangle(0, 0, ProgramData.maxWidth, ProgramData.maxHeight);
        graphics2D.setPaint(Color.LIGHT_GRAY);
        graphics2D.fill(limit);

        for (Hare hare : hareList) {
            hare.draw(graphics2D);
        }

        for (Grass grass : grassList) {
            grass.draw(graphics2D);
        }


    }
}