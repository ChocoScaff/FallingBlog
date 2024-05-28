package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.*;
import java.awt.*;

public class VueGameOver extends JPanel {
    public VueGameOver() {
        // Create a label to display the game over message
        JLabel gameOverLabel = new JLabel("Game Over", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 50));
        gameOverLabel.setForeground(Color.RED);

        // Set the layout and add the label
        this.setLayout(new BorderLayout());
        this.add(gameOverLabel, BorderLayout.CENTER);
    }
}
