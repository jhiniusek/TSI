package DeadlockSolution.cannonhealth;

public class SolvedDeadlock {
    public static void main(String[] args) throws InterruptedException {
        Summoner adc = new Summoner("Ashe");
        Summoner support = new Summoner("Bard");
        CannonMinion cannon = new CannonMinion();

        var thread1 = new Thread(() -> adc.killCannon(support, cannon));
        var thread2 = new Thread(() -> support.killCannon(adc, cannon));
        var thread3 = new Thread(cannon::getDamage);
        thread2.start();
        Thread.sleep(50);
        thread1.start();
        thread3.start();
        thread1.join();
        thread2.join();
    }
}
