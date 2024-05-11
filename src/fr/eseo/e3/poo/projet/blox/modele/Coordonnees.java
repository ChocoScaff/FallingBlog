package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

/**
 * @class Coordonnees
 */
public class Coordonnees {
	private final int abscisse;
	private final int ordonnee;
	
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

	public Coordonnees deplacerDe(int deltaAbscisse, int deltaOrdonnee) {
		return new Coordonnees(this.abscisse + deltaAbscisse, this.ordonnee + deltaOrdonnee);
	}


    public String toString() {
        return "(" + this.abscisse + ", " + this.ordonnee + ")";
    }

    /**
     *     
     * Override equals() method
     * 
     * @param obj
     * @return true or false
     * 
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordonnees that = (Coordonnees) obj;
        return abscisse == that.abscisse && ordonnee == that.ordonnee;
    }

    /**
     * Override hashCode() method
     * 
     * @return
     */
    public int hashCode() {
        return Objects.hash(this.abscisse, this.ordonnee);
    }
	
}
