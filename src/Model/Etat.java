package Model;

import View.Affichage;

import java.awt.*;
import java.util.ArrayList;

public class Etat  {
    public static final int HEIGHTMIN = 10;
    public static final int HEIGHTMAX = 400;
    public static final int WIDTH = 600;
    public static final int WIDTHMAX = WIDTH+200;
    public static final int WIDTHMIN = -100;
    public static int HAUTEUR = (HEIGHTMAX/2-10);
    public static final int SAUT = 20;
    public static final int DOWN = Affichage.getHauteurOval()/10;
    public static final int HAUTEURCADREMIN = 100;
    public static final int HAUTEURCADREMAX = 300;
    public Parcours parcours;

    public Etat(){
        (new Voler(this)).start();
        this.parcours = new Parcours();
        (new Avancer(this,this.parcours)).start();
    }



    /**
     * Déplace l'oval vers le haut de la valeur de saut
     */
    public void jump(){
        if(HAUTEUR > HEIGHTMIN){
            HAUTEUR -= SAUT;
        }

    }

    /**
     *
     */
    public void moveDown(){
        if(HAUTEUR + DOWN < HEIGHTMAX-Affichage.getHauteurOval()){
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

    public static int getWIDTHMAX() {
        return WIDTHMAX;
    }

    public static int getHEIGHTMIN() {
        return HEIGHTMIN;
    }

    public ArrayList<Point> getPoint(){
        return this.parcours.getPoint();
    }

    public static int getHAUTEURCADREMIN() {
        return HAUTEURCADREMIN;
    }

    public static int getHAUTEURCADREMAX() {
        return HAUTEURCADREMAX;
    }

    public static int getWIDTHMIN() {
        return WIDTHMIN;
    }
}

