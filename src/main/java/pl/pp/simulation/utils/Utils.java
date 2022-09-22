package pl.pp.simulation.utils;

import pl.pp.simulation.model.*;

import static pl.pp.simulation.ui.panels.ScrollPanel.textArea;
import static pl.pp.simulation.utils.ProgramData.context;

public class Utils {
    public static double getDistance(Organism organism1, Organism organism2) {
        double deltaX = organism1.getX() - organism2.getX();
        double deltaY = organism1.getY() - organism2.getY();

        return Math.hypot(deltaX, deltaY);
    }

    public static void multipleHare(Hare hare1, Hare hare2) {
        hare1.clearDesireForParenthood();
        hare2.clearDesireForParenthood();
        HaresService haresService = context.getBean("haresService", HaresService.class);

        haresService.getNewHareList().add(new Hare(hare1.getX(), hare2.getY())); //tworzenie nowego zajaca i przypisanie wspolrzednych jednego rodzica

        textArea.append("\n Hares reproduction");
    }

    public static void multipleFoxes(Fox fox1, Fox fox2) {
        fox1.clearDesireForParenthood();
        fox2.clearDesireForParenthood();

        FoxesService foxesService = context.getBean("foxesService", FoxesService.class);

        foxesService.getNewFoxList().add(new Fox(fox1.getX(), fox2.getY())); //tworzenie nowego zajaca i przypisanie wspolrzednych jednego rodzica

        textArea.append("\n Hares reproduction");
    }
}