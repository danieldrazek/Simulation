package pl.pp.simulation;

import pl.pp.simulation.model.Foxes;
import pl.pp.simulation.model.GrassUtils;
import pl.pp.simulation.model.Hares;
import pl.pp.simulation.ui.SimulationComponent;
import pl.pp.simulation.ui.panels.ControlPanel;

import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.steps;

public class Step {
    private Timer timer;

    public Step(SimulationComponent simulationComponent) {
        System.out.println("Constructor - Step");
        timer = new Timer(40, e -> {
            steps++;
            ControlPanel.timeLabel.setText("Time: " + steps);

            GrassUtils.grow();

            Hares.move();
            Foxes.move();

            updateAmount();

            simulationComponent.repaint();
        });
    }

    public void stop() {
        timer.stop();
    }

    public void start() {
        timer.start();
    }

    public void updateAmount() {
        GrassUtils.UpdateAmount();
        Hares.updateAmount();
        Foxes.updateAmount();
    }
}