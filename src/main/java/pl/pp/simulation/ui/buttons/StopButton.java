package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.Step;

import javax.annotation.PostConstruct;
import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.running;

public class StopButton extends JButton {

    private Step timer;
    private StartButton startButton;

    public StopButton(String text) {
        super(text);
        System.out.println("Constructor - StopButton");
    }

    @PostConstruct
    private void init() {
        setEnabled(false);
        addActionListener(e -> {
            running = false;
            setEnabled(false);
            startButton.setEnabled(true);
            timer.stop();
        });
    }

    public void setTimer(Step timer) {
        this.timer = timer;
    }

    public void setStartButton(StartButton startButton) {
        this.startButton = startButton;
    }
}