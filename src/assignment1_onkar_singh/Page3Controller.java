/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_onkar_singh;

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
public class Page3Controller implements Initializable {

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
    public void show2(){
        Assignment1_Onkar_Singh.show2();
    }
    
    @FXML
    RadioButton large;
    
    @FXML 
    RadioButton small;
    
    @FXML
    ComboBox chicken;
    
    @FXML
    CheckBox nonVeg;
    
    @FXML
    CheckBox cheeseCrust;
    
    @FXML
    CheckBox ComboDeal;
    
    @FXML
    RadioButton allVeggies;
    
    @FXML
    RadioButton someVeggies;
    
    @FXML
    RadioButton eatHeree;
    
    @FXML
    RadioButton onTheGo;
    
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
        if(nonVeg.isSelected())
            price += 1;   //price increase by 1 if nonVeg is selected
        if(ComboDeal.isSelected())
            price += 5;
        
        lblPrice.setText("$"+price);
    }
    
    @FXML
    public void enableChicken(){
        if(nonVeg.isSelected())
            chicken.setDisable(false);
        else
            chicken.setDisable(true);
        
        //just to use two methods when non-veg is selected, let's call displayPrice here
        displayPrice();
    }
    
    @FXML
    public void addSalad(){
        String bowlSize = "";
        String veggies = "";
        boolean isNonVeg = false;
        String chickenType = "";   //chickenType will be initialised only if isnonveg is true.
        boolean hasComboDeal;
        boolean hasCheese;
        boolean eatHere = false;   
        
        if(large.isSelected())
            bowlSize = "Large";
        if(small.isSelected())
            bowlSize = "Small";
        
        isNonVeg = nonVeg.isSelected();
        if(nonVeg.isSelected()){
        chickenType = (String)chicken.getValue();
        }
        hasCheese = cheeseCrust.isSelected();
        hasComboDeal = ComboDeal.isSelected();
        if(allVeggies.isSelected())
            veggies = "All Veggies";
        else if(someVeggies.isSelected())
            veggies = "Some Veggies";
        else
            veggies = "none";
        if(this.eatHeree.isSelected())
            eatHere = true;
        if(this.onTheGo.isSelected())
            eatHere = false;
        
        
        Salad s = new Salad(bowlSize, isNonVeg, chickenType, veggies, hasComboDeal, hasCheese, eatHere);
        MyLogic.orderedFoods.add(s);
        
        //for checking purposes on the console
        System.out.println("The orderedfoods list now is : ");
        MyLogic.orderedFoods.forEach((f) -> {
            System.out.println(f + "the cost is $"+ f.getSubtotal());
            
        large.setSelected(true);
        lblPrice.setText("$6.0");
        cheeseCrust.setSelected(false);
        ComboDeal.setSelected(false);
        chicken.getSelectionModel().select("Beef"); //default value was beef
        allVeggies.setSelected(false);
        someVeggies.setSelected(false);
        nonVeg.setSelected(false);
        eatHeree.setSelected(true); 
        chicken.setDisable(true);
        });
    }
    
    @FXML
    public void checkOut(){
        MyLogic.printBill();
    }
    
}
