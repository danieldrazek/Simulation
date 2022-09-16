package pl.pp.simulation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pp.simulation.ui.MyFrame;
import pl.pp.simulation.ui.SimulationComponent;
import pl.pp.simulation.ui.panels.ControlPanel;
import pl.pp.simulation.ui.panels.ScrollPanel;

@Configuration
public class SimulationConfig {

    @Bean
    public ControlPanel controlPanel(){
        return new ControlPanel();
    }

    @Bean
    public ScrollPanel scrollPanel() {
        return new ScrollPanel();
    }

    @Bean
    SimulationComponent simulationComponent(){
        return new SimulationComponent();
    }

    @Bean
    MyFrame myFrame(){
        return new MyFrame(controlPanel(), scrollPanel(), simulationComponent());
    }
}
