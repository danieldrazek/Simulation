package pl.pp.simulation.model;

import pl.pp.simulation.utils.Utils;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Collections;
import java.util.Comparator;

import static pl.pp.simulation.ui.panels.ScrollPanel.textArea;
import static pl.pp.simulation.utils.ProgramData.deathHareList;
import static pl.pp.simulation.utils.ProgramData.grassList;
import static pl.pp.simulation.utils.Utils.getDistance;
import static pl.pp.simulation.utils.Utils.multipleHare;

public class Hare extends Animal {

    public Hare() {
        super();
    }

    public Hare(double x, double y) {           //nowy zajac
        super(x, y);
    }

    @Override
    public void init() {
        visibility = 55;
        maxSpeed = 10;
    }

    @Override
    public void move() {
        super.move();

        if (hunger > deathlyHunger) {        //umieranie
            deathHareList.add(this);
        }
    }

    public void draw(Graphics2D graphics2D) {
        Ellipse2D.Double hareEllipse = new Ellipse2D.Double(x, y, size, size);      //rysowanie zajecy
        graphics2D.setPaint(Color.RED);
        graphics2D.fill(hareEllipse);

    }

    public void changeSpeed() {
        if (getVisibleFoxes().size() > 0) {  //jezeli jest widoczny lis to zajac straci zycie
            Fox nearestFox = Collections.min(getVisibleFoxes(), Comparator.comparingDouble((Fox f) -> getDistance(this, f)));   //pobieranie najblizszego lisa
            runAwayFrom(nearestFox);        //uciekam od najblizszego lisa
        } else if (hunger >= minHunger && getVisibleGrass().size() > 0) {
            Grass nearestGrass = Collections.min(getVisibleGrass(), Comparator.comparingDouble((Grass hare) -> getDistance(this, hare)));   //pobieranie trawy
            adjustSpeedTo(nearestGrass);        //dostosowanie predkosci
            eatIfContact(nearestGrass);         //zjadanie
        } else if (desireForParenthood >= minDesireForParenthood && getVisibleHares().size() > 0 && hunger < minHunger * 2) {
            Hare nearestHare = Collections.min(getVisibleHares(), Comparator.comparingDouble((Hare hare) -> getDistance(this, hare)));
            adjustSpeedTo(nearestHare);
            multipleIfContact(nearestHare);
        } else {
            randomChangeSpeed();        //losowe poruszenie sie
        }
    }

    private void multipleIfContact(Hare nearestHare) {
        double distance = Utils.getDistance(nearestHare, this);

        if (distance < size) {
            multipleHare(this, nearestHare);
        }
    }

    private void eatIfContact(Grass nearestGrass) {
        double distance = Utils.getDistance(nearestGrass, this);    //warunkowe zjadanie

        if (distance < size) {
            eatGrass(nearestGrass);
        }
    }

    private void eatGrass(Grass nearestGrass) {
        grassList.remove(nearestGrass);
        textArea.append("\n Eating grass");
        hunger -= reducingHungerByGrass;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}