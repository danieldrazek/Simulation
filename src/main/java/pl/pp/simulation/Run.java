package pl.pp.simulation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.pp.simulation.config.SimulationConfig;
import pl.pp.simulation.ui.MyFrame;
import pl.pp.simulation.ui.SimulationComponent;

import java.awt.*;

import static pl.pp.simulation.utils.ProgramData.timer;

public class Run {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SimulationConfig.class);
        SimulationComponent simulationComponent = context.getBean("simulationComponent", SimulationComponent.class);
        MyFrame myFrame = context.getBean("myFrame", MyFrame.class);

        myFrame.setVisible(true);

        timer = new Step(simulationComponent);
    }
}