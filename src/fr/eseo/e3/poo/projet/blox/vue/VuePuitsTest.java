package fr.eseo.e3.poo.projet.blox.vue;
import fr.eseo.e3.poo.projet.blox.modele.*;

import javax.swing.*;
import java.awt.*;


public class VuePuitsTest {
    private static void Affichage(VuePuits vuePuits){

        // Create and setup the frame
        JFrame frame = new JFrame("Simple Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        // Set frame size based on VuePuits' dimensions
        frame.setSize(new Dimension(vuePuits.getPuits().getLargeur(), vuePuits.getPuits().getProfondeur()));
        frame.add(vuePuits);
        frame.pack(); // Fit the frame to the contents

        // Center the frame and make it visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        // Create a Puits instance
        Puits puits = new Puits();
        UsineDePiece usineDePiece = new UsineDePiece();

        // Create coordinates and a piece
        Piece piece = usineDePiece.genererPiece();
        puits.setPieceSuivante(piece);

        // Create VuePuits and VuePiece
        VuePuits vuePuits = new VuePuits(puits);

        Affichage(vuePuits);

        piece.deplacerDe(4, 0);
        piece.tourner(true);

    }

}
