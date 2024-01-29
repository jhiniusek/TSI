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
    private Label welcomeText;
    @FXML
    private GridPane map;
    private ArrayList<Cell> cells = new ArrayList<Cell>();
    private ArrayList<Cell> toDecideFate = new ArrayList<Cell>();
    private int width = 9;
    private int height = 9;
    private int bombs = 10;

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
                    newBomb.getButton().setText("*");
                }
            });
            toDecideFate.remove(newBomb);
        }
        for(Cell x : toDecideFate){
            x.setStatus(1);
            x.getButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    x.getButton().setText(String.valueOf(x.getValue()));
                }
            });
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
            }
        }
        start.getButton().setText(String.valueOf(start.getValue()));
    }
}