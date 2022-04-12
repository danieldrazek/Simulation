package pl.pp.simulation.ui.panels;

import pl.pp.simulation.utils.ProgramData;

import javax.swing.*;
import java.awt.*;

public class ScrollPanel extends JScrollPane{

    public static JTextArea textArea;

    private static final ScrollPanel scrollPanel = new ScrollPanel();

    public static ScrollPanel getInstance() {
        return scrollPanel;
    }

    private ScrollPanel() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(ProgramData.frameWidth, ProgramData.frameHeight - ProgramData.maxHeight - 50));
    }
}