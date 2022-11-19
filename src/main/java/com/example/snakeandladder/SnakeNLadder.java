package com.example.snakeandladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeNLadder extends Application {
    public final int tileSize = 40;
    int height = 10;
    int width = 10;
    int yline = 430;
    int diceValue;
    public Label comment;
    boolean GameRunningStatus = true;
    boolean Player1Turn = true;
    boolean Player2Turn = false;
    Group tileGroup = new Group();
    Player player1;
    Player player2;

    public Pane createContent() {
        Pane root = new Pane();
        root.setPrefSize(width * tileSize, height * tileSize + 80);
        root.getChildren().addAll(tileGroup);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Tile tile = new Tile(tileSize, tileSize);
                tile.setTranslateX(i * tileSize);
                tile.setTranslateY(j * tileSize);
                tileGroup.getChildren().addAll(tile);
            }
        }
        comment = new Label("Start Playing");
        comment.setTranslateX(165);
        comment.setTranslateY(yline - 20);

        Button playerOne = new Button("Player 1");
        playerOne.setTranslateX(20);
        playerOne.setTranslateY(yline);
        playerOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (GameRunningStatus == true && Player1Turn == true) {
                    getDiceValue();
                    player1.movePlayer(diceValue);
                    player1.playerAtSnakeOrLadder();
                    Player1Turn = false;
                    Player2Turn = true;
                }
            }
        });

        Button Start = new Button("Start");
        Start.setTranslateX(180);
        Start.setTranslateY(yline);

        Button playerTwo = new Button("Player 2");
        playerTwo.setTranslateX(320);
        playerTwo.setTranslateY(yline);
        playerTwo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (GameRunningStatus == true && Player2Turn == true) {
                    getDiceValue();
                    player2.movePlayer(diceValue);
                    player2.playerAtSnakeOrLadder();
                    Player1Turn = true;
                    Player2Turn = false;
                }
            }
        });

        player1 = new Player(tileSize, Color.BLACK);
        player2 = new Player(tileSize - 10, Color.WHITE);

        Image img = new Image("C:\\Users\\HP\\IdeaProjects\\SnakeAndLadder\\src\\snakesandladdersboard.jpg");
        ImageView boardImg = new ImageView();
        boardImg.setImage(img);
        boardImg.setFitHeight(height * tileSize);
        boardImg.setFitWidth(width * tileSize);
        tileGroup.getChildren().addAll(boardImg, comment, playerOne, Start, playerTwo, player1.getGamePiece(), player2.getGamePiece());
        return root;
    }

    public void TerminateGame(){
        GameRunningStatus = false;
    }
    private void getDiceValue(){
        diceValue = (int)(Math.random()*6+1);
        comment.setText(Integer.toString(diceValue));
    }

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(SnakeNLadder.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake And Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}