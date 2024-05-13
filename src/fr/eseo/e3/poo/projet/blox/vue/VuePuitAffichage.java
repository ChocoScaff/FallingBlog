package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.*;
import java.awt.*;

public class VuePuitAffichage {
    public static void Affichage(VuePuits vuePuits) {

        // Create and setup the frame
        JFrame frame = new JFrame("Simple Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Set frame size based on VuePuits' dimensions
        frame.setSize(new Dimension(vuePuits.getPuits().getLargeur(), vuePuits.getPuits().getProfondeur()));
        frame.add(vuePuits);
        frame.pack(); // Fit the frame to the contents

        // Center the frame and make it visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
