package Model;

//Classe qui va servir à faire avancer le parcours
//Extends Thread afin d'executer des Threads
public class Avancer extends Thread{
    //Declaration d'un etat
    public Etat etat;
    //Declaration d'un parcours
    public Parcours parcours;

    //Constructeur de la classe
    public Avancer(Etat etat , Parcours parcours){
        this.etat = etat;
        this.parcours = parcours;
    }


    @Override
    public void run (){
        //Boucle infinie
        while(true){
            //Fait avancer le parcours en mettant
            //a jour les positions
            parcours.setPOSITION();
            //Try and catch basique
            //pour que le thread attende 200ms
            //entre chaque boucle
            try { Thread.sleep(200);}
            catch (Exception e) { e.printStackTrace(); }
        }

    }
}