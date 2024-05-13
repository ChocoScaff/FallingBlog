package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Piece;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuitAffichage;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;

public class ControleurMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Puits puits = new Puits();
            UsineDePiece usineDePiece = new UsineDePiece();

            Piece pieceActuelle = usineDePiece.genererPiece();
            puits.setPieceSuivante(pieceActuelle);

            Piece PieceSuivante = usineDePiece.genererPiece();
            puits.setPieceSuivante(PieceSuivante);

            VuePuits vuePuits = new VuePuits(puits);

            PieceDeplacement pieceDeplacement = new PieceDeplacement(vuePuits, puits);
            vuePuits.addMouseMotionListener(pieceDeplacement);

            VuePuitAffichage.Affichage(vuePuits);
        });
    }
}
