package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element {

    private Coordonnees coordonnees;
    private Couleur couleur;

    /**
     * @param coordonnees
     */
    public Element(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    /**
     * @param abscisse
     * @param ordonnee
     */
    public Element(int abscisse, int ordonnee) {
        this.coordonnees = new Coordonnees(abscisse, ordonnee);
    }

    /**
     * @param coordonnees
     * @param couleur
     */
    public Element(Coordonnees coordonnees, Couleur couleur) {
        this.coordonnees = coordonnees;
        this.couleur = couleur;
    }

    /**
     * @param abscisse
     * @param ordonnee
     * @param couleur
     */
    public Element(int abscisse, int ordonnee, Couleur couleur) {
        this.coordonnees = new Coordonnees(abscisse, ordonnee);
        this.couleur = couleur;

    }

    /**
     * @return
     */
    public Coordonnees getCoordonnees() {
        return this.coordonnees;
    }

    /**
     * @return
     */
    public Couleur getCouleur() {
        return this.couleur;
    }

    /**
     * @param coordonnee
     */
    public void setCoordonnees(Coordonnees coordonnee) {
        this.coordonnees = coordonnee;
    }

    /**
     * @param couleur
     */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * Override toString() method
     *
     * @return
     */
    public String toString() {
        return this.coordonnees + ", " + this.couleur;
    }

    /**
     * Override equals() method
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Element element = (Element) obj;
        return Objects.equals(coordonnees, element.coordonnees) &&
                Objects.equals(couleur, element.couleur);
    }

    /**
     * @param deltaAbscisse
     * @param deltaOrdonnee
     */
    public void deplacerDe(int deltaAbscisse, int deltaOrdonnee) {
        this.coordonnees = this.coordonnees.deplacerDe(deltaAbscisse, deltaOrdonnee);
    }

    /**
     * Override hashCode() method
     *
     * @return
     */
    public int hashCode() {
        return Objects.hash(this.couleur, this.coordonnees);
    }

}
