package Deadlock;

public class DeadlockTask {
    public static void main(String[] args) throws InterruptedException {
        Summoner adc = new Summoner("Ashe");
        Summoner support = new Summoner("Bard");

        var thread1 = new Thread(() -> adc.killCannon(support));
        var thread2 = new Thread(() -> support.killCannon(adc));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Cannon minion died.");
    }
}