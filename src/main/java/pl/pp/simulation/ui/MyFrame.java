package pl.pp.simulation.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.pp.simulation.config.SimulationConfig;
import pl.pp.simulation.ui.panels.ControlPanel;
import pl.pp.simulation.ui.panels.ScrollPanel;
import pl.pp.simulation.utils.ProgramData;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private ControlPanel controlPanel;
    private ScrollPanel scrollPanel;
    private SimulationComponent simulationComponent;

    public MyFrame(ControlPanel controlPanel, ScrollPanel scrollPanel, SimulationComponent simulationComponent) throws HeadlessException {
        this.controlPanel = controlPanel;
        this.scrollPanel = scrollPanel;
        this.simulationComponent = simulationComponent;

        setTitle("Predator - Prey (simulation)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(ProgramData.frameWidth, ProgramData.frameHeight);
        setResizable(false);

        add(simulationComponent);
        add(controlPanel, BorderLayout.EAST);
        add(scrollPanel, BorderLayout.SOUTH);
    }

}