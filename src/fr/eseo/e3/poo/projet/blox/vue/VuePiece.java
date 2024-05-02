package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.*;
import java.awt.*;
import javax.swing.*;

public class VuePiece extends JPanel {
    public static final double MULTIPLIER_TEINTE = 0.3;
    private final Piece piece;

    public VuePiece(Piece piece) {
        this.piece = piece;
    }

    public Color teinte(Color couleur) {
        int r = (int)(couleur.getRed() + (255 - couleur.getRed()) * MULTIPLIER_TEINTE);
        int g = (int)(couleur.getGreen() + (255 - couleur.getGreen()) * MULTIPLIER_TEINTE);
        int b = (int)(couleur.getBlue() + (255 - couleur.getBlue()) * MULTIPLIER_TEINTE);
        return new Color(Math.min(r, 255), Math.min(g, 255), Math.min(b, 255));
    }

    protected void afficherPiece(Graphics2D g2D, int tileSize) {
        Color color = teinte(new Color(255, 0, 0)); // Example color
        g2D.setColor(color);
        for(int row = 0; row < this.piece.getDimension().length; row += 1){
            for(int col = 0; col < this.piece.getDimension()[row].length; col += 1){
                if(this.piece.getDimension()[row][col] == 1){
                    g2D.fill3DRect(row * tileSize + 20,col * tileSize + 20, tileSize, tileSize, true);
                }
            }
        }

    }
}
