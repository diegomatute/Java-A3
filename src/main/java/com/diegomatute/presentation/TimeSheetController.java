/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegomatute.presentation;

import com.diegomatute.business.TimeSheet;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;


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
    
}
