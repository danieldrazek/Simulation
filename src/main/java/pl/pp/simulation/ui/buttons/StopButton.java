package pl.pp.simulation.ui.buttons;

import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.running;
import static pl.pp.simulation.utils.ProgramData.timer;

public class StopButton extends JButton {

    private static final StopButton stopButton = new StopButton("Stop");

    public static StopButton getInstance() {    //tworzy tylko 1 instancje klasy (wskazuje na ten jedyny stopButton)
        return stopButton;
    }

    private StopButton(String text) {
        super(text);

        setEnabled(false);
        addActionListener(e -> {
            running = false;

            setEnabled(false);
            StartButton.getInstance().setEnabled(true);

            timer.stop();
        });
    }
}