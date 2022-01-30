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
        //try and catch basique faisant faire une pause
        //de 3000ms avant de lancer notre boucle
        try { Thread.sleep(3000);}
        catch (Exception e) { e.printStackTrace();}
        //Continue de run tant que testPerdu n'est pas faux
        while(!etat.testPerdu()){
            //Recalcule tout en fonction de ce qui a ete ajoute
            //et supprime
            affichage.revalidate();
            //Reaffiche tout
            affichage.repaint();
            //Test de defaite
            etat.testPerdu();
            //try and catch basique faisant faire une pause
            //de 300ms a notre boucle
            try { Thread.sleep(50);}
            catch (Exception e) { e.printStackTrace(); }

        }

        affichage.affichageFinPartie();
    }
}
