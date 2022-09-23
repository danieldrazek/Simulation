package pl.pp.simulation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
import java.util.Objects;

@Configuration
@PropertySource("simulation.properties")
public class SimulationConfig {
    @Autowired
    private Environment environment;

    @Bean
    public StartButton startButton() {
        StartButton startButton = new StartButton(environment.getProperty("button.start.text"));
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
        StopButton stopButton = new StopButton(environment.getProperty("button.stop.text"));
        stopButton.setTimer(timer());
        return stopButton;
    }

    @Bean
    public ResetButton resetButton() {
        ResetButton resetButton = new ResetButton(environment.getProperty("button.reset.text"));
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
        String label = environment.getProperty("parameter.grass.label");
        int defaultValue = Integer.parseInt(Objects.requireNonNull(environment.getProperty("parameter.grass.value")));
        return new ParameterModel(label, defaultValue);
    }

    @Bean
    public ParameterModel hareParameter() {
        String label = environment.getProperty("parameter.hare.label");
        int defaultValue = Integer.parseInt(Objects.requireNonNull(environment.getProperty("parameter.hare.value")));
        return new ParameterModel(label, defaultValue);
    }

    @Bean
    public ParameterModel foxParameter() {
        String label = environment.getProperty("parameter.fox.label");
        int defaultValue = Integer.parseInt(Objects.requireNonNull(environment.getProperty("parameter.fox.value")));
        return new ParameterModel(label, defaultValue);
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
        return new JLabel(environment.getProperty("time.label"));
    }

    @Bean
    public JButton chartButton() {
        return new JButton(environment.getProperty("chart.button.text"));
    }

    @Bean
    public ControlPanel controlPanel() {
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setResetButton(resetButton());
        controlPanel.setStartButton(startButton());
        controlPanel.setStopButton(stopButton());
        controlPanel.setSimulationChart(simulationChart());
        controlPanel.setTimeLabel(timeLabel());
        controlPanel.setChartButton(chartButton());

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
