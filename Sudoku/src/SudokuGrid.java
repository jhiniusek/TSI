import java.util.ArrayList;

public class SudokuGrid {
    private int size;
    private ArrayList<Cell> cells;
    private ArrayList<Cell> puzzle = new ArrayList<Cell>();
    private ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();

    public SudokuGrid(int size) {
        this.size = size;
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

    public ArrayList<ArrayList<Integer>> getSolutions() {
        return solutions;
    }

    public Cell getCell(int row, int col){
        for(Cell cell : cells){
            if(cell.getRow()==row && cell.getCol()==col){
                return cell;
            }
        }
        return null;
    }

    public Cell getFirstEmpty(){
        for(Cell cell : cells){
            if(cell.getValue()==0){
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
        solutions.clear();
        if(numbers.size()==size*size){
            int counter = 0;
            for(Cell cell : cells){
                cell.setValue(numbers.get(counter));
                counter++;
            }
        }else{
            if(size==9){
                System.out.println("Invalid import size. Required 81 numbers.");
            }
            if(size==16){
                System.out.println("Invalid import size. Required 256 numbers.");
            }

        }

    }

    public void generateEmptyGrid(){

        if(size == 9){
            solutions.clear();
            ArrayList<Cell> cells = new ArrayList<Cell>();
            int box = 1;
            int cellcounter = 1;
            for(int x = 1; x <= 9; x++){
                for(int y = 1; y<=9; y++){
                    if(y<=3){
                        Cell cell = new Cell(size,x,y,box);
                        cells.add(cell);
                    } else if (y>3&&y<=6) {
                        Cell cell = new Cell(size,x,y,box+1);
                        cells.add(cell);
                    } else{
                        Cell cell = new Cell(size,x,y,box+2);
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
        if(size == 16){
            solutions.clear();
            ArrayList<Cell> cells = new ArrayList<Cell>();
            int box = 1;
            int cellcounter = 1;
            for(int x = 1; x <= 16; x++){
                for(int y = 1; y<=16; y++){
                    if(y<=4){
                        Cell cell = new Cell(size,x,y,box);
                        cells.add(cell);
                    } else if (y>4&&y<=8) {
                        Cell cell = new Cell(size,x,y,box+1);
                        cells.add(cell);
                    } else if (y>8&&y<=12) {
                        Cell cell = new Cell(size,x,y,box+2);
                        cells.add(cell);
                    }else{
                        Cell cell = new Cell(size,x,y,box+3);
                        cells.add(cell);
                    }
                    cellcounter++;
                }
                if(cellcounter>64){
                    box+=4;
                    cellcounter=1;
                }
            }
            this.cells = cells;
        }
    }

    public void generateRandomSudoku(){
        int randomNums = 1;
        if(size==9){
            randomNums =  10 + (int)(Math.random() * ((25 - 10) + 1));
        }
        if(size==16){
            randomNums =  60 + (int)(Math.random() * ((90 - 60) + 1));
        }


        for(int i = 0; i<randomNums; i++){
            int row = 1 + (int)(Math.random() * ((size - 1) + 1));
            int col = 1 + (int)(Math.random() * ((size - 1) + 1));
            int value = 1 + (int)(Math.random() * ((size - 1) + 1));
            if(isSafe(row,col,value)){
                getCell(row,col).setValue(value);
            }
        }
        if(!findFirstSolution()){
            generateEmptyGrid();
            generateRandomSudoku();
        }
    }

    public boolean isFull(){
        for(Cell cell : cells){
            if(cell.getValue()==0){
                return false;
            }
        }
        return true;
    }

    public int emptyCells(){
        int counter = 0;
        for(Cell cell : cells){
            if(cell.getValue()==0){
                counter++;
            }
        }
        return counter;
    }

    public void setPuzzle(int cellsToHide){ //9x9 - 57 is kinda max
        int counter = 0;
        solutions.clear();
        while(puzzle.size()!=cellsToHide){
            int randomCell = (int) (Math.random() * (((size * size - 1)) + 1));
            if(!puzzle.contains(cells.get(randomCell))){
                Cell cell = cells.get(randomCell);
                int temp = cell.getValue();
                cell.setValue(0);
                puzzle.add(cell);
                checkIfMoreSolutions();
                if(solutions.size()>1){
                    cell.setValue(temp);
                    puzzle.remove(cell);
                }
                solutions.clear();
            }
            counter++;
            if(counter > cellsToHide*4){
                System.out.println("Couldn't find a puzzle, generating new grid...");
                puzzle.clear();
                generateEmptyGrid();
                generateRandomSudoku();
                setPuzzle(cellsToHide);
                break;
            }
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

    public boolean findFirstSolution(){
        for (int i=1; i<= size; i++) {
            for (int j = 1; j <= size; j++) {
                int currentValue = getCell(i,j).getValue();
                if(currentValue==0){
                    for(int brute = 1; brute <= size; brute++){
                        if(isSafe(i,j,brute)){
                            getCell(i,j).setValue(brute);
                            if (findFirstSolution()) {
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

    public boolean findOneSolution(){
        for (int i=1; i<= size; i++) {
            for (int j = 1; j <= size; j++) {
                int currentValue = getCell(i,j).getValue();
                if(currentValue==0){
                    for(int brute = 1; brute <= size; brute++){
                        if(isSafe(i,j,brute)){
                            getCell(i,j).setValue(brute);
                            if (findOneSolution()) {
                                return true;
                            }
                            getCell(i,j).setValue(0);
                        }
                    }
                    return false;
                }
            }
        }
        solutions.add(exportGrid());
        System.out.println(this);
        return true;
    }

    public boolean findAllSolutions(int mode){  // 1 - print output    2 - don't print anything
        for (int i=1; i<= size; i++) {
            for (int j = 1; j <= size; j++) {
                int currentValue = getCell(i,j).getValue();
                if(currentValue==0){
                    for(int brute = 1; brute <= size; brute++){
                        if(isSafe(i,j,brute)){
                            getCell(i,j).setValue(brute);
                            if (findAllSolutions(mode)) {
                                if(isFull()){
                                    solutions.add(exportGrid());
                                }
                            }
                            getCell(i,j).setValue(0);
                        }
                    }
                    return false;
                }
            }
        }
        if(mode==1){
            System.out.println(this);
        }
        return true;
    }

    public boolean checkIfMoreSolutions(){
        for (int i=1; i<= size; i++) {
            for (int j = 1; j <= size; j++) {
                int currentValue = getCell(i,j).getValue();
                if(currentValue==0){
                    for(int brute = 1; brute <= size; brute++){
                        if(isSafe(i,j,brute)){
                            getCell(i,j).setValue(brute);
                            if (checkIfMoreSolutions()) {
                                if(isFull()){
                                    solutions.add(exportGrid());
                                }
                            }
                            getCell(i,j).setValue(0);
                        }
                    }
                    return false;
                }
            }
        }
        if(solutions.size()>1){
            return false;
        }
        return true;
    }

    public void multithreadSolve(int digit){
        Cell cell = getFirstEmpty();
        if(isSafe(cell.getRow(), cell.getCol(), digit)){
            cell.setValue(digit);
            findAllSolutions(1);
        }
    }


    @Override
    public String toString(){

        if(size == 9){
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
        if(size == 16){
            StringBuilder display = new StringBuilder();

            for(int x = 1; x <= size; x++){
                for(int y = 1; y<= size; y++){
                    display.append(this.getCell(x, y));
                    if(y==4||y==8||y==12){
                        display.append("\033[32m│\033[0m");
                    }
                }
                display.append("\n");
                if(x==4||x==8||x==12){
                    display.append("\033[32m———————————————————————————————————————————————————————————————————\033[0m\n");
                }
            }
            return display.toString();
        }
        return null;
    }
}