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
 * Contains MyDate class code. This class holds MyDate member variables
 * and methods.
 * 
 * @author diegomatute
 * @since 9/25/2020
 * 
 */
public class MyDate 
{
    //Attributes that maps class variables to JSON variables
    @SerializedName("month")
    private int Month;
    
    //Attributes that maps class variables to JSON variables
    @SerializedName("day")
    private int Day;
    
    //Attributes that maps class variables to JSON variables
    @SerializedName("year")
    private int Year;
    
    /**
     * This method sets the values of each member variable to
     * a default value.
     */
    public MyDate()
    {
        Month = 0;
        Day = 0;
        Year = 0;
    
    };
    
    /**
     * This method sets the values of each member variable to
     * the corresponding parameter values.
     * 
     * @param month Month is set to m.
     * @param day Day os set to d.
     * @param year Year is set to y.
    */
    public MyDate(int month, int day, int year)
    {
        Month = month;
        Day = day;
        Year = year;
    };
    
        
    /**
     * This method gets and returns Month.
     * 
     * @return Month
    */
    public int GetMonth()
    {
        return Month;
    };
    
            
    /**
     * This method gets and returns Day.
     * 
     * @return Day
    */
    public int GetDay()
    {
        return Day;
    };
    
            
    /**
     * This method gets and returns Year.
     * 
     * @return Year
    */
    public int GetYear()
    {
        return Year;
    };
    
            
    /**
     * This method sets Month to m.
     * 
     * @param month Month is set to m.
    */
    public void SetMonth(int month)
    {
        Month = month;
    };
    
            
    /**
     * This method sets Day to d.
     * 
     * @param day Day is set to Day.
    */
    public void SetDay(int day)
    {
        Day = day;
    };
    
            
    /**
     * This method sets Year to y.
     * 
     * @param year Year is set to y.
    */
    public void SetYear(int year)
    {
        Year = year;
    };
    
            
    /**
     * This method reads the contents of all member variables 
     * from the given instance of FileReader as JSON.
     * 
     * @param fr An open file.
    */
    public void readJSON(FileReader fr)
    {
        Gson gson = new Gson();
        
        MyDate mD;
        
        mD = gson.fromJson(fr, MyDate.class);
        
        Month = mD.Month;
        Day = mD.Day;
        Year = mD.Year;
    };
    
            
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
        
        //MyDate x;
        MyDate x = new MyDate();
        
        
        Month = x.Month;
        Day = x.Day;
        Year = x.Year;
        
        String jsonString = gson.toJson(x);
        
        ps.printf("%s\n", jsonString);

    };
    
    /**
     * This method should return a String instance that contains 
     * a formatted date.
     * 
     * @return String S
     */
    @Override 
    public String toString()
    {
        //String s = String.format("%.1f", Month) + "/" + String.format("%.1f", Day) + "/" + String.format("%.1f", Year); 
        String s = Month + "/" + Day + "/" + Year; 
        return s;
    }
    
    
    
    
}
