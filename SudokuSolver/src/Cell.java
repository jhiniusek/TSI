import java.util.ArrayList;
import java.util.Collections;

public class Cell {
    private int row;
    private int col;
    private int box;
    private int value = 0;
    private ArrayList<Integer> possibleValues;

    public Cell(int row, int col, int box){
        this.row = row;
        this.col = col;
        this.box = box;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(ArrayList<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public void removePossibility(Integer x){
        possibleValues.removeAll(Collections.singletonList(x));
    }

    public void solveCell(){
        if(possibleValues.size()==1){
            value = possibleValues.get(0);
            possibleValues.clear();
        }
    }

    @Override
    public String toString(){
        String display = "[ ]";
        if(value!=0){
            display = "["+value+"]";
        }
        return display;
    }
}
