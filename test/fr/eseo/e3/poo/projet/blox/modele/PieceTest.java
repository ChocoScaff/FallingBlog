package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class PieceTest {

    @Test
    void setPuits() {
        Puits puits = new Puits();
        UsineDePiece usineDePiece = new UsineDePiece();
        Piece piece = usineDePiece.genererPiece();

        piece.setPuits(puits);
        assertEquals(puits, piece.getPuits());
    }

    @Test
    void tournerHorrairTest() {
        Coordonnees coordonnee = new Coordonnees(2, 2);
        Piece piece = new LPiece(coordonnee, Couleur.CYAN);

        piece.tourner(true);
        Assertions.assertEquals(new Coordonnees(2, 2), piece.getElements().get(0).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(2, 1), piece.getElements().get(1).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(2, 0), piece.getElements().get(2).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(1, 2), piece.getElements().get(3).getCoordonnes());
    }

    @Test
    void tournerAntiHorrairTest() {
        Coordonnees coordonnee = new Coordonnees(2, 2);
        Piece piece = new LPiece(coordonnee, Couleur.CYAN);

        piece.tourner(false);
        Assertions.assertEquals(new Coordonnees(2, 2), piece.getElements().get(0).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(2, 3), piece.getElements().get(1).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(2, 4), piece.getElements().get(2).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(3, 2), piece.getElements().get(3).getCoordonnes());
    }
}