package fr.eseo.e3.poo.projet.blox.modele;

import java.awt.Color;

/**
 * This enumeration defines colors with corresponding java.awt.Color instances for display purposes.
 */
public enum Couleur {
	ROUGE(Color.RED),
	ORANGE(Color.ORANGE),
	BLEU(Color.BLUE),
	VERT(Color.GREEN),
	JAUNE(Color.YELLOW),
	CYAN(Color.CYAN),
	VIOLET(Color.MAGENTA);

	// Instance variable to store the associated java.awt.Color
	private final Color couleurPourAffichage;

	/**
	 * Private constructor to initialize the color for each enumeration constant.
	 *
	 * @param couleurPourAffichage the java.awt.Color instance associated with the constant
	 */
	Couleur(Color couleurPourAffichage) {
		this.couleurPourAffichage = couleurPourAffichage;
	}

	/**
	 * Returns the java.awt.Color object associated with the enum constant.
	 *
	 * @return java.awt.Color instance linked with the enum constant.
	 */
	public Color getCouleurPourAffichage() {
		return couleurPourAffichage;
	}
}
