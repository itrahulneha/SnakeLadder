//package com.example.snakladder;
//
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//
//public class SnakeLadder extends Application {
//    public static final int tileSize = 60, width = 10, height = 10;
//    public static final int buttonLine = height*tileSize + 50, infoLine  = buttonLine-30;
//
//    private static Dice dice = new Dice();
//    private Player playerOne, playerTwo;
//
//    private boolean gameStarted = false , playerOneTurn = false , playerTwoTurn = false;
//
//    private Pane createContent() {
//        Pane root = new Pane();
//        root.setPrefSize(width * tileSize, height * tileSize + 100);
//
//        // Creating the grid using Tile class
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                Tile tile = new Tile(tileSize);
//                tile.setTranslateX(j * tileSize);
//                tile.setTranslateY(i * tileSize);
//                root.getChildren().add(tile);
//            }
//        }
//
//        Image img = new Image("E:\\javaProject\\SnakLadder\\src\\main\\ludo.jpg");
//        ImageView board = new ImageView();
//        board.setImage(img);
//        board.setFitHeight(height*tileSize);
//        board.setFitWidth(width*tileSize);
//
//        // Buttons
//        Button playerOneButton = new Button("Player One");
//        Button playerTwoButton = new Button("Player Two");
//        Button startButton = new Button("Start");
//
//        playerOneButton.setTranslateY(buttonLine);
//        playerOneButton.setTranslateX(100);
//        playerOneButton.setDisable(true);
//        playerTwoButton.setTranslateY(buttonLine);
//        playerTwoButton.setTranslateX(400);
//        playerTwoButton.setDisable(true);
//        startButton.setTranslateY(buttonLine);
//        startButton.setTranslateX(300);
//
//
//        // Info Display
//        Label playerOneLabel = new Label ("");
//        Label playerTwoLabel = new Label("");
//        Label diceLabel = new Label ("Start the Game");
//
//
//        playerOneLabel.setTranslateY(infoLine);
//        playerOneLabel.setTranslateX(100);
//        playerTwoLabel.setTranslateY(infoLine);
//        playerTwoLabel.setTranslateX(400);
//        diceLabel.setTranslateY(infoLine);
//        diceLabel.setTranslateX(300);
//
//
//        playerOne = new Player(tileSize, Color.BLACK,"Nitish");
//        playerTwo = new Player(tileSize, Color.RED,"Aniket");
//
//
//        // player action
//
//        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//
//                if (gameStarted){
//                    if(playerOneTurn){
//                        int diceValue = dice.getRolledDiceValue();
//                        diceLabel.setText("DiceValue : " +  diceValue);
//                        playerOne.movePlayer(diceValue);
//                        // check winning condition
//
//                        if(playerOne.isWinner()){
//                            diceLabel.setText("Winner is " + playerOne.getName());
//
//                            playerOneTurn = false;
//                            playerOneButton.setDisable(true);
//                            playerOneLabel.setText("");
//
//                            playerTwoTurn = false;
//                            playerTwoButton.setDisable(true);  // Changed from false to true
//                            playerTwoLabel.setText("");
//
//                            startButton.setDisable(false);
//                            startButton.setText("Restart the game ");
//                            gameStarted = false;
//
//                        }else{
//                            playerOneTurn = false;
//                            playerOneButton.setDisable(true);
//                            playerOneLabel.setText("");
//
//                            playerTwoTurn = true;
//                            playerTwoButton.setDisable(false);
//                            playerTwoLabel.setText("YourTurn" + playerTwo.getName());
//                        }
//
//
//
//                    }
//                }
//
//
//            }
//        });
//
//        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                if (gameStarted){
//                    if(playerTwoTurn){
//                        int diceValue = dice.getRolledDiceValue();
//                        diceLabel.setText("DiceValue : " +  diceValue);
//                        playerTwo.movePlayer(diceValue);
//                        // check winning condition
//                        if(playerTwo.isWinner()){
//                            diceLabel.setText("Winner is " + playerTwo.getName());
//
//                            playerOneTurn = false;
//                            playerOneButton.setDisable(true);
//                            playerOneLabel.setText("");
//
//                            playerTwoTurn = false;
//                            playerTwoButton.setDisable(true);  // Changed from false to true
//                            playerTwoLabel.setText("");
//
//                            startButton.setDisable(false);
//                            startButton.setText("Restart the game ");
//
//                        }
//                        else {
//                            playerOneTurn = true;
//                            playerOneButton.setDisable(false);
//                            playerOneLabel.setText("YourTurn" + playerOne.getName());
//
//                            playerTwoTurn = false;
//                            playerTwoButton.setDisable(true);  // Changed from false to true
//                            playerTwoLabel.setText("");
//                        }
//
//                    }
//                }
//            }
//        });
//
//
//
//
//        startButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                gameStarted = true;
//                diceLabel.setText("Game Started");
//                startButton.setDisable(true);
//                playerOneTurn = true;
//                playerOneLabel.setText("your Turn " + playerOne.getName());
//                playerOneButton.setDisable(false);
//                playerOne.statingPosition();
//
//                playerTwoTurn = false;
//                playerTwoLabel.setText("");
//                playerTwoButton.setDisable(true);
//                playerTwo.statingPosition();
//            }
//        });
//
//
//
//
//
//        root.getChildren().addAll(board,
//                playerOneButton, playerTwoButton, startButton,
//                playerOneLabel, playerTwoLabel, diceLabel,
//                playerOne.getCoin(), playerTwo.getCoin()
//        );
//
//        return root;
//    }
//
//    @Override
//    public void start(Stage stage) {
//        Scene scene = new Scene(createContent());
//        stage.setTitle("Snake & Ladder Grid");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}


package com.example.snakladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SnakeLadder extends Application {
    public static final int tileSize = 60, width = 10, height = 10;
    public static final int buttonLine = height*tileSize + 50, infoLine = buttonLine-30;

    private static Dice dice = new Dice();
    private Player playerOne, playerTwo;

    private boolean gameStarted = false, playerOneTurn = false, playerTwoTurn = false;

    private Button createStyledButton(String text, double x) {
        Button button = new Button(text);
        button.setStyle(
                "-fx-background-color: #4CAF50;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10px 20px;" +
                        "-fx-background-radius: 5px;" +
                        "-fx-cursor: hand"
        );
        button.setPrefWidth(120);
        button.setTranslateX(x);
        button.setTranslateY(buttonLine);

        // Add hover effect
        button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: #45a049;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10px 20px;" +
                        "-fx-background-radius: 5px;" +
                        "-fx-cursor: hand"
        ));
        button.setOnMouseExited(e -> button.setStyle(
                "-fx-background-color: #4CAF50;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10px 20px;" +
                        "-fx-background-radius: 5px;" +
                        "-fx-cursor: hand"
        ));

        return button;
    }

    private Label createStyledLabel(String text, double x) {
        Label label = new Label(text);
        label.setStyle(
                "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #333333"
        );
        label.setTranslateX(x);
        label.setTranslateY(infoLine);
        return label;
    }

    private Pane createContent() {
        Pane root = new Pane();
        root.setPrefSize(width * tileSize, height * tileSize + 100);
        root.setStyle("-fx-background-color: #f0f0f0");

        // Creating the grid using Tile class
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = new Tile(tileSize);
                tile.setTranslateX(j * tileSize);
                tile.setTranslateY(i * tileSize);
                root.getChildren().add(tile);
            }
        }

        Image img = new Image("C:\\Users\\neha7\\Desktop\\SnakLadder\\SnakLadder\\src\\main\\ludo.jpg");
        ImageView board = new ImageView();
        board.setImage(img);
        board.setFitHeight(height*tileSize);
        board.setFitWidth(width*tileSize);

        // Buttons with improved styling
        Button playerOneButton = createStyledButton("Player 1", 80);
        Button playerTwoButton = createStyledButton("Player 2", 380);
        Button startButton = createStyledButton("Start Game", 230);

        playerOneButton.setDisable(true);
        playerTwoButton.setDisable(true);

        // Info Labels with improved styling
        Label playerOneLabel = createStyledLabel("", 80);
        Label playerTwoLabel = createStyledLabel("", 380);
        Label diceLabel = createStyledLabel("Start the Game", 230);

        playerOne = new Player(tileSize, Color.BLACK, "Player 1");
        playerTwo = new Player(tileSize, Color.RED, "Player 2");

        // Player One Button Action
        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (gameStarted && playerOneTurn) {
                    int diceValue = dice.getRolledDiceValue();
                    diceLabel.setText("Dice: " + diceValue);
                    playerOne.movePlayer(diceValue);

                    if(playerOne.isWinner()) {
                        diceLabel.setText("Winner is " + playerOne.getName() + "!");
                        endGame(playerOneButton, playerTwoButton, playerOneLabel,
                                playerTwoLabel, startButton);
                    } else {
                        switchTurn(true, playerOneButton, playerTwoButton,
                                playerOneLabel, playerTwoLabel);
                    }
                }
            }
        });

        // Player Two Button Action
        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (gameStarted && playerTwoTurn) {
                    int diceValue = dice.getRolledDiceValue();
                    diceLabel.setText("Dice: " + diceValue);
                    playerTwo.movePlayer(diceValue);

                    if(playerTwo.isWinner()) {
                        diceLabel.setText("Winner is " + playerTwo.getName() + "!");
                        endGame(playerOneButton, playerTwoButton, playerOneLabel,
                                playerTwoLabel, startButton);
                    } else {
                        switchTurn(false, playerOneButton, playerTwoButton,
                                playerOneLabel, playerTwoLabel);
                    }
                }
            }
        });

        // Start Button Action
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStarted = true;
                diceLabel.setText("Game Started!");
                startButton.setDisable(true);

                playerOneTurn = true;
                playerOneLabel.setText("Your Turn, " + playerOne.getName());
                playerOneButton.setDisable(false);
                playerOne.statingPosition();

                playerTwoTurn = false;
                playerTwoLabel.setText("");
                playerTwoButton.setDisable(true);
                playerTwo.statingPosition();
            }
        });

        root.getChildren().addAll(
                board,
                playerOneButton, playerTwoButton, startButton,
                playerOneLabel, playerTwoLabel, diceLabel,
                playerOne.getCoin(), playerTwo.getCoin()
        );

        return root;
    }

    private void switchTurn(boolean toPlayerTwo, Button playerOneButton, Button playerTwoButton,
                            Label playerOneLabel, Label playerTwoLabel) {
        if (toPlayerTwo) {
            playerOneTurn = false;
            playerTwoTurn = true;
            playerOneButton.setDisable(true);
            playerTwoButton.setDisable(false);
            playerOneLabel.setText("");
            playerTwoLabel.setText("Your Turn, " + playerTwo.getName());
        } else {
            playerOneTurn = true;
            playerTwoTurn = false;
            playerOneButton.setDisable(false);
            playerTwoButton.setDisable(true);
            playerOneLabel.setText("Your Turn, " + playerOne.getName());
            playerTwoLabel.setText("");
        }
    }

    private void endGame(Button playerOneButton, Button playerTwoButton,
                         Label playerOneLabel, Label playerTwoLabel, Button startButton) {
        gameStarted = false;
        playerOneTurn = false;
        playerTwoTurn = false;
        playerOneButton.setDisable(true);
        playerTwoButton.setDisable(true);
        playerOneLabel.setText("");
        playerTwoLabel.setText("");
        startButton.setDisable(false);
        startButton.setText("Play Again");
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake & Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}