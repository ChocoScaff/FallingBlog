package fr.eseo.e3.poo.projet.blox.vue;
import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.*;

import javax.swing.*;
import java.awt.*;

public class VuePuitsTest {
    public static void main(String[] args) {
        // Create a Puits instance
        Puits puits = new Puits();

        // Create coordinates and a piece
        Coordonnees coordonnees = new Coordonnees(2,4);
        OPiece Piece = new OPiece(coordonnees, Couleur.ROUGE); // Assuming OPiece accepts Coordonnees and Color
        Piece.rotation();
        Piece.rotation();
        puits.setPieceSuivante(Piece); // Assuming setPieceSuivante is a method to set the next piece in Puits

        // Create VuePuits and VuePiece
        VuePuits vuePuits = new VuePuits(puits);
        VuePiece vuePiece = new VuePiece(Piece);

        // Associate VuePiece with VuePuits
        vuePuits.setVuePiece(vuePiece);

        // Create and setup the frame
        JFrame frame = new JFrame("Simple Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        // Set frame size based on VuePuits' dimensions
        frame.setSize(new Dimension(puits.getLargeur(), puits.getProfondeur()));
        frame.add(vuePuits);
        frame.pack(); // Fit the frame to the contents

        // Center the frame and make it visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
