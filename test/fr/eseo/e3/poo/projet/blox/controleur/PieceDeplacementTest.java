package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.vue.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceDeplacementTest {

    private VuePuits vuePuits;
    private Puits puits;
    private PieceDeplacement pieceDeplacement;

    @BeforeEach
    public void setUp() {
        puits = new Puits();
        vuePuits = new VuePuits(puits);
        pieceDeplacement = new PieceDeplacement(vuePuits, puits);
    }

    @Test
    public void testMouseMoved() {
//todo
    }

    @Test
    public void testMouseWheelMoved() {
//todo
    }

    @Test
    public void testKeyPressed() {
        //todo
    }
}
