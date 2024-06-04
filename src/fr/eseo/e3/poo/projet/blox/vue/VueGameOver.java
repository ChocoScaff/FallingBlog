package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueGameOver extends JPanel {

    public VueGameOver(JFrame frame) {
        // Create a label to display the game over message
        JLabel gameOverLabel = new JLabel("Game Over", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 50));
        gameOverLabel.setForeground(Color.RED);

        // Create a button to return to the main menu
        JButton mainMenuButton = new JButton("Return to Main Menu");
        mainMenuButton.setFont(new Font("Arial", Font.PLAIN, 20));
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    frame.dispose();  // Close the current game window
                    new VueMainMenu().setVisible(true);  // Open a new main menu window
                });
            }
        });

        // Set the layout and add components
        this.setLayout(new BorderLayout());
        this.add(gameOverLabel, BorderLayout.CENTER);
        this.add(mainMenuButton, BorderLayout.SOUTH);
    }
}
