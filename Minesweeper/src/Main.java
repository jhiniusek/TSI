import javax.swing.*;
import java.io.PipedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Minesweeper!");
        AsciGUI gui = new AsciGUI();
        InputValidation check = new InputValidation();
        GameLogic game = new GameLogic();
        gui.printMainMenu();
        Scanner reader = new Scanner(System.in);
        int input;
        boolean run = true;
        while(run){
            input = check.checkInt(reader.next());
            switch(input){
                case 1: { //play
                    boolean play = true;
                    gui.printLevels();
                    while(play){
                        input = check.checkInt(reader.next());
                        switch(input) {
                            case 1:{
                                int width = 9; //x
                                int height = 9; //y
                                int bombs = 10;
                                game.startGame(width,height,bombs);
                                break;
                            }
                            case 2:{
                                int width = 16; //x
                                int height = 16; //y
                                int bombs = 40;
                                game.startGame(width,height,bombs);
                                break;
                            }
                            case 3:{
                                int width = 30; //x
                                int height = 16; //y
                                int bombs = 99;
                                game.startGame(width,height,bombs);
                                break;
                            }
                            case 4:{
                                System.out.println("wip");
                                break;
                            }
                            default:{
                                System.out.println("Incorrect input.");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2: { //howToPlay
                    System.out.println("wip\n");
                    break;
                }
                case 3: { //quit
                    run = false;
                    break;
                }
                default: {
                    System.out.println("Incorrect input.");
                    break;
                }
            }
        }

        /*int width = 10; //x
        int height = 10; //y
        int bombs = 10;
        Map game = new Map();
        game.generateMap(width, height);
        game.printMap();
        Cell activeCell = game.chooseCell(3,3);
        game.spawnBombs(bombs, activeCell);
        game.spawnNumbers();
        System.out.println("\n");
        game.printMap();
        game.guess(game.chooseCell(3,4));
        System.out.println("\n");
        game.printMap();*/
    }
}