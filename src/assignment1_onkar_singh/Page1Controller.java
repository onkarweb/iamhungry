/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_onkar_singh;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author Onkar
 */
public class Page1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bread.getItems().removeAll(bread.getItems());
        bread.getItems().addAll("Flat", "Italian", "Honey Oats");
        bread.getSelectionModel().select("Italian");
    }    
    
    @FXML
    public void show2(){
        Assignment1_Onkar_Singh.show2();
    }
    
    @FXML
    public void show3(){
        Assignment1_Onkar_Singh.show3();
    }
    @FXML
    RadioButton sixInch;
    
    @FXML 
    RadioButton footLong;
    
    @FXML
    ComboBox bread;
    
    @FXML
    CheckBox cheeseCrust;
    
    @FXML
    CheckBox ComboDeal;
    
    @FXML
    RadioButton allVeggies;
    
    @FXML
    RadioButton someVeggies;
    
    @FXML
    CheckBox sauce;
    
    @FXML
    CheckBox VegPattie;
    
    @FXML
    Label lblPrice;
    
    //this method is for updating the output
    @FXML
    public void displayPrice(){
        double price = -1;
        if(sixInch.isSelected())
            price = 3.80;
        if(footLong.isSelected())
            price = 7.60;
        if(VegPattie.isSelected())
            price += 2;
        if(ComboDeal.isSelected())
            price += 5;
        
        lblPrice.setText("$"+price);
    }
    
    @FXML
    public void addSandwich(){
        String size = "";
        String breadType;
        boolean cheese;
        boolean hasVegPattie;
        boolean hasExtraSause;
        boolean hasComboDeal;
        String veggies = "";
        
        if(sixInch.isSelected())
            size = "6inch";
        if(footLong.isSelected())
            size = "Foot-Long";
        breadType = (String)bread.getValue();
        cheese = cheeseCrust.isSelected();
        hasVegPattie = VegPattie.isSelected();
        hasExtraSause = sauce.isSelected();
        hasComboDeal = ComboDeal.isSelected();
        if(allVeggies.isSelected())
            veggies = "All Veggies";
        else if(someVeggies.isSelected())
            veggies = "Some Veggies";
        else
            veggies = "none";
            

        
        Sandwich s = new Sandwich(size, breadType, cheese, hasVegPattie, hasExtraSause, hasComboDeal, veggies);
        MyLogic.orderedFoods.add(s);
        
        //for checking purposes on the console
        System.out.println("The orderedfoods list now is : ");
        MyLogic.orderedFoods.forEach((f) -> {
            System.out.println(f);
         });    
        
         sixInch.setSelected(true);
         lblPrice.setText("$3.80");
         footLong.setSelected(false);
         cheeseCrust.setSelected(false);
         ComboDeal.setSelected(false);
         allVeggies.setSelected(false);
         someVeggies.setSelected(false);
         VegPattie.setSelected(false);
         sauce.setSelected(false);
         
       
    }
    
    @FXML
    public void checkOut(){
        MyLogic.printBill();
    }
    
    
    
    
    
    
}
