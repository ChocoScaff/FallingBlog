package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Rotation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;
import java.awt.event.*;

public class PieceDeplacement implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {
    private final VuePuits vuePuits;
    private final Puits puits;
    private int lastColumn = -1;

    public PieceDeplacement(VuePuits vuePuits, Puits puits) {
        this.vuePuits = vuePuits;
        this.puits = puits;
        this.vuePuits.addMouseMotionListener(this);
        this.vuePuits.addKeyListener(this);
        this.vuePuits.setFocusable(true);
        this.vuePuits.requestFocusInWindow();
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        if (puits.getPieceActuelle() != null) {
            int currentMouseColumn = vuePuits.getColumnAt(mouseEvent.getX());
            int pieceColumn = puits.getPieceActuelle().getElements().get(0).getCoordonnees().getAbscisse();

            System.out.println("Mouse X: " + mouseEvent.getX() + ", Column: " + currentMouseColumn);
            System.out.println("Piece Current Column: " + pieceColumn);

            int columnDelta = currentMouseColumn - pieceColumn;
            System.out.println("Column Delta: " + columnDelta);

            if (columnDelta != 0) {
                try {
                    puits.getPieceActuelle().deplacerDe(columnDelta, 0);
                    lastColumn = currentMouseColumn;
                    vuePuits.repaint(); //Todo: deplacer dans le GameLoop quand il serat fait
                    System.out.println("Moved piece to column: " + currentMouseColumn);
                } catch (Exception ex) {
                    System.out.println("Failed to move piece: " + ex.getMessage());
                }
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (puits.getPieceActuelle() != null) {
            try {
                if (SwingUtilities.isRightMouseButton(mouseEvent)) {
                    puits.getPieceActuelle().tourner(Rotation.HORRAIRE);
                } else if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
                    puits.getPieceActuelle().tourner(Rotation.ANTIHORRAIRE);
                }
                vuePuits.repaint(); //Todo: deplacer dans le GameLoop quand il serat fait
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
        lastColumn = -1;
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseEvent) {
        if (puits.getPieceActuelle() != null && mouseEvent.getWheelRotation() > 0) {
            puits.getPieceActuelle().deplacerDe(0, mouseEvent.getWheelRotation());
            vuePuits.repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (puits.getPieceActuelle() != null) {
            try {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        puits.getPieceActuelle().deplacerDe(-1, 0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        puits.getPieceActuelle().deplacerDe(1, 0);
                        break;
                    case KeyEvent.VK_DOWN:
                        puits.getPieceActuelle().deplacerDe(0, 1);
                        break;
                    case KeyEvent.VK_UP:
                        puits.getPieceActuelle().tourner(Rotation.HORRAIRE);
                        break;
                    case KeyEvent.VK_SPACE:
                        puits.getPieceActuelle().tourner(Rotation.HORRAIRE);
                        break;
                    default:
                        break;
                }
                vuePuits.repaint();
            } catch (Exception ex) {
                System.out.println("Failed to process key event: " + ex.getMessage());
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        // Implement as needed
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        // Implement as needed
    }
}

