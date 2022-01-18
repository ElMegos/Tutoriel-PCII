
import org.w3c.dom.events.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Affichage extends JPanel {

    public static final int HAUT = 400;
    public static final int LARG = 600;
    public static  int hauteur = 300;
    public static final int saut = 20;


    public  Affichage(){
        JFrame fenetre = new JFrame("Test");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(LARG, HAUT));
        fenetre.add(this);
        fenetre.addMouseListener( new Action(this));
        fenetre.pack();
        fenetre.setVisible(true);
    }


    public void repaint(Graphics g){
        g.drawOval(40,hauteur+saut,20,100);
    }

    /**
     * Dessine l'oval et nettoie l'affichage
     * @param g un graphics
     */
    public void paint(Graphics g){
       super.paint(g);
        g.drawOval(40,hauteur,20,100);
    }

    /**
     * Déplace l'oval vers le haut de la valeur de saut
     */
    public static void jump(){
        if(hauteur>=saut){
            hauteur -=saut;
        }

    }
}
