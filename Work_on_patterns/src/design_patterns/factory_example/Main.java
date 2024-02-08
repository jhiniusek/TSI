package design_patterns.factory_example;

import java.util.Scanner;

import static Animal_Factory.AnimalFactory.createAnimal;
import static design_patterns.factory_example.ShapeFactory.createShape;

public class Main {
    public static void main(String[] args) {
        Scanner fromUser = new Scanner(System.in);
        System.out.println("What shape you want to create?");
        String input = fromUser.next();

        createShape(input).draw();
    }
}
