/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci2020u.pkgfinal.project;

import Blackjack.Dealer;
import Blackjack.Deck;
import Blackjack.HumanPlayer;
import java.util.Scanner;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.geometry.Insets;


/**
 *
 * @author brend
 */
public class Game {
    public static void runGame(Stage primaryStage, String playerName) {
        BorderPane pane = new BorderPane();
        
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
