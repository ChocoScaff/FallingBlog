package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.Test;
import static org.junit.Assert.*;

public class ElementTest {

    @Test
    public void testConstructorWithCoordinates() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Element element = new Element(coordonnees);
        assertEquals(coordonnees, element.getCoordonnees());
    }

    @Test
    public void testConstructorWithCoordinatesAndColor() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        Element element = new Element(coordonnees, couleur);
        assertEquals(coordonnees, element.getCoordonnees());
        assertEquals(couleur, element.getCouleur());
    }

    @Test
    public void testConstructorWithCoordinatesAndColorInt() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        Element element = new Element(1, 2, couleur);
        assertEquals(coordonnees, element.getCoordonnees());
        assertEquals(couleur, element.getCouleur());
    }

    @Test
    public void testConstructorWithIntegers() {
        int abscisse = 1;
        int ordonnee = 2;
        Element element = new Element(abscisse, ordonnee);
        Coordonnees coordonnees = new Coordonnees(abscisse, ordonnee);
        assertEquals(coordonnees, element.getCoordonnees());
    }

    @Test
    public void testSetCoordonnes() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Element element = new Element(3, 4);
        element.setCoordonnees(coordonnees);
        assertEquals(coordonnees, element.getCoordonnees());
    }

    @Test
    public void testSetCouleur() {
        Element element = new Element(1, 2);
        Couleur couleur = Couleur.VERT;
        element.setCouleur(couleur);
        assertEquals(couleur, element.getCouleur());
    }

    @Test
    public void testToString() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        Element element = new Element(coordonnees, couleur);
        String expected = "(1, 2), ROUGE";
        assertEquals(expected, element.toString());
    }

    @Test
    public void testEquals() {
        Coordonnees coordonnees1 = new Coordonnees(1, 2);
        Coordonnees coordonnees2 = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        Element element1 = new Element(coordonnees1, couleur);
        Element element2 = new Element(coordonnees2, couleur);
        assertEquals(element1, element2);
    }

}


