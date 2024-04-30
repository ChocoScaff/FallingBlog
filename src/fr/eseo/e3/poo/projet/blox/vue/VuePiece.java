package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.*;
import java.awt.*;
import javax.swing.*;

public class VuePiece extends JPanel {
    public static final double MULTIPLIER_TEINTE = 0.3;  // Adjust as needed
    private final int taille;
    private final Piece piece;

    public VuePiece(Piece piece, int taille) {
        this.piece = piece;
        this.taille = taille;
    }

    public Color teinte(Color couleur) {
        int r = couleur.getRed();
        int g = couleur.getGreen();
        int b = couleur.getBlue();
        r += (255 - r) * MULTIPLIER_TEINTE;
        g += (255 - g) * MULTIPLIER_TEINTE;
        b += (255 - b) * MULTIPLIER_TEINTE;
        return new Color(Math.min(r, 255), Math.min(g, 255), Math.min(b, 255));
    }

    protected void afficherPiece(Graphics2D g2D) {
        for (Element el : piece.getElements()) {
            Color color = (el == piece.getElements().get(0)) ? teinte(el.getCouleur().getCouleurPourAffichage()) : el.getCouleur().getCouleurPourAffichage();
            g2D.setColor(color);
            g2D.fill3DRect(el.getCoordonnes().getAbscisse() * taille, el.getCoordonnes().getOrdonnee() * taille, taille, taille, true);
        }
    }
}
