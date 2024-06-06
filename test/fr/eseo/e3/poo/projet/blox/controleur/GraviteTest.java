package fr.eseo.e3.poo.projet.blox.controleur;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.Piece;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;

public class GraviteTest {

    private Puits puits;
    private UsineDePiece usineDePiece;
    private Gravite gravite;

    @Before
    public void setUp() {
        puits = new Puits(10, 20);
        usineDePiece = new UsineDePiece();
        gravite = new Gravite(puits, usineDePiece);
    }

    @Test
    public void testApplyGravite() {
        Piece piece = usineDePiece.genererPiece();
        puits.setPieceSuivante(piece);

        gravite.applyGravite();

        // Vérifie que la pièce a bougé ou une nouvelle pièce a été générée.
        if (puits.getPieceActuelle() == piece) {
            // La pièce actuelle a bougé
            assertTrue(puits.getPieceActuelle().deplacerDe(0, 1));
        } else {
            // Alors une nouvelle pièce a été générée
            assertNotNull(puits.getPieceActuelle());
        }
    }

    @Test
    public void testGraviteAvecCollision() {
        // On crée une situation de collision pour tester sa gestion
        Piece piece = usineDePiece.genererPiece();
        puits.setPieceSuivante(piece);

        // On déplace la pièce à la position de collision
        while (piece.deplacerDe(0, 1));

        // On applique la gravité
        gravite.applyGravite();

        // On vérifie qu'une nouvelle pièce a été générée après la collision
        assertNotNull(puits.getPieceActuelle());
    }
}
