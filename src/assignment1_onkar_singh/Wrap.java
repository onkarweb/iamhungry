/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_onkar_singh;

/**
 *
 * @author Onkar
 */
public class Wrap implements Food {
    private String RollSize;
    private String ChickenType;
    private boolean hasCheeseCrust;
    private boolean hasExtraSauce;
    private boolean hasComboDeal;
    private String veggies;
    
    public Wrap(String RollSize, String ChickenType, boolean hasCheeseCrust, boolean hasExtraSauce, boolean hasComboDeal, String veggies){
        this.RollSize = RollSize;
        this.ChickenType = ChickenType;
        this.hasCheeseCrust = hasCheeseCrust;
        this.hasExtraSauce = hasExtraSauce;
        this.hasComboDeal = hasComboDeal;
        this.veggies = veggies;
    }

    public Wrap(String RollSize, String ChickenType, boolean hasComboDeal) {
        this.RollSize = RollSize;
        this.ChickenType = ChickenType;
        this.hasComboDeal = hasComboDeal;
    }

    @Override
    public double getSubtotal() {
        double price = -1;
        if(RollSize.equals("Small"));
            price = 3.50;
        if(RollSize.equals("Large"))
            price = 6.00;
        if(ChickenType.equals("Tuna"))  //tuna meat is for $1 and rest meats are free to include
            price += 1.00;
        if(hasComboDeal)
            price += 5.00;
        
        return price;
    }

    public String getRollSize() {
        return RollSize;
    }

    public String getChickenType() {
        return ChickenType;
    }

    public boolean isHasCheeseCrust() {
        return hasCheeseCrust;
    }

    public boolean isHasExtraSauce() {
        return hasExtraSauce;
    }

    public boolean isHasComboDeal() {
        return hasComboDeal;
    }

    public String getVeggies() {
        return veggies;
    }

    public void setRollSize(String RollSize) {
        this.RollSize = RollSize;
    }

    public void setChickenType(String ChickenType) {
        this.ChickenType = ChickenType;
    }

    public void setHasCheeseCrust(boolean hasCheeseCrust) {
        this.hasCheeseCrust = hasCheeseCrust;
    }

    public void setHasExtraSauce(boolean hasExtraSauce) {
        this.hasExtraSauce = hasExtraSauce;
    }

    public void setHasComboDeal(boolean hasComboDeal) {
        this.hasComboDeal = hasComboDeal;
    }

    public void setVeggies(String veggies) {
        this.veggies = veggies;
    }

    @Override
    public String toString() {
        String br = System.getProperty("line.separator");
        String sp = "  ";
        String sp4 = sp+sp+sp+sp;
        return "Wrap" + sp4+sp4+sp+sp+sp+" $" + this.getSubtotal() + br 
                +sp+ ">" + RollSize + br
                +sp+ ">" + ChickenType +" Chicken"+ br
                +((hasCheeseCrust)? sp + ">Cheese" + br:"") 
                +((hasExtraSauce)? sp + ">Extra Sauce" + br:"") 
                +((hasComboDeal)? sp + ">Combo Deal*" + br:"") 
                +((!veggies.equals("none"))? sp + ">"+veggies +br:"");
        
    }
    
    
    
    
    
    
    
    
    
}
