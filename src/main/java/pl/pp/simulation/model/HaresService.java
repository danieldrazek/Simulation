package pl.pp.simulation.model;

import pl.pp.simulation.ui.charts.SimulationChart;
import pl.pp.simulation.ui.panels.ControlPanel;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static pl.pp.simulation.utils.ProgramData.steps;

public class HaresService {

    private final List<Hare> hareList = new LinkedList<>();
    private final List<Hare> newHareList = new LinkedList<>();
    private final List<Hare> deathHareList = new LinkedList<>();

    public void move() {
        getNewHareList().clear();
        getDeathHareList().clear();
        for (Hare hare : getHareList()) {
            hare.move();
        }

        getHareList().addAll(getNewHareList());
        getHareList().removeAll(getDeathHareList());
    }

    public void updateAmount() {
        int hareAmount = getHareList().size();
        ControlPanel.hareParameter.setValue(hareAmount);
        SimulationChart.simulationChart.getHareSeries().add(steps, hareAmount);
    }

    public void draw(Graphics2D graphics2D) {
        for (Hare hare : hareList) {              //iterujemy przez liste zajecy
            hare.draw(graphics2D);
        }
    }

    public List<Hare> getHareList() {
        return hareList;
    }

    public List<Hare> getNewHareList() {
        return newHareList;
    }

    public List<Hare> getDeathHareList() {
        return deathHareList;
    }

}
