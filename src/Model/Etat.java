package Model;

import View.Affichage;

import java.awt.*;
import java.util.ArrayList;

public class Etat  {

    /* Constante liee a l'affichage */
    /**
     * Const : Hauteur de l'affichage
     */
    public static final int HEIGHT = 400;
    /**
     * Const : Largeur de l'affichage
     */
    public static final int WIDTH = 600;
    /**
     * Const : Hauteur minimale ou l'ovale peut aller
     */
    public static final int HEIGHTMIN = 10;
    /**
     * Const : Valeur max ou les points peuvent
     * generes
     */
    public static final int WIDTHMAX = WIDTH+200;
    /**
     * Const : Valeur min ou les points peuvent
     * apparaitre avant d'etre enleves
     */
    public static final int WIDTHMIN = -100;

    /**
     * Const : Hautreur min ou la courbe peut etre
     */
    public static final int HAUTEURCADREMIN = 100;
    /**
     * COnst : Hauteur max ou la courbe peut etre
     */
    public static final int HAUTEURCADREMAX = 300;

    //Position de l'ovale
    public static int HAUTEUR = (HEIGHT /2);
    /**
     * Const : Valeur d'un saut de l'ovale
     */
    public static final int SAUT = 20;
    /**
     * Const : Valeur de laquelle l'ovale descend
     * a chaque appelle de la methode moveDownr()
     */
    public static final int DOWN = Affichage.getHauteurOvale()/10;

    //Declaration d'un parcours
    public Parcours parcours;

    //Constructeur de la classe
    public Etat(){
        //Initialisation du thread Voler
        (new Voler(this)).start();
        //Creation d'un parcours
        this.parcours = new Parcours();
        //Initialisation du thread Avancer
        (new Avancer(this,this.parcours)).start();
    }

    /**
     * Fait monter l'ovale sur l'ecran de la valeur
     * de SAUT a chaque appel
     */
    public void jump(){
        if(HAUTEUR > HEIGHTMIN){
            HAUTEUR -= SAUT;
        }

    }

    /**
     * Fait descendre l'ovale sur l'ecran de la valeur de DOWN
     * a chaque appel
     */
    public void moveDown(){
        if(HAUTEUR + DOWN < HEIGHT -Affichage.getHauteurOvale()){
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
        return HEIGHT;
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