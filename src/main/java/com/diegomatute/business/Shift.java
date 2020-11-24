/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegomatute.business;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.io.FileReader;
import java.io.PrintStream;

/**
 * Contains Shift class code. This class holds Shift member variables
 * and methods.
 * 
 * @author diegomatute
 * @since 9/25/2020
 * 
 */
public class Shift
{
    //Attributes that maps class variables to JSON variables
    @SerializedName ("date")
    private MyDate Date;
    
    //Attributes that maps class variables to JSON variables
    @SerializedName("hoursWorked")
    private double HoursWorked; 
    
    /**
     * This method sets the values of each member variable to
     * a default value.
    */
    public Shift()
    {
        Date = new MyDate();
        HoursWorked = 5;
    }
    
   
    /**
     * This method sets the values of each member variable to
     * the corresponding parameter values.
     * 
     * @param d MyDate calls new on MyDate()
     * @param hw HoursWorked is set to HW
    */
    public Shift(MyDate d, double hw)
    {
        Date = d;
        HoursWorked = hw;
        /*
        //this.Date = new MyDate();
        //this.Date = d;
        d = Date;
        this.d = new MyDate();
        this.HoursWorked = hw;

        */
        
    }
    
    
    
    
    /**
     * This method gets and returns Date.
     * 
     * @return Date
    */
    public MyDate GetDate()
    {
        return Date;
    }
    
    /**
     * This method gets and returns HoursWorked.
     * 
     * @return HoursWorked
    */
    public double GetHoursWorked()
    {
        return HoursWorked;
    }
    
    
    /**
     * This method sets Month, Day, and Year to
     * Shift class member variables.
     * 
     * @param d sets the date value.
    */
    public void SetDate(MyDate d)
    {
        Date = d;
    }
    
    
    /**
     * This method sets HoursWorked to HW
     * 
     * @param hw HoursWorked is set to HW
     */
    public void SetHoursWorked(double hw)
    {
        HoursWorked = hw;
    }
    
    /**
     * This method reads the contents of all member variables 
     * from the given instance of FileReader as JSON.
     * 
     * @param fr An open file.
    */
    public void readJSON(FileReader fr)
    {

        Gson gson = new Gson();
        
        Shift y; 
        y = gson.fromJson(fr, Shift.class);
        
        Date = y.Date;
        HoursWorked = y.HoursWorked;
        
        
    }
    
    /**
     * This method writes the member variables in JSON format
     * too the given PrintStream.
     * 
     * @param ps A new output file.
    */
    public void writeJSON(PrintStream ps)
    {
        GsonBuilder builder = new GsonBuilder();
        //Sets prettyPrinting to true
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        
        Shift x = new Shift();
        
        x.SetDate(Date);
        HoursWorked = x.HoursWorked;

        
        String jsonString = gson.toJson(x);
        ps.printf("%s\n", jsonString);
       
    }
    
    /**
     * This method should return a String with descriptive text.
     * 
     * @return String y
    */
    @Override
    public String toString()
    {
        String y = Date + ", " + HoursWorked + " hours"; //"\n"
        //String y = String.format("%.1f", Date) + ", " + String.format("%.1f", HoursWorked) + " hours"; //"\n" 
        //String.format("%.1f", Worker.GetPayRate())
        //String y = Date.GetMonth() + "" + Date.GetDay() + "" + Date.GetYear() + ", " + HoursWorked + " hours"; //"\n" 
        return y;
    }
    
}