package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GraviteTest {
    private Gravite gravite;
    private Puits puits;
    private VuePuits vuePuits;

    @BeforeEach
    public void setUp() {
        puits = new Puits();
        vuePuits = new VuePuits(puits);
        gravite = new Gravite(vuePuits);

        // Initialiser une pièce pour le puits ici
        Piece piece = new OPiece(new Coordonnees(5, 0), Couleur.ROUGE);
        puits.setPieceSuivante(piece);

        // Appel de gravite pour initialiser pieceActuelle
        if (puits.getPieceActuelle() == null) {
            puits.gravite();
        }
    }

    @Test
    public void testActionPerformed() {
        assertNotNull(puits.getPieceActuelle(), "La pièce actuelle ne doit pas être nulle avant l'appel à gravite.");
        List<Element> elements = puits.getPieceActuelle().getElements();
        int initialOrdonnee = elements.get(0).getCoordonnees().getOrdonnee();

        // Simuler l'action de la gravité
        gravite.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        int nouvelleOrdonnee = elements.get(0).getCoordonnees().getOrdonnee();

        assertEquals(initialOrdonnee + 1, nouvelleOrdonnee, "La pièce doit descendre d'une unité après l'appel à gravite.");
    }
}
