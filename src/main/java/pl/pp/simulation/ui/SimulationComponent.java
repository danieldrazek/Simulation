package pl.pp.simulation.ui;

import pl.pp.simulation.model.Organisms;
import pl.pp.simulation.utils.ProgramData;

import javax.swing.*;
import java.awt.*;

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

        Organisms.draw(graphics2D);

    }
}