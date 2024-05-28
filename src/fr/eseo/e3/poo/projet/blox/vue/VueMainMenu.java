package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VueMainMenu extends JPanel {
    private final JButton startButton;
    private final JTextField initialBlocksField;
    private final JTextField speedField;

    public VueMainMenu(ActionListener startGameListener) {
        this.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Blox Game", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        this.add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2));

        JLabel initialBlocksLabel = new JLabel("Initial Blocks:");
        initialBlocksField = new JTextField("5");
        JLabel speedLabel = new JLabel("Speed (ms):");
        speedField = new JTextField("1000");

        centerPanel.add(initialBlocksLabel);
        centerPanel.add(initialBlocksField);
        centerPanel.add(speedLabel);
        centerPanel.add(speedField);

        this.add(centerPanel, BorderLayout.CENTER);

        startButton = new JButton("Start Game");
        startButton.addActionListener(startGameListener);
        this.add(startButton, BorderLayout.SOUTH);
    }

    public int getInitialBlocks() {
        return Integer.parseInt(initialBlocksField.getText());
    }

    public int getSpeed() {
        return Integer.parseInt(speedField.getText());
    }
}
