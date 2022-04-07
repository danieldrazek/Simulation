package pl.pp.simulation;

import pl.pp.simulation.model.Fox;
import pl.pp.simulation.model.Grass;
import pl.pp.simulation.model.Hare;

import javax.swing.*;

import static pl.pp.simulation.utils.Components.*;
import static pl.pp.simulation.utils.ProgramData.*;

public class Step extends Timer {

    public Step() {
        super(40, e -> {
            steps++;
            timeLabel.setText("Czas: " + steps);

            if (steps % 2 == 0) {
                grassList.add(new Grass());
            }

            newHareList.clear();
            deathHareList.clear();
            for (Hare hare :hareList) {
                hare.move();
            }

            hareList.addAll(newHareList);
            hareList.removeAll(deathHareList);


            newFoxList.clear();
            deathFoxList.clear();
            for (Fox fox :foxList) {
                fox.move();
            }

            foxList.addAll(newFoxList);
            foxList.removeAll(deathFoxList);

            int hareAmount = hareList.size();
            hareParameter.setValue(hareAmount);
            simulationChart.getHareSeries().add(steps, hareAmount);

            int grassAmount = grassList.size();
            grassParameter.setValue(grassAmount);
            simulationChart.getGrassSeries().add(steps, grassAmount);

            int foxAmount = foxList.size();
            foxParameter.setValue(foxAmount);
            simulationChart.getFoxSeries().add(steps, foxAmount);

            myComponent.repaint();
        });
    }
}