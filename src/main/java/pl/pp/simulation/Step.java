package pl.pp.simulation;

import pl.pp.simulation.model.FoxesService;
import pl.pp.simulation.model.GrassService;
import pl.pp.simulation.model.HaresService;
import pl.pp.simulation.ui.SimulationComponent;
import pl.pp.simulation.ui.panels.ControlPanel;

import javax.annotation.PostConstruct;
import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.steps;

public class Step {
    private Timer timer;

    private GrassService grassService;
    private FoxesService foxesService;
    private HaresService haresService;

    private SimulationComponent simulationComponent;

    public Step() {
        System.out.println("Constructor - Step");
    }

    @PostConstruct
    private void init() {
        timer = new Timer(40, e -> {
            steps++;
            ControlPanel.timeLabel.setText("Time: " + steps);

            grassService.grow();

            haresService.move();
            foxesService.move();

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
        grassService.updateAmount();
        haresService.updateAmount();
        foxesService.updateAmount();
    }

    public void setGrassService(GrassService grassService) {
        this.grassService = grassService;
    }

    public void setSimulationComponent(SimulationComponent simulationComponent) {
        this.simulationComponent = simulationComponent;
    }

    public void setFoxesService(FoxesService foxesService) {
        this.foxesService = foxesService;
    }

    public void setHaresService(HaresService haresService) {
        this.haresService = haresService;
    }
}