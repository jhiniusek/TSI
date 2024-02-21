import java.util.ArrayList;

public class SudokuGrid {
    private int size = 9;
    private ArrayList<Cell> cells;
    private ArrayList<Cell> puzzle = new ArrayList<Cell>();

    public SudokuGrid() {
        generateEmptyGrid();
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    public int getSize() {
        return size;
    }

    public Cell getCell(int row, int col){
        for(Cell cell : cells){
            if(cell.getRow()==row && cell.getCol()==col){
                return cell;
            }
        }
        return null;
    }

    public ArrayList<Cell> getBox(int box){
        ArrayList<Cell> myBox = new ArrayList<Cell>();
        for(Cell cell : cells){
            if(cell.getBox()==box){
                myBox.add(cell);
            }
        }
        return myBox;
    }

    public ArrayList<Integer> exportGrid(){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(Cell cell : cells){
            numbers.add(cell.getValue());
        }
        return numbers;
    }

    public void importGrid(ArrayList<Integer> numbers){
        if(numbers.size()==81){
            int counter = 0;
            for(Cell cell : cells){
                cell.setValue(numbers.get(counter));
                counter++;
            }
        }else{
            System.out.println("Invalid import size. Required 81 numbers.");
        }

    }

    public void generateEmptyGrid(){
        ArrayList<Cell> cells = new ArrayList<Cell>();
        int box = 1;
        int cellcounter = 1;
        for(int x = 1; x <= 9; x++){
            for(int y = 1; y<=9; y++){
                if(y<=3){
                    Cell cell = new Cell(x,y,box);
                    cells.add(cell);
                } else if (y>3&&y<=6) {
                    Cell cell = new Cell(x,y,box+1);
                    cells.add(cell);
                } else{
                    Cell cell = new Cell(x,y,box+2);
                    cells.add(cell);
                }
                cellcounter++;
            }
            if(cellcounter>27){
                box+=3;
                cellcounter=1;
            }
        }
        this.cells = cells;
    }

    public void generateRandomSudoku(){
        int randomNums =  10 + (int)(Math.random() * ((25 - 10) + 1));

        for(int i = 0; i<randomNums; i++){
            int row = 1 + (int)(Math.random() * ((9 - 1) + 1));
            int col = 1 + (int)(Math.random() * ((9 - 1) + 1));
            int value = 1 + (int)(Math.random() * ((9 - 1) + 1));
            if(isSafe(row,col,value)){
                getCell(row,col).setValue(value);
            }
        }
        if(!solve()){
            generateRandomSudoku();
        }
    }

    public void setPuzzle(int difficulty){
        if(solve()){
            int cellsToHide = 20;
            switch(difficulty) {
                case 1 -> cellsToHide = 20;
                case 2 -> cellsToHide = 42;
                case 3 -> cellsToHide = 64;
            }

            while(puzzle.size()!=cellsToHide){
                int randomCell =  0 + (int)(Math.random() * ((80 - 0) + 1));
                if(!puzzle.contains(cells.get(randomCell))){
                    cells.get(randomCell).setValue(0);
                    puzzle.add(cells.get(randomCell));
                }
            }
        } else {
            System.out.println("Cannot generate puzzle.");
        }

    }

    public boolean isSafe(int row, int col, int value){

        Cell checkingCell = getCell(row,col);

        //ROW
        for(int a = 1; a <= size; a++) {
            Cell cell = getCell(row, a);
            if(cell.getValue()==value) {
                return false;
            }
        }
        //COL
        for(int b = 1; b <= size; b++) {
            Cell cell = getCell(b, col);
            if(cell.getValue()==value) {
                return false;
            }
        }
        //BOX
        ArrayList<Cell> BoxOfCell = getBox(checkingCell.getBox());
        for(Cell cell : BoxOfCell){
            if(cell.getValue()==value) {
                return false;
            }
        }
        return true;
    }

    public boolean solve(){
        for (int i=1; i<= size; i++) {
            for (int j = 1; j <= size; j++) {
                int currentValue = getCell(i,j).getValue();
                if(currentValue==0){
                    for(int brute = 1; brute <= size; brute++){
                        if(isSafe(i,j,brute)){
                            getCell(i,j).setValue(brute);
                            if (solve()) {
                                return true;
                            }
                            getCell(i,j).setValue(0);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }



    @Override
    public String toString(){

        StringBuilder display = new StringBuilder();

        for(int x = 1; x <= size; x++){
            for(int y = 1; y<= size; y++){
                display.append(this.getCell(x, y));
                if(y==3||y==6){
                    display.append("\033[32m│\033[0m");
                }
            }
            display.append("\n");
            if(x==3||x==6){
                display.append("\033[32m—————————————————————————————\033[0m\n");
            }
        }
        return display.toString();
    }
}
