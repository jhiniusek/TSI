package DeadlockSolution.locksolution;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SolvedDeadlock {
    public static void main(String[] args) throws InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        Summoner adc = new Summoner("Ashe");
        Summoner support = new Summoner("Bard");
        CannonMinion cannon = new CannonMinion();

        var thread1 = new Thread(() -> {
            try {
                adc.killCannon(support, cannon);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        var thread2 = new Thread(() -> {
            try {
                support.killCannon(adc, cannon);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        if(adc.killedCannon){
            LocalTime localTime = LocalTime.now();
            System.out.println("["+dtf.format(localTime)+"] Cannon minion has been slain by " + adc.name);
            System.out.println("\033[34m["+dtf.format(localTime)+"] "+ adc.name + ": \033[0mOh...");
        }
        if(support.killedCannon){
            LocalTime localTime = LocalTime.now();
            System.out.println("["+dtf.format(localTime)+"] Cannon minion has been slain by " + support.name);
            System.out.println("\033[34m["+dtf.format(localTime)+"] "+ support.name + ": \033[0mOh...");
        }
    }
}
