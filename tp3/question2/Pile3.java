package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * DÃ©crivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numÃ©ro de version ou une date)
 */
public class Pile3 implements PileI {
    private Vector<Object> v;
    private int capacité;
    
    /**
     * Constructeur par défaut.
     */
    public Pile3() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }
    
    /**
     * Constructeur par initialisation.
     * @param taille : nombre d'éléments de la pile.
     */
    public Pile3(int taille) {
        if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.v = new Vector<Object>();
        this.capacité = taille;
    }
    
    
    /**
     * Ajoute un élément à la pile si celle-ci n'est pas pleine.
     * @param Object o : l'élément ajouté.
     */
    public void empiler(Object o) throws PilePleineException {
        if(estPleine()){
            throw new PilePleineException();
        }
        this.v.add(o);
    }
    
    /**
     * Supprime le dernier élément ajouté à la pile.
     */
    public Object depiler() throws PileVideException {
        if (estVide()){
            throw new PileVideException();
        }
        int d = v.lastIndexOf(sommet());    
        return this.v.remove(d);
    }
    
    
    /**
     * Retourne le dernier élément ajouté.
     */
    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return this.v.lastElement();
    }
    
    /**
     * Retourne le nombre d'éléments que contient la pile à cet instant.
     */
    public int taille() {
        return this.v.size();
    }
    
    /**
     * Retourne le nombre d'éléments que peut contenir la pile.
     */
    public int capacite() {
        return this.capacité;
    }
    
    /**
     * Méthode retournant true si la pile est vide.
     */
    public boolean estVide() {
        return this.v.isEmpty();
    }
    
    
    /**
     * Méthode retournant true si la pile est pleine.
     */
    public boolean estPleine() {
        return this.v.size()==this.capacité;
    }

    public String toString() {
        String s = "[";
        for (int i = this.v.size() - 1; i >= 0; i--) {
            s+= this.v.get(i).toString();
            if(i >0){
                s+= ", ";
            }

        }
        return s + "]"; 
    }

 
    public boolean equals(Object o) {
        if( this== o ){
            return true;
        }
        if(!(o instanceof Pile3)){
            return false;
        }
        Pile3 p = (Pile3) o;
        if(this.taille() == p.taille()){
            if(this.capacite() == p.capacite()){
               boolean estEgale = false; 
               for (int i = this.v.size() - 1; i >= 0; i--) {
                    Object tmp = this.v.get(i);
                    boolean existe = false;
                    for(int j = this.v.size() - 1; j >= 0; j--){
                        if((tmp == p.v.get(i))){
                               existe = true;
                        }
                    }
                    if(existe){
                        estEgale = true;
                    } else{
                        return false;
                    }
                   
               }
                return true;
            }
                
        }
        return false;
    }


    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}