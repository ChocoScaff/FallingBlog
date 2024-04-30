package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import java.awt.*;
import javax.swing.*;

public class VuePuits extends JPanel {
    private final int taille;
    private Puits puits;
    private VuePiece vuePiece;  // Associating a VuePiece with VuePuits

    public static final int TAILLE_PAR_DEFAUT = 700; // assuming a default size

    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    public VuePuits(Puits puits, int taille) {
        this.puits = puits;
        this.taille = taille;
        this.setPreferredSize(new Dimension(taille, taille));
        this.setBackground(Color.WHITE);
    }

    // Accessor and mutator for VuePiece
    public VuePiece getVuePiece() {
        return vuePiece;
    }

    public void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
        repaint();  // Repaint the panel when the VuePiece is set or changed
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // This will fill the background with the set color (white)

        Graphics2D g2D = (Graphics2D) g.create();
        int tileSize = (this.getTaille() - 40) / puits.getProfondeur();
        g2D.setColor(Color.LIGHT_GRAY);

        // Drawing a light gray grid
        for (int x = 20; x <= puits.getLargeur() * tileSize; x += tileSize) {
            for (int y = 20; y <= puits.getProfondeur() * tileSize; y += tileSize) {
                g2D.drawRect(x, y, tileSize, tileSize);
            }
        }

        // Draw the associated VuePiece
        if (vuePiece != null) {
            vuePiece.afficherPiece(g2D);
        }

        g2D.dispose(); // Free up the graphics object resources
    }

    public int getTaille() {
        return this.taille;
    }

    public Puits getPuits() {
        return puits;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
        repaint();
    }


}
