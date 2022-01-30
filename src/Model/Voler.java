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
        //try and catch basique faisant faire une pause
        //de 3000ms avant de lancer notre boucle
        try { Thread.sleep(3000);}
        catch (Exception e) { e.printStackTrace();}
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
