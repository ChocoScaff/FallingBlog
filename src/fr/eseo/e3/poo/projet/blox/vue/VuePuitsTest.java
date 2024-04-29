package fr.eseo.e3.poo.projet.blox.vue;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuitsTest {
    public static void main(String[] args) {
        Puits puits = new Puits();
        VuePuits vp = new VuePuits(puits);
        vp.DisplayPuits();

    }
}


