//package com.example.snakladder;
//
//import javafx.util.Pair;
//
//import java.util.ArrayList;
//
//public class Board {
//    ArrayList<Pair<Integer, Integer>> positionCoordinates;
//    ArrayList<Integer>  snakeLadderPosition;
//    public Board(){
//        positionCoordinates = new ArrayList<>();
//        populatePositionsCoordinates();
//        populateSnakeLadder();
//    }
//
//    private void populatePositionsCoordinates(){
//        positionCoordinates.add(new Pair<>(0, 0));
//        for (int i = 0; i < SnakeLadder.height ; i++) {
//            for (int j = 0; j < SnakeLadder.width; j++) {
//                //x coordinates
//                int xCord = 0;
//                if(i%2 == 0){
//                    xCord = j*SnakeLadder.tileSize + SnakeLadder.tileSize/2;
//                }
//                else {
//                    xCord = SnakeLadder.tileSize* SnakeLadder.height - (j*SnakeLadder.tileSize) - SnakeLadder.tileSize/2;
//                }
//                //y coordinates
//                int yCord = SnakeLadder.tileSize* SnakeLadder.height - (i*SnakeLadder.tileSize) - SnakeLadder.tileSize/2;
//                positionCoordinates.add(new Pair<>(xCord,yCord));
//            }
//        }
//    }
//
//
//    private  void populateSnakeLadder(){
//        snakeLadderPosition = new ArrayList<>();
//        for (int i = 0; i < 101; i++) {
//            snakeLadderPosition.add(i);
//        }
//        snakeLadderPosition.set(4,25);
//        snakeLadderPosition.set(13,46);
//        snakeLadderPosition.set(27,5);
//        snakeLadderPosition.set(33,49);
//        snakeLadderPosition.set(40,3);
//        snakeLadderPosition.set(42,63);
//        snakeLadderPosition.set(43,18);
//        snakeLadderPosition.set(50,69);
//        snakeLadderPosition.set(54,31);
//        snakeLadderPosition.set(62,81);
//        snakeLadderPosition.set(66,45);
//        snakeLadderPosition.set(74,92);
//        snakeLadderPosition.set(76,58);
//        snakeLadderPosition.set(89,53);
//        snakeLadderPosition.set(99,41);
//    }
//
//    public  int getNewPosition(int currentPosition){
//        if(currentPosition > 0 && currentPosition<=100){
//            return  snakeLadderPosition.get(currentPosition);
//        }
//        return -1;
//    }
//
//    int getXCoordinates(int position){
//        if(position>=1&&position<=100) return positionCoordinates.get(position).getKey();
//        return -1;
//    }
//    int getYCoordinates(int position){
//        if(position>=1&&position<=100) return positionCoordinates.get(position).getValue();
//        return -1;
//    }
//
//}


package com.example.snakladder;

import javafx.util.Pair;
import java.util.ArrayList;

public class Board {
    private ArrayList<Pair<Integer, Integer>> positionCoordinates;
    private ArrayList<Integer> snakeLadderPosition;

    public Board() {
        positionCoordinates = new ArrayList<>();
        populatePositionsCoordinates();
        populateSnakeLadder();
    }

    private void populatePositionsCoordinates() {
        positionCoordinates.add(new Pair<>(0, 0));
        for (int i = 0; i < SnakeLadder.height; i++) {
            for (int j = 0; j < SnakeLadder.width; j++) {
                // x coordinates
                int xCord;
                if(i % 2 == 0) {
                    xCord = j * SnakeLadder.tileSize + SnakeLadder.tileSize/2;
                } else {
                    xCord = SnakeLadder.tileSize * SnakeLadder.height - (j * SnakeLadder.tileSize) - SnakeLadder.tileSize/2;
                }
                // y coordinates
                int yCord = SnakeLadder.tileSize * SnakeLadder.height - (i * SnakeLadder.tileSize) - SnakeLadder.tileSize/2;
                positionCoordinates.add(new Pair<>(xCord, yCord));
            }
        }
    }

    private void populateSnakeLadder() {
        snakeLadderPosition = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            snakeLadderPosition.add(i);
        }
        // Ladders (positions where you climb up)
        snakeLadderPosition.set(4, 25);   // Ladder from 4 to 25
        snakeLadderPosition.set(13, 46);  // Ladder from 13 to 46
        snakeLadderPosition.set(33, 49);  // Ladder from 33 to 49
        snakeLadderPosition.set(42, 63);  // Ladder from 42 to 63
        snakeLadderPosition.set(50, 69);  // Ladder from 50 to 69
        snakeLadderPosition.set(62, 81);  // Ladder from 62 to 81
        snakeLadderPosition.set(74, 92);  // Ladder from 74 to 92

        // Snakes (positions where you slide down)
        snakeLadderPosition.set(27, 5);   // Snake from 27 to 5
        snakeLadderPosition.set(40, 3);   // Snake from 40 to 3
        snakeLadderPosition.set(43, 18);  // Snake from 43 to 18
        snakeLadderPosition.set(54, 31);  // Snake from 54 to 31
        snakeLadderPosition.set(66, 45);  // Snake from 66 to 45
        snakeLadderPosition.set(76, 58);  // Snake from 76 to 58
        snakeLadderPosition.set(89, 53);  // Snake from 89 to 53
        snakeLadderPosition.set(99, 41);  // Snake from 99 to 41
    }

    public int getNewPosition(int currentPosition) {
        if(currentPosition > 0 && currentPosition <= 100) {
            return snakeLadderPosition.get(currentPosition);
        }
        return -1;
    }

    public int getXCoordinates(int position) {
        if(position >= 1 && position <= 100) {
            return positionCoordinates.get(position).getKey();
        }
        return -1;
    }

    public int getYCoordinates(int position) {
        if(position >= 1 && position <= 100) {
            return positionCoordinates.get(position).getValue();
        }
        return -1;
    }
}