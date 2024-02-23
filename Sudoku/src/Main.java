import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("SUDOKU");

        // HARDCODING SUDOKU TO SOLVE
        ArrayList<Integer> toImport;
        ArrayList<Integer> toImportNOSOLUTION;
        ArrayList<Integer> mohit;
        ArrayList<Integer> moreThan1Solution;
        ArrayList<Integer> tenSolutions;
        ArrayList<Integer> oneSolution16x16;
        if(true){
            toImport = new ArrayList<Integer>(Arrays.asList(
                    0,0,6,3,0,7,0,0,0,
                    0,0,4,0,0,0,0,0,5,
                    1,0,0,0,0,6,0,8,2,
                    2,0,5,0,3,0,1,0,6,
                    0,0,0,2,0,0,3,0,0,
                    9,0,0,0,7,0,0,0,4,
                    0,5,0,0,0,0,0,0,0,
                    0,1,0,0,0,0,0,0,0,
                    0,0,8,1,0,9,0,4,0));

            toImportNOSOLUTION = new ArrayList<Integer>(Arrays.asList(
                    0,0,0,0,0,0,6,0,0,
                    0,2,0,0,3,0,0,0,1,
                    0,0,0,0,0,0,5,0,0,
                    0,0,0,0,0,0,1,0,0,
                    0,6,0,0,0,9,0,0,0,
                    0,4,0,0,0,0,0,0,2,
                    0,0,0,0,8,0,0,0,0,
                    0,3,0,0,0,0,0,0,0,
                    0,0,8,0,0,0,0,2,0));

            mohit = new ArrayList<Integer>(Arrays.asList(
                    1,0,0,0,2,0,3,0,4,
                    0,4,0,5,6,0,7,8,0,
                    0,9,0,0,8,0,0,0,2,
                    0,0,3,0,0,8,0,0,7,
                    0,0,7,0,0,0,6,0,0,
                    8,0,0,2,0,0,9,0,0,
                    6,0,0,0,1,0,0,3,0,
                    0,5,8,0,9,3,0,7,0,
                    2,0,1,0,4,0,0,0,6));

            moreThan1Solution = new ArrayList<Integer>(Arrays.asList(
                    2,9,5,7,4,3,8,6,1,
                    4,3,1,8,6,5,9,0,0,
                    8,7,6,1,9,2,5,4,3,
                    3,8,7,4,5,9,2,1,6,
                    6,1,2,3,8,7,4,9,5,
                    5,4,9,2,1,6,7,3,8,
                    7,6,3,5,2,4,1,8,9,
                    9,2,8,6,7,1,3,5,4,
                    1,5,4,9,3,8,6,0,0));

            tenSolutions = new ArrayList<Integer>(Arrays.asList(
                    5,9,0,0,0,0,0,4,8,
                    6,0,8,0,0,0,3,0,7,
                    0,0,0,2,0,1,0,0,0,
                    0,0,0,0,4,0,0,0,0,
                    0,7,5,3,0,6,9,8,0,
                    0,0,0,0,9,0,0,0,0,
                    0,0,0,8,0,3,0,0,0,
                    2,0,6,0,0,0,7,0,9,
                    3,4,0,0,0,0,0,6,5));

            oneSolution16x16 = new ArrayList<Integer>(Arrays.asList(
                    2,0,3,7,0,5,9,6,0,8,0,0,14,13,15,16,
                    5,0,9,10,1,0,4,0,7,15,0,0,0,3,0,12,
                    4,16,0,0,0,11,13,0,2,5,12,3,1,0,7,0,
                    11,12,0,15,3,0,16,7,1,0,0,9,4,5,0,2,
                    0,0,1,2,0,0,0,0,0,0,0,12,15,0,16,13,
                    0,4,0,8,2,0,0,0,3,16,15,13,9,0,12,5,
                    14,0,5,0,0,0,0,3,0,0,9,7,0,1,8,10,
                    0,15,16,9,8,13,0,11,0,1,2,10,0,7,0,6,
                    1,3,0,11,9,0,0,16,0,0,4,5,0,8,0,15,
                    7,0,6,0,13,0,8,1,11,9,0,15,0,12,3,14,
                    8,0,14,0,0,3,0,5,0,2,6,0,10,4,9,11,
                    0,5,0,12,11,0,2,4,10,0,7,8,0,16,13,0,
                    0,7,0,1,4,6,0,0,9,12,0,14,16,0,0,8,
                    16,14,0,3,5,15,0,12,8,10,1,2,13,9,6,0,
                    15,0,2,0,0,9,0,0,0,7,0,6,12,0,1,4,
                    0,0,12,0,16,7,1,8,15,13,5,0,11,0,0,3));
        }


        /// CLASSIC 9x9 SOLVING ///

//        SudokuGrid sudoku = new SudokuGrid(9);
//        sudoku.importGrid(toImport);
//        System.out.println(sudoku);
//        //sudoku.checkIfMoreSolutions();
//        sudoku.findAllSolutions(1);
//        //sudoku.findFirstSolution(1);
//        ArrayList<ArrayList<Integer>> solutions = sudoku.getSolutions();
//        System.out.println("There are that many solutions: " + solutions.size());


        /// 16x16 SOLVING ///

//        SudokuGrid sudoku = new SudokuGrid(16);
//        sudoku.importGrid(oneSolution16x16);
//        System.out.println(sudoku);
//        //sudoku.checkIfMoreSolutions();
//        //sudoku.findAllSolutions(1);
//        sudoku.findFirstSolution(1);
//        ArrayList<ArrayList<Integer>> solutions = sudoku.getSolutions();
//        System.out.println("There are that many solutions: " + solutions.size());


        /// 9x9 GENERATE PUZZLE ///

        SudokuGrid sudoku = new SudokuGrid(9);
        sudoku.generateRandomSudoku();
        System.out.println("\nPUZZLE:");
        sudoku.setPuzzle(25);             // gets hard around 24

        System.out.println(sudoku);

        System.out.println("\nSOLUTIONS:");
        sudoku.findAllSolutions(1);

        ArrayList<ArrayList<Integer>> solutions = sudoku.getSolutions();
        System.out.println("There are that many solutions: " + solutions.size());
        System.out.println(solutions.get(0));



        /// 16x16 GENERATE PUZZLE ///

//        SudokuGrid sudoku = new SudokuGrid(16);
//        sudoku.generateRandomSudoku();
//        System.out.println(sudoku);
//        System.out.println("\nPUZZLE:");
//        sudoku.setPuzzle(200);
//
//        System.out.println(sudoku);
//
//        System.out.println("\nSOLUTIONS:");
//        sudoku.findAllSolutions(1);
//
//        ArrayList<ArrayList<Integer>> solutions = sudoku.getSolutions();
//        System.out.println("There are that many solutions: " + solutions.size());
//        System.out.println(solutions.get(0));
    }
}