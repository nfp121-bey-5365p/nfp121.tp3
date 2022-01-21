package question1;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer par votre classe Pile .
 * 
 * @author (votre nom)
 * @version (un numÃ©ro de version ou une date)
 */
public class Pile {
    public final static int TAILLE_PAR_DEFAUT = 5;

    private Object[] zone;
    private int ptr;
    /**
     * Constructeur par initialisation de la taille de la pile.
     * 
     * @param taille : nombre d'éléments dans la pile.
     */
    
    public Pile(int taille) {
        if (taille < 0)
            taille = TAILLE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }
    /**
     * Constructeur par défaut de la pile.
     */
    public Pile() {
        this(TAILLE_PAR_DEFAUT);
    }
    
    /**
     * Ajoute un objet à la pile.
     * 
     * @param Object i : object à ajouter.
     */
    public void empiler(Object i) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = i;
        this.ptr++;
    }

    /**
     * Supprime l'objet de la pile.
     * 
     */
    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }
    
    /**
     * Contrôle si la pile est vide.
     * Si vide renvoie true.
     */
    public boolean estVide() {
        return ptr == 0;
    }

    /**
     * Contrôle si la pile est pleine.
     * Si pleine renvoie true.
     */
    public boolean estPleine() {
        return ptr == zone.length;
    }

    /**
     * Méthode d'affichage de la pile.
     */
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