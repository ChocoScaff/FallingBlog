package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gravite implements ActionListener {
    private static final int DELAY = 1000; // Delay in milliseconds
    private final Puits puits;
    private final VuePuits vuePuits;
    private final Timer timer;

    public Gravite(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
        this.timer = new Timer(DELAY, this);
        this.timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.puits.gravite();
        this.vuePuits.repaint();
    }

    public int getPeriodicite() {
        return this.timer.getDelay();
    }

    public void setPeriodicite(int periodicite) {
        this.timer.setDelay(periodicite);
    }
}
