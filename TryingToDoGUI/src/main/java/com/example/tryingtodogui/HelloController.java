package com.example.tryingtodogui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label resultLabel;
    @FXML
    private Label info;
    @FXML
    private GridPane map;
    @FXML
    private Button flagButton;
    private ArrayList<Cell> cells = new ArrayList<Cell>();
    private ArrayList<Cell> toDecideFate = new ArrayList<Cell>();
    private int width = 9;
    private int height = 9;
    private int bombs = 10;
    private boolean flagging = false;

    @FXML
    protected void onStartButtonClick() {
        for(int x=0;x<width;x++){
            map.addColumn(x);
        }
        for(int x=0;x<height;x++){
            map.addColumn(x);
        }
        for(int x = 0; x<width; x++){
            for(int y = 0; y<height; y++){
                Cell cell = new Cell(x,y,width,height,map);
                cells.add(cell);
                toDecideFate.add(cell);
            }
        }
        initCells();
    }

    public void initCells(){
        for(Cell x : cells){
            x.getButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    spawnBombs(x);
                }
            });
        }
    }

    public void spawnBombs(Cell start){
        toDecideFate.remove(start);
        for(int i = 0; i < bombs; i++) {
            int bomb = (int) (Math.random() * toDecideFate.size());
            Cell newBomb = toDecideFate.get(bomb);
            newBomb.setStatus(3);
            newBomb.getButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(flagging){
                        if(newBomb.getButton().getText() == "F"){
                            newBomb.getButton().setText("  ");
                        }
                        else {
                            newBomb.getButton().setText("F");
                            newBomb.getButton().setStyle("-fx-text-fill: green");
                        }
                    }
                    else{
                        if(newBomb.getButton().getText() == "F"){ }
                        else{
                            newBomb.getButton().setText("*");
                            newBomb.getButton().setStyle("-fx-text-fill: red");
                            resultLabel.setText("YOU LOST!");
                        }
                    }
                }
            });
            toDecideFate.remove(newBomb);
        }
        toDecideFate.add(start);
        for(Cell x : toDecideFate){
            x.setStatus(1);

        }
        for(Cell number : cells){
            if(number.getStatus()==1){
                int bombcounter = 0;
                for(Cell bomb : cells){
                    if(bomb.getStatus()==3 && (number.getX()==bomb.getX()-1 || number.getX()==bomb.getX() ||  number.getX()==bomb.getX()+1) && (number.getY()==bomb.getY()-1 || number.getY()==bomb.getY() ||  number.getY()==bomb.getY()+1)){
                        bombcounter++;
                    }
                }
                number.setValue(bombcounter);
                number.getButton().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        if(flagging){
                            if(number.getButton().getText() == "F"){
                                number.getButton().setText("  ");
                            }
                            else {
                                number.getButton().setText("F");
                                number.getButton().setStyle("-fx-text-fill: green");
                            }
                        }
                        else{
                            if(number.getButton().getText() == "F"){ }
                            else {
                                number.getButton().setStyle("-fx-text-fill: black");
                                number.getButton().setText(String.valueOf(number.getValue()));
                                if (number.getValue() == 0) {
                                    ArrayList<Cell> neighbours = getNeighbours(number);
                                }
                                checkWin();
                            }
                        }
                    }
                });
            }
        }
        start.getButton().setText(String.valueOf(start.getValue()));
    }
    public ArrayList<Cell> getNeighbours(Cell clicked){
        ArrayList<Cell> neighbours = new ArrayList<Cell>();
        for(Cell check : cells){
            if((clicked.getX()==check.getX()-1 || clicked.getX()==check.getX() ||  clicked.getX()==check.getX()+1) && (clicked.getY()==check.getY()-1 || clicked.getY()==check.getY() || clicked.getY()==check.getY()+1)){
                check.getButton().setText(String.valueOf(check.getValue()));
                neighbours.add(check);
            }
        }
        return neighbours;
    }

    public void checkWin(){
        int counter = 0;
        for(Cell x : toDecideFate){
            if(x.getButton().getText()!="  "){
                counter++;
            }
        }
        if(counter == width*height - bombs){
            resultLabel.setText("YOU WON!");
        }
    }

    @FXML
    protected void flagger(){
        if(flagging){
            flagging = false;
            info.setText("Status: Guessing");
        }
        else{
            flagging = true;
            info.setText("Status: Flagging");
        }
    }
}