public class PuzzelerThread implements Runnable{
    private SudokuGrid sudoku;
    private int clues;
    private Canceller cancel;


    public PuzzelerThread(SudokuGrid sudoku, int clues, Canceller cancel) {
        this.sudoku = sudoku;
        this.clues = clues;
        this.cancel = cancel;
    }

    public void setPuzzle(int cellsToHide){ //9x9 - 57 is kinda max
        System.out.println("Generating new grid...");
        int counter = 0;
        sudoku.clearSolutions();
        while(sudoku.getPuzzle().size()!=cellsToHide){
            int randomCell = (int) (Math.random() * (((sudoku.getSize() * sudoku.getSize() - 1)) + 1));
            if(!sudoku.getPuzzle().contains(sudoku.getCells().get(randomCell))){
                Cell cell = sudoku.getCells().get(randomCell);
                int temp = cell.getValue();
                cell.setValue(0);
                sudoku.getPuzzle().add(cell);
                sudoku.checkIfMoreSolutions();
                if(sudoku.getSolutions().size()>1){
                    cell.setValue(temp);
                    sudoku.getPuzzle().remove(cell);
                }
                sudoku.clearSolutions();
            }

            if(cancel.isFinished()){
                break;
            }

            counter++;
            if(counter > cellsToHide*4){
                System.out.println("Couldn't find a puzzle.");
                sudoku.getPuzzle().clear();
                sudoku.generateEmptyGrid();
                sudoku.generateRandomSudoku();
                setPuzzle(cellsToHide);
                break;
            }
        }
        if(!cancel.isFinished()){
            cancel.setFinished(true);
            System.out.println(sudoku);

            System.out.println("\nSOLUTIONS:");
            sudoku.findAllSolutions(1);
        }
    }

    public void run(){
        setPuzzle(81-clues);
    }
}
