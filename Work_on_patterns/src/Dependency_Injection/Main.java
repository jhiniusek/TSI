package Dependency_Injection;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random generator = new Random();
        int target;

        //SETTER DI
        target = generator.nextInt(101);
        GuessGameSetterDI game = GuessGameSetterDI.getInstance();
        game.setTargetNumber(target);
        game.playGame();

        //CONSTRUCTOR DI
        target = generator.nextInt(101);
        GuessGameConstructorDI game2 = new GuessGameConstructorDI(target);
        game2.playGame();
    }
}
