package Control;
import Model.Etat;
import View.Affichage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Control implements MouseListener {
    //Declaration d'un affichage
    public static Affichage affichage;
    //declaration d'un etat
    public static Etat etat;

    //Constructeur de la classe
    public Control(Affichage affichage , Etat etat) {
        this.affichage = affichage;
        this.etat = etat;
    }

    /**
     * Prends les entrees de souris et effectue les actions
     * en fonction de l'action executee
     * @param e l'action
     */
    @Override
    //Lorsque l'on clique avec la souris
    //dans la zone d'affichage
    public void mouseClicked(MouseEvent e) {
        //Appelle la methode de saut de l'oval
        etat.jump();
        //Reaffiche tout l'affichage
        affichage.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}