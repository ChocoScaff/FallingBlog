package fr.eseo.e3.poo.projet.blox.vue;
import fr.eseo.e3.poo.projet.blox.modele.*;

import javax.swing.*;
import java.awt.*;


public class VueMain {
    public static void main(String[] args) {
        Puits puits = new Puits();
        UsineDePiece usineDePiece = new UsineDePiece();

        Piece piece = usineDePiece.genererPiece();
        puits.setPieceSuivante(piece);

        VuePuits vuePuits = new VuePuits(puits);

        VuePuitAffichage.Affichage(vuePuits);

        piece.deplacerDe(4, 0);
        piece.tourner(true);

    }

}
