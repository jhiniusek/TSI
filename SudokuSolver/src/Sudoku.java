import java.util.ArrayList;

public class Sudoku {
    private int size;
    private ArrayList<Cell> cells;
    private ArrayList<Cell> numberCells = new ArrayList<Cell>();
    private ArrayList<Cell> emptyCells = new ArrayList<Cell>();

    public Sudoku(ArrayList<Cell> cells, int size){
        this.cells = cells;
        this.size = size;

        emptyCells.addAll(cells);

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    public ArrayList<Cell> getNumberCells() {
        return numberCells;
    }

    public void setNumberCells(ArrayList<Cell> numberCells) {
        this.numberCells = numberCells;
    }

    public Cell getCell(int row, int col){
        for(Cell cell : cells){
            if(cell.getRow() == row && cell.getCol() == col){
                return cell;
            }
        }
        return null;
    }

    public void assignPossibilities(){
        for(Cell cell : emptyCells){
            ArrayList<Integer> possibilities = new ArrayList<Integer>();
            for(int x = 1; x <= size; x++){
                possibilities.add(x);
            }
            cell.setPossibleValues(possibilities);
        }
    }

    public void checkForNumberCells(){
        for(Cell cell : cells){
            cell.solveCell();
            if(cell.getValue() != 0){
                numberCells.add(cell);
            }
        }
        for(Cell cell : numberCells){
            emptyCells.remove(cell);
        }
    }

    @Override
    public String toString(){

        StringBuilder display = new StringBuilder();

        for(int x = 1; x <= size; x++){
            for(int y = 1; y<= size; y++){
                if(y==3){
                    display.append("\033[32m│\033[0m");
                }
                display.append(this.getCell(x, y));
            }
            display.append("\n");
            if(x==2){
                display.append("\033[32m—————————————\033[0m\n");
            }
        }
        return display.toString();
    }

    public void scanRows(){
        Cell scanned;
        for(Cell cell : emptyCells){
            for(int x = 1; x <= size; x++){
                scanned = getCell(cell.getRow(), x);
                if(scanned != null && scanned.getValue()!=0){
                    int toRemove = scanned.getValue();
                    //System.out.println("cell "+cell.getRow() + " " + cell.getCol() + " removed value " + toRemove);
                    cell.removePossibility(toRemove);
                }
            }
        }
    }

    public void scanCols(){
        Cell scanned;
        for(Cell cell : emptyCells){
            for(int x = 1; x <= size; x++){
                scanned = getCell(x, cell.getCol());
                if(scanned != null && scanned.getValue()!=0){
                    int toRemove = scanned.getValue();
                    //System.out.println("cell "+cell.getRow() + " " + cell.getCol() + " removed value " + toRemove);
                    cell.removePossibility(toRemove);
                }
            }
        }
    }

    public void scanBox(){
        ArrayList<Cell> box = new ArrayList<Cell>();
        ArrayList<Integer> numbersInBox = new ArrayList<Integer>();
        for(int x = 1; x <= size; x++){
            for(Cell cell : cells){
                if(cell!=null && cell.getBox() == x){
                    box.add(cell);
                    if(cell.getValue() != 0){
                        numbersInBox.add(cell.getValue());
                    }
                }
            }
            for(Cell cell : box){
                if(emptyCells.contains(cell)){
                    for(Integer toRemove : numbersInBox){
                        cell.removePossibility(toRemove);
                    }
                }
            }
            box.clear();
            numbersInBox.clear();
        }
    }
}