public class Cell {
    private final int gridSize;
    private final int row;
    private final int col;
    private final int box;
    private int value = 0;

    public Cell(int gridSize, int row, int col, int box) {
        this.gridSize = gridSize;
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

        if(gridSize == 9){
            String display = "[ ]";
            if(value!=0){
                display = "["+value+"]";
            }
            return display;
        }
        if(gridSize == 16){
            String display = "[  ]";
            if(value!=0&&value<10){
                display = "[ "+value+"]";
            }
            if(value>=10){
                display = "["+value+"]";
            }
            return display;
        }
        return null;
    }
}
