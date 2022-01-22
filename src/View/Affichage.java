package View;

import Control.Control;
import Model.Etat;


import javax.swing.*;
import java.awt.*;


public class Affichage extends JPanel {

    public static final int HAUT = 400;
    public static final int LARG = 600;

    public static Etat etat;

    public  Affichage(Etat etat){
        this.etat = etat;
        JFrame fenetre = new JFrame("Test");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(LARG, HAUT));
        fenetre.add(this);
        fenetre.addMouseListener( new Control(this,etat));
        fenetre.pack();
        fenetre.setVisible(true);

    }



    /**
     * Dessine l'oval et nettoie l'affichage
     * @param g un graphics
     */
    public void paint(Graphics g){
       super.paint(g);
        g.drawOval(40,this.etat.getHauteur(),20,100);
    }


}
