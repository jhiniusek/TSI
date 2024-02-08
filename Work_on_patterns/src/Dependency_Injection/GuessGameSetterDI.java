package Dependency_Injection;
import java.util.Scanner;

public class GuessGameSetterDI {
    public static final GuessGameSetterDI instance = new GuessGameSetterDI();
    private int targetNumber;
    private GuessGameSetterDI() {}
    public static GuessGameSetterDI getInstance(){
        return instance;
    }

    public void setTargetNumber(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    public void playGame() {

        Scanner fromUser = new Scanner(System.in);

        System.out.println("I'm thinking of a number between 1 and 100. Can you guess what it is?");
        int guess;

        while(true) {
            guess = fromUser.nextInt(); //just don't give bad values :)
            if(guess == targetNumber) {
                break;
            } else {
                System.out.print("That guess is too ");
                if(guess > targetNumber) {
                    System.out.print("high");
                } else {
                    System.out.print("low");
                }
                System.out.println(" try again!");
            }
        }
        System.out.println("You got it! It was " + targetNumber + " all along!");
    }

}
