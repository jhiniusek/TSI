public class SolverThread implements Runnable{
    private int threadNumber;
    private SudokuGrid sudoku;


    public SolverThread(int threadNumber, SudokuGrid sudoku) {
        this.threadNumber = threadNumber;
        this.sudoku = sudoku;
    }

    public void run(){
        sudoku.multithreadSolve(threadNumber);
    }
}
