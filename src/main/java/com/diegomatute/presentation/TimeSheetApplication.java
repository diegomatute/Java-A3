/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegomatute.presentation;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author diegomatute
 */
//Inherits from Application
public class TimeSheetApplication extends Application {

    //Overrides the abstract start method of the Application
    @Override
    //Start method added
    public void start(Stage primaryStage) 
    {
        Parent root = null;
        Scene scene = null;
        try {
            //Instance of FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
            //Load FXMl from file
            root = loader.load();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        // Put the root containing the FXML into the scene
        scene = new Scene(root, 300, 275);
        //Put the scene in the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
