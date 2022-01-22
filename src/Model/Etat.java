package Model;

public class Etat {

    public static int HAUTEUR = 300;
    public static final int SAUT = 20;

    public static int getSAUT() {
        return SAUT;
    }

    public static int getHauteur(){
        return HAUTEUR;
    }

    /**
     * Déplace l'oval vers le haut de la valeur de saut
     */
    public void jump(){
        if(HAUTEUR>= SAUT){

            HAUTEUR -= SAUT;
        }

    }
}

