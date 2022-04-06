package pl.pp.simulation;

import static pl.pp.simulation.Components.*;
import static pl.pp.simulation.ProgramData.hareList;
import static pl.pp.simulation.ProgramData.newHareList;

public class Utils {
    public static double getDistance(Hare hare1, Hare hare2) {
        double deltaX = hare1.getX() - hare2.getX();
        double deltaY = hare1.getY() - hare2.getY();

        return Math.hypot(deltaX, deltaY);
    }

    public static void multiple(Hare hare1, Hare hare2) {
        hare1.clearDesireForParenthood();
        hare2.clearDesireForParenthood();

        newHareList.add(new Hare(hare1.getX(), hare1.getY()));

        textArea.append("\n Rozmnożenie zająców");
    }
}