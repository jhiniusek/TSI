import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("SUDOKU");

        // HARDCODING SUDOKU TO SOLVE
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

        ArrayList<Integer> toImportNOSOLUTION = new ArrayList<Integer>(Arrays.asList(
                0,0,0,0,0,0,6,0,0,
                0,2,0,0,3,0,0,0,1,
                0,0,0,0,0,0,5,0,0,
                0,0,0,0,0,0,1,0,0,
                0,6,0,0,0,9,0,0,0,
                0,4,0,0,0,0,0,0,2,
                0,0,0,0,8,0,0,0,0,
                0,3,0,0,0,0,0,0,0,
                0,0,8,0,0,0,0,2,0));

        ArrayList<Integer> mohit = new ArrayList<Integer>(Arrays.asList(
                1,0,0,0,2,0,3,0,4,
                0,4,0,5,6,0,7,8,0,
                0,9,0,0,8,0,0,0,2,
                0,0,3,0,0,8,0,0,7,
                0,0,7,0,0,0,6,0,0,
                8,0,0,2,0,0,9,0,0,
                6,0,0,0,1,0,0,3,0,
                0,5,8,0,9,3,0,7,0,
                2,0,1,0,4,0,0,0,6));

        ArrayList<Integer> moreThan1Solution = new ArrayList<Integer>(Arrays.asList(
                2,9,5,7,4,3,8,6,1,
                4,3,1,8,6,5,9,0,0,
                8,7,6,1,9,2,5,4,3,
                3,8,7,4,5,9,2,1,6,
                6,1,2,3,8,7,4,9,5,
                5,4,9,2,1,6,7,3,8,
                7,6,3,5,2,4,1,8,9,
                9,2,8,6,7,1,3,5,4,
                1,5,4,9,3,8,6,0,0));

        ArrayList<Integer> tenSolutions = new ArrayList<Integer>(Arrays.asList(
                5,9,0,0,0,0,0,4,8,
                6,0,8,0,0,0,3,0,7,
                0,0,0,2,0,1,0,0,0,
                0,0,0,0,4,0,0,0,0,
                0,7,5,3,0,6,9,8,0,
                0,0,0,0,9,0,0,0,0,
                0,0,0,8,0,3,0,0,0,
                2,0,6,0,0,0,7,0,9,
                3,4,0,0,0,0,0,6,5));

        SudokuGrid sudoku = new SudokuGrid();
        sudoku.importGrid(tenSolutions);
        System.out.println(sudoku);


        long startTimeOriginal = System.nanoTime();
        boolean resultOriginal = sudoku.checkIfMoreSolutions();     ///1.9 - check if more         ///2.9 - find all
        long endTimeOriginal = System.nanoTime();
        double timeOriginal = (endTimeOriginal - startTimeOriginal) / 1e7;


        System.out.println("moresolutions method result: " + resultOriginal + ", Time taken: " + timeOriginal + " seconds");


        //sudoku.findAllSolutions();
        //sudoku.findOneSolution();
        ArrayList<ArrayList<Integer>> solutions = sudoku.getSolutions();
        System.out.println("There are that many solutions: " + solutions.size());



//        SudokuGrid sudoku = new SudokuGrid();
//        sudoku.generateRandomSudoku();
//        System.out.println("\nPUZZLE:");
//        sudoku.setPuzzleRecursive();    //3 is dangerous
//        System.out.println("\nSOLUTIONS:");
//        sudoku.findAllSolutions();
//
//        ArrayList<ArrayList<Integer>> solutions = sudoku.getSolutions();
//        System.out.println("There are that many solutions: " + solutions.size());
//        System.out.println(solutions.get(0));


    }
}