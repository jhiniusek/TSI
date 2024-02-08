package Animal_Factory;
import java.util.Scanner;

import static Animal_Factory.AnimalFactory.createAnimal;

public class Main {
    public static void main(String[] args) {

        Scanner fromUser = new Scanner(System.in);
        System.out.println("What animal you want to create?");
        String input = fromUser.next();

        createAnimal(input).saySomething();

    }
}