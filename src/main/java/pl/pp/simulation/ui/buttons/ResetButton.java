package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.Step;
import pl.pp.simulation.model.Foxes;
import pl.pp.simulation.model.GrassUtils;
import pl.pp.simulation.model.Hares;
import pl.pp.simulation.ui.panels.ControlPanel;

import javax.swing.*;

import static pl.pp.simulation.ui.charts.SimulationChart.simulationChart;
import static pl.pp.simulation.ui.panels.ScrollPanel.textArea;
import static pl.pp.simulation.utils.ProgramData.*;

public class ResetButton extends JButton {

    public ResetButton(StartButton startButton, StopButton stopButton, Step timer, String text) {
        super(text);
        System.out.println("Constructor - ResetButton");

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
        Hares.hareList.clear();
        GrassUtils.grassList.clear();
        Foxes.foxList.clear();
    }
}
