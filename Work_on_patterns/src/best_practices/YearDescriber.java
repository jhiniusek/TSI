package best_practices;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import static java.lang.Math.floor;

/*
This class has a super bloated method that does too many things at once. Refactor the describeYear method and
separate out the responsibilities into other methods to improve readability and maintainability.
 */
public class YearDescriber {

    static Scanner fromUser = new Scanner(System.in);

    private YearDescriber(){}; //static class

    public static void describeYear() {
        System.out.println("What year would you like to learn about?");
        int year = getYear();
        String printMessage = year + " was " + isLeap(year) + " and started on a " + getStartDay(year) + "!";
        System.out.println(printMessage);
    }

    public static int getYear(){
        int year;
        while(true) {
            String input = fromUser.next();
            try {
                year = Integer.parseInt(input);
                break;
            } catch (Exception e) {
                System.out.println("Please just input a year in the format YYYY!");
            }
        }
        return year;
    }

    public static String isLeap(int year){
        String message;
        if((year%4 == 0) || ((year%100 == 0) && !(year%400 == 0))) {
            message = "a leap year,";
        } else {
            message = "not a leap year,";
        }
        return message;
    }

    public static String getStartDay(int year){
        String message;
        int startDay = (1 + (int)floor((2.6*11) -0.2) - (2*(year/100)) + ((year%100)-1) + (int)floor((double)((year%100)-1) / 4) + (int)floor((double)(year/100) / 4));
        /*
        int/int uses integer division e.g 11/5 = 2 (discard the remainder)
        double/int uses true division e.g. (double)(11)/5 = 2.2
        */
        startDay = (startDay % 7 + 7) % 7;
        /*
        % is remainder function, NOT modulus division operator.
        Line 56 implements true modulus division.
        https://cs.uwaterloo.ca/~alopez-o/math-faq/node73.html for more info on the equation used.
        */

        List<String> day = Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

        message = day.get(startDay);
        return message;
    }
}
