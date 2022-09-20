package pl.pp.simulation;

import pl.pp.simulation.ui.MyFrame;

import static pl.pp.simulation.utils.ProgramData.context;

public class Run {
    public static void main(String[] args) {

        MyFrame myFrame = context.getBean("myFrame", MyFrame.class);

        myFrame.setVisible(true);

    }
}