/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegomatute.presentation;

import com.diegomatute.business.TimeSheet;
import java.io.File;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;
import javafx.stage.WindowEvent;


/**
 *
 * @author diegomatute
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
    private ListView listView;
    
    @FXML
    private Tab workerTab;
    
    @FXML
    private Tab shiftTab;
    
    @FXML
    private Window stage;
    
   @FXML
   protected void handleOpenMenuItemAction(ActionEvent event)
   {
       //System.out.println("Opened file chooser");
       
       FileChooser fileChooser = new FileChooser();
       
       fileChooser.setTitle("Open TimeSheet File");
       
       File file = fileChooser.showOpenDialog(stage);
       
       /*
       if (file != null)
       {
           stage.display(file);
       }
        */
       
       
       // https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm
   }
   
   @FXML
   protected void handleSaveAsMenuItemAction(ActionEvent event)
   {
       
       FileChooser fileChooser = new FileChooser();
       
       fileChooser.setTitle("Save As TimeSheet");
       
       //fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Json files(*.json)", "*.json"));
       fileChooser.getExtensionFilters().addAll(
       new ExtensionFilter("Text Files", "*.txt"),
       new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
       new ExtensionFilter("Json Files", "*.json"));
       File file = fileChooser.showSaveDialog(stage);
       
   }
    
   @FXML
   protected void handleSaveReportMenuItemAction(ActionEvent event)
   {
       FileChooser fileChooser = new FileChooser();
       
       fileChooser.setTitle("Save TimeSheet");
       
       
   }
   
   @FXML
   protected void handleExitMenuItemAction(WindowEvent event)
   {
      /* 
      Platform.exit();
      System.exit(0);
      */
   }
   
   
}
