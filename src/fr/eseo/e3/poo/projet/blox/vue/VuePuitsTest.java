package fr.eseo.e3.poo.projet.blox.vue;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;

public class VuePuitsTest {
    public static void main(String[] args) {
        Puits puits = new Puits();
        VuePuits vp = new VuePuits(puits);
        vp.DisplayPuits();

        Coordonnees coordonnees = new Coordonnees(2,2);
        OPiece oPiece = new OPiece(coordonnees, Couleur.ROUGE);
        puits.setPieceSuivante(oPiece);
    }
}


