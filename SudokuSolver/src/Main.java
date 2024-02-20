import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("sudoku");

        ArrayList<Cell> cells = new ArrayList<Cell>();
        int box = 1;
        int cellcounter = 1;

        for(int x = 1; x <= 4; x++){
            for(int y = 1; y<=4; y++){
                if(y<3){
                    Cell cell = new Cell(x,y,box);
                    cells.add(cell);
                }
                else{
                    Cell cell = new Cell(x,y,box+1);
                    cells.add(cell);
                }
                cellcounter++;
            }
            if(cellcounter>8){  //4x4
                box+=2;
                cellcounter=1;
            }
        }

        Sudoku sudoku1 = new Sudoku(cells, 4);
        sudoku1.assignPossibilities();

        // HARDCODING SUDOKU TO SOLVE
        Cell cell = sudoku1.getCell(1,4);
        cell.setValue(3);
        cell = sudoku1.getCell(2,2);
        cell.setValue(4);
        cell = sudoku1.getCell(3,3);
        cell.setValue(3);
        cell = sudoku1.getCell(3,4);
        cell.setValue(2);

        int loop = 0;
        while (loop<5){
            sudoku1.checkForNumberCells();
            sudoku1.scanRows();
            sudoku1.scanCols();
            sudoku1.scanBox();
            System.out.println(sudoku1);
            loop++;
            Thread.sleep(1000);
        }

        cell = sudoku1.getCell(3,2);
        System.out.println(cell.getPossibleValues());
    }
}