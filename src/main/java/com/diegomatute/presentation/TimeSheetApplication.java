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
 * Contains TimeSheetApplication class code. This class holds 
 * TimeSheetApplication member variables, loads the FXML file 
 * and shows the window.
 * 
 * @author diegomatute
 * @since 11/23/2020
 * 
 */


//Inherits from Application
public class TimeSheetApplication extends Application {


    //Overrides the abstract start method of Application.
    @Override
    //Start method added
     /**
     * This method should load the FXML file 
     * and shows the window.
     * 
     * @param primaryStage is constructed by the platform.
     * @exception IOException is produced by failed or interrupted
     *            I/O Exceptions.
     */
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
