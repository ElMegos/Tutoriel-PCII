package View;

import Model.Etat;

public class AffichageThread extends Thread{
    public Etat etat;
    public Affichage affichage;


    public AffichageThread(Etat etat , Affichage affichage){
        this.etat = etat;
        this.affichage = affichage;
    }

    @Override
    public void run (){
        while(true){
            affichage.revalidate();
            affichage.repaint();
            try { Thread.sleep(300);}
            catch (Exception e) { e.printStackTrace(); }
        }

    }
}
