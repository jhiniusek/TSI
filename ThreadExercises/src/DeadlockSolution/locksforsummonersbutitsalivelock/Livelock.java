package DeadlockSolution.locksforsummonersbutitsalivelock;
public class Livelock {

    public static void main(String[] args) throws InterruptedException {
        Summoner adc = new Summoner("Ashe");
        Summoner support = new Summoner("Bard");

        var thread1 = new Thread(() -> {
            try {
                adc.killCannon(support);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        var thread2 = new Thread(() -> {
            try {
                support.killCannon(adc);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
