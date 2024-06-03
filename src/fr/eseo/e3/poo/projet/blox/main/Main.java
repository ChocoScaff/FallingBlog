package fr.eseo.e3.poo.projet.blox.main;

import fr.eseo.e3.poo.projet.blox.vue.VueMainMenu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VueMainMenu mainMenu = new VueMainMenu();
            mainMenu.setVisible(true);
        });
    }
}
