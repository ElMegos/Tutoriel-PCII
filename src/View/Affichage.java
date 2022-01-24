package View;

import Control.Control;
import Model.Etat;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//Classe qui gere l'affichage du jeu
//Extends JPanel pour l'afficahge
public class Affichage extends JPanel {

    /**
     * Const : Largeur de l'ovale
     */
    public static final int LARGEUR_OVALE = 20;
    /**
     * Const : Hauteur de l'ovale
     */
    public static final int HAUTEUR_OVALE = 100;

    //Declaration d'un etat
    public static Etat etat;

    //Constructeur de la classe
    public  Affichage(Etat etat){
        this.etat = etat;
        //Commence le Thread de l'affichage
        (new AffichageThread(this.etat , this)).start();

        //Affichage de la fenetre de jeu et ajout du MouseListener
        JFrame fenetre = new JFrame("FLAPPY BIRD WISH");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(this.etat.getWIDTH(), this.etat.getHEIGHTMAX()));
        fenetre.add(this);
        fenetre.addMouseListener( new Control(this,this.etat));
        fenetre.pack();
        fenetre.setVisible(true);

    }


    /**
     * Methode qui gere tout l'affichage du jeu
     * @param g Un Graphics
     */
    public void paint(Graphics g){

        //Nettoie l'ecran
        g.clearRect(0,0,etat.getWIDTH(),etat.getHEIGHTMAX());
        super.paint(g);

        //Dessine l'ovale
        g.drawOval(40,this.etat.getHAUTEUR(), LARGEUR_OVALE, HAUTEUR_OVALE);

        //Affichage de la ligne brisee
        //ArrayList avec le parcours a afficher
        ArrayList<Point> point = etat.getPoint();
        //Couleur de la ligne brisee
        g.setColor(Color.magenta);
        //On parcours le tableau de points et on trace une ligne
        //entre chaque couple de point
        for(int i = 1;i<point.size() ; i++){
            Point p1 = point.get(i-1);
            Point p2 = point.get(i);
            g.drawLine(p1.x,p1.y,p2.x,p2.y);
        }
        //On re-set la couleur a noir
        g.setColor(Color.BLACK);
        //Affichage du score
        g.drawString("Score : " + etat.parcours.getPOSITION()/2 , etat.getWIDTH()-100 , 50);
    }




    /**
     * Renvoie la valeur de la largeur de l'oval
     * @return
     */
    public static int getLargeurOvale() {
        return LARGEUR_OVALE;
    }


    /**
     * Renvoie la valeur de la hauteur de l'oval
     * @return
     */
    public static int getHauteurOvale() {
        return HAUTEUR_OVALE;
    }

    /**
     * Renvoie la valeur du milieu de l'oval
     * @return
     */
    public static int getCentreXOval(){
        return etat.HAUTEUR/2;
    }

}