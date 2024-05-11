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
            puits.setPieceSuivante(pieceActuelle);

            Piece PieceSuivante = usineDePiece.genererPiece();
            puits.setPieceSuivante(PieceSuivante);

            // Setup the view
            VuePuits vuePuits = new VuePuits(puits); // assuming VuePuits constructor takes a Puits

            // Set up piece movement handling
            PieceDeplacement pieceDeplacement = new PieceDeplacement(vuePuits, puits);
            vuePuits.addMouseMotionListener(pieceDeplacement);

            VuePuitAffichage.Affichage(vuePuits);
        });
    }
}
