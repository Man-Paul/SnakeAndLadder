package com.example.snakeandladder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    public Tile(int height, int width) {
        setHeight(height);
        setWidth(width);
        setFill(Color.RED);
        setStroke(Color.BLACK);
    }
}
