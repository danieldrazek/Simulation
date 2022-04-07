package pl.pp.simulation.utils;

import pl.pp.simulation.model.Grass;
import pl.pp.simulation.model.Hare;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class ProgramData {
    public static int frameWidth = 1000;
    public static int frameHeight = 850;

    public static int maxWidth = 800;
    public static int maxHeight = 700;

    public static boolean started = false;
    public static boolean running = false;

    public static Timer timer;
    public static long steps = 0;

    public static List<Hare> hareList = new LinkedList<>();
    public static List<Hare> newHareList = new LinkedList<>();
    public static List<Hare> deathHareList = new LinkedList<>();
    public static List<Grass> grassList = new LinkedList<>();

}