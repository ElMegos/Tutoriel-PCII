package Control;
import Model.Etat;
import View.Affichage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Control implements MouseListener {

    public static Affichage affichage;
    public static Etat etat;

    public Control(Affichage affichage , Etat etat) {
        this.affichage = affichage;
        this.etat = etat;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        etat.jump();
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
