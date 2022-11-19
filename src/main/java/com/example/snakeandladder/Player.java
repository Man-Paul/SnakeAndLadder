package com.example.snakeandladder;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    private Circle gamePiece;
    int xPos;
    int yPos;
    int currPiecePos;

    Label comment;
    static GameBoard gameboard = new GameBoard();

    Player(int tileSize, Color pieceColor) {
        this.currPiecePos = 1;
        this.xPos = gameboard.getXvalue(this.currPiecePos);
        this.yPos = gameboard.getYvalue(this.currPiecePos);

        gamePiece = new Circle(tileSize/2);
        gamePiece.setFill(pieceColor);
        gamePiece.setTranslateX(this.xPos);
        gamePiece.setTranslateY(this.yPos);
    }

    SnakeNLadder TerGame = new SnakeNLadder();
    public void movePlayer(int diceValue) {
        if (currPiecePos + diceValue < 100) {
            currPiecePos += diceValue;
            translatePlayer();
        }
        else if(currPiecePos + diceValue == 100){
            currPiecePos += diceValue;
            translatePlayer();
            //comment.setText(player + " " + "wins");
            TerGame.TerminateGame();
        }
    }

    private void translatePlayer() {
        this.xPos = gameboard.getXvalue(this.currPiecePos);
        this.yPos = gameboard.getYvalue(this.currPiecePos);

        TranslateTransition animate = new TranslateTransition(Duration.millis(1000.0), this.gamePiece);
        animate.setToX(this.xPos);
        animate.setToY(this.yPos);
        animate.setAutoReverse(false);
        animate.play();
    }

    public void playerAtSnakeOrLadder() {
        int newPosition = gameboard.playerPositionAtSnakeOrLadder(this.currPiecePos);
        if (newPosition != -1) {
            this.currPiecePos = newPosition;
            translatePlayer();
        }
    }

    public Circle getGamePiece() {
        return this.gamePiece;
    }
}

