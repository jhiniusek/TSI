import java.security.PublicKey;
import java.util.ArrayList;

public class Map {
    private ArrayList<Cell> map = new ArrayList<Cell>();
    private int width;
    private int height;
    private int bombs;

    public void generateMap(int width, int height){
        this.width = width;
        this.height = height;
        for(int x = 0; x < height; x++){
            for(int y = 0; y < width; y++){
                Cell newCell = new Cell(x+1, y+1);
                map.add(newCell);
            }
        }
    }

    public void printMap(){
        int rowCounter = 0;
        for(int x = 0; x < width*height; x++){
            System.out.print(map.get(x).display());
            rowCounter++;
            if(rowCounter==width){
                System.out.print("\n");
                rowCounter=0;
            }
        }
    }

    public Cell chooseCell(int x, int y){
        for(Cell cell : map) {
            if (cell.getX() == y && cell.getY() == x) {
                return cell;
            }
        }
        return map.getFirst();
    }
    public ArrayList<Cell> getNeighbours(Cell active){
        ArrayList<Cell> neighbours = new ArrayList<Cell>();
        int x = active.getX();
        int y = active.getY();
        for(Cell cell : map){
            if((cell.getX()==x-1||cell.getX()==x||cell.getX()==x+1)&&(cell.getY()==y-1||cell.getY()==y||cell.getY()==y+1)){
                neighbours.add(cell);
            }
        }
        return neighbours;
    }

    public ArrayList<Cell> getUnrevealedNeighbours(Cell active){
        ArrayList<Cell> neighbours = new ArrayList<Cell>();
        int x = active.getX();
        int y = active.getY();
        for(Cell cell : map){
            if((cell.getX()==x-1||cell.getX()==x||cell.getX()==x+1)&&
                    (cell.getY()==y-1||cell.getY()==y||cell.getY()==y+1)&&
                    (cell.getIsCovered())&&
                    ((cell.getStatus()!=4)||(cell.getStatus()!=2))){
                neighbours.add(cell);
            }
        }
        return neighbours;
    }

    public void revealNeighbours(ArrayList<Cell> neighbours){
        for(Cell cell : neighbours){
            guess(cell);
        }
    }

    public void guess(Cell guess){
        if(!guess.getIsCovered()){
            System.out.println("You've already revealed this cell.");
        }
        else{
            if(guess.getStatus()==1){
                guess.discoverCell();
                if(guess.getValue()==0){
                    ArrayList<Cell> neighbours = getUnrevealedNeighbours(guess);
                    revealNeighbours(neighbours);
                }
            }
            if(guess.getStatus()==2||guess.getStatus()==4){
                System.out.println("Cannot discover the flag!");
            }
            if(guess.getStatus()==3){
                guess.discoverCell();
                System.out.println("You lost!");
            }
        }
    }

    public void flagCell(Cell x){

    }

    public void spawnNumbers(){
        for(Cell check : map){
            if(check.getStatus() == 3){}
            else{
                ArrayList<Cell> neighbours = getNeighbours(check);
                int bombcounter = 0;
                for(Cell maybeBomb : neighbours){
                    if(maybeBomb.getStatus()==3){
                        bombcounter++;
                    }
                }
                check.setStatus(1);
                check.setValue(bombcounter);
            }
        }
    }

    public void spawnBombs(int bombs, Cell start){
        this.bombs = bombs;
        while(bombs > 0){
            int x =(int)((Math.random()*this.width)+1);
            int y =(int)((Math.random()*this.height)+1);
            Cell newBomb = chooseCell(x,y);
            if(start == newBomb || newBomb.getStatus() == 3){}
            else{
                newBomb.setStatus(3);
                bombs--;
            }
        }
        spawnNumbers();
        guess(start);
    }

    public void debugCell(int x, int y){
        for(Cell cell : map){
            if(cell.getX() == y && cell.getY() == x){
                System.out.println("CELL FOUND");
                System.out.println(cell.getX() + " and " + cell.getY() + "is" + cell.getStatus());
            }
        }
    }

    public void debugDiscoverAll(){
        for(Cell cell : map) {
            cell.discoverCell();
        }
    }
}
