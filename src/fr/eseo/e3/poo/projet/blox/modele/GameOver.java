package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.List;

public class GameOver {

    private Tas tas;
    private List<Element> elements;
    private Coordonnees coordonnees;


    public GameOver(Tas tas) {
        this.tas = tas;

        this.elements =  this.tas.getElements();

        for (Element element : elements) {

            coordonnees = element.getCoordonnees();
            if (coordonnees.getOrdonnee() == 3) {
                System.out.println("Game Over");
            }
        }

    }

}
