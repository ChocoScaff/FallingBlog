package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class VuePuitsTest {

    private Puits puits;
    private VuePuits vuePuits;

    @BeforeEach
    void setUp() {
        // Set up the Puits with some initial pieces
        puits = new Puits(10, 20);
        Piece pieceActuelle = new OPiece(new Coordonnees(5, 2), Couleur.CYAN);
        Piece pieceSuivante = new TPiece(new Coordonnees(5, 2), Couleur.CYAN);
        puits.setPieceSuivante(pieceActuelle);
        puits.setPieceSuivante(pieceSuivante);

        // Initialize VuePuits
        vuePuits = new VuePuits(puits);
    }

    @Test
    void testVuePuitsInitialization() {
        assertNotNull(vuePuits);
        assertEquals(puits, vuePuits.getPuits());
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vuePuits.getTaille());
    }

    @Test
    void testPropertyChange() {
        Piece newPiece = new TPiece(new Coordonnees(5, 2), Couleur.CYAN);
        puits.setPieceSuivante(newPiece);
        puits.setPieceSuivante(newPiece);
        vuePuits.propertyChange(new java.beans.PropertyChangeEvent(puits, Puits.MODIFICATION_PIECE_ACTUELLE, null, newPiece));
        assertNotNull(vuePuits.getVuePiece());
        assertEquals(newPiece, vuePuits.getVuePiece().getPiece());
    }

    @Test
    void testPainting() {
        JFrame frame = new JFrame();
        frame.add(vuePuits);
        frame.setSize(800, 800);
        frame.setVisible(true);

        Graphics graphics = vuePuits.getGraphics();
        assertNotNull(graphics);

        vuePuits.paintComponent(graphics);
    }

}
