//package com.example.snakladder;
//
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//
//public class Tile extends Rectangle {
//    public Tile(int tileSize) {
//        setWidth(tileSize);
//        setHeight(tileSize);
//        setFill(Color.LIGHTGRAY); // Grid color
//        setStroke(Color.BLACK);   // Border color
//    }
//}


// Tile.java
package com.example.snakladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    public Tile(int tileSize) {
        setWidth(tileSize);
        setHeight(tileSize);
        setFill(Color.rgb(245, 245, 245));  // Light gray background
        setStroke(Color.rgb(200, 200, 200)); // Lighter border
        setStrokeWidth(0.5);                 // Thinner border for cleaner look
        setArcHeight(4);                     // Slightly rounded corners
        setArcWidth(4);
    }
}
