package fr.eseo.e3.poo.projet.blox.modele;

import java.util.List;

abstract public class Piece {

	private Couleur couleur;
    private Puits puits;
    private Element element;
	
	/**
	 * 
	 * @param coordonnees
	 * @param couleur
	 */
	public Piece(Coordonnees coordonnees, Couleur couleur) {
		
    	this.element.setCoordonnes(coordonnees);
		this.couleur = couleur;
	}
	
	/**
	 * 
	 * @param coordonnees
	 * @param couleur
	 */
	protected void setElements(Coordonnees coordonnees, Couleur couleur) {
		
    	Element element = new Element(coordonnees, couleur);
	    this.element = element;
	}

	/**
	 *  Get elements
	 * @return
	 */
	public List<Element> getElements() {
		return (List<Element>) element;
	}
	
	/**
	 * Set position
	 * @param abscisse
	 * @param ordonnee
	 */
    public void setPosition(int abscisse, int ordonnee) {
    	
    	Coordonnees coordonnees = new Coordonnees(abscisse, ordonnee);
    	
    	this.element.setCoordonnes(coordonnees);
    }

    /**
     * Override toString() method
     */
    public String toString() {
        
        return "(" + this.element + ", " + this.couleur +  ", " + this.puits + ")";
    }

    /**
     * Get puits
     * @return
     */
    public Puits getPuits() {
        return puits;
    }

    /**
     * Set puits
     * @param puits
     */
    public void setPuits(Puits puits) {
        this.puits = puits;
    }
	
}
