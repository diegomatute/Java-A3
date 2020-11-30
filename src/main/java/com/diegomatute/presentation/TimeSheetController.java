/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegomatute.presentation;

import com.diegomatute.business.TimeSheet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
//import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;
//import javafx.stage.WindowEvent;


/**
 * Contains TimeSheetController class code. This class holds 
 * TimeSheetController member variables and GUI event handlers.
 * 
 * @author diegomatute
 * @since 11/23/2020
 * 
 */
public class TimeSheetController 
{
    
    private TimeSheet ts = new TimeSheet();
    
    
    @FXML
    private AnchorPane anchorpane;
    
    @FXML
    private MenuItem openMenuItem;
    
    @FXML
    private MenuItem saveAsMenuItem;
    
    @FXML
    private MenuItem saveReportMenuItem;
    
    @FXML
    private MenuItem exitMenuItem;
    
    
    @FXML
    private ListView shiftListView;
    
    @FXML
    private Tab workerTab;
    
    @FXML
    private Tab shiftTab;
    
    @FXML
    private Window stage;
    
    @FXML
    private TextField firstNameTF;
    
    @FXML
    private TextField lastNameTF;
    
    @FXML
    private TextField idTF;
    
    @FXML
    private TextField payRateTF;
    
    /*
    @FXML
    private ListView workerListView;
    */
    
    
    /**
     * This method should Open a file selected by a user and read and display
     * the data in the Worker and Shift tabs.
     *
     * @param event is an event representing some type of action.
     * @exception ArrayIndexOutOfBoundsException is produced If we request for
     *            an index that is either negative, or greater than or equal 
     *            to the size of the array
     */
   @FXML
    protected void handleOpenMenuItemAction(ActionEvent event) {

        //New FileChooser
        FileChooser fileChooser = new FileChooser();

        //Set heading 
        fileChooser.setTitle("Open TimeSheet File");

        //Extension filter allows .Json files to be read
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Json files", "*.json"));

        //Open FileChooser 
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            //Try/Catch block
            try {
                //Open FileReader
                FileReader fileReader = new FileReader(file);

                //readJson method called from TimeSheet class
                ts.readJson(fileReader);

                //Set worker values
                //Using Worker method from TimeSheet instance
                firstNameTF.setText(ts.getWorker().GetFirst());

                lastNameTF.setText(ts.getWorker().GetLast());

                idTF.setText(String.valueOf(ts.getWorker().GetId()));

                payRateTF.setText(String.valueOf(ts.getWorker().GetPayRate()));

                //Set worker shifts
                //Get background collection
                ObservableList<String> items = shiftListView.getItems();

                //Clear previous shifts
                items.clear();

                //For loop until out of bounds
                for (int i = 0;; i++) {
                    //Try to get each worker shift until it fails
                    try {
                        //Add to the List View
                        items.add(ts.getAt(i).toString());
                    } catch (ArrayIndexOutOfBoundsException e) {
                        //Stop loop
                        break;
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println(e);
            }

        }

    }
   
        
    /**
     * This method should display a FileChooser and let the user decide
     * which file to write data to.The program should then write data from
     * the TimeSheet instance into the selected file.
     * 
     * @param event is an event representing some type of action.
     */
   @FXML
    protected void handleSaveAsMenuItemAction(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Save As TimeSheet");

        //fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Json files(*.json)", "*.json"));
        /*
       fileChooser.getExtensionFilters().addAll(
       new ExtensionFilter("Text Files", "*.txt"),
       new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
       new ExtensionFilter("Json Files", "*.json"));
         */
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Json files", "*.json"));

        //Shows save as option 
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            try {
                //Open PrintStream
                PrintStream ps = new PrintStream(file);

                //Call writeJSON method from TimeSheet instance
                ts.writeJSON(ps);
            } //Catch if file not found
            catch (FileNotFoundException e) {
                System.out.println(e);
            }
        }

    
    }
    
    /**
     * When the User selects the Save Report menu item the program
     * should display a FileChooser and let the user decide which file 
     * to write a report to.
     * 
     * @param event is an event representing some type of action.
     */    
   @FXML
    protected void handleSaveReportMenuItemAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //fileChooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
       
       //Extensions allow for different files to be read/written to. 
       fileChooser.getExtensionFilters().addAll(
       new ExtensionFilter("Text Files", "*.txt"),
       new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
       new ExtensionFilter("Json Files", "*.json"));
        
       fileChooser.setTitle("Save TimeSheet Report");

       File file = fileChooser.showSaveDialog(stage);

       if (file != null) 
       {
           try 
           {
               PrintStream ps = new PrintStream(file);

               //Calls report method from TimeSheet class
               ts.report(ps);
           } catch (FileNotFoundException e) {
               System.out.println(e);
           }

        }

    }
   
     /**
     * This method should close the window and go back to the main 
     * menu console window prompt that created the window in the first place.
     * 
     * @param event is an event representing some type of action.
     */
   @FXML
    protected void handleExitMenuItemAction(ActionEvent event) {

        //Platform.exit();

        System.exit(0);
    }

}
