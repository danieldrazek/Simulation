package pl.pp.simulation.model;

import pl.pp.simulation.utils.Utils;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Collections;
import java.util.Comparator;

import static pl.pp.simulation.ui.panels.ScrollPanel.textArea;
import static pl.pp.simulation.utils.Utils.getDistance;
import static pl.pp.simulation.utils.Utils.multipleFoxes;

public class Fox extends Animal {

    public Fox() {
        super();
    }

    public Fox(double x, double y) {           //nowy lis
        super(x, y);
    }

    @Override
    public void init() {
        visibility = 50;
        maxSpeed = 12;
    }

    @Override
    public void move() {
        super.move();

        if (hunger > deathlyHunger) {        //umieranie jesli smiertelnie glodny
            foxesService.getDeathFoxList().add(this);         //dodawanie do listy martwych lisow
        }
    }

    public void draw(Graphics2D graphics2D) {
        Ellipse2D.Double hareEllipse = new Ellipse2D.Double(x, y, size, size);      //rysowanie lisow
        graphics2D.setPaint(new Color(67, 164, 36));
        graphics2D.fill(hareEllipse);

    }

    public void changeSpeed() {
        if (hunger >= minHunger && getVisibleHares().size() > 0) {      //jesli glodny (zjadanie)
            Hare nearestHare = Collections.min(getVisibleHares(), Comparator.comparingDouble((Hare hare) -> getDistance(this, hare)));   //pobieranie trawy
            adjustSpeedTo(nearestHare);        //dostosowanie predkosci
            eatIfContact(nearestHare);         //zjadanie
        } else if (desireForParenthood >= minDesireForParenthood && getVisibleFoxes().size() > 0 && hunger < minHunger * 2) {
            Fox nearestFox = Collections.min(getVisibleFoxes(), Comparator.comparingDouble((Fox fox) -> getDistance(this, fox)));
            adjustSpeedTo(nearestFox);
            multipleIfContact(nearestFox);
        } else {
            randomChangeSpeed();
        }
    }

    private void multipleIfContact(Fox nearestHare) {
        double distance = Utils.getDistance(nearestHare, this);

        if (distance < size) {
            multipleFoxes(this, nearestHare);
        }
    }

    private void eatIfContact(Hare hare) {
        double distance = Utils.getDistance(hare, this);    //warunkowe zjadanie

        if (distance < size) {
            eatHare(hare);
        }
    }

    private void eatHare(Hare hare) {
        haresService.getHareList().remove(hare);
        textArea.append("\n Eating hares");
        hunger -= reducingHungerByHare;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
