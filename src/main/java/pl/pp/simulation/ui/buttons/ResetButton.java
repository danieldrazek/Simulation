package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.Step;
import pl.pp.simulation.model.FoxesService;
import pl.pp.simulation.model.GrassService;
import pl.pp.simulation.model.HaresService;
import pl.pp.simulation.ui.panels.ControlPanel;

import javax.annotation.PostConstruct;
import javax.swing.*;

import static pl.pp.simulation.ui.charts.SimulationChart.simulationChart;
import static pl.pp.simulation.ui.panels.ScrollPanel.textArea;
import static pl.pp.simulation.utils.ProgramData.*;

public class ResetButton extends JButton {

    private StartButton startButton;
    private StopButton stopButton;
    private Step timer;
    private GrassService grassService;
    private HaresService haresService;
    private FoxesService foxesService;


    public ResetButton(String text) {
        super(text);
        System.out.println("Constructor - ResetButton");
    }

    @PostConstruct
    private void init(){
        addActionListener(e -> {
            running = false;
            started = false;

            textArea.setText("");

            simulationChart.clear();

            timer.stop();

            clear();

            stopButton.setEnabled(true);
            startButton.setEnabled(false);

            ControlPanel.setEditableParameters();

            steps = 0;
            ControlPanel.timeLabel.setText("Time: 0");
        });
    }

    public void clear() {
        haresService.getHareList().clear();
        grassService.getGrassList().clear();
        foxesService.getFoxList().clear();
    }

    public void setStartButton(StartButton startButton) {
        this.startButton = startButton;
    }

    public void setStopButton(StopButton stopButton) {
        this.stopButton = stopButton;
    }

    public void setTimer(Step timer) {
        this.timer = timer;
    }

    public void setGrassService(GrassService grassService) {
        this.grassService = grassService;
    }

    public void setHaresService(HaresService haresService) {
        this.haresService = haresService;
    }

    public void setFoxesService(FoxesService foxesService) {
        this.foxesService = foxesService;
    }
}
