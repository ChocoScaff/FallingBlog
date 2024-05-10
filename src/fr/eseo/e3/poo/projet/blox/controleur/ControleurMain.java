package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.vue.*;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Dimension;

public class ControleurMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the game components
            Puits puits = new Puits(); // assuming Puits has a default constructor
            UsineDePiece usineDePiece = new UsineDePiece(); // assuming this class exists to generate pieces

            // Generate and set the initial piece
            Piece pieceActuelle = usineDePiece.genererPiece();
            puits.setPieceSuivante(pieceActuelle); // Assuming there's a method to set the current piece

            // Setup the view
            VuePuits vuePuits = new VuePuits(puits); // assuming VuePuits constructor takes a Puits

            // Set up piece movement handling
            PieceDeplacement pieceDeplacement = new PieceDeplacement(vuePuits, puits);
            vuePuits.addMouseMotionListener(pieceDeplacement);

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
        });
    }
}
