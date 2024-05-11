package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class PieceTest {

    @Test
    void placerPieceTest() {
        Coordonnees coordonnee = new Coordonnees(2, 2);
        Piece piece = new LPiece(coordonnee, Couleur.CYAN);

        Assertions.assertEquals(new Coordonnees(2, 2), piece.getElements().get(0).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(2, 1), piece.getElements().get(1).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(2, 0), piece.getElements().get(2).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(3, 2), piece.getElements().get(3).getCoordonnes());
    }

    @Test
    void tournerHorrairTest() {
        Coordonnees coordonnee = new Coordonnees(2, 2);
        Piece piece = new LPiece(coordonnee, Couleur.CYAN);

        piece.tourner(true);
        Assertions.assertEquals(new Coordonnees(2, 2), piece.getElements().get(0).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(3, 2), piece.getElements().get(1).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(4, 2), piece.getElements().get(2).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(2, 3), piece.getElements().get(3).getCoordonnes());
    }

    @Test
    void tournerAntiHorrairTest() {
        Coordonnees coordonnee = new Coordonnees(2, 2);
        Piece piece = new LPiece(coordonnee, Couleur.CYAN);

        piece.tourner(false);
        Assertions.assertEquals(new Coordonnees(2, 2), piece.getElements().get(0).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(1, 2), piece.getElements().get(1).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(0, 2), piece.getElements().get(2).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(2, 1), piece.getElements().get(3).getCoordonnes());
    }

    @Test
    void deplaceHorizontalTest() {
        Coordonnees coordonnee = new Coordonnees(2, 2);
        Piece piece = new LPiece(coordonnee, Couleur.CYAN);

        piece.deplacerDe(1,0);
        Assertions.assertEquals(new Coordonnees(3, 2), piece.getElements().get(0).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(3, 1), piece.getElements().get(1).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(3, 0), piece.getElements().get(2).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(4, 2), piece.getElements().get(3).getCoordonnes());
    }

    @Test
    void deplaceVerticalTest() {
        Coordonnees coordonnee = new Coordonnees(2, 2);
        Piece piece = new LPiece(coordonnee, Couleur.CYAN);

        piece.deplacerDe(0,1);
        Assertions.assertEquals(new Coordonnees(2, 3), piece.getElements().get(0).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(2, 2), piece.getElements().get(1).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(2, 1), piece.getElements().get(2).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(3, 3), piece.getElements().get(3).getCoordonnes());
    }

}