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
 * Contains Worker class code. This class holds Worker member variables 
 * and methods.
 * 
 * @author diegomatute
 * @since 9/25/2020
 * 
 */
public class Worker 
{
    @SerializedName("first")
    private String First;
    
    @SerializedName("last")
    private String Last;
    
    @SerializedName("id")
    private int Id;
    
    @SerializedName("payRate")
    private double PayRate; 
    
    
    /**
     * This method sets the values of each member variable to
     * a default value.
    */
    public Worker()
    {
        First = "NO_FIRST";
        Last = "NO_LAST";
        Id = 0;
        PayRate = 0;
    }
    
    /**
     * This method sets the values of each member variable to
     * the corresponding parameter values.
     * 
     * @param f First is set to f
     * @param l Last is set to l
     * @param Id2 Id is set to Id2
     * @param pRate PayRate is set to pRate
    */
    public Worker(String f, String l, int Id2, double pRate)
    {
        First = f;
        Last = l;
        Id = Id2;
        PayRate = pRate;   
    }
    /**
     * This method gets and returns First.
     * 
     * @return First
    */
    public String GetFirst()
    {
        return First;
    }
    
    /**
     * This method gets and returns Last.
     * 
     * @return Last
    */
    public String GetLast()
    {
        return Last;
    }
    
    /**
     * This method gets and returns Id.
     * 
     * @return Id
    */
    public int GetId()
    {
        return Id;
    }
    
    /**
     * This method gets and returns PayRate.
     * 
     * @return PayRate
    */
    public double GetPayRate()
    {
        return PayRate;
    }
    
    /**
     * This method sets First to f.
     * 
     * @param f First is set to f.
    */
    public void SetFirst(String f)
    {
        First = f;
    }
    
    /**
     * This method sets Last to l.
     * 
     * @param l Last is set to l.
    */
    public void SetLast(String l)
    {
        Last = l;
    }
    
    /**
     * This method sets Id to Id2.
     * 
     * @param Id2 Id is set to Id2.
    */
    public void SetId(int Id2)
    {
        Id = Id2;
    }
    
    /**
     * This method sets PayRate to pRate.
     * 
     * @param pRate PayRate is set to pRate.
    */
    public void SetPayRate(double pRate)
    {
        PayRate = pRate;
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
        
        Worker x;
        
        
        x = gson.fromJson(fr, Worker.class);
        
        //PayRate = x.GetPayRate();
        
        First = x.First;
        Last = x.Last;
        Id = x.Id;
        PayRate = x.PayRate;
        
        
        
        //String jsonString = ("shift.json");
    }
    
    /**
     * This method writes the member variables in JSON format
     * too the given PrintStream.
     * 
     * @param ps A new output file.
    */
    public void writeJSON(PrintStream ps)
    {
        //Gson gson = new Gson();
        
        GsonBuilder builder = new GsonBuilder();
        //Sets prettyPrinting to true
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        
        Worker x = new Worker();
        First = x.First;
        Last = x.Last;
        Id = x.Id;
        PayRate = x.PayRate;
        
        String jsonString = gson.toJson(x);
        
        ps.printf("%s\n", jsonString);
  
        
        //String jsonString = "{\"hoursWorked\": 5.0}";
    }
    
    /**
     * This method should return a String with 
     * descriptive text
     * 
     * @return String x
    */
    @Override
    public String toString()
    {
        String x = First + " " + Last + " " + Id + " " + PayRate; 
        return x;
    }
    
    
}

