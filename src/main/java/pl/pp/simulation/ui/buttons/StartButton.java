package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.Step;
import pl.pp.simulation.model.*;
import pl.pp.simulation.utils.ParameterModel;

import javax.annotation.PostConstruct;
import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.running;
import static pl.pp.simulation.utils.ProgramData.started;

public class StartButton extends JButton {
    public ParameterModel grassParameter;
    public ParameterModel hareParameter;
    public ParameterModel foxParameter;

    private Step timer;
    private StopButton stopButton;

    private GrassService grassService;
    private HaresService haresService;
    private FoxesService foxesService;


    public StartButton(String text) {      //prywatny konstruktor
        super(text);
        System.out.println("Constructor - StartButton");
    }

    @PostConstruct
    private void init() {
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

            setNotEditableParameters();

            timer.start();
        });
    }

    public void setNotEditableParameters() {
        grassParameter.setEditable(false);
        hareParameter.setEditable(false);
        foxParameter.setEditable(false);
    }

    public void createObject() {
        for (int i = 0; i < hareParameter.getValue(); i++) {        //generowanie/losowanie zajacow
            haresService.getHareList().add(new Hare());
        }
        for (int i = 0; i < grassParameter.getValue(); i++) {
            grassService.getGrassList().add(new Grass());
        }
        for (int i = 0; i < foxParameter.getValue(); i++) {
            foxesService.getFoxList().add(new Fox());
        }
    }

    public void setTimer(Step timer) {
        this.timer = timer;
    }

    public void setStopButton(StopButton stopButton) {
        this.stopButton = stopButton;
    }

    public void setGrassService(GrassService grassService) {
        this.grassService = grassService;
    }

    public void setHaresService(HaresService haresService) {
        this.haresService = haresService;
    }

    public void setFoxesService(FoxesService foxesService) {
        this.foxesService = foxesService;
    }

    public void setGrassParameter(ParameterModel grassParameter) {
        this.grassParameter = grassParameter;
    }

    public void setHareParameter(ParameterModel hareParameter) {
        this.hareParameter = hareParameter;
    }

    public void setFoxParameter(ParameterModel foxParameter) {
        this.foxParameter = foxParameter;
    }
}

