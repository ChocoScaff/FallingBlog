package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.MainMenu;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueMainMenu extends JFrame {
    private final MainMenu mainMenu;

    public VueMainMenu() {
        this.mainMenu = new MainMenu();
        setupUI();
    }

    private void setupUI() {
        setTitle("Main Menu");
        setSize(400, 600);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Puit size
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Puit Width:"), gbc);
        gbc.gridx = 1;
        JTextField largeurField = new JTextField("10");
        add(largeurField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Puit Depth:"), gbc);
        gbc.gridx = 1;
        JTextField profondeurField = new JTextField("20");
        add(profondeurField, gbc);

        // Mode Usine de Piece
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Mode Usine de Piece:"), gbc);
        gbc.gridx = 1;
        JComboBox<UsineDePiece.Mode> modeComboBox = new JComboBox<>(UsineDePiece.Mode.values());
        add(modeComboBox, gbc);

        // Tas parameters
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Number of Elements in Tas:"), gbc);
        gbc.gridx = 1;
        JTextField nbElementsField = new JTextField("0");
        add(nbElementsField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Number of Lines in Tas:"), gbc);
        gbc.gridx = 1;
        JTextField nbLignesField = new JTextField("0");
        add(nbLignesField, gbc);

        // Game speed slider
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Game Speed:"), gbc);
        gbc.gridx = 1;
        JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, 100, 2000, 1000);
        speedSlider.setMajorTickSpacing(500);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        add(speedSlider, gbc);

        // Play button
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        JButton playButton = new JButton("Play");
        add(playButton, gbc);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int largeur = Integer.parseInt(largeurField.getText());
                int profondeur = Integer.parseInt(profondeurField.getText());
                UsineDePiece.Mode mode = (UsineDePiece.Mode) modeComboBox.getSelectedItem();
                int nbElements = Integer.parseInt(nbElementsField.getText());
                int nbLignes = Integer.parseInt(nbLignesField.getText());
                int speed = speedSlider.getValue();

                mainMenu.setLargeurPuits(largeur);
                mainMenu.setProfondeurPuits(profondeur);
                mainMenu.setModeUsineDePiece(mode);
                mainMenu.setNbElementsTas(nbElements);
                mainMenu.setNbLignesTas(nbLignes);
                mainMenu.setGameSpeed(speed);

                dispose();
                mainMenu.startGame();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VueMainMenu());
    }
}
