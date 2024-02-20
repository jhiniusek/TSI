package DeadlockSolution.locksolution;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class CannonMinion {
    private int health;
    private final ReentrantLock lock = new ReentrantLock();
    private boolean dead = false;

    public CannonMinion() {
        Random random = new Random();
        this.health = random.nextInt(8 - 3 + 1) + 3;
    }

    public boolean getDamage() throws InterruptedException {
        if(!dead){
            try{
                lock.lock();
                Thread.sleep(1000);
                if(!dead){
                    health--;
                    if(health == 0){
                        dead = true;
                    }
                }
            } finally {
                lock.unlock();
            }
        }
        return dead;
    }
}
