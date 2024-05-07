package fr.eseo.e3.poo.projet.blox.vue;
import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.*;

import javax.swing.*;
import java.awt.*;

public class VuePuitsTest {
    private static void Affichage(VuePuits vuePuits, VuePiece vuePiece){
        // Associate VuePiece with VuePuits
        vuePuits.setVuePiece(vuePiece);

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
        //piece.deplacerDe(0, 0);
        //piece.tourner(false);
        puits.setPieceSuivante(piece); // Assuming setPieceSuivante is a method to set the next piece in Puits

        // Create VuePuits and VuePiece
        VuePuits vuePuits = new VuePuits(puits);
        VuePiece vuePiece = new VuePiece(piece);

        Affichage(vuePuits,vuePiece);

    }
}
