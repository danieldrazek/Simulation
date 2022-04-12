package pl.pp.simulation;

import pl.pp.simulation.ui.MyFrame;

import java.awt.*;

import static pl.pp.simulation.utils.ProgramData.timer;

public class Run {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MyFrame myFrame = new MyFrame();
            myFrame.setVisible(true);

            timer = new Step();
        });

    }
}