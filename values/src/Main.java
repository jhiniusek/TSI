import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Ultimate Paint Calculator");
        System.out.println("How many walls you plan to paint?");

        Scanner reader = new Scanner(System.in);
        String input = " ";

        int numberOfWalls = 0;
        int savedWalls = 0;
        while (numberOfWalls == 0) {
            input = reader.next();
            try{
                numberOfWalls = Integer.parseInt(input);
            }
            catch (Exception e) {
                System.out.println("Incorrect number of walls! Try again!");
            }
        }

        int index = 0;
        int bufferindex = 0;

        ArrayList<Shape> listOfWalls = new ArrayList<Shape>();
        for(int i = 0; i < numberOfWalls; i++){
            Shape newWall = new Shape();
            listOfWalls.add(newWall);
        }


        System.out.println("How many non paintable areas there are? (Windows, Doors, etc.)");

        Integer numberOfWindows = null;
        int savedWindows = 0;

        while (numberOfWindows == null) {
            input = reader.next();
            try{
                numberOfWindows = Integer.parseInt(input);
            }
            catch (Exception e) {
                System.out.println("Incorrect number of not paintable areas! Try again!");
            }
        }

        ArrayList<Shape> listOfWindows = new ArrayList<Shape>();
        for(int i = 0; i < numberOfWindows; i++){
            Shape newWindow = new Shape();
            listOfWindows.add(newWindow);
        }

        boolean run = true;
        while(run == true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add a wall");
            System.out.println("2. Add a not paintable area");
            System.out.println("3. Remove a wall");
            System.out.println("4. Remove a not paintable area");
            System.out.println("5. Check walls");
            System.out.println("6. Calculate");
            System.out.println("7. Help");
            System.out.println("8. Quit");

            input = reader.next();

            switch(input){
                case "1":       //adding a wall
                    if(numberOfWalls == savedWalls){
                        System.out.println("You cant add walls anymore.");
                        break;
                    }
                    for(Shape x : listOfWalls){  //check for the first empty wall
                        if(x.value == 0){
                            bufferindex = index;
                            index = 0;
                            break;
                        }
                        index++;
                    }
                    System.out.println("What is the shape of a wall?\n1.Square\n2.Rectangle\n3.Triangle\n4.Trapezium\n5.Circle piece");
                    input = reader.next();
                    switch(input){
                        case "1" -> {               //SQUARE
                            listOfWalls.get(bufferindex).value = 1;
                            System.out.println("What is the base measurement? (in meters)");
                            try {
                                double base = Double.valueOf(reader.next());
                                listOfWalls.get(bufferindex).base = base;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWalls.get(bufferindex).value = 0;
                                break;

                            }
                            System.out.println("What is the color?");
                            listOfWalls.get(bufferindex).setColor(reader.next());
                            System.out.println("Wall added.");
                            savedWalls++;
                        }
                        case "2" -> {
                            listOfWalls.get(bufferindex).value = 2;
                            System.out.println("What is the base measurement? (in meters)");
                            try {
                                double base = Double.valueOf(reader.next());
                                listOfWalls.get(bufferindex).base = base;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWalls.get(bufferindex).value = 0;
                                break;
                            }
                            System.out.println("What is the height measurement? (in meters)");
                            try {
                                double height = Double.valueOf(reader.next());
                                listOfWalls.get(bufferindex).height = height;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWalls.get(bufferindex).value = 0;
                                break;
                            }
                            System.out.println("What is the color?");
                            listOfWalls.get(bufferindex).setColor(reader.next());
                            System.out.println("Wall added.");
                            savedWalls++;

                        }
                        case "3" -> {
                            listOfWalls.get(bufferindex).value = 3;
                            System.out.println("What is the base measurement? (in meters)");
                            try {
                                double base = Double.valueOf(reader.next());
                                listOfWalls.get(bufferindex).base = base;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWalls.get(bufferindex).value = 0;
                                break;
                            }
                            System.out.println("What is the height measurement? (in meters)");
                            try {
                                double height = Double.valueOf(reader.next());
                                listOfWalls.get(bufferindex).height = height;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWalls.get(bufferindex).value = 0;
                                break;
                            }
                            System.out.println("What is the color?");
                            listOfWalls.get(bufferindex).setColor(reader.next());
                            System.out.println("Wall added.");
                            savedWalls++;
                        }
                        case "4" -> {
                            listOfWalls.get(bufferindex).value = 4;
                            System.out.println("What is the base 1 measurement? (in meters)");
                            try {
                                double base = Double.valueOf(reader.next());
                                listOfWalls.get(bufferindex).base = base;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWalls.get(bufferindex).value = 0;
                                break;
                            }
                            System.out.println("What is the base 2 measurement? (in meters)");
                            try {
                                double base2 = Double.valueOf(reader.next());
                                listOfWalls.get(bufferindex).base2 = base2;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWalls.get(bufferindex).value = 0;
                                break;
                            }
                            System.out.println("What is the height measurement (in meters)?");
                            try {
                                double height = Double.valueOf(reader.next());
                                listOfWalls.get(bufferindex).height = height;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWalls.get(bufferindex).value = 0;
                                break;
                            }
                            System.out.println("What is the color?");
                            listOfWalls.get(bufferindex).setColor(reader.next());
                            System.out.println("Wall added.");
                            savedWalls++;
                        }
                        case "5" -> {
                            listOfWalls.get(bufferindex).value = 5;
                            System.out.println("What is the radius measurement (in meters)?");
                            try {
                                double base = Double.valueOf(reader.next());
                                listOfWalls.get(bufferindex).base = base;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWalls.get(bufferindex).value = 0;
                                break;

                            }
                            System.out.println("How many degrees does your circle piece have?");
                            try {
                                double degree = Double.valueOf(reader.next());
                                if(degree > 0 && degree <= 360){
                                    listOfWalls.get(bufferindex).degree = degree;
                                }
                                else{
                                    System.out.println("Incorrect amount of degrees! Try again!");
                                    listOfWalls.get(bufferindex).value = 0;
                                    break;
                                }
                            }
                            catch (Exception e){
                                System.out.println("Incorrect amount of degrees! Try again!");
                                listOfWalls.get(bufferindex).value = 0;
                                break;

                            }
                            System.out.println("What is the color?");
                            listOfWalls.get(bufferindex).setColor(reader.next());
                            System.out.println("Wall added.");
                            savedWalls++;
                        }
                        default -> System.out.println("Incorrect input! Try again!");
                    }
                    break;

                case "2":   //Add a not paintable area
                    if(numberOfWindows == savedWindows){
                        System.out.println("You cant add not paintable areas anymore.");
                        break;
                    }
                    for(Shape x : listOfWindows){  //check for the first empty wall
                        if(x.value == 0){
                            bufferindex = index;
                            index = 0;
                            break;
                        }
                        index++;
                    }
                    System.out.println("On which wall the area is?");
                    input = reader.next();
                    try {
                        Integer wallId = Integer.parseInt(input) - 1;
                        if(wallId >= 0 && wallId <= numberOfWalls - 1)
                        {
                            listOfWindows.get(bufferindex).wall = false;
                            listOfWindows.get(bufferindex).wallIndex = wallId;
                        }
                        else{
                            System.out.println("There is no wall with this number!");
                            break;
                        }
                    }
                    catch (Exception e){
                        System.out.println("There is no wall with this number!");
                        break;
                    }
                    System.out.println("What is the shape of a not paintable area?\n1.Square\n2.Rectangle\n3.Triangle\n4.Trapezium\n5.Circle piece");
                    input = reader.next();
                    switch(input){
                        case "1" -> {               //SQUARE
                            listOfWindows.get(bufferindex).value = 1;
                            System.out.println("What is the base measurement? (in meters)");
                            try {
                                double base = Double.valueOf(reader.next());
                                listOfWindows.get(bufferindex).base = base;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWindows.get(bufferindex).value = 0;
                                break;

                            }
                            System.out.println("Area added.");
                            savedWindows++;
                        }
                        case "2" -> {
                            listOfWindows.get(bufferindex).value = 2;
                            System.out.println("What is the base measurement? (in meters)");
                            try {
                                double base = Double.valueOf(reader.next());
                                listOfWindows.get(bufferindex).base = base;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWindows.get(bufferindex).value = 0;
                                break;
                            }
                            System.out.println("What is the height measurement? (in meters)");
                            try {
                                double height = Double.valueOf(reader.next());
                                listOfWindows.get(bufferindex).height = height;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWindows.get(bufferindex).value = 0;
                                break;
                            }
                            System.out.println("Area added.");
                            savedWindows++;

                        }
                        case "3" -> {
                            listOfWindows.get(bufferindex).value = 3;
                            System.out.println("What is the base measurement? (in meters)");
                            try {
                                double base = Double.valueOf(reader.next());
                                listOfWindows.get(bufferindex).base = base;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWindows.get(bufferindex).value = 0;
                                break;
                            }
                            System.out.println("What is the height measurement? (in meters)");
                            try {
                                double height = Double.valueOf(reader.next());
                                listOfWindows.get(bufferindex).height = height;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWindows.get(bufferindex).value = 0;
                                break;
                            }
                            System.out.println("Area added.");
                            savedWindows++;
                        }
                        case "4" -> {
                            listOfWindows.get(bufferindex).value = 4;
                            System.out.println("What is the base 1 measurement? (in meters)");
                            try {
                                double base = Double.valueOf(reader.next());
                                listOfWindows.get(bufferindex).base = base;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWindows.get(bufferindex).value = 0;
                                break;
                            }
                            System.out.println("What is the base 2 measurement? (in meters)");
                            try {
                                double base2 = Double.valueOf(reader.next());
                                listOfWindows.get(bufferindex).base2 = base2;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWindows.get(bufferindex).value = 0;
                                break;
                            }
                            System.out.println("What is the height measurement (in meters)?");
                            try {
                                double height = Double.valueOf(reader.next());
                                listOfWindows.get(bufferindex).height = height;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWindows.get(bufferindex).value = 0;
                                break;
                            }
                            System.out.println("Area added.");
                            savedWindows++;
                        }
                        case "5" -> {
                            listOfWindows.get(bufferindex).value = 5;
                            System.out.println("What is the radius measurement (in meters)?");
                            try {
                                double base = Double.valueOf(reader.next());
                                listOfWindows.get(bufferindex).base = base;
                            }
                            catch (Exception e){
                                System.out.println("Incorrect measurement! Try again!");
                                listOfWindows.get(bufferindex).value = 0;
                                break;

                            }
                            System.out.println("How many degrees does your circle piece have?");
                            try {
                                double degree = Double.valueOf(reader.next());
                                if(degree > 0 && degree <= 360){
                                    listOfWindows.get(bufferindex).degree = degree;
                                }
                                else{
                                    System.out.println("Incorrect amount of degrees! Try again!");
                                    listOfWindows.get(bufferindex).value = 0;
                                    break;
                                }
                            }
                            catch (Exception e){
                                System.out.println("Incorrect amount of degrees! Try again!");
                                listOfWindows.get(bufferindex).value = 0;
                                break;

                            }
                            System.out.println("Area added.");
                            savedWindows++;
                        }
                        default -> System.out.println("Incorrect input! Try again!");
                    }
                    break;

                case "3": //Remove a wall
                    System.out.println("Which wall you want to remove?");
                    input = reader.next();
                    try{
                        int wallToRemove = Integer.parseInt(input);
                        listOfWalls.get(wallToRemove-1).value = 0;
                        savedWalls--;
                    }
                    catch (Exception e){
                        System.out.println("Invalid wall number.");
                        break;
                    }
                    break;
                case "4": //Remove a window
                    System.out.println("Which area you want to remove?");
                    input = reader.next();
                    try{
                        int areaToRemove = Integer.parseInt(input);
                        listOfWindows.get(areaToRemove-1).value = 0;
                        savedWindows--;
                    }
                    catch (Exception e){
                        System.out.println("Invalid wall number.");
                        break;
                    }
                    break;
                case "5": //Check walls and windows
                    for(Shape i: listOfWalls) {
                        if(i.value != 0){
                            System.out.println("Wall nr: " + (listOfWalls.indexOf(i) + 1) + "\tShape: " + i.getShape() + "\tMeasurements: " + i.getMeasurements() + "\tColor: " + i.getColor());
                            for(Shape z: listOfWindows) {
                                if(z.value != 0 && z.wallIndex == listOfWalls.indexOf(i)){
                                    System.out.println("\tNon printable area nr: " + (listOfWindows.indexOf(z) + 1) + "\tShape: " + z.getShape() + "\tMeasurements: " + z.getMeasurements() + "\tWall: " + z.wallIndex);
                                }
                            }
                        }
                        else{
                            System.out.println("Empty Wall Slot");
                            for(Shape z: listOfWindows) {
                                if(z.value != 0 && z.wallIndex == listOfWalls.indexOf(i)){
                                    System.out.println("\tNon printable area nr: " + (listOfWindows.indexOf(z) + 1) + "\tShape: " + z.getShape() + "\tMeasurements: " + z.getMeasurements() + "\tWall: " + z.wallIndex);
                                }
                            }
                        }
                    }
                    break;
                case "6": //calculate
                    ArrayList<String> colors = new ArrayList<String>();
                    for(Shape i: listOfWalls) {
                        if(i.value != 0){
                            if(colors.contains(i.color.toUpperCase())) {
                                //how to do 'not contains'
                            }
                            else {
                                colors.add(i.color.toUpperCase());
                            }
                        }
                    }
                    ArrayList<Double> price = new ArrayList<Double>();
                    ArrayList<Double> coverage = new ArrayList<Double>();
                    ArrayList<Double> totalPrice = new ArrayList<Double>();
                    ArrayList<Double> totalPaint = new ArrayList<Double>();
                    for(String x : colors){
                        System.out.println("What is a price for a litre of: " + x);
                        try {
                            double newprice = Double.valueOf(reader.next());
                            price.add(newprice);
                            totalPrice.add(0d);
                        }
                        catch (Exception e){
                            System.out.println("Incorrect price! Try again!");
                            break;
                        }
                        System.out.println("What is a coverage of one litre of: " + x + " (in square metres)");
                        try {
                            double newcoverage = Double.valueOf(reader.next());
                            coverage.add(newcoverage);
                            totalPaint.add(0d);
                        }
                        catch (Exception e){
                            System.out.println("Incorrect coverage! Try again!");
                            break;
                        }
                    }
                    for(Shape x : listOfWalls){
                        if(x.value != 0){
                            String wallColor = x.getColor();
                            index = colors.indexOf(wallColor.toUpperCase());
                            double wallArea = x.calculateArea();
                            for(Shape y : listOfWindows){
                                if(y.value != 0 && y.wallIndex == listOfWalls.indexOf(x)) {
                                    wallArea -= y.calculateArea();
                                }
                            }
                            double paintLitres = totalPaint.get(index) + wallArea / coverage.get(colors.indexOf(wallColor.toUpperCase()));
                            totalPaint.set(index, paintLitres);
                        }
                    }
                    for(String x : colors){
                        totalPrice.set(colors.indexOf(x), totalPaint.get(colors.indexOf(x)) * price.get(colors.indexOf(x)));
                        System.out.println("\nFor paint in color: " + x);
                        System.out.printf("\nPaint needed: %,.2fL", totalPaint.get(colors.indexOf(x)));
                        System.out.printf("\nCost: £%,.2f", totalPrice.get(colors.indexOf(x)));
                    }
                    break;
                case "7": //help
                    System.out.println("Welcome to the Ultimate Paint Calculator");
                    System.out.println("Do not use anything other than digits and dot while inputting measurements, prices and coverages");
                    System.out.println("Name your colors!");
                    System.out.println("The colors are not case sensitive.");
                    System.out.println("'White' is the same as 'white' or 'WhITe'");
                    System.out.println("You can remove a wall which contains not printable area.");
                    System.out.println("Non printable areas will stick to the empty wall,");
                    System.out.println("so remember to add a new wall after removing one");
                    break;
                case "8": //quit
                    run = false;
                    break;
                default:
                    System.out.println("Incorrect input, try again!");
            }

        }
    }
}