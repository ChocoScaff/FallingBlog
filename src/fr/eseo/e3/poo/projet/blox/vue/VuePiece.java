package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static fr.eseo.e3.poo.projet.blox.vue.VuePuits.MARGE;

public class VuePiece extends JPanel {
    public static final double MULTIPLIER_TEINTE = 0.3;
    private final Piece piece;

    public VuePiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public Color teinte(Color couleur) {
        int r = (int) (couleur.getRed() + (255 - couleur.getRed()) * MULTIPLIER_TEINTE);
        int g = (int) (couleur.getGreen() + (255 - couleur.getGreen()) * MULTIPLIER_TEINTE);
        int b = (int) (couleur.getBlue() + (255 - couleur.getBlue()) * MULTIPLIER_TEINTE);
        return new Color(Math.min(r, 255), Math.min(g, 255), Math.min(b, 255));
    }

    protected void afficherPiece(Graphics2D g2D, int tileSize) {

        List<Element> elements = this.piece.getElements();

        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);

            Color color = teinte(element.getCouleur().getCouleurPourAffichage());
            g2D.setColor(color);

            int abs = element.getCoordonnees().getAbscisse();
            int ord = element.getCoordonnees().getOrdonnee();

            g2D.fill3DRect(abs * tileSize + MARGE, ord * tileSize + MARGE, tileSize, tileSize, true);
        }

    }

    protected void afficherNextPiece(Graphics2D g2D, int tileSize) {

        List<Element> elements = this.piece.getElements();

        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);

            Color color = teinte(element.getCouleur().getCouleurPourAffichage());
            g2D.setColor(color);

            int abs = element.getCoordonnees().getAbscisse();
            int ord = element.getCoordonnees().getOrdonnee();

            g2D.fill3DRect(abs * tileSize + (15 * tileSize + MARGE), ord * tileSize + MARGE, tileSize, tileSize, true);
        }

    }


}
