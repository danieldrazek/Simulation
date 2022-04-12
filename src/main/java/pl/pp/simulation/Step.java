package pl.pp.simulation;

import pl.pp.simulation.model.Fox;
import pl.pp.simulation.model.Grass;
import pl.pp.simulation.model.Hare;
import pl.pp.simulation.ui.SimulationComponent;
import pl.pp.simulation.ui.charts.SimulationChart;
import pl.pp.simulation.ui.panels.ControlPanel;

import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.*;

public class Step extends Timer {

    public Step() {
        super(40, e -> {
            steps++;
            ControlPanel.timeLabel.setText("Time: " + steps);

            if (steps % 2 == 0) {                //dodawanie nowej trawy co 5 krok
                grassList.add(new Grass());
            }

            newHareList.clear();
            deathHareList.clear();
            for (Hare hare : hareList) {
                hare.move();
            }

            hareList.addAll(newHareList);
            hareList.removeAll(deathHareList);


            newFoxList.clear();
            deathFoxList.clear();
            for (Fox fox : foxList) {
                fox.move();
            }

            foxList.addAll(newFoxList);
            foxList.removeAll(deathFoxList);

            int hareAmount = hareList.size();
            ControlPanel.hareParameter.setValue(hareAmount);
            SimulationChart.simulationChart.getHareSeries().add(steps, hareAmount);

            int grassAmount = grassList.size();
            ControlPanel.grassParameter.setValue(grassAmount);
            SimulationChart.simulationChart.getGrassSeries().add(steps, grassAmount);

            int foxAmount = foxList.size();
            ControlPanel.foxParameter.setValue(foxAmount);
            SimulationChart.simulationChart.getFoxSeries().add(steps, foxAmount);

            SimulationComponent.getInstance().repaint();
        });
    }
}