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
public class Page2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chicken.getItems().removeAll(chicken.getItems());
        chicken.getItems().addAll("Tuna", "Bacon", "Ham", "Beef");
        chicken.getSelectionModel().select("Beef");
    }  
    
    @FXML
    public void show1(){
        Assignment1_Onkar_Singh.show1();
    }
    
    @FXML
    public void show3(){
        Assignment1_Onkar_Singh.show3();
    }
    
    @FXML
    RadioButton large;
    
    @FXML 
    RadioButton small;
    
    @FXML
    ComboBox chicken;
    
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
    Label lblPrice;
    
    
    //this method is for updating the output
    @FXML
    public void displayPrice(){
        double price = -1;
        if(small.isSelected())
            price = 3.50;
        if(large.isSelected())
            price = 6.00;
        if("Tuna".equals(chicken.getValue().toString())){
            price += 1;
            System.out.println("Tuna is selected **");
        }
        if(ComboDeal.isSelected())
            price += 5;
        
        System.out.println(chicken.getValue().toString());
        lblPrice.setText("$"+price);
    }
    
    @FXML
    public void addWrap(){
        String size = "";
        String chickenType;
        boolean cheese;
        boolean hasExtraSause;
        boolean hasComboDeal;
        String veggies = "";
        
        if(large.isSelected())
            size = "Large";
        if(small.isSelected())
            size = "Small";
        chickenType = (String)chicken.getValue();
        cheese = cheeseCrust.isSelected();
        hasExtraSause = sauce.isSelected();
        hasComboDeal = ComboDeal.isSelected();
        if(allVeggies.isSelected())
           veggies = "All Veggies";
        else if(someVeggies.isSelected())
           veggies = "Some Veggies";
        else    
           veggies = "none";
 
        
        Wrap w = new Wrap(size, chickenType, cheese, hasExtraSause, hasComboDeal, veggies);
        MyLogic.orderedFoods.add(w);
        
        //for checking purposes on the console
        System.out.println("The orderedfoods list now is : ");
        MyLogic.orderedFoods.forEach((f) -> {
            System.out.println(f + "the cost is $"+ f.getSubtotal());
            
        large.setSelected(true);
        lblPrice.setText("$6.0");
        small.setSelected(false);
        chicken.getSelectionModel().select("Beef"); //default value was beef
        cheeseCrust.setSelected(false);
        ComboDeal.setSelected(false);
        allVeggies.setSelected(false);
        someVeggies.setSelected(false);
        sauce.setSelected(false);    
        });
    }
    
    @FXML
    public void checkOut(){
        MyLogic.printBill();
        
    }
}
