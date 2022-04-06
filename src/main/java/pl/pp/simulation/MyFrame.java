package pl.pp.simulation;

import javax.swing.*;
import java.awt.*;

import static pl.pp.simulation.Components.*;
import static pl.pp.simulation.ProgramData.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        setTitle("Sumulacja drapieżnik - ofiara");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(ProgramData.frameWidth, ProgramData.frameHeight);
        setResizable(false);

        JPanel controlPanel = getControlPanel();
        JScrollPane scrollPane = getScrollPane();

        timer = new Timer(40, e -> {
            steps++;
            timeLabel.setText("Czas: " + steps);


            myComponent.repaint();
        });


        add(myComponent);
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

        timeLabel = new JLabel("Czas: 0");

        JPanel grassPanel = getParameterPanel("Trawa", "10");
        JPanel harePanel = getParameterPanel("Zające", "5");
        JPanel foxPanel = getParameterPanel("Lisy", "2");

        initStartButton();
        initStopButton();
        initResetButton();

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

    private void initResetButton() {
        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            running = false;
            started = false;

            timer.stop();

            steps = 0;
            timeLabel.setText("Czas: 0");

        });
    }

    private void initStopButton() {
        stopButton = new JButton("Stop");
        stopButton.setEnabled(false);
        stopButton.addActionListener(e -> {
            running = false;
            stopButton.setEnabled(false);
            startButton.setEnabled(true);
            timer.stop();
        });
    }

    private void initStartButton() {
        startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            running = true;
            started = true;

            stopButton.setEnabled(true);
            startButton.setEnabled(false);

            timer.start();
        });
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