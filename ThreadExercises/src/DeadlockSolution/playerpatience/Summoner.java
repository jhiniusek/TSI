package DeadlockSolution.playerpatience;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Summoner {
    public final String name;
    public boolean killedCannon = false;
    public int patience;

    public Summoner(String name){
        this.name = name;
        Random random = new Random();
        this.patience = random.nextInt(6 - 3 + 1) + 3;
    }

    public void killCannon(Summoner ally){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        if(!killedCannon){
            if(patience > 0){
                if(!ally.killedCannon){
                    System.out.println("\033[34m["+dtf.format(localTime)+"] "+ this.name + ": \033[0m" + ally.name + " should get a cannon minion.");
                    patience--;
                    try{
                        Thread.sleep(1500);
                    } catch (Exception e){
                        System.out.println("Thread Interrupted");
                    }
                    ally.killCannon(this);
                }
            }  else {
                try{
                    Thread.sleep(500);
                } catch (Exception e){
                    System.out.println("Thread Interrupted");
                }
                if(!ally.killedCannon){
                    System.out.println("\033[34m["+dtf.format(localTime)+"] "+ this.name + ": \033[0m... Fine.");
                    System.out.println("[" + dtf.format(localTime) + "] Cannon minion has been slain by " + this.name + ".");
                    this.killedCannon = true;
                }
            }
        }
    }
}
