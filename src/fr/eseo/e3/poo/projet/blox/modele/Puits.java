package fr.eseo.e3.poo.projet.blox.modele;

public class Puits {
	private static final int LARGEUR_PAR_DEFAULT = 36;
	private static final int PROFONDEUR_PAR_DEFAULT = 60;

	private int largeur;
	private int profondeur;

	public Puits() {
		this.largeur = LARGEUR_PAR_DEFAULT;
		this.profondeur = PROFONDEUR_PAR_DEFAULT;
	}

	public Puits(int largeur, int profondeur) {
		this.largeur = largeur;
		this.profondeur = profondeur;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getProfondeur() {
		return profondeur;
	}
}
