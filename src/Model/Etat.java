package Model;

import View.Affichage;

public class Etat  {
    public static final int HEIGHTMIN = -10;
    public static final int HEIGHTMAX = 400;
    public static final int WIDTH = 600;
    public static int HAUTEUR = (HEIGHTMAX/2-10);
    public static final int SAUT = 20;
    public static final int DOWN = Affichage.getHauteurOval()/10;

    public Etat(){
        (new Voler(this)).start();
    }



    /**
     * Déplace l'oval vers le haut de la valeur de saut
     */
    public void jump(){
        if(HAUTEUR > 0){
            HAUTEUR -= SAUT;
        }

    }

    /**
     *
     */
    public void moveDown(){
        if(HAUTEUR + DOWN <= HEIGHTMAX){
            HAUTEUR += DOWN;
        }
    }


    /* Getter et Setter */

    public static int getSAUT() {
        return SAUT;
    }

    public static int getHAUTEUR(){
        return HAUTEUR;
    }

    public static int getHEIGHTMAX() {
        return HEIGHTMAX;
    }

    public static int getWIDTH() {
        return WIDTH;
    }
}

