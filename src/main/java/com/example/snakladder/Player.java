//package com.example.snakladder;
//import javafx.animation.PauseTransition;
//import javafx.animation.SequentialTransition;
//import javafx.animation.TranslateTransition;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//import javafx.util.Duration;
//
//public class Player {
//    private Circle coin;
//    private int currentPosition;
//    private String name;
//    private static Board gameBoard = new Board();
//
//    public Player(int tileSize, Color coinColor, String playerName) {
//        coin = new Circle(tileSize/2);
//        coin.setFill(coinColor);
//        currentPosition = 0;
//        movePlayer(1);
//        name = playerName;
//    }
//
//    public void movePlayer(int diceValue) {
//        if (currentPosition + diceValue <= 100) {
//            currentPosition += diceValue;
//            TranslateTransition secondMove = null , firstMove = translateAnimation();
//
//            int newPosition = gameBoard.getNewPosition(currentPosition);
//            if(newPosition!=currentPosition && newPosition!=-1){
//                currentPosition = newPosition;
//                secondMove = translateAnimation();
//            }
//
//            if(secondMove == null){
//                firstMove.play();
//            }else {
//                SequentialTransition sequentialTransition = new SequentialTransition(firstMove,
//                        new PauseTransition(Duration.millis(1000)), secondMove
//                        );
//
//                sequentialTransition.play();
//            }
//        }
//    }
//
//    private TranslateTransition translateAnimation() {
//        TranslateTransition animate = new TranslateTransition(Duration.millis(1000), coin);
//        animate.setToX(gameBoard.getXCoordinates(currentPosition));
//        animate.setToY(gameBoard.getYCoordinates(currentPosition));
//        animate.setAutoReverse(false);
//        return animate;
//    }
//
//
//    public void statingPosition(){
//        currentPosition = 1;
//        movePlayer(0);
//    }
//
//    boolean isWinner(){
//        if(currentPosition == 100)
//            return  true;
//        return  false;
//
//    }
//
//    public Circle getCoin() {
//        return coin;
//    }
//
//    public int getCurrentPosition() {
//        return currentPosition;
//    }
//
//    public String getName() {
//        return name;
//    }
//}



package com.example.snakladder;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    private Circle coin;
    private int currentPosition;
    private String name;
    private static Board gameBoard = new Board();

    public Player(int tileSize, Color coinColor, String playerName) {
        coin = new Circle(tileSize/3);  // Made coin slightly smaller for better visibility
        coin.setFill(coinColor);
        coin.setStroke(Color.WHITE);    // Added white border for better contrast
        coin.setStrokeWidth(2);         // Border width
        currentPosition = 0;
        movePlayer(1);
        name = playerName;
    }

    public void movePlayer(int diceValue) {
        if (currentPosition + diceValue <= 100) {
            currentPosition += diceValue;
            TranslateTransition secondMove = null, firstMove = translateAnimation();

            int newPosition = gameBoard.getNewPosition(currentPosition);
            if(newPosition != currentPosition && newPosition != -1) {
                currentPosition = newPosition;
                secondMove = translateAnimation();
            }

            if(secondMove == null) {
                firstMove.play();
            } else {
                SequentialTransition sequentialTransition = new SequentialTransition(
                        firstMove,
                        new PauseTransition(Duration.millis(500)), // Reduced pause time for better game flow
                        secondMove
                );
                sequentialTransition.play();
            }
        }
    }

    private TranslateTransition translateAnimation() {
        TranslateTransition animate = new TranslateTransition(Duration.millis(200), coin); // Faster animation
        animate.setToX(gameBoard.getXCoordinates(currentPosition));
        animate.setToY(gameBoard.getYCoordinates(currentPosition));
        animate.setAutoReverse(false);
        return animate;
    }

    public void statingPosition() {
        currentPosition = 0;
        movePlayer(1);
    }

    public boolean isWinner() {
        return currentPosition == 100;
    }

    public Circle getCoin() {
        return coin;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }
}