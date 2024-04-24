package fr.eseo.e3.poo.projet.blox.modele;


public class Puits {
	final int LARGEUR_PAR_DEFAULT = 360;
	final int PROFONDEUR_PAR_DEFAULT = 600;
	
	private int largeur;
	private int profondeur;
	
	/**
	 * 
	 */
	public Puits () {
		this.largeur = LARGEUR_PAR_DEFAULT;
		this.profondeur = PROFONDEUR_PAR_DEFAULT;
	}
	
	/**
	 * 
	 * @param largeur
	 * @param profondeur
	 */
	public Puits(int largeur, int profondeur) {
		this.largeur = largeur;
		this.profondeur = profondeur;
	}
	
}
