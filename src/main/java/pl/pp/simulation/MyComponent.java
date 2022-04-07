package pl.pp.simulation;

import pl.pp.simulation.model.Fox;
import pl.pp.simulation.model.Grass;
import pl.pp.simulation.model.Hare;
import pl.pp.simulation.utils.ProgramData;

import javax.swing.*;
import java.awt.*;

import static pl.pp.simulation.utils.ProgramData.*;

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

        for (Fox grass : foxList) {
            grass.draw(graphics2D);
        }

    }
}