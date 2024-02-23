import java.util.ArrayList;

public class Validator {
    private final SudokuGrid sudoku;

    public Validator(SudokuGrid sudoku) {
        this.sudoku = sudoku;
    }

    public boolean validRows(){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int row = 1; row<=sudoku.getSize(); row++){
            for(int col = 1; col<=sudoku.getSize(); col++){
                Cell cell = sudoku.getCell(row,col);
                if(numbers.contains(cell.getValue())){
                    return false;
                }
                numbers.add(cell.getValue());
            }
            numbers.clear();
        }
        return true;
    }

    public boolean validColumns(){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int col = 1; col<=sudoku.getSize(); col++){
            for(int row = 1; row<=sudoku.getSize(); row++){
                Cell cell = sudoku.getCell(row,col);
                if(numbers.contains(cell.getValue())){
                    return false;
                }
                numbers.add(cell.getValue());
            }
            numbers.clear();
        }
        return true;
    }

    public boolean validBoxes(){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int box = 1; box <= sudoku.getSize(); box++){
            ArrayList<Cell> cells = sudoku.getBox(box);
            for(Cell cell : cells){
                if(numbers.contains(cell.getValue())){
                    return false;
                }
                numbers.add(cell.getValue());
            }
            numbers.clear();
        }
        return true;
    }
}
