package pl.pp.simulation.ui.panels;

import pl.pp.simulation.ui.buttons.ResetButton;
import pl.pp.simulation.ui.buttons.StartButton;
import pl.pp.simulation.ui.buttons.StopButton;
import pl.pp.simulation.utils.ParameterModel;
import pl.pp.simulation.utils.ProgramData;

import javax.swing.*;
import java.awt.*;

import static pl.pp.simulation.ui.charts.SimulationChart.simulationChart;

public class ControlPanel extends JPanel {
    public static ParameterModel grassParameter;
    public static ParameterModel hareParameter;
    public static ParameterModel foxParameter;

    public static JLabel timeLabel;

    private static final ControlPanel controlPanel = new ControlPanel();

    public static ControlPanel getInstance() {
        return controlPanel;
    }

    private ControlPanel() {
        setLayout(new GridLayout(8, 1, 50, 50));

        setPreferredSize(new Dimension(ProgramData.frameWidth - ProgramData.maxWidth - 50, ProgramData.frameHeight));

        timeLabel = new JLabel("Time: 0");

        grassParameter = new ParameterModel("Grass", 50);
        hareParameter = new ParameterModel("Hares", 20);
        foxParameter = new ParameterModel("Foxes", 12);

        JButton chartButton = new JButton("Chart");

        chartButton.addActionListener(e -> simulationChart.setVisible(true));

        add(timeLabel);
        add(grassParameter.getPanel());
        add(hareParameter.getPanel());
        add(foxParameter.getPanel());
        add(StartButton.getInstance());
        add(StopButton.getInstance());
        add(ResetButton.getInstance());
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

}