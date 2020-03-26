/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci2020u.pkgfinal.project;

import java.time.LocalDate;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author brend
 */
public class Intro {
    static LocalDate currentDate = LocalDate.now();
    
    public static void runIntro(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setStyle("-fx-background-color: grey; -fx-border-color: black;"
                + "-fx-border-width: .25px; -fx-padding: 10 10 10 10;"
                + "-fx-font-size: 14px; -fx-font-family: Tahoma;");
        
        //Get info from player
        pane.add(new Label("Please enter your player information."), 0, 0);
        //Entry for name
        pane.add(new Label("Name:"),0,2);
        final TextField name = new TextField();
        pane.add(name, 1,2);
        
        //Entry for date of birth
        final DatePicker dob = new DatePicker();
        pane.add(new Label("Date of Birth:"), 0,3);
        pane.add(dob, 1, 3);
        
        //Entry for the number of chips
        Slider numOfChips = new Slider(100, 500, 300);
        Label chipsIndicator = new Label("");
        pane.add(chipsIndicator, 2, 4);
        numOfChips.setBlockIncrement(10);
        numOfChips.setMajorTickUnit(10);
        numOfChips.setMinorTickCount(0);
        numOfChips.setShowTickLabels(true);
        numOfChips.setSnapToTicks(true);
        numOfChips.valueProperty().addListener( 
            new ChangeListener<Number>() { 
            public void changed(ObservableValue <? extends Number >  
                      observable, Number oldValue, Number newValue) { 
                chipsIndicator.setText("Chips: " + newValue); 
            } 
        });
        pane.add(new Label("Starting Chips:"), 0 , 4);
        pane.add(numOfChips, 1 , 4);
        
        //Button to submit entries
        //Defining Register button and extra Label
        Button btnEnter = new Button("Enter Casino");
        pane.add(btnEnter, 0,6);
        GridPane.setHalignment(btnEnter, HPos.RIGHT);
        final Label message = new Label();
        pane.add(message, 1, 6);
        
        //Create a new pane for pop up messages based on button outcome
        GridPane popup = new GridPane();
        popup.setAlignment(Pos.CENTER);
        popup.setStyle("-fx-background-color: black; -fx-border-color: black;"
                + "-fx-border-width: .25px; -fx-padding: 10 10 10 10;"
                + "-fx-font-size: 14px; -fx-font-weight: bold;"
                + "-fx-font-family: Tahoma;");
        Label popupMessage = new Label("");
        popupMessage.setTextFill(Color.RED);
        popup.add(popupMessage, 0, 0);
        Stage secondaryStage = new Stage();
        Scene scene2 = new Scene(popup, 800, 200);
        secondaryStage.setScene(scene2);
        Button btnAccept = new Button("Accept");
        btnAccept.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
               secondaryStage.close();
           }
        });
        popup.add(btnAccept, 0, 1);
        
        //Setting an action for Enter Casinio button
        btnEnter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (name.getText() == null || dob.getValue() == null) {
                    message.setText("Please fill in all fields.");
                    
                //If the player is underage, inform them and then close
                } else if (currentDate.getYear() - dob.getValue().getYear() < 19) {
                    primaryStage.close();
                    popupMessage.setText("Sorry, no minors allowed. Come back in "
                            + (19 - (currentDate.getYear() - dob.getValue().getYear()))
                            + " years.");
                    secondaryStage.setTitle("Error");
                    secondaryStage.show();
                    
                //If the player is legible to play, start the first game
                } else {
                    primaryStage.close();
                    popupMessage.setText("Welcome to the table, " + name.getText());
                    secondaryStage.setTitle("Welcome");
                    secondaryStage.show();
                    secondaryStage.close();
                    Game.runGame(primaryStage, name.getText());
                }
            }
        });
        
        //Create scene
        Scene scene = new Scene(pane, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Blackjack");
        primaryStage.show();
    }
}
