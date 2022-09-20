package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.Step;
import pl.pp.simulation.model.*;
import pl.pp.simulation.ui.panels.ControlPanel;
import pl.pp.simulation.utils.ParameterModel;

import javax.annotation.PostConstruct;
import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.*;

public class StartButton extends JButton {
    public ParameterModel grassParameter = ControlPanel.grassParameter;
    public ParameterModel hareParameter  = ControlPanel.hareParameter;
    public ParameterModel foxParameter = ControlPanel.foxParameter;

    private Step timer;
    private StopButton stopButton;


    public StartButton(String text) {      //prywatny konstruktor
        super(text);
        System.out.println("Constructor - StartButton");
    }

    @PostConstruct
    private void init(){
        //        inicjalizacja StartButton
        stopButton.setStartButton(this);
        addActionListener(e -> {

            if (!started) {
                createObject();
            }
            running = true;
            started = true;

            stopButton.setEnabled(true);
            setEnabled(false);

            ControlPanel.setNotEditableParameters();

            timer.start();
        });
    }

    public void createObject() {
        for (int i = 0; i < ControlPanel.hareParameter.getValue(); i++) {        //generowanie/losowanie zajacow
            Hares.hareList.add(new Hare());
        }
        for (int i = 0; i < ControlPanel.grassParameter.getValue(); i++) {
            GrassUtils.grassList.add(new Grass());
        }
        for (int i = 0; i < ControlPanel.foxParameter.getValue(); i++) {
            Foxes.foxList.add(new Fox());
        }
    }

    public void setTimer(Step timer) {
        this.timer = timer;
    }

    public void setStopButton(StopButton stopButton) {
        this.stopButton = stopButton;
    }
}
