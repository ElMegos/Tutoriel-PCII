package Model;

import View.Affichage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

//Classe ou le parcours de point
//Ainsi que sa gestion sont initialises
public class Parcours {

    //Score
    public static int POSITION;
    /**
     * Const : Valeur de deplacement des points
     */
    public static final int VITESSE = 5;
    //ArrayList contenant les valeurs de chaque point
    public static ArrayList<Point> point = new ArrayList<Point>();
    //Generation d'un random
    public static Random rand = new Random();


    //Constructeur de la classe
    public Parcours(){
        POSITION = 2;
        //Initialisation des points de notre
        //ArrayList
        InitPoint();
    }

    /**
     * Initialise un nouveau parcours dans un ArrayList vide
     */
    void InitPoint(){
        //Initialisation du premier point
        int x = Affichage.getCentreXOval();
        int y = Etat.TOPOVALE + Etat.getHauteurOvale()/2;
        Point p = new Point(x,y);
        point.add(p);
        //Creation de tous les autres points du parcours
        while(x <= Etat.getWIDTHMAX()){
            x += 75+rand.nextInt(20);
            //Le calcul sert a ce que notre y soit entre deux bornes definies
            y = rand.nextInt(Etat.getHAUTEURCADREMAX() - Etat.getHAUTEURCADREMIN()) + Etat.getHAUTEURCADREMIN();
            Point pp = new Point(x,y);
            point.add(pp);
        }
    }

    /**
     * Cree le point suivant d'un parcours a partir de
     * l'abscisse du point precedent
     * @param Oldx Abscisse du point precedent
     * @return Le Point cree
     */
    public static Point CreationPoint(int Oldx){
        int x =  Oldx+75+rand.nextInt(20);
        int y = rand.nextInt(Etat.getHAUTEURCADREMAX() - Etat.getHAUTEURCADREMIN()) + Etat.getHAUTEURCADREMIN();
        Point p = new Point(x,y);
        return p;
    }


    /*Getter et Setter*/

    /**
     * Renvoie point, notre ArrayList avec le parcours mis a jour
     * @return ArrayList contenant le parcours a jour
     */
    public static ArrayList<Point> getPoint() {
        //On parcours notre ArrayList a mettre a jour
        for(int i = 0 ; i<point.size(); i++){
            //Si un point sort du cadre prevu, on le supprime
            //et on en recree un, qu'on ajoute a la fin de point
            if(point.get(i).x - VITESSE < Etat.getWIDTHMIN()){
                //Enleve le point qui est en dehors du cadre
                point.remove(point.get(i));
                //Cree le nouveau point a partir de l'actuel dernier
                Point p = CreationPoint(point.get(point.size()-1).x);
                //Ajoute ce point a point
                point.add(p);
            }
        }
        return point;
    }

    public static int getPOSITION() {
        return POSITION;
    }

    /**
     * Met a jour la position tout en incrementant
     * les abscisses de tous les points de la valeur
     * de VITESSE afin de creer le mouvement
     */
    public static void setPOSITION() {
        //Incremente POSITION aka le score
        POSITION+=2;
        //Chaque point p de point
        //se voit incremente de VITESSE
        for (Point p : point){
            p.x -= VITESSE;
        }
    }
}

