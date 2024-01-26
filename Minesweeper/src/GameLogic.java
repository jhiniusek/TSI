public class GameLogic {
    public void startGame(int width, int height, int bombs){
        Map game = new Map();
        game.generateMap(width, height);
        game.printMap();
    }
}
