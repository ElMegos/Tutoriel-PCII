package Model;

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
     * Const : Hauteur max ou la courbe peut etre
     */
    public static final int HAUTEURCADREMAX = 300;


    //Position de l'ovale


    /**
     * Const : Largeur de l'ovale
     */
    public static final int LARGEUR_OVALE = 20;


    /**
     * Const : Hauteur de l'ovale
     */
    public static final int HAUTEUR_OVALE = 100;


    /**
     * Const : Valeur d'un saut de l'ovale
     */
    public static final int SAUT = 20;


    /**
     * Const : Valeur de laquelle l'ovale descend
     * a chaque appelle de la methode moveDown()
     */
    public static final int DOWN = HAUTEUR_OVALE/10;


    /**
     * Const : Valeur de l'abscisse de l'ovale
     */
    public static final int POSITIONX = 40;


    /**
     *  Valeur du haut de l'ovale
     */
    public static int TOPOVALE = (HEIGHT /2);


    /**
     *  Valeur du bas de l'ovale
     */
    public int BOTTOMOVALE = TOPOVALE - HAUTEUR_OVALE;


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
        if(TOPOVALE > HEIGHTMIN){
            TOPOVALE -= SAUT;
        }

    }

    /**
     * Fait descendre l'ovale sur l'ecran de la valeur de DOWN
     * a chaque appel
     */
    public void moveDown(){
        if(TOPOVALE + DOWN < HEIGHT -HAUTEUR_OVALE){
            TOPOVALE += DOWN;
        }
    }


    /**
     * Test si le joueur a perdu
     * @return vrai si le joueur a perdu
     */
    public boolean testPerdu (){
        //Parcours tout les points du parcours
        for(int i = 1 ; i<parcours.point.size() ; i++){
            //Verifie que l'ovale est bien entre le point suivant et celui d'avant
           if(parcours.point.get(i).x >= POSITIONX && parcours.point.get(i-1).x <= POSITIONX){
               //Definition de l'equation de droite grace a l'interpolation lineaire
               float coef = (float) ((parcours.point.get(i).y -parcours.point.get(i-1).y)/(parcours.point.get(i).x -parcours.point.get(i-1).x));
               float orig = (parcours.point.get(i-1).y - (coef*parcours.point.get(i-1).x));
               //Defaite dans le cas où TOPOVALE ou BOTTOMOVALE est superieur/inferieur a l'equation de droite
                if(TOPOVALE > (coef*POSITIONX + orig) || (TOPOVALE +HAUTEUR_OVALE) < (coef*POSITIONX + orig)){
                    return true;
                }
           }
        }
        return false;
    }



    /* Getter et Setter */

    public static int getSAUT() {
        return SAUT;
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


    public int getTOPOVALE() {
        return TOPOVALE;
    }

    public int getBOTTOMOVALE() {
        return BOTTOMOVALE;
    }

    public static int getPOSITIONX() {
        return POSITIONX;
    }

    public static int getLargeurOvale() {
        return LARGEUR_OVALE;
    }

    public static int getHauteurOvale() {
        return HAUTEUR_OVALE;
    }

}