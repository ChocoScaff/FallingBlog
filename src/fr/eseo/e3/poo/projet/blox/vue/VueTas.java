package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Tas;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static fr.eseo.e3.poo.projet.blox.vue.VuePuits.MARGE;

public class VueTas extends JPanel {
    public static final double MULTIPLIER_NUANCE = 0.3;
    private final Tas tas;

    public VueTas(Tas tas) {
        this.tas = tas;
    }

    public Color nuance(Color couleur) {
        int r = (int) (couleur.getRed() * (1 - MULTIPLIER_NUANCE));
        int g = (int) (couleur.getGreen() * (1 - MULTIPLIER_NUANCE));
        int b = (int) (couleur.getBlue() * (1 - MULTIPLIER_NUANCE));
        return new Color(Math.min(r, 255), Math.min(g, 255), Math.min(b, 255));
    }

    protected void afficherTas(Graphics2D g2D, int tileSize) {

        List<Element> elements = this.tas.getElements();

        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);

            Color color = nuance(element.getCouleur().getCouleurPourAffichage());
            g2D.setColor(color);

            int abs = element.getCoordonnees().getAbscisse();
            int ord = element.getCoordonnees().getOrdonnee();

            g2D.fill3DRect(abs * tileSize + MARGE, ord * tileSize + MARGE, tileSize, tileSize, true);
        }

    }

}
