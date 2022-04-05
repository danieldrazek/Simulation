package pl.pp.simulation;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        setTitle("Sumulacja drapieżnik - ofiara");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(ProgramData.frameWidth, ProgramData.frameHeight);
        setResizable(false);

        JPanel controlPanel = getControlPanel();
        JScrollPane scrollPane = getScrollPane();


        add(new MyComponent());
        add(controlPanel, BorderLayout.EAST);
        add(scrollPane, BorderLayout.SOUTH);

    }

    private JScrollPane getScrollPane() {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(ProgramData.frameWidth, ProgramData.frameHeight - ProgramData.maxHeight));
        return scrollPane;
    }

    private JPanel getControlPanel() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(8, 1, 50, 50));

        controlPanel.setPreferredSize(new Dimension(ProgramData.frameWidth - ProgramData.maxWidth, ProgramData.frameHeight));

        JLabel timeLabel = new JLabel("Czas: ");

        JPanel grassPanel = getParameterPanel("Trawa", "10");
        JPanel harePanel = getParameterPanel("Zające", "5");
        JPanel foxPanel = getParameterPanel("Lisy", "2");

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JButton resetButton = new JButton("Reset");
        JButton chartButton = new JButton("Wykres");

        controlPanel.add(timeLabel);
        controlPanel.add(grassPanel);
        controlPanel.add(harePanel);
        controlPanel.add(foxPanel);
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(resetButton);
        controlPanel.add(chartButton);
        return controlPanel;
    }

    private JPanel getParameterPanel(String label, String defaultValue) {
        JPanel grassPanel = new JPanel();
        grassPanel.setLayout(new GridLayout(1, 2, 2, 2));
        JLabel grassLabel = new JLabel(label);
        JTextField grassTextField = new JTextField(defaultValue);
        grassPanel.add(grassLabel);
        grassPanel.add(grassTextField);
        return grassPanel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MyFrame myFrame = new MyFrame();
            myFrame.setVisible(true);
        });

    }
}