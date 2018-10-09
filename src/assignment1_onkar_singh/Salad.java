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
public class Salad implements Food {
    private String bowlSize;
    private String veggies;
    private boolean isNonVeg;
    private String chickenType;   //chickenType will be initialised only if isnonveg is true.
    private boolean hasComboDeal;
    private boolean hasCheese;
    private boolean eatHere;      //if eatHere is false then it means customers chose OntheGo option

    public Salad(String bowlSize,boolean isNonVeg, String chickenType, String veggies,  boolean hasComboDeal, boolean hasCheese, boolean eatHere) {
        this.bowlSize = bowlSize;
        this.veggies = veggies;
        this.isNonVeg = isNonVeg;
        this.chickenType = chickenType;
        this.hasComboDeal = hasComboDeal;
        this.hasCheese = hasCheese;
        this.eatHere = eatHere;
    }

    public Salad(String bowlSize, boolean isNonVeg, boolean hasComboDeal) {
        this.bowlSize = bowlSize;
        this.isNonVeg = isNonVeg;
        this.hasComboDeal = hasComboDeal;
    }

    public String getBowlSize() {
        return bowlSize;
    }

    public String getVeggies() {
        return veggies;
    }

    public boolean isIsNonVeg() {
        return isNonVeg;
    }

    public String getChickenType() {
        return chickenType;
    }

    public boolean isHasComboDeal() {
        return hasComboDeal;
    }

    public boolean isHasCheese() {
        return hasCheese;
    }

    public boolean isEatHere() {
        return eatHere;
    }

    public void setBowlSize(String bowlSize) {
        this.bowlSize = bowlSize;
    }

    public void setVeggies(String veggies) {
        this.veggies = veggies;
    }

    public void setIsNonVeg(boolean isNonVeg) {
        this.isNonVeg = isNonVeg;
    }

    public void setChickenType(String chickenType) {
        this.chickenType = chickenType;
    }

    public void setHasComboDeal(boolean hasComboDeal) {
        this.hasComboDeal = hasComboDeal;
    }

    public void setHasCheese(boolean hasCheese) {
        this.hasCheese = hasCheese;
    }

    public void setEatHere(boolean eatHere) {
        this.eatHere = eatHere;
    }
    
    
    
    @Override
    public double getSubtotal() {
        double price = -1;
        if(bowlSize.equals("Large"))
            price = 6.0;
        if(bowlSize.equals("Small"))
            price = 3.5;
        if(hasComboDeal)
            price += 5;
        if(isNonVeg)
            price += 1;     // non-veg option is $1 expensive
        
        return price;
    }
   
    @Override
    public String toString() {
        
        String br = System.getProperty("line.separator");
        String sp = "  ";
        String sp4 = sp+sp+sp+sp;
        return "Salad" + sp4+sp4+sp+sp+sp+" $" + this.getSubtotal() + br 
                +sp+ ">" + bowlSize +" "+((isNonVeg)? sp + "Non-Veg":"Veg") + br
                +((isNonVeg)? sp + ">"+chickenType +br:"")
                +((hasCheese)? sp + ">Cheese Crust" + br:"") 
                +((hasComboDeal)? sp + ">Combo Deal*" + br:"") 
                +((!veggies.equals("none"))? sp + ">"+veggies +br:"")
                +((eatHere)? sp + ">Eat Here" + br:"On the Go" + br) ;
    }
    
    
    
    
    
    
    
}
