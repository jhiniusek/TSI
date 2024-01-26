public class Cell {
    private int x = 0;      //position
    private int y = 0;
    private String graphic = "[ ]";
    private int status = 0; //1 - Number  2 - Flag  3 - Bomb  4 - Flagged Bomb
    private int value = 0;  //how many bombs neighbouring
    private boolean isCovered = true;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setStatus(int i){
        status = i;
    }

    public int getStatus(){
        return status;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void discoverCell(){
        this.isCovered = false;
    }

    public boolean getIsCovered(){
        return isCovered;
    }

    public String display(){
        if(isCovered){
            return graphic;
        }
        else{
            switch(status){
                case 1: {
                    graphic = "[" + value + "]";
                    return graphic;
                }
                case 2,4: {
                    graphic = "[F]";
                    return graphic;
                }
                case 3: {
                    graphic = "[*]";
                    return graphic;
                }
                default: {
                    return graphic;  //DEBUG NARAZIE
                }
            }
        }
    }
}
