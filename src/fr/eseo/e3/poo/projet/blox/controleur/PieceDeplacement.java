package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.vue.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PieceDeplacement implements MouseMotionListener {
    private VuePuits vue;
    private Puits puits;
    private int lastColumn = -1;

    public PieceDeplacement(VuePuits vue, Puits puits) {
        this.vue = vue;
        this.puits = puits;
        this.vue.addMouseMotionListener(this);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (puits.getPieceActuelle() != null) {
            int currentMouseColumn = vue.getColumnAt(e.getX());
            int pieceColumn = puits.getPieceActuelle().getElements().get(0).getCoordonnes().getAbscisse();

            System.out.println("Mouse X: " + e.getX() + ", Column: " + currentMouseColumn);
            System.out.println("Piece Current Column: " + pieceColumn);

            int columnDelta = currentMouseColumn - pieceColumn;
            System.out.println("Column Delta: " + columnDelta);

            if (columnDelta != 0) {
                try {
                    puits.getPieceActuelle().deplacerDe(columnDelta, 0);
                    lastColumn = currentMouseColumn;
                    vue.repaint();
                    System.out.println("Moved piece to column: " + currentMouseColumn);
                } catch (Exception ex) {
                    System.out.println("Failed to move piece: " + ex.getMessage());
                }
            }
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        // This method can be implemented if needed for dragging interactions
    }
}
