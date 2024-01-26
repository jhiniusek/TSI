import javax.swing.*;

public class GameLogic {
    public Map startGame(int width, int height, int bombs){
        Map game = new Map();
        game.generateMap(width, height);
        game.printMap();
        return game;
    }

    public Map startCustomGame(int width, int height, int bombs){
        if(width >= 5 && height >= 5){
            if(bombs > 0 && bombs <= (width*height)-15){
                Map game = new Map();
                game.generateMap(width, height);
                game.printMap();
                return game;
            }
            else {
                System.out.println("Incorrect number of bombs.");
                System.out.println("Make sure there are atleast 1 bomb");
                System.out.println("and atleast 15 safe cells.");
            }
        }
        else {
            System.out.println("Incorrect number of rows and columns.");
        }
        Map game = new Map();
        game.setPlayabe(false);
        return game;
    }
}
