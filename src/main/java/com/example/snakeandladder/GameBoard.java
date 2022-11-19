package com.example.snakeandladder;

import java.util.ArrayList;
import javafx.util.Pair;

public class GameBoard {
    static int tileSize = 40;
    static int height = 10;
    static int width = 10;
    static ArrayList<Pair<Integer, Integer>> positionCoordinates;
    static ArrayList<Integer> SnakeLadderPosition;

    GameBoard() {
        populatePositionCoordinates();
        setSnakeLadderPosition();
    }

    public int getXvalue(int piecePos) {
        return positionCoordinates.get(piecePos).getKey();
    }

    public int getYvalue(int piecePos) {
        return positionCoordinates.get(piecePos).getValue();
    }

    private void populatePositionCoordinates() {
        positionCoordinates = new ArrayList();
        positionCoordinates.add(new Pair(20, 380));

        for(int i = height - 1; i >= 0; i--) {
            for(int j = width - 1; j >= 0; j--) {
                int xTilepos,yTilepos;
                if (i % 2 != 0) {
                    xTilepos = tileSize*width - (tileSize/2 + j*tileSize);
                }
                else {
                    xTilepos = tileSize/2 + j*tileSize;
                }

                yTilepos = tileSize/2 + i*tileSize;
                positionCoordinates.add(new Pair(xTilepos, yTilepos));
            }
        }

    }

    public int playerPositionAtSnakeOrLadder(int piecePosition) {
        if(piecePosition != SnakeLadderPosition.get(piecePosition))
            return SnakeLadderPosition.get(piecePosition);
        return -1;
    }

    private void setSnakeLadderPosition() {
        SnakeLadderPosition = new ArrayList();

        for(int i = 0; i < 101; ++i) {
            SnakeLadderPosition.add(i);
        }

        SnakeLadderPosition.set(2, 38);
        SnakeLadderPosition.set(7, 14);
        SnakeLadderPosition.set(8, 31);
        SnakeLadderPosition.set(15, 26);
        SnakeLadderPosition.set(16, 6);
        SnakeLadderPosition.set(21, 42);
        SnakeLadderPosition.set(28, 84);
        SnakeLadderPosition.set(36, 44);
        SnakeLadderPosition.set(46, 25);
        SnakeLadderPosition.set(49, 11);
        SnakeLadderPosition.set(51, 67);
        SnakeLadderPosition.set(62, 19);
        SnakeLadderPosition.set(64, 60);
        SnakeLadderPosition.set(71, 91);
        SnakeLadderPosition.set(74, 53);
        SnakeLadderPosition.set(78, 98);
        SnakeLadderPosition.set(87, 94);
        SnakeLadderPosition.set(89, 68);
        SnakeLadderPosition.set(92, 88);
        SnakeLadderPosition.set(95, 75);
        SnakeLadderPosition.set(99, 80);
    }
}
