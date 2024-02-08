package Car_Builder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarDirector director = new CarDirector();
        CarBuilder builder;
        Car usersCar;
        Scanner fromUser = new Scanner(System.in);
        System.out.println("What car you want to create?");
        String input = fromUser.next();

        if(input.equals("sport")){
            builder = new SportsCar();
            director.construct(builder);
            usersCar = builder.getCarInfo();
        }
        else{
            builder = new FamilyCar();
            director.construct(builder);
            usersCar = builder.getCarInfo();
        }
        usersCar.getInfo();
    }
}
