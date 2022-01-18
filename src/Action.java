import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Action implements MouseListener {

    public static Affichage affichage;

    public Action(Affichage affichage) {
        this.affichage = affichage;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        affichage.jump();
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
