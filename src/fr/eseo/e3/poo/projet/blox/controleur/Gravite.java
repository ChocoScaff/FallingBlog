package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class Gravite {
    private final Puits puits;
    private final VuePuits vuePuits;

    public Gravite(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    public void applyGravity() {
        if (puits.getPieceActuelle() != null) {
            boolean moved = puits.getPieceActuelle().deplacerDe(0, 1);
            if (!moved) {
                puits.gererCollision();
                if (!puits.isGameOver()) {
                    Piece pieceSuivante = puits.getPieceSuivante();
                    puits.setPieceSuivante(pieceSuivante);
                }
            }
        }
    }
}
