package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {
    private Object[] zone;
    private int ptr;
    /**
     * Constructeur par initialisation
     * @param taille : nombre d'�l�ments de la pile.
     */
    public Pile(int taille) {
        if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.zone = new Object[taille];
        this.ptr = 0;
    }
    
    /**
     * Constructeur par d�faut.
     */
    public Pile() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }
    
    /**
     * Ajoute un objet � la pile.
     * @param Object o : l'�l�ment ajout�.
     */
    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] =o;
        this.ptr++;
    }
    
    /**
     * Supprime le dernier �l�ment entr�.
     */
    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return this.zone[ptr];
    }
    
    /**
     * Retourne le dernier �l�ment ajout�.
     */
    public Object sommet() throws PileVideException {

        if (estVide())
            throw new PileVideException();

        return this.zone[ptr-1];
    }
    
    /**
     * Donne le nombre maximum d'�l�ments que peut contenir la pile.
     */
    public int capacite() {
        return this.zone.length;
    }
    
    /**
     * Donne le nombre d'�l�ments que contient la pile � cet instant.
     */
    public int taille() { 
        if(estVide()){
            ptr = 0;
        }
        return this.ptr;
    }
    
    /**
     * M�thode retournant true si la pile est vide.
     */
    public boolean estVide() {
        return this.ptr == 0;
    }
    
    /**
     * M�thode retournant true si la pile est pleine.
     */
    public boolean estPleine() {
        return this.ptr == this.zone.length;
    }
    
   
 public boolean equals(Object o) {

        if( this== o ){
            return true;
        }      
        if(!(o instanceof Pile)){
            return false;
        }
        Pile p1 = (Pile)o;

        if (p1.taille() == this.taille() && p1.capacite() == this.capacite()){
            boolean estEgale = false;
            for(int i=zone.length - 1; i >=0; i--){
                Object tmp = zone[i];
                boolean egal = false;
                for(int j = zone.length-1; j>=0; j--){
                    if(tmp == p1.zone[i]){
                        egal = true;
                    }       
                }
                if(egal){
                    estEgale = true;
                }else{
                    return false;
                }
            }
            return true;
        }                
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    }