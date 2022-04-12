package pl.pp.simulation.model;

import java.awt.*;

public class Organisms {

    public static void clear() {
        Hares.hareList.clear();
        GrassUtils.grassList.clear();
        Foxes.foxList.clear();
    }

    public static void init() {
        GrassUtils.init();
        Hares.init();
        Foxes.init();
    }

    public static void draw(Graphics2D graphics2D) {
        GrassUtils.draw(graphics2D);
        Hares.draw(graphics2D);
        Foxes.draw(graphics2D);
    }

    public static void updateAmount() {
        GrassUtils.UpdateAmount();
        Hares.updateAmount();
        Foxes.updateAmount();
    }
}
