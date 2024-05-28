package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.List;

public class GameOver {

    private final List<Element> elements;


    public GameOver(List<Element> elements) {
        this.elements = elements;
        System.out.println("Game over");
    }

}
