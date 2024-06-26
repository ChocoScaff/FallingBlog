package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Piece;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Rotation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PieceDeplacementTest {

    private VuePuits vuePuits;
    private Puits puits;
    private PieceDeplacement pieceDeplacement;

    @BeforeEach
    public void setUp() {
        puits = new Puits();
        vuePuits = new VuePuits(puits);
        pieceDeplacement = new PieceDeplacement(vuePuits, puits);

        // Initialize a piece in the puits
        Piece piece = new Piece(new Coordonnees(3, 1), Couleur.BLEU) {
            @Override
            protected void setElements(Coordonnees coordonnees, Couleur couleur) {
                elements.add(new Element(coordonnees, couleur));
                elements.add(new Element(coordonnees.deplacerDe(1, 0), couleur));
                elements.add(new Element(coordonnees.deplacerDe(0, 1), couleur));
                elements.add(new Element(coordonnees.deplacerDe(1, 1), couleur));
            }
        };
        puits.setPieceSuivante(piece);
        puits.setPieceSuivante(new Piece(new Coordonnees(3, 1), Couleur.ROUGE) {
            @Override
            protected void setElements(Coordonnees coordonnees, Couleur couleur) {
                elements.add(new Element(coordonnees, couleur));
                elements.add(new Element(coordonnees.deplacerDe(1, 0), couleur));
                elements.add(new Element(coordonnees.deplacerDe(0, 1), couleur));
                elements.add(new Element(coordonnees.deplacerDe(1, 1), couleur));
            }
        });
    }

    @Test
    public void testMouseMoved() {
        vuePuits.setSize(200, 400);

        MouseEvent mouseEvent = new MouseEvent(vuePuits, 0, 0, 0, 100, 100, 1, false);
        vuePuits.dispatchEvent(mouseEvent);

        int currentMouseColumn = vuePuits.getColumnAt(mouseEvent.getX());
        int pieceColumn = puits.getPieceActuelle().getElements().get(0).getCoordonnees().getAbscisse();

        int columnDelta = currentMouseColumn - pieceColumn;

        if (columnDelta != 0) {
            assertDoesNotThrow(() -> puits.getPieceActuelle().deplacerDe(columnDelta, 0));
            assertEquals(currentMouseColumn, puits.getPieceActuelle().getElements().get(0).getCoordonnees().getAbscisse());
        }
    }

    @Test
    public void testMouseWheelMoved() {
        MouseWheelEvent wheelEvent = new MouseWheelEvent(vuePuits, 0, 0, 0, 0, 0, 0, false, 0, 0, 1);

        assertDoesNotThrow(() -> pieceDeplacement.mouseWheelMoved(wheelEvent));
        assertEquals(2, puits.getPieceActuelle().getElements().get(0).getCoordonnees().getOrdonnee());
    }

    @Test
    public void testKeyPressed() {
        KeyEvent leftKeyEvent = new KeyEvent(vuePuits, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, ' ');
        KeyEvent rightKeyEvent = new KeyEvent(vuePuits, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, ' ');
        KeyEvent downKeyEvent = new KeyEvent(vuePuits, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, ' ');
        KeyEvent upKeyEvent = new KeyEvent(vuePuits, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, ' ');
        KeyEvent spaceKeyEvent = new KeyEvent(vuePuits, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_SPACE, ' ');

        assertDoesNotThrow(() -> pieceDeplacement.keyPressed(leftKeyEvent));
        assertEquals(2, puits.getPieceActuelle().getElements().get(0).getCoordonnees().getAbscisse());

        assertDoesNotThrow(() -> pieceDeplacement.keyPressed(rightKeyEvent));
        assertEquals(3, puits.getPieceActuelle().getElements().get(0).getCoordonnees().getAbscisse());

        assertDoesNotThrow(() -> pieceDeplacement.keyPressed(downKeyEvent));
        assertEquals(2, puits.getPieceActuelle().getElements().get(0).getCoordonnees().getOrdonnee());

        // Verify rotation effect by checking new coordinates
        List<Coordonnees> originalCoords = getCoordonneesList(puits.getPieceActuelle().getElements());
        System.out.println("Original Coords: " + originalCoords);

        assertDoesNotThrow(() -> pieceDeplacement.keyPressed(upKeyEvent));
        List<Coordonnees> newCoords = getCoordonneesList(puits.getPieceActuelle().getElements());
        System.out.println("New Coords after UP: " + newCoords);
        assertTrue(hasRotated(originalCoords, newCoords, Rotation.HORRAIRE));

        // Reset for the next test
        puits.setPieceSuivante(new Piece(new Coordonnees(3, 1), Couleur.BLEU) {
            @Override
            protected void setElements(Coordonnees coordonnees, Couleur couleur) {
                elements.add(new Element(coordonnees, couleur));
                elements.add(new Element(coordonnees.deplacerDe(1, 0), couleur));
                elements.add(new Element(coordonnees.deplacerDe(0, 1), couleur));
                elements.add(new Element(coordonnees.deplacerDe(1, 1), couleur));
            }
        });
        puits.setPieceSuivante(new Piece(new Coordonnees(3, 1), Couleur.ROUGE) {
            @Override
            protected void setElements(Coordonnees coordonnees, Couleur couleur) {
                elements.add(new Element(coordonnees, couleur));
                elements.add(new Element(coordonnees.deplacerDe(1, 0), couleur));
                elements.add(new Element(coordonnees.deplacerDe(0, 1), couleur));
                elements.add(new Element(coordonnees.deplacerDe(1, 1), couleur));
            }
        });
        originalCoords = getCoordonneesList(puits.getPieceActuelle().getElements());

        assertDoesNotThrow(() -> pieceDeplacement.keyPressed(spaceKeyEvent));
        newCoords = getCoordonneesList(puits.getPieceActuelle().getElements());
        System.out.println("New Coords after SPACE: " + newCoords);
        assertTrue(hasRotated(originalCoords, newCoords, Rotation.HORRAIRE));
    }

    @Test
    public void testMouseClickedRightButton() {
        MouseEvent rightClickEvent = new MouseEvent(vuePuits, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 0, 0, 1, false, MouseEvent.BUTTON3);

        List<Coordonnees> originalCoords = getCoordonneesList(puits.getPieceActuelle().getElements());
        assertDoesNotThrow(() -> pieceDeplacement.mouseClicked(rightClickEvent));
        List<Coordonnees> newCoords = getCoordonneesList(puits.getPieceActuelle().getElements());
        assertTrue(hasRotated(originalCoords, newCoords, Rotation.HORRAIRE));
    }

    @Test
    public void testMouseClickedLeftButton() {
        MouseEvent leftClickEvent = new MouseEvent(vuePuits, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 0, 0, 1, false, MouseEvent.BUTTON1);

        List<Coordonnees> originalCoords = getCoordonneesList(puits.getPieceActuelle().getElements());
        System.out.println("Original Coords: " + originalCoords); // Ajouté pour le débogage

        assertDoesNotThrow(() -> pieceDeplacement.mouseClicked(leftClickEvent));

        List<Coordonnees> newCoords = getCoordonneesList(puits.getPieceActuelle().getElements());
        System.out.println("New Coords after rotation: " + newCoords); // Ajouté pour le débogage

        assertTrue(hasRotated(originalCoords, newCoords, Rotation.ANTIHORRAIRE));
    }

    private List<Coordonnees> getCoordonneesList(List<Element> elements) {
        return elements.stream().map(Element::getCoordonnees).collect(Collectors.toList());
    }

    private boolean hasRotated(List<Coordonnees> originalCoords, List<Coordonnees> newCoords, Rotation rotation) {
        Coordonnees pivot = originalCoords.get(0);
        for (int i = 0; i < originalCoords.size(); i++) {
            Coordonnees original = originalCoords.get(i);
            Coordonnees newCoord = newCoords.get(i);
            int relativeX = original.getAbscisse() - pivot.getAbscisse();
            int relativeY = original.getOrdonnee() - pivot.getOrdonnee();

            int expectedX, expectedY;

            if (rotation == Rotation.HORRAIRE) {
                expectedX = pivot.getAbscisse() - relativeY;
                expectedY = pivot.getOrdonnee() + relativeX;
            } else if (rotation == Rotation.ANTIHORRAIRE) {
                expectedX = pivot.getAbscisse() + relativeY;
                expectedY = pivot.getOrdonnee() - relativeX;
            } else {
                return false; // Rotation inconnue
            }

            if (newCoord.getAbscisse() != expectedX || newCoord.getOrdonnee() != expectedY) {
                return false;
            }
        }
        return true;
    }
}
