package pl.pp.simulation.ui;

import pl.pp.simulation.model.Fox;
import pl.pp.simulation.model.Grass;
import pl.pp.simulation.model.Hare;
import pl.pp.simulation.utils.ProgramData;

import javax.swing.*;
import java.awt.*;

import static pl.pp.simulation.utils.ProgramData.*;

public class SimulationComponent extends JComponent {


    private static final SimulationComponent SIMULATION_COMPONENT = new SimulationComponent();

    public static SimulationComponent getInstance() {
        return SIMULATION_COMPONENT;
    }

    private SimulationComponent() {

    }

    @Override
    protected void paintComponent(Graphics g) {     //met. rysujaca lisy i wilki
        Toolkit.getDefaultToolkit().sync();
        Graphics2D graphics2D = (Graphics2D) g;

        Rectangle limit = new Rectangle(0, 0, ProgramData.maxWidth, ProgramData.maxHeight);
        graphics2D.setPaint(Color.LIGHT_GRAY);
        graphics2D.fill(limit);

        for (Hare hare : hareList) {    //iterujemy przez liste zajecy
            hare.draw(graphics2D);
        }

        for (Grass grass : grassList) {
            grass.draw(graphics2D);
        }

        for (Fox fox : foxList) {
            fox.draw(graphics2D);
        }


    }
}