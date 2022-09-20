package pl.pp.simulation.ui.panels;

import pl.pp.simulation.ui.buttons.ResetButton;
import pl.pp.simulation.ui.buttons.StartButton;
import pl.pp.simulation.ui.buttons.StopButton;
import pl.pp.simulation.utils.ParameterModel;
import pl.pp.simulation.utils.ProgramData;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

import static pl.pp.simulation.ui.charts.SimulationChart.simulationChart;

public class ControlPanel extends JPanel {
    public static ParameterModel grassParameter = new ParameterModel("Grass", 50);
    public static ParameterModel hareParameter = new ParameterModel("Hares", 20);
    public static ParameterModel foxParameter = new ParameterModel("Foxes", 12);

    public static JLabel timeLabel;

    private ResetButton resetButton;
    private StartButton startButton;
    private StopButton stopButton;

    public ControlPanel() {
        System.out.println("Constructor - ControlPanel");
    }

    @PostConstruct
    private void init(){
        setLayout(new GridLayout(8, 1, 50, 50));

        setPreferredSize(new Dimension(ProgramData.frameWidth - ProgramData.maxWidth - 50, ProgramData.frameHeight));

        timeLabel = new JLabel("Time: 0");

        JButton chartButton = new JButton("Chart");

        chartButton.addActionListener(e -> simulationChart.setVisible(true));

        add(timeLabel);
        add(grassParameter.getPanel());
        add(hareParameter.getPanel());
        add(foxParameter.getPanel());
        add(startButton);
        add(stopButton);
        add(resetButton);
        add(chartButton);
    }

    public static void setEditableParameters() {
        grassParameter.setEditable(true);
        hareParameter.setEditable(true);
        foxParameter.setEditable(true);
    }

    public static void setNotEditableParameters() {
        grassParameter.setEditable(false);
        hareParameter.setEditable(false);
        foxParameter.setEditable(false);
    }

    public void setResetButton(ResetButton resetButton) {
        this.resetButton = resetButton;
    }

    public void setStartButton(StartButton startButton) {
        this.startButton = startButton;
    }

    public void setStopButton(StopButton stopButton) {
        this.stopButton = stopButton;
    }
}