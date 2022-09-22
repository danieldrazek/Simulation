package pl.pp.simulation.ui;

import pl.pp.simulation.model.FoxesService;
import pl.pp.simulation.model.GrassService;
import pl.pp.simulation.model.HaresService;
import pl.pp.simulation.utils.ProgramData;

import javax.swing.*;
import java.awt.*;

public class SimulationComponent extends JComponent {

    private GrassService grassService;
    private HaresService haresService;
    private FoxesService foxesService;

    public SimulationComponent() {
        System.out.println("Constructor - SimulationComponent");
    }

    @Override
    protected void paintComponent(Graphics g) {     //met. rysujaca lisy i wilki
        Toolkit.getDefaultToolkit().sync();
        Graphics2D graphics2D = (Graphics2D) g;

        Rectangle limit = new Rectangle(0, 0, ProgramData.maxWidth, ProgramData.maxHeight);
        graphics2D.setPaint(Color.LIGHT_GRAY);
        graphics2D.fill(limit);

        draw(graphics2D);
    }

    public void draw(Graphics2D graphics2D) {
        grassService.draw(graphics2D);
        haresService.draw(graphics2D);
        foxesService.draw(graphics2D);
    }

    public void setGrassService(GrassService grassService) {
        this.grassService = grassService;
    }

    public void setHaresService(HaresService haresService) {
        this.haresService = haresService;
    }

    public void setFoxesService(FoxesService foxesService) {
        this.foxesService = foxesService;
    }
}