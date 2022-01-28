package Model;

//Classe qui gere la senstion de vol
//de l'oval avec la methode moveDown()
//Extends Thread pour la gestion de Thread
public class Voler extends Thread{

    //Declaration d'un etat
    public Etat etat;

    //Constructeur de la classe
    public Voler(Etat etat){
        this.etat = etat;
    }


    @Override
    public void run (){
        //Continue de run tant que testPerdu n'est pas faux
        while(!etat.testPerdu()){
            //Fais descendre l'ovale
            etat.moveDown();
            //Try and catch basique faisant faire une pause
            //de 300ms a notre boucle
            try { Thread.sleep(300);}
            catch (Exception e) { e.printStackTrace(); }
        }

    }
}
