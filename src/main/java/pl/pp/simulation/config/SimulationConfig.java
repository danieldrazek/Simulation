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
import pl.pp.simulation.ui.panels.ControlPanel;
import pl.pp.simulation.ui.panels.ScrollPanel;

@Configuration
public class SimulationConfig {
    @Bean
    public StartButton startButton() {
        StartButton startButton = new StartButton("Start");
        startButton.setStopButton(stopButton());
        startButton.setTimer(timer());
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
        resetButton.setGrassService(grassService());
        resetButton.setFoxesService(foxesService());
        resetButton.setHaresService(haresService());
        return resetButton;
    }

    @Bean
    public GrassService grassService(){
        return new GrassService();
    }

    @Bean
    public HaresService haresService() {
        return new HaresService();
    }

    @Bean
    public FoxesService foxesService() {
        return new FoxesService();
    }
    @Bean
    public Step timer() {
        Step step = new Step();
        step.setSimulationComponent(simulationComponent());
        step.setGrassService(grassService());
        step.setHaresService(haresService());
        step.setFoxesService(foxesService());
        return step;
    }
    @Bean
    public ControlPanel controlPanel(){
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setResetButton(resetButton());
        controlPanel.setStartButton(startButton());
        controlPanel.setStopButton(stopButton());
        return controlPanel;
    }

    @Bean
    public ScrollPanel scrollPanel() {
        return new ScrollPanel();
    }

    @Bean
    SimulationComponent simulationComponent(){
        SimulationComponent simulationComponent = new SimulationComponent();
        simulationComponent.setGrassService(grassService());
        simulationComponent.setFoxesService(foxesService());
        simulationComponent.setHaresService(haresService());
        return simulationComponent;
    }

    @Bean
    MyFrame myFrame(){
        MyFrame myFrame = new MyFrame();
        myFrame.setControlPanel(controlPanel());
        myFrame.setScrollPanel(scrollPanel());
        myFrame.setSimulationComponent(simulationComponent());
        return myFrame;
    }
}
