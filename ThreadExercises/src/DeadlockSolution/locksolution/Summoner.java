package DeadlockSolution.locksolution;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Summoner {
    public final String name;
    public boolean killedCannon = false;

    public Summoner(String name){
        this.name = name;
    }

    public void killCannon(Summoner ally, CannonMinion cannon) throws InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();

        if(!ally.killedCannon){
            System.out.println("\033[34m["+dtf.format(localTime)+"] "+ this.name + ": \033[0m" + ally.name + " should get a cannon minion.");
            try{
                Thread.sleep(1000);
            } catch (Exception e){
                System.out.println("Thread Interrupted");
            }
            killedCannon = cannon.getDamage();
            ally.killCannon(this, cannon);
        }

    }
}
