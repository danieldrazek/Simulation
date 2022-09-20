package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.Step;

import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.*;

public class StopButton extends JButton {

//      TODO fix this
//    public StopButton(StartButton startButton, String text) {
    public StopButton(Step timer, String text) {
        super(text);
        System.out.println("Constructor - StopButton");

        setEnabled(false);
        addActionListener(e -> {
            running = false;
            setEnabled(false);
//            TODO fix this
//            startButton.setEnabled(true);
            timer.stop();
        });
    }
}