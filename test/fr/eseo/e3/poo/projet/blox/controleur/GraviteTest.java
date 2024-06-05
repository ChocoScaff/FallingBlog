package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Piece;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraviteTest {

    private Puits puits;
    private Gravite gravite;
    private UsineDePiece usineDePiece;

    @BeforeEach
    public void setUp() {
        puits = new Puits(10, 20);
        usineDePiece = new UsineDePiece(UsineDePiece.Mode.ALEATOIRE_PIECE);
        gravite = new Gravite(puits, usineDePiece);
        Piece pieceActuelle = createPiece(new Coordonnees(3, 1));
        puits.setPieceSuivante(pieceActuelle);
    }

    private Piece createPiece(Coordonnees coordonnees) {
        return new Piece(coordonnees, Couleur.ROUGE) {
            @Override
            protected void setElements(Coordonnees coordonnees, Couleur couleur) {
                elements.add(new Element(coordonnees, couleur));
                elements.add(new Element(new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee()), couleur));
                elements.add(new Element(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() + 1), couleur));
                elements.add(new Element(new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee() + 1), couleur));
            }
        };
    }

    @Test
    public void testApplyGravitePieceDeplacee() {
        gravite.applyGravite();

        Piece pieceActuelle = puits.getPieceActuelle();
        assertNotNull(pieceActuelle);
        assertEquals(new Coordonnees(3, 2), pieceActuelle.getElements().get(0).getCoordonnees());
        assertEquals(new Coordonnees(4, 2), pieceActuelle.getElements().get(1).getCoordonnees());
        assertEquals(new Coordonnees(3, 3), pieceActuelle.getElements().get(2).getCoordonnees());
        assertEquals(new Coordonnees(4, 3), pieceActuelle.getElements().get(3).getCoordonnees());
    }

    @Test
    public void testApplyGravitePieceNonDeplacee() {
        Piece pieceActuelle = createPiece(new Coordonnees(3, puits.getProfondeur() - 2));
        puits.setPieceSuivante(pieceActuelle);

        gravite.applyGravite();
        gravite.applyGravite();

        Tas tas = puits.getTas();
        for (Element element : pieceActuelle.getElements()) {
            assertTrue(tas.getElements().contains(element), "La pièce actuelle devrait être ajoutée au tas.");
        }
        assertNotNull(puits.getPieceActuelle(), "Une nouvelle pièce devrait être générée.");
    }
}
