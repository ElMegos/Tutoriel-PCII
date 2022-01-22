
import Model.Etat;
import View.Affichage;

import javax.swing.*;

public class Main extends JPanel {

    public static void main(String [] args) {
        Etat etat = new Etat();
        Affichage affichage = new Affichage(etat);
    }
}
