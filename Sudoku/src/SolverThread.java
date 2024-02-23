public class SolverThread implements Runnable{
    private int threadNumber;
    private SudokuGrid sudoku;


    public SolverThread(int threadNumber, SudokuGrid sudoku) {
        this.threadNumber = threadNumber;
        this.sudoku = sudoku;
    }

    public void multithreadSolve(int digit){
        Cell cell = sudoku.getFirstEmpty();
        if(sudoku.isSafe(cell.getRow(), cell.getCol(), digit)){
            cell.setValue(digit);
            sudoku.findAllSolutions(1);
        }
    }

    public void run(){
        multithreadSolve(threadNumber);
    }
}
