package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    private Puits puits;
    private PieceConcrete piece;

    @BeforeEach
    public void setUp() {
        puits = new Puits(10, 20); // Create a puits of 10 blocks wide and 20 blocks deep
        piece = new PieceConcrete(new Coordonnees(5, 5), Couleur.ROUGE); // Initialize piece at the center of the puits
        piece.setPuits(puits);
        puits.setPieceSuivante(piece); // Set the piece as the next piece to be used
    }

    @Test
    public void testDeplacerDePasDeCollision() {
        // Move right without collision
        boolean moved = piece.deplacerDe(1, 0);
        assertTrue(moved);
        assertEquals(6, piece.getElements().get(0).getCoordonnes().getAbscisse());
        assertEquals(5, piece.getElements().get(0).getCoordonnes().getOrdonnee());
    }

    @Test
    public void testDeplacerDeCollisionAvecMur() {
        // Déplacement à gauche avec collision contre le mur
        piece.setPosition(0, 5); // Placer la pièce près du mur gauche

        // Tenter de déplacer la pièce encore plus à gauche, ce qui devrait échouer
        boolean moved = piece.deplacerDe(-1, 0);
        assertFalse(moved, "The piece should not move outside the left boundary of the Puits");

        // Vérifier que les coordonnées de la pièce n'ont pas changé
        for (Element element : piece.getElements()) {
            Assertions.assertTrue(element.getCoordonnes().getAbscisse() >= 0, "The X coordinate should not be negative");
        }
    }

    @Test
    public void testDeplacerDeCollisionAvecTas() {
        // Add an element to the tas to provoke collision
        puits.getTas().ajouterElements(new OPiece(new Coordonnees(6, 5), Couleur.BLEU)); // Use the method to add an element

        // Move right with collision against the tas
        boolean moved = piece.deplacerDe(1, 0);
        assertFalse(moved);
        assertEquals(5, piece.getElements().get(0).getCoordonnes().getAbscisse());
        assertEquals(5, piece.getElements().get(0).getCoordonnes().getOrdonnee());
    }

    @Test
    public void testDeplacerDeMouvementInvalide() {
        // Move up, which is invalid
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(0, -1));
        assertEquals("Invalid movement direction. Movement must be left, right, or down.", exception.getMessage());
    }

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

        piece.tourner(Rotation.HORRAIRE);
        Assertions.assertEquals(new Coordonnees(2, 2), piece.getElements().get(0).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(3, 2), piece.getElements().get(1).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(4, 2), piece.getElements().get(2).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(2, 3), piece.getElements().get(3).getCoordonnes());
    }

    @Test
    void tournerAntiHorrairTest() {
        Coordonnees coordonnee = new Coordonnees(2, 2);
        Piece piece = new LPiece(coordonnee, Couleur.CYAN);

        piece.tourner(Rotation.ANTIHORRAIRE);
        Assertions.assertEquals(new Coordonnees(2, 2), piece.getElements().get(0).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(1, 2), piece.getElements().get(1).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(0, 2), piece.getElements().get(2).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(2, 1), piece.getElements().get(3).getCoordonnes());
    }

    @Test
    void deplaceHorizontalTest() {
        Coordonnees coordonnee = new Coordonnees(2, 2);
        Piece piece = new LPiece(coordonnee, Couleur.CYAN);

        piece.deplacerDe(1, 0);
        Assertions.assertEquals(new Coordonnees(3, 2), piece.getElements().get(0).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(3, 1), piece.getElements().get(1).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(3, 0), piece.getElements().get(2).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(4, 2), piece.getElements().get(3).getCoordonnes());
    }

    @Test
    void deplaceVerticalTest() {
        Coordonnees coordonnee = new Coordonnees(2, 2);
        Piece piece = new LPiece(coordonnee, Couleur.CYAN);

        piece.deplacerDe(0, 1);
        Assertions.assertEquals(new Coordonnees(2, 3), piece.getElements().get(0).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(2, 2), piece.getElements().get(1).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(2, 1), piece.getElements().get(2).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(3, 3), piece.getElements().get(3).getCoordonnes());
    }

    @Test
    void deplaceVersLeHautTest() {
        Coordonnees coordonnee = new Coordonnees(2, 2);
        Piece piece = new LPiece(coordonnee, Couleur.CYAN);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(0, -1));
        Assertions.assertEquals("Invalid movement direction. Movement must be left, right, or down.", exception.getMessage());
    }

    @Test
    void tournerOPieceTest() {
        Coordonnees coordonnee = new Coordonnees(2, 2);
        Piece piece = new OPiece(coordonnee, Couleur.CYAN);

        piece.tourner(Rotation.HORRAIRE);
        Assertions.assertEquals(new Coordonnees(2, 2), piece.getElements().get(0).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(3, 2), piece.getElements().get(1).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(2, 1), piece.getElements().get(2).getCoordonnes());
        Assertions.assertEquals(new Coordonnees(3, 1), piece.getElements().get(3).getCoordonnes());
    }
}
