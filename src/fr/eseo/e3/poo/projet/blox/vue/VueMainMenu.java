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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        // Number of elements in the pile (nbElementsTas)
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Number of Elements in Pile:"), gbc);
        gbc.gridx = 1;
        JTextField nbElementsTasField = new JTextField("0");
        add(nbElementsTasField, gbc);

        // Number of lines in the pile (nbLignesTas)
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Number of Lines in Pile:"), gbc);
        gbc.gridx = 1;
        JTextField nbLignesTasField = new JTextField("0");
        add(nbLignesTasField, gbc);

        // Game speed
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Game Speed (ms):"), gbc);
        gbc.gridx = 1;
        JTextField gameSpeedField = new JTextField("1000");
        add(gameSpeedField, gbc);

        // Start button
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int largeur = Integer.parseInt(largeurField.getText());
                int profondeur = Integer.parseInt(profondeurField.getText());
                UsineDePiece.Mode mode = (UsineDePiece.Mode) modeComboBox.getSelectedItem();
                int nbElementsTas = Integer.parseInt(nbElementsTasField.getText());
                int nbLignesTas = Integer.parseInt(nbLignesTasField.getText());
                int gameSpeed = Integer.parseInt(gameSpeedField.getText());

                mainMenu.setLargeurPuits(largeur);
                mainMenu.setProfondeurPuits(profondeur);
                mainMenu.setModeUsineDePiece(mode);
                mainMenu.setNbElementsTas(nbElementsTas);
                mainMenu.setNbLignesTas(nbLignesTas);
                mainMenu.setGameSpeed(gameSpeed);

                mainMenu.startGame();
                dispose();  // Close the main menu window
            }
        });
        add(startButton, gbc);
    }
}
