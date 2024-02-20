package DeadlockSolution.playerpatience;

public class SolvedDeadlock {
    public static void main(String[] args) throws InterruptedException {
        Summoner adc = new Summoner("Ashe");
        Summoner support = new Summoner("Bard");

        var thread1 = new Thread(() -> adc.killCannon(support));
        var thread2 = new Thread(() -> support.killCannon(adc));
        thread2.start();
        Thread.sleep(50);
        thread1.start();
        thread1.join();
        thread2.join();
    }
}
