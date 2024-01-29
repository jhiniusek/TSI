package com.example.tryingtodogui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Cell extends HelloController{
    private int x;
    private int width;
    private int y;
    private int height;
    private int status = 0;

    private int value;
    private Button button;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Button getButton() {
        return button;
    }

    public Cell(int x, int y, int width, int height, GridPane map) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        button = new Button();
        button.setText("  ");
        /*button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                debugCell();
                button.setText(String.valueOf(value));
            }
        });*/
        map.add(button, x, y);
    }
}
