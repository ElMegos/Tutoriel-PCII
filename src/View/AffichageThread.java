package View;

import Model.Etat;

//Classe contenant le thread d'affichage
//Extends Thread pour la gestion de Threads
public class AffichageThread extends Thread{

    //Declaration d'un etat
    public Etat etat;
    //Declaration d'un affichage
    public Affichage affichage;

    //Constructeur de la classe
    public AffichageThread(Etat etat , Affichage affichage){
        this.etat = etat;
        this.affichage = affichage;
    }

    @Override
    public void run (){
        //Boucle infinie
        while(true){
            //Recalcule tout en fonction de ce qui a ete ajoute
            //et supprime
            affichage.revalidate();
            //Reaffiche tout
            affichage.repaint();
            //try and catch basique faisant faire une pause
            //de 300ms a notre boucle
            try { Thread.sleep(300);}
            catch (Exception e) { e.printStackTrace(); }
        }

    }
}
