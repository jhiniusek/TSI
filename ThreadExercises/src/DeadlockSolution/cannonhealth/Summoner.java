package DeadlockSolution.cannonhealth;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Summoner {
    public final String name;
    public boolean killedCannon = false;

    public Summoner(String name){
        this.name = name;
    }

    public void killCannon(Summoner ally, CannonMinion cannon){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        if(cannon.alive){
            if(!ally.killedCannon){
                System.out.println("\033[34m["+dtf.format(localTime)+"] "+ this.name + ": \033[0m" + ally.name + " should get a cannon minion.");
                try{
                    Thread.sleep(1500);
                } catch (Exception e){
                    System.out.println("Thread Interrupted");
                }

                ally.killCannon(this, cannon);
            } else {
                System.out.println("["+dtf.format(localTime)+"] Cannon minion has been slain by " + this.name);
                killedCannon = true;
            }
        } else {
            System.out.println("\033[34m["+dtf.format(localTime)+"] "+ this.name + ": \033[0mReport " + ally.name + " please.");
        }
    }
}
