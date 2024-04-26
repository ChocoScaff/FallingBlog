package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

/**
 * @class Coordonnees
 */
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
	
	/**
	 * 	Override toString() method
	 * 
	 * @return
	 */
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
