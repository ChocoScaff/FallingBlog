package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PieceRotation implements MouseListener {
    private final VuePuits vuePuits;
    private final Puits puits;

    public PieceRotation(VuePuits vuePuits, Puits puits) {
        this.vuePuits = vuePuits;
        this.puits = puits;
        this.vuePuits.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (puits.getPieceActuelle() != null) {
            try {
                if (SwingUtilities.isRightMouseButton(mouseEvent)) {
                    puits.getPieceActuelle().tourner(true);
                } else if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
                    puits.getPieceActuelle().tourner(false);
                }
                vuePuits.repaint();
            } catch (Exception ex) {
                System.out.println("Rotation failed: " + ex.getMessage());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
}
