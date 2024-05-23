package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.modele.Piece;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class VuePuitsTest {

    private Puits puits;
    private VuePuits vuePuits;
    private VuePiece vuePiece;
    private VueTas vueTas;

    @Before
    public void setUp() {
        puits = mock(Puits.class);
        vuePiece = mock(VuePiece.class);
        vueTas = mock(VueTas.class);

        when(puits.getPieceActuelle()).thenReturn(mock(Piece.class));
        when(puits.getTas()).thenReturn(mock(Tas.class));

        vuePuits = new VuePuits(puits, VuePuits.TAILLE_PAR_DEFAUT);
    }

    @Test
    public void testGetVuePiece() {
        assertNotNull(vuePuits.getVuePiece());
    }

    @Test
    public void testSetVuePiece() {
        vuePuits.setVuePiece(vuePiece);
        assertEquals(vuePiece, vuePuits.getVuePiece());
    }

    @Test
    public void testPaintComponent() {
        // Simulate the painting process
        Graphics g = mock(Graphics.class);
        Graphics2D g2D = mock(Graphics2D.class);
        when(g.create()).thenReturn(g2D);

        vuePuits.paintComponent(g);

        verify(g2D, atLeastOnce()).setColor(Color.lightGray);
        verify(g2D, atLeastOnce()).dispose();
    }

    @Test
    public void testPropertyChange() {
        Piece newPiece = mock(Piece.class);
        PropertyChangeEvent event = new PropertyChangeEvent(puits, Puits.MODIFICATION_PIECE_ACTUELLE, null, newPiece);

        vuePuits.propertyChange(event);
        assertEquals(newPiece, vuePuits.getVuePiece().getPiece());
    }

    @Test
    public void testGetTaille() {
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vuePuits.getTaille());
    }

    @Test
    public void testGetPuits() {
        assertEquals(puits, vuePuits.getPuits());
    }

    @Test
    public void testSetPuits() {
        Puits newPuits = mock(Puits.class);
        vuePuits.setPuits(newPuits);
        assertEquals(newPuits, vuePuits.getPuits());
    }

    @Test
    public void testGetColumnAt() {
        vuePuits.setPuits(puits); // Initialize tileSize
        int column = vuePuits.getColumnAt(VuePuits.MARGE + 10); // Assuming tileSize > 10
        assertEquals(0, column);
    }

    @Test
    public void testGetRowAt() {
        vuePuits.setPuits(puits); // Initialize tileSize
        int row = vuePuits.getRowAt(VuePuits.MARGE + 10); // Assuming tileSize > 10
        assertEquals(0, row);
    }
}
