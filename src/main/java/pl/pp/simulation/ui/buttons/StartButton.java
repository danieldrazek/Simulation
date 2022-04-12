package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.model.Organisms;
import pl.pp.simulation.ui.panels.ControlPanel;

import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.*;

public class StartButton extends JButton {

    private static final StartButton START_BUTTON = new StartButton("Start");

    public static StartButton getInstance() {
        return START_BUTTON;
    }

    private StartButton(String text) {      //prywatny konstruktor
        super(text);
//        inicjalizacja StartButton
        addActionListener(e -> {

            if (!started) {
                Organisms.init();
            }
            running = true;
            started = true;

            StopButton.getInstance().setEnabled(true);
            setEnabled(false);

            ControlPanel.setNotEditableParameters();

            timer.start();
        });
    }
}
