package Model;

public class Voler extends Thread{

    public Etat etat;

    public Voler(Etat etat){
        this.etat = etat;
    }


    @Override
    public void run (){
        while(true){
            etat.moveDown();
            try { Thread.sleep(300);}
            catch (Exception e) { e.printStackTrace(); }
        }

    }
}
