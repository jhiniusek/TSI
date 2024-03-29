import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Multithreading {

    public static Void createGrid(int size){
        SudokuGrid sudoku = new SudokuGrid(size);
        sudoku.generateRandomSudoku();
        return null;
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {
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

        ArrayList<Integer> toImport = new ArrayList<Integer>(Arrays.asList(
                0,0,6,3,0,7,0,0,0,
                0,0,4,0,0,0,0,0,5,
                1,0,0,0,0,6,0,8,2,
                2,0,5,0,3,0,1,0,6,
                0,0,0,2,0,0,3,0,0,
                9,0,0,0,7,0,0,0,4,
                0,5,0,0,0,0,0,0,0,
                0,1,0,0,0,0,0,0,0,
                0,0,8,1,0,9,0,4,0));



        /// VALIDATION WITH MULTITHREADING ///

//        SudokuGrid sudoku = new SudokuGrid(9);
//        sudoku.importGrid(invalidSudoku);
//
//        Validator check = new Validator(sudoku);
//        List<Future<Boolean>> results;
//
//        final var tasks = new ArrayList<Callable<Boolean>>();
//        tasks.add(check::validColumns);
//        tasks.add(check::validRows);
//        tasks.add(check::validBoxes);
//
//        try(var pool = Executors.newFixedThreadPool(3)){
//            results = pool.invokeAll(tasks);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        if(results.get(0).get() && results.get(1).get() && results.get(2).get()){
//            System.out.println("Valid");
//        } else {
//            System.out.println("Invalid");
//        }


        /// SOLVING WITH MULTITHREADING ///

//        ArrayList<Thread> listOfThreads = new ArrayList<Thread>();
//        for(int i = 1; i <= 9; i++){
//            SudokuGrid threadSudoku = new SudokuGrid(9);
//            threadSudoku.importGrid(toImport);
//            var thread = new Thread(new SolverThread(i, threadSudoku));
//            thread.start();
//            listOfThreads.add(thread);
//        }
//
//        for(Thread x : listOfThreads){
//            x.join();
//        }


        /// GENERATING MULTIPLE GRIDS ///

//        final var tasks = new ArrayList<Callable<Void>>();
//
//        for(int i = 0; i<10; i++){
//            tasks.add(() -> createGrid(9));
//        }
//
//        try(var pool = Executors.newCachedThreadPool()){
//            pool.invokeAll(tasks);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }



        /// BITCOIN MINER ///

        ArrayList<Thread> listOfThreads = new ArrayList<Thread>();
        Canceller cancel = new Canceller();

        for(int i = 1; i <= 4; i++){
            SudokuGrid threadSudoku = new SudokuGrid(9);
            threadSudoku.generateRandomSudoku();
            var thread = new Thread(new PuzzelerThread(threadSudoku, 23, cancel));  //aroud 24 gets hard to generate
            listOfThreads.add(thread);
        }
        for(Thread x : listOfThreads){
            x.start();
        }
    }
}