package DeadlockSolution.cannonhealth;

public class CannonMinion {
    public int health = 10;
    public boolean alive = true;

    public void getDamage(){
        while(true){
            try{
                Thread.sleep(1000);
            } catch (Exception e){
                System.out.println("ThreadInterrupted");
            }
            health --;
            if(health == 0){
                alive = false;
                System.out.println("Cannon minion died.");
                break;
            }
        }
    }


}
