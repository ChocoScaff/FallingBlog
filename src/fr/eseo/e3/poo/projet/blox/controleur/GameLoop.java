package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.vue.VueGameOver;
import fr.eseo.e3.poo.projet.blox.vue.VuePuitAffichage;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLoop implements ActionListener {
    private final Puits puits;
    private final VuePuits vuePuits;
    private final Timer timer;
    private boolean isGameOver;
    private final Gravite gravite;

    public GameLoop(Puits puits, UsineDePiece.Mode mode, int gameSpeed) {
        this.puits = puits;
        UsineDePiece usineDePiece = new UsineDePiece(mode);

        Piece pieceActuelle = usineDePiece.genererPiece();
        puits.setPieceSuivante(pieceActuelle);
        Piece pieceSuivante = usineDePiece.genererPiece();
        puits.setPieceSuivante(pieceSuivante);

        this.vuePuits = new VuePuits(puits);
        VuePuitAffichage.Affichage(vuePuits);

        this.gravite = new Gravite(puits, usineDePiece);
        this.timer = new Timer(gameSpeed, this);
        this.timer.start();
        this.isGameOver = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
            gravite.applyGravite();
            vuePuits.repaint();
            checkGameOver();
        }
    }

    private void checkGameOver() {
        if (puits.isGameOver()) {
            isGameOver = true;
            stopGame();
            showGameOverScreen();
        }
    }

    private void stopGame() {
        timer.stop();
    }

    private void showGameOverScreen() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(vuePuits);
            if (frame != null) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new VueGameOver(frame));
                frame.revalidate();
                frame.repaint();
            }
        });
    }
}
