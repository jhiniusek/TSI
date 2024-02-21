public class Cell {
    private int row;
    private int col;
    private int box;
    private int value = 0;

    public Cell(int row, int col, int box) {
        this.row = row;
        this.col = col;
        this.box = box;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getBox() {
        return box;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
