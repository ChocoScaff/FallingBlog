package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.vue.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameLoop implements ActionListener {
    private final Puits puits;
    private final VuePuits vuePuits;
    private final Timer timer;
    private boolean isGameOver;
    private final Gravite gravite;

    public GameLoop() {
        this.puits = new Puits();
        UsineDePiece usineDePiece = new UsineDePiece();

        Piece pieceActuelle = usineDePiece.genererPiece();
        puits.setPieceSuivante(pieceActuelle);

        Piece pieceSuivante = usineDePiece.genererPiece();
        puits.setPieceSuivante(pieceSuivante);

        this.vuePuits = new VuePuits(puits);

        puits.getTas().construireTas(5, 1, new Random());

        VuePuitAffichage.Affichage(vuePuits);

        this.gravite = new Gravite(vuePuits);
        this.timer = new Timer(1000, this); // Set a 1-second delay for game loop
        this.timer.start();
        this.isGameOver = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
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
        gravite.stop();
        timer.stop();
    }

    private void showGameOverScreen() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(vuePuits);
            if (frame != null) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new VueGameOver());
                frame.revalidate();
                frame.repaint();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameLoop());
    }
}
