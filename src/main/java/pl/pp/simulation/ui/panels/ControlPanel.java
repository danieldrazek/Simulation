package pl.pp.simulation.ui.panels;

import pl.pp.simulation.ui.buttons.ResetButton;
import pl.pp.simulation.ui.buttons.StartButton;
import pl.pp.simulation.ui.buttons.StopButton;
import pl.pp.simulation.utils.ParameterModel;
import pl.pp.simulation.utils.ProgramData;

import javax.swing.*;
import java.awt.*;

import static pl.pp.simulation.ui.charts.SimulationChart.simulationChart;

public class ControlPanel extends JPanel{
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

        ControlPanel.timeLabel = new JLabel("Time: 0");

        ControlPanel.grassParameter = new ParameterModel("Grass", 50);
        ControlPanel.hareParameter = new ParameterModel("Hares", 20);
        ControlPanel.foxParameter = new ParameterModel("Foxes", 12);

        JButton chartButton = new JButton("Chart");

        chartButton.addActionListener(e -> {
            simulationChart.setVisible(true);
        });

        add(ControlPanel.timeLabel);
        add(ControlPanel.grassParameter.getPanel());
        add(ControlPanel.hareParameter.getPanel());
        add(ControlPanel.foxParameter.getPanel());
        add(StartButton.getInstance());
        add(StopButton.getInstance());
        add(ResetButton.getInstance());
        add(chartButton);
    }

}