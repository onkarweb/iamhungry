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
public class Sandwich implements Food {
    private String size;
    private String breadType;
    private boolean cheeseType;
    private boolean hasVegPattie;
    private boolean hasExtraSause;
    private boolean hasComboDeal;
    private String veggies;

    public Sandwich(String size, String breadType, boolean cheeseType, boolean hasVegPattie, boolean hasExtraSause, boolean hasComboDeal, String veggies) {
        this.size = size;
        this.breadType = breadType;
        this.cheeseType = cheeseType;
        this.hasVegPattie = hasVegPattie;
        this.hasExtraSause = hasExtraSause;
        this.hasComboDeal = hasComboDeal;
        this.veggies = veggies;
    }

    public Sandwich(String size, boolean hasVegPattie, boolean hasComboDeal) {
        this.size = size;
        this.hasVegPattie = hasVegPattie;
        this.hasComboDeal = hasComboDeal;
    }

    public String getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }

    public boolean getCheeseType() {
        return cheeseType;
    }

    public boolean isHasVegPattie() {
        return hasVegPattie;
    }

    public boolean isHasExtraSause() {
        return hasExtraSause;
    }

    public boolean isHasComboDeal() {
        return hasComboDeal;
    }

    public String getVeggies() {
        return veggies;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public void setCheeseType(boolean cheeseType) {
        this.cheeseType = cheeseType;
    }

    public void setHasVegPattie(boolean hasVegPattie) {
        this.hasVegPattie = hasVegPattie;
    }

    public void setHasExtraSause(boolean hasExtraSause) {
        this.hasExtraSause = hasExtraSause;
    }

    public void setHasComboDeal(boolean hasComboDeal) {
        this.hasComboDeal = hasComboDeal;
    }

    public void setVeggies(String veggies) {
        this.veggies = veggies;
    }
    
   
    
    @Override
    public double getSubtotal(){
        double price = -1;
        if(size.equals("6inch"))
            price = 3.80;
        if(size.equals("Foot-Long"))
            price = 7.60;
        if(hasVegPattie)
            price += 2;
        if(hasComboDeal)
            price += 5;
        
        return price;
    }
    



    
//    @Override
//    public String toString() {
//        String br = System.getProperty("line.separator");
//        String sp = "    ";
//        return "Sandwich" + "        $" + this.getSubtotal() + br 
//                +sp+ "size:" + size + br
//                +sp+ "bread:" + breadType + br
//                +sp+ "cheese:" + cheeseType + br
//                +sp+ "hasVegPattie:" + hasVegPattie + br
//                +sp+ "hasExtraSause:" + hasExtraSause + br
//                +sp+ "hasComboDeal:" + hasComboDeal + br 
//                +sp+ "veggies:" + veggies + br;
//    }
    
    @Override
    public String toString() {
        String br = System.getProperty("line.separator");
        String sp = "  ";
        String sp4 = sp+sp+sp+sp;
        return "Sandwich" + sp4+sp4+sp+"$" + this.getSubtotal() + br 
                +sp+ ">" + size + br
                +sp+ ">" + breadType +" Bread"+ br
                +((cheeseType)? sp + ">Cheese Crust" + br:"") 
                +((hasVegPattie)? sp + ">Veg Pattie" + br:"") 
                +((hasExtraSause)? sp + ">Extra Sauce" + br:"") 
                +((hasComboDeal)? sp + ">Combo Deal*" + br:"") 
                +((!veggies.equals("none"))? sp + ">"+veggies +br:"");
    }
    
    
}
