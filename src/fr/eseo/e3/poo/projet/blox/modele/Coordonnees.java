package fr.eseo.e3.poo.projet.blox.modele;

public class Coordonnees {
	private int abscisse;
	private int ordonnee;
	
	/**
	 * 
	 * @param abscisse
	 * @param ordonnee
	 */
	public Coordonnees(int abscisse, int ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getAbscisse() {
		return this.abscisse;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getOrdonnee() {
		return this.ordonnee;
	}
	
	/**
	 * 
	 * @param abscisse
	 */
	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}
	
	/**
	 * 
	 * @param ordonnee
	 */
	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}
	
}
