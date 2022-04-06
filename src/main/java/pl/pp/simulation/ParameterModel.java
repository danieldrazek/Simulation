package pl.pp.simulation;

import javax.swing.*;
import java.awt.*;

public class ParameterModel {
    private String stringLabel;
    private int defaultValue;
    private JPanel panel;
    private JTextField textField;

    public ParameterModel(String stringLabel, int defaultValue) {
        this.stringLabel = stringLabel;
        this.defaultValue = defaultValue;
        initPanel();
    }

    private void initPanel() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 2, 2));
        JLabel grassLabel = new JLabel(stringLabel);
        textField = new JTextField(Integer.toString(defaultValue));
        panel.add(grassLabel);
        panel.add(textField);
    }

    public void setEditable(boolean editable) {
        textField.setVisible(editable);
    }

    public JPanel getPanel() {
        return panel;
    }
}