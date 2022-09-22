package pl.pp.simulation.ui.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class SimulationChart extends JFrame {

    private XYSeries hareSeries;
    private XYSeries grassSeries;
    private XYSeries foxSeries;

    public SimulationChart() {
        System.out.println("Constructor - SimulationChart");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Chart");

        XYSeriesCollection dataSet = getDataSet();
        JFreeChart freeChart = getChart(dataSet);

        ChartPanel chartPanel = new ChartPanel(freeChart);

        add(chartPanel);
        pack();
    }

    private JFreeChart getChart(XYSeriesCollection dataSet) {
        return ChartFactory.createXYLineChart(
                "Quantity of organisms depending on time",
                "time",
                "quantity",
                dataSet
        );
    }

    private XYSeriesCollection getDataSet() {
        XYSeriesCollection dataSet = new XYSeriesCollection();

        hareSeries = new XYSeries("Hares");             //tworze serie zajacow
        grassSeries = new XYSeries("Grass");             //tworze serie trawy
        foxSeries = new XYSeries("Foxes");             //tworze serie lisow

        dataSet.addSeries(hareSeries);                      //dodaje serie do kolekcji
        dataSet.addSeries(grassSeries);
        dataSet.addSeries(foxSeries);
        return dataSet;
    }

    public XYSeries getHareSeries() {
        return hareSeries;
    }

    public XYSeries getGrassSeries() {
        return grassSeries;
    }

    public XYSeries getFoxSeries() {
        return foxSeries;
    }

    public void clear() {
        grassSeries.clear();
        hareSeries.clear();
        foxSeries.clear();
    }
}
