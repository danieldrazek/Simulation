package pl.pp.simulation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pp.simulation.Step;
import pl.pp.simulation.model.FoxesService;
import pl.pp.simulation.model.GrassService;
import pl.pp.simulation.model.HaresService;
import pl.pp.simulation.ui.MyFrame;
import pl.pp.simulation.ui.SimulationComponent;
import pl.pp.simulation.ui.buttons.ResetButton;
import pl.pp.simulation.ui.buttons.StartButton;
import pl.pp.simulation.ui.buttons.StopButton;
import pl.pp.simulation.ui.charts.SimulationChart;
import pl.pp.simulation.ui.panels.ControlPanel;
import pl.pp.simulation.ui.panels.ScrollPanel;
import pl.pp.simulation.utils.ParameterModel;

import javax.swing.*;

@Configuration
public class SimulationConfig {
    @Bean
    public StartButton startButton() {
        StartButton startButton = new StartButton("Start");
        startButton.setStopButton(stopButton());
        startButton.setTimer(timer());

        startButton.setFoxParameter(foxParameter());
        startButton.setGrassParameter(grassParameter());
        startButton.setHareParameter(hareParameter());

        startButton.setGrassService(grassService());
        startButton.setHaresService(haresService());
        startButton.setFoxesService(foxesService());
        return startButton;
    }

    @Bean
    public StopButton stopButton() {
        StopButton stopButton = new StopButton("Stop");
        stopButton.setTimer(timer());
        return stopButton;
    }

    @Bean
    public ResetButton resetButton() {
        ResetButton resetButton = new ResetButton("Reset");
        resetButton.setStartButton(startButton());
        resetButton.setStopButton(stopButton());
        resetButton.setTimer(timer());
        resetButton.setSimulationChart(simulationChart());
        resetButton.setTimeLabel(timeLabel());

        resetButton.setFoxParameter(foxParameter());
        resetButton.setGrassParameter(grassParameter());
        resetButton.setHareParameter(hareParameter());

        resetButton.setGrassService(grassService());
        resetButton.setFoxesService(foxesService());
        resetButton.setHaresService(haresService());
        return resetButton;
    }

    @Bean
    public GrassService grassService() {
        GrassService grassService = new GrassService();
        grassService.setSimulationChart(simulationChart());
        grassService.setGrassParameter(grassParameter());
        return grassService;
    }

    @Bean
    public HaresService haresService() {
        HaresService haresService = new HaresService();
        haresService.setSimulationChart(simulationChart());
        haresService.setHareParameter(hareParameter());
        return haresService;
    }

    @Bean
    public FoxesService foxesService() {
        FoxesService foxesService = new FoxesService();
        foxesService.setSimulationChart(simulationChart());
        foxesService.setFoxParameter(foxParameter());
        return foxesService;
    }

    @Bean
    public ParameterModel grassParameter() {
        return new ParameterModel("Grass", 50);
    }

    @Bean
    public ParameterModel hareParameter() {
        return new ParameterModel("Hares", 20);
    }

    @Bean
    public ParameterModel foxParameter() {
        return new ParameterModel("Foxes", 12);
    }

    @Bean
    public Step timer() {
        Step step = new Step();
        step.setSimulationComponent(simulationComponent());
        step.setGrassService(grassService());
        step.setHaresService(haresService());
        step.setFoxesService(foxesService());
        step.setTimeLabel(timeLabel());
        return step;
    }

    @Bean
    public JLabel timeLabel() {
        return new JLabel("Time: 0");
    }

    @Bean
    public ControlPanel controlPanel() {
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setResetButton(resetButton());
        controlPanel.setStartButton(startButton());
        controlPanel.setStopButton(stopButton());
        controlPanel.setSimulationChart(simulationChart());
        controlPanel.setTimeLabel(timeLabel());

        controlPanel.setFoxParameter(foxParameter());
        controlPanel.setGrassParameter(grassParameter());
        controlPanel.setHareParameter(hareParameter());
        return controlPanel;
    }

    @Bean
    public ScrollPanel scrollPanel() {
        return new ScrollPanel();
    }

    @Bean
    public SimulationChart simulationChart() {
        return new SimulationChart();
    }

    @Bean
    SimulationComponent simulationComponent() {
        SimulationComponent simulationComponent = new SimulationComponent();
        simulationComponent.setGrassService(grassService());
        simulationComponent.setFoxesService(foxesService());
        simulationComponent.setHaresService(haresService());
        return simulationComponent;
    }

    @Bean
    MyFrame myFrame() {
        MyFrame myFrame = new MyFrame();
        myFrame.setControlPanel(controlPanel());
        myFrame.setScrollPanel(scrollPanel());
        myFrame.setSimulationComponent(simulationComponent());
        return myFrame;
    }
}
