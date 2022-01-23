package Model;

import View.Affichage;
import Model.Etat;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class Parcours {

    public static int POSITION;
    public static final int VITESSE = 5;
    public static ArrayList<Point> point = new ArrayList<Point>();
    public static Random rand = new Random();



    public Parcours(){
        POSITION = 2;
        InitPoint();
    }

    void InitPoint(){

        //Initialisation du premier point
        int x = Affichage.getCentreXOval();
        int y = Etat.HAUTEUR + Affichage.getHauteurOval()/2;
        Point p = new Point(x,y);
        point.add(p);

        while(x <= Etat.getWIDTHMAX()){
            x += 75+rand.nextInt(20);
            y = rand.nextInt(Etat.getHAUTEURCADREMAX() - Etat.getHAUTEURCADREMIN()) + Etat.getHAUTEURCADREMIN();
            Point pp = new Point(x,y);
            point.add(pp);
        }
    }

    public static Point CreationPoint(int Oldx){
        int x =  Oldx+75+rand.nextInt(20);
        int y = rand.nextInt(Etat.getHAUTEURCADREMAX() - Etat.getHAUTEURCADREMIN()) + Etat.getHAUTEURCADREMIN();
        Point p = new Point(x,y);
        return p;
    }


    /*Getter et Setter*/

    public static ArrayList<Point> getPoint() {
        for(int i = 0 ; i<point.size(); i++){
            if(point.get(i).x - VITESSE < Etat.getWIDTHMIN()){
                point.remove(point.get(i));
                Point p = CreationPoint(point.get(point.size()-1).x);
                point.add(p);
            }
        }
        return point;
    }

    public static int getPOSITION() {
        return POSITION;
    }

    public static void setPOSITION() {
        POSITION+=2;
        for (Point p : point){
            p.x -= VITESSE;
        }
    }
}
