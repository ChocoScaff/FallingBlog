package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class Gravite {
    private final Puits puits;
    private final UsineDePiece usineDePiece;

    public Gravite(VuePuits vuePuits, UsineDePiece usineDePiece) {
        this.puits = vuePuits.getPuits();
        this.usineDePiece = usineDePiece;
    }

    public void applyGravite() {
        if (puits.getPieceActuelle() != null) {
            boolean moved = puits.getPieceActuelle().deplacerDe(0, 1);
            if (!moved) {
                puits.gererCollision();
                if (!puits.isGameOver()) {
                    Piece pieceSuivante = usineDePiece.genererPiece();
                    puits.setPieceSuivante(pieceSuivante);
                }
            }
        }
    }
}
