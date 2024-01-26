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
        int width;
        int height;
        int bombs;
        gui.printMainMenu();
        Scanner reader = new Scanner(System.in);
        int input;
        boolean run = true;
        boolean play = false;
        while(run){
            input = check.checkInt(reader.next());
            switch(input){
                case 1: { //play
                    boolean level = true;
                    gui.printLevels();
                    while(level){
                        input = check.checkInt(reader.next());
                        switch(input) {
                            case 1:{
                                width = 9; //x
                                height = 9; //y
                                bombs = 10;
                                Map map = game.startGame(width,height,bombs);
                                play = true;
                                level = false;
                                break;
                            }
                            case 2:{
                                width = 16; //x
                                height = 16; //y
                                bombs = 40;
                                Map map = game.startGame(width,height,bombs);
                                play = true;
                                level = false;
                                break;
                            }
                            case 3:{
                                width = 30; //x
                                height = 16; //y
                                bombs = 99;
                                Map map = game.startGame(width,height,bombs);
                                play = true;
                                level = false;
                                break;
                            }
                            case 4:{
                                System.out.print("How many colums? (minimum 5)");
                                width = check.checkInt(reader.next());
                                System.out.print("How many rows? (minimum 5)");
                                height = check.checkInt(reader.next());
                                System.out.println("How many bombs?");
                                bombs = check.checkInt(reader.next());
                                Map map = game.startCustomGame(width,height,bombs);
                                play = map.isPlayabe();
                                level = false;
                                break;
                            }
                            default:{
                                System.out.println("Incorrect input.");
                                break;
                            }
                        }
                    }
                    while(play){
                        System.out.print("Enter a column digit: ");

                        System.out.print("Enter a row digit: ");

                        gui.printCellOptions();
                        reader.next();
                        play = false;
                    }
                    gui.printMainMenu();
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

        /*Cell activeCell = game.chooseCell(3,3);
        game.spawnBombs(bombs, activeCell);
        game.spawnNumbers();
        System.out.println("\n");
        game.printMap();
        game.guess(game.chooseCell(3,4));
        System.out.println("\n");
        game.printMap();*/
    }
}