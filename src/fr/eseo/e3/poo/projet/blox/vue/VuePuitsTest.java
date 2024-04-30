package fr.eseo.e3.poo.projet.blox.vue;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;

import javax.swing.*;
import java.awt.*;

public class VuePuitsTest {
    public static void main(String[] args) {
        Puits puits = new Puits();

        Coordonnees coordonnees = new Coordonnees(2,2);
        OPiece oPiece = new OPiece(coordonnees, Couleur.ROUGE);
        puits.setPieceSuivante(oPiece);

        VuePuits vuePuits = new VuePuits(puits);
        VuePiece vuePiece = new VuePiece(oPiece, 10);



        JFrame frame = new JFrame("Simple Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        frame.setSize(new Dimension(puits.getLargeur(), puits.getProfondeur()));
        frame.add(vuePuits);
        frame.add(vuePiece);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}


