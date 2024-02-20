package DeadlockSolution.locksforsummonersbutitsalivelock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Summoner {
    public String name;
    public ReentrantLock lock = new ReentrantLock();
    public boolean killedCannon = false;

    public Summoner(String name){
        this.name = name;
    }

    public void killCannon(Summoner ally) throws InterruptedException {
        if(!ally.killedCannon && !killedCannon){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            try{
                lock.tryLock(100, TimeUnit.MILLISECONDS);
                ally.lock.tryLock(100, TimeUnit.MILLISECONDS);

                if(lock.isHeldByCurrentThread() && ally.lock.isHeldByCurrentThread()){
                    if(!ally.killedCannon){
                        LocalTime localTime = LocalTime.now();
                        System.out.println("[" + dtf.format(localTime) + "] Cannon minion has been slain by " + this.name + ".");
                        killedCannon=true;
                    }
                } else {
                    LocalTime localTime = LocalTime.now();
                    System.out.println("\033[34m["+dtf.format(localTime)+"] "+ this.name + ": \033[0m" + ally.name + " should get a cannon minion.");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                if(lock.isHeldByCurrentThread()){
                    lock.unlock();
                }
                if(ally.lock.isHeldByCurrentThread()){
                    ally.lock.unlock();
                }
                Random random = new Random();
                int time = random.nextInt(10 - 5 + 1) + 5;
                Thread.sleep(100*time);
                ally.killCannon(this);
            }
        }
    }
}
