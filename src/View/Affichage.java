package View;

import Control.Control;
import Model.Etat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//Classe qui gere l'affichage du jeu
//Extends JPanel pour l'afficahge
public class Affichage extends JPanel {


    //Declaration d'un etat
    public static Etat etat;

    //Affichage de la fenetre de jeu et ajout du MouseListener
    JFrame fenetre = new JFrame("FLAPPY BIRD WISH");

    //Constructeur de la classe
    public  Affichage(Etat etat){
        this.etat = etat;
        //Commence le Thread de l'affichage
        (new AffichageThread(this.etat , this)).start();

        //Creation de la fenetre et ses dimensions
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(this.etat.getWIDTH(), this.etat.getHEIGHTMAX()));
        fenetre.add(this);
        fenetre.addMouseListener( new Control(this,this.etat));
        fenetre.pack();
        fenetre.setVisible(true);


    }

    /**
     * Affiche une fenetre contextuelle de fin de partie avec le score et ferme le jeu
     * lorsque l'on ferme la fenetre
     */
    public void affichageFinPartie() {
        //Cree une fenetre de dialogue qui affiche le score et qui empeche de cliquer sur le jeu tant qu'elle est visible
        JOptionPane.showMessageDialog(fenetre,"Votre Score : " + etat.parcours.getPOSITION()/2, "FIN DE PARTIE", JOptionPane.PLAIN_MESSAGE);
        //Exit le jeu
        System.exit(0);
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
        g.drawOval(this.etat.getPOSITIONX(),this.etat.getTOPOVALE(), this.etat.getLargeurOvale(), this.etat.getHauteurOvale());

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
     * Renvoie la valeur du milieu de l'oval
     * @return
     */
    public static int getCentreXOval(){
        return etat.TOPOVALE /2;
    }

}