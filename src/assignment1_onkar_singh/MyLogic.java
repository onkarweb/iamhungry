/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_onkar_singh;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Onkar
 */
public class MyLogic {
    
    //this list will be used by the rest of the classes and other stuff
    public static ArrayList<Food> orderedFoods = new ArrayList<Food>();  
    
    //static process to open bill using notepad
    static ProcessBuilder pb;
    
    //method to print the bill to a text file
    public static void printBill(){
        
        try{
        //identify the file
        File file = new File("Bill.txt");
        
        //if the file doesn't exist then make a new one
        if(!file.exists())
            file.createNewFile();
        
        //open the file
        FileWriter fr = new FileWriter(file);
        BufferedWriter br = new BufferedWriter(fr);
        
        //write to the file
        String sp = "  ";
        String sp4 = sp+sp+sp+sp;
        String sep = "******************************";
        String brs = System.getProperty("line.separator");
                
        br.write(sp4+sp4+"I am Hungry"+sp4+brs);
        br.write(sp4+sp+sp+"1203 Mavis Road"+sp+sp+brs);
        br.write(sp4+sp+sp+sp+"Brampton, ON"+sp+sp+brs);
        br.write(sp4+sp4+sp+"L6P 3W8"+sp+sp+sp+brs);
        br.newLine();
        br.write(sep);
        br.newLine();
        for(Food f : orderedFoods){
            br.write(f.toString());
            br.newLine();
        }
        br.write(sep);
        br.newLine();
        br.write("Subtotal:" +sp4+sp4+sp+" $"+ subtotal() + brs);
        br.write("Taxes(13%):" +sp4+sp+sp+sp+"$"+ calculateTax() + brs);
        br.write("Total:" +sp4+sp4+sp+sp+sp+" $"+ grandTotal() + brs);
        
        //close the file
        br.close();
        
        
        }catch(IOException e){
            System.out.println(e);
        }
        
        //this is the call to my custom method to show bill on notepad
        showBillOnNotepad(); 
    }
    
    //method to caluclate the grandtotal
    public static double grandTotal(){
        return roundIt(subtotal() + calculateTax());
    }
    
    //method to calulate the totalSubtotal
    public static double subtotal(){
        double subtotal = 0;
        for(Food f : orderedFoods){
            subtotal += f.getSubtotal();
        }
        return roundIt(subtotal);
    }
    
    //method to calculate the taxes
    public static double calculateTax(){
        return roundIt(subtotal() * 0.13);
    }
    
    //metjod to limit the decimal places to 2 values
    public static double roundIt(double a){
        return Math.round(a * 100.0) / 100.0;
    }
    
   // method to print display the bill on notepad
    public static void showBillOnNotepad(){
        try{
        pb = new ProcessBuilder("Notepad.exe", "Bill.txt");
        pb.start();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
