package View;

import Control.Control;
import Model.Etat;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Affichage extends JPanel {


    public static final int LARGEUR_OVAL = 20;
    public static final int HAUTEUR_OVAL = 100;
    public static Etat etat;

    public  Affichage(Etat etat){
        this.etat = etat;
        (new AffichageThread(this.etat , this)).start();

        JFrame fenetre = new JFrame("Test");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(this.etat.getWIDTH(), this.etat.getHEIGHTMAX()));
        fenetre.add(this);
        fenetre.addMouseListener( new Control(this,this.etat));
        fenetre.pack();
        fenetre.setVisible(true);

    }



    /**
     * Dessine l'oval et nettoie l'affichage
     * @param g un graphics
     */
    public void paint(Graphics g){

        //Nettoie l'ecran
        g.clearRect(0,0,etat.getWIDTH(),etat.getHEIGHTMAX());
        super.paint(g);

        //Dessine l'oval
        g.drawOval(40,this.etat.getHAUTEUR(),LARGEUR_OVAL,HAUTEUR_OVAL);

        ArrayList<Point> point = etat.getPoint();
        g.setColor(Color.magenta);
        for(int i = 1;i<point.size() ; i++){
            Point p1 = point.get(i-1);
            Point p2 = point.get(i);
            g.drawLine(p1.x,p1.y,p2.x,p2.y);
        }
        g.setColor(Color.BLACK);
        g.drawString("Score : " + etat.parcours.getPOSITION()/2 , etat.getWIDTH()-100 , 50);
    }




    /**
     * Renvoie la valeur de la largeur de l'oval
     * @return
     */
    public static int getLargeurOval() {
        return LARGEUR_OVAL;
    }


    /**
     * Renvoie la valeur de la hauteur de l'oval
     * @return
     */
    public static int getHauteurOval() {
        return HAUTEUR_OVAL;
    }

    /**
     * Renvoie la valeur du milieu de l'oval
     * @return
     */
    public static int getCentreXOval(){
        return etat.HAUTEUR/2;
    }

}
