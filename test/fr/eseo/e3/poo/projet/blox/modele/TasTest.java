package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TasTest {

    private Puits puits;
    private Tas tas;

    @BeforeEach
    public void setUp() {
        puits = new Puits(10, 20);
        tas = new Tas(puits);
    }

    @Test
    public void testAjouterElements() {
        Piece piece = new OPiece(new Coordonnees(5, 0), Couleur.ROUGE);
        tas.ajouterElements(piece);
        assertFalse(tas.getElements().isEmpty(), "Les éléments de la pièce devraient être ajoutés au tas.");
    }

    @Test
    public void testClearLines() {
        // Remplir la dernière ligne
        for (int x = 0; x < puits.getLargeur(); x++) {
            tas.getElements().add(new Element(new Coordonnees(x, puits.getProfondeur() - 1), Couleur.ROUGE));
        }

        assertEquals(puits.getLargeur(), tas.getElements().stream()
                        .filter(e -> e.getCoordonnees().getOrdonnee() == puits.getProfondeur() - 1).count(),
                "La dernière ligne devrait être complètement remplie avant l'appel à clearLines.");

        tas.clearLines();

        // Vérifier que la dernière ligne a été supprimée
        assertEquals(0, tas.getElements().stream()
                        .filter(e -> e.getCoordonnees().getOrdonnee() == puits.getProfondeur() - 1).count(),
                "La dernière ligne devrait être supprimée après l'appel à clearLines.");
    }

    @Test
    public void testConstruireTasAvecLignes() {
        int nbElements = 29; // Assurez-vous que ce nombre est inférieur ou égal à puits.getLargeur() * nbLignes
        int nbLignes = 3;
        tas = new Tas(puits, nbElements, nbLignes);

        // Vérifier que tous les éléments sont dans les lignes spécifiées
        for (Element element : tas.getElements()) {
            assertTrue(element.getCoordonnees().getOrdonnee() >= (puits.getProfondeur() - nbLignes),
                    "Les éléments devraient être placés dans les " + nbLignes + " lignes les plus basses.");
        }
    }

    @Test
    public void testConstruireTasAvecCoordonneesUniques() {
        int nbElements = 29; // Assurez-vous que ce nombre est inférieur ou égal à puits.getLargeur() * nbLignes
        int nbLignes = 3;
        tas = new Tas(puits, nbElements, nbLignes);

        // Vérifier que tous les éléments ont des coordonnées uniques
        List<Element> elements = tas.getElements();
        Set<Coordonnees> coordonneesSet = new HashSet<>();
        for (Element element : elements) {
            assertTrue(coordonneesSet.add(element.getCoordonnees()),
                    "Les éléments devraient avoir des coordonnées uniques.");
        }
    }
}
