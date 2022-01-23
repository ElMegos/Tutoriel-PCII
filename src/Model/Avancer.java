package Model;

public class Avancer extends Thread{
    public Etat etat;
    public Parcours parcours;

    public Avancer(Etat etat , Parcours parcours){
        this.etat = etat;
        this.parcours = parcours;
    }

    @Override
    public void run (){
        while(true){
            parcours.setPOSITION();
            try { Thread.sleep(200);}
            catch (Exception e) { e.printStackTrace(); }
        }

    }
}
