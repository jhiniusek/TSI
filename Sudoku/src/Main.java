import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("SUDOKU");

        SudokuGrid sudoku = new SudokuGrid();

        // HARDCODING SUDOKU TO SOLVE
        ArrayList<Integer> toImport = new ArrayList<Integer>(Arrays.asList(0,0,6,3,0,7,0,0,0,0,0,4,0,0,0,0,0,5,1,0,0,0,0,6,0,8,2,2,0,5,0,3,0,1,0,6,0,0,0,2,0,0,3,0,0,9,0,0,0,7,0,0,0,4,0,5,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,8,1,0,9,0,4,0));

        ArrayList<Integer> toImportNOSOLUTION = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,6,0,0,0,2,0,0,3,0,0,0,1,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,1,0,0,0,6,0,0,0,9,0,0,0,0,4,0,0,0,0,0,0,2,0,0,0,0,8,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,8,0,0,0,0,2,0));

        ArrayList<Integer> mohit = new ArrayList<Integer>(Arrays.asList(1,0,0,0,2,0,3,0,4,0,4,0,5,6,0,7,8,0,0,9,0,0,8,0,0,0,2,0,0,3,0,0,8,0,0,7,0,0,7,0,0,0,6,0,0,8,0,0,2,0,0,9,0,0,6,0,0,0,1,0,0,3,0,0,5,8,0,9,3,0,7,0,2,0,1,0,4,0,0,0,6));

        sudoku.generateEmptyGrid();
        sudoku.generateRandomSudoku();
        System.out.println(sudoku);
        ArrayList<Integer> check = sudoku.exportGrid();
        sudoku.setPuzzle(1);
        System.out.println(sudoku);

        sudoku.solve();
        System.out.println(sudoku);
        ArrayList<Integer> check2 = sudoku.exportGrid();

        System.out.println(check.equals(check2));   

    }
}