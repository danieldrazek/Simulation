package pl.pp.simulation.ui;

import pl.pp.simulation.ui.panels.ControlPanel;
import pl.pp.simulation.ui.panels.ScrollPanel;
import pl.pp.simulation.utils.ProgramData;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        setTitle("Predator - Prey (simulation)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(ProgramData.frameWidth, ProgramData.frameHeight);
        setResizable(false);

        add(SimulationComponent.getInstance());
        add(ControlPanel.getInstance(), BorderLayout.EAST);
        add(ScrollPanel.getInstance(), BorderLayout.SOUTH);
    }

}