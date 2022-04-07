package pl.pp.simulation;

import pl.pp.simulation.model.Hare;

import javax.swing.*;

import static pl.pp.simulation.utils.Components.*;
import static pl.pp.simulation.utils.ProgramData.*;

public class Step extends Timer {

    public Step() {
        super(40, e -> {
            steps++;
            timeLabel.setText("Czas: " + steps);

            newHareList.clear();
            for (Hare hare :hareList) {
                hare.move();
            }

            hareList.addAll(newHareList);

            int hareAmount = hareList.size();
            hareParameter.setValue(hareAmount);
            simulationChart.addPoint(steps, hareAmount);

            myComponent.repaint();
        });
    }
}