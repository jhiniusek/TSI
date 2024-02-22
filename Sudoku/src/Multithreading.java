import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Multithreading {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SudokuGrid sudoku = new SudokuGrid();
//        sudoku.generateEmptyGrid();
//        sudoku.generateRandomSudoku();

        ArrayList<Integer> invalidSudoku = new ArrayList<Integer>(Arrays.asList(
                2,9,5,7,4,3,8,6,1,
                4,3,1,8,6,5,9,7,2,
                8,7,6,1,9,2,5,4,3,
                3,8,7,4,5,9,2,1,6,
                6,1,2,3,8,7,4,9,5,
                5,4,9,2,1,6,7,3,8,
                7,6,3,5,2,4,1,8,9,
                9,2,8,6,7,1,3,5,4,
                1,5,4,9,3,8,6,2,8)); //9,9 = 7

        sudoku.importGrid(invalidSudoku);

        Validator check = new Validator(sudoku);
        List<Future<Boolean>> results;

        final var tasks = new ArrayList<Callable<Boolean>>();
        tasks.add(check::validColumns);
        tasks.add(check::validRows);
        tasks.add(check::validBoxes);

        try(var pool = Executors.newFixedThreadPool(3)){
            results = pool.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(results.get(0).get() && results.get(1).get() && results.get(2).get()){
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}