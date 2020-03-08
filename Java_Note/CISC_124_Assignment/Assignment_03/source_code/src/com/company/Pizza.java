package com.company;


import java.util.Objects;
import java.io.Serializable;

/**
 * this class include a Pizza object and all the other accessor that it will need
 * @author     Xinghao Zuo
 */
public class Pizza implements Cloneable, Serializable{
    // First, instantiate the attributes of the pizza
    public String size;
    public Boolean vege;
    public String cheese;
    public String pineapple;
    public String greenpepper;
    public String ham;


    /**
     * This is the 1st constructor
     * accept all 6 attributes of pizza as its param
     * @param size the size information of pizza
     * @param vege if the pizza is a vegetarian pizza
     * @param cheese the quantity of cheese on pizza
     * @param pineapple the quantity of the pineapple topping
     * @param greenpepper the quantity of the green pepper topping
     * @param ham the quantity of the ham topping
     * @throws IllegalPizza will be thrown when the illegal param exist.
     */
    public Pizza(String size, Boolean vege, String cheese, String pineapple, String greenpepper, String ham){
        // check if the params are illegal, if not put is into attributes, else throw exception
        if (cheese == null || pineapple == null || greenpepper == null || ham == null || size == null){
            throw new IllegalPizza("Invalid input");
        }

        if (size.equals("Small") || size.equals("Medium") || size.equals("Large")){
            this.size = size;
        } else{
            throw new IllegalPizza("Invalid pizza size.");
        }

        this.vege = vege;

        if (cheese.equals("Single") || cheese.equals("Double") || cheese.equals("Triple")){
            this.cheese = cheese;
        } else{
            throw new IllegalPizza("Invalid cheese option.");
        }

        if (pineapple.equals("Single") || pineapple.equals("None")){
            this.pineapple = pineapple;
        } else{
            throw new IllegalPizza("Invalid pineapple option.");
        }

        if (greenpepper.equals("Single") || greenpepper.equals("None")){
            this.greenpepper = greenpepper;
        } else{
            throw new IllegalPizza("Invalid green pepper option.");
        }

        if (ham.equals("None") && vege){
            this.ham = ham;
        } else if(ham.equals("Single") && !vege){
            this.ham = ham;
        } else{
            throw new IllegalPizza("Invalid ham option");
        }
    } //end constructor


    /**
     * This is the 2nd constructor
     * has 5 attributes of pizza as its param
     * the vegetarian attributes is false
     * @param size the size information of pizza
     * @param cheese if the pizza is a vegetarian pizza
     * @param pineapple the quantity of the pineapple topping
     * @param greenpepper the quantity of the green pepper topping
     * @param ham the quantity of the ham topping
     * @throws IllegalPizza will be thrown when the illegal param exist.
     */
    public Pizza(String size, String cheese, String pineapple, String greenpepper, String ham){
        // check if the params are illegal, if not put is into attributes, else throw exception
        if (cheese == null || pineapple == null || greenpepper == null || ham == null || size == null){
            throw new IllegalPizza("Invalid input");
        }

        if (size.equals("Small") || size.equals("Medium") || size.equals("Large")){
            this.size = size;
        } else{
            throw new IllegalPizza("Invalid pizza size.");
        }

        //the attributes vegetarian is set as false in this constructor
        this.vege = false;

        if (cheese.equals("Single") || cheese.equals("Double") || cheese.equals("Triple")){
            this.cheese = cheese;
        } else{
            throw new IllegalPizza("Invalid cheese option.");
        }

        if (pineapple.equals("Single") || pineapple.equals("None")){
            this.pineapple = pineapple;
        } else{
            throw new IllegalPizza("Invalid pineapple option.");
        }

        if (greenpepper.equals("Single") || greenpepper.equals("None")){
            this.greenpepper = greenpepper;
        } else{
            throw new IllegalPizza("Invalid green pepper option.");
        }

        if (ham.equals("None") || ham.equals("Single")){
            this.ham = ham;
        } else{
            throw new IllegalPizza("Invalid ham option");
        }
    } //end constructor


    /**
     * This is the 3rd constructor,
     * it has no param, it will create the default pizza.
     * @param None
     * @return None
     */
    public Pizza(){
        //create default pizza
        size = "Small";
        vege = false;
        cheese = "Single";
        ham = "Single";
        pineapple = "None";
        greenpepper = "None";
    } //end constructor


    /**
     * The method of calculating the price
     * A small cheese pizza with single cheese only is $7.00
     * a medium with cheese only is $9.00
     * a large with cheese only is $11.00
     * Each additional topping costs $1.50 each.
     * @return cost the price of the single pizza
     */
    public double getCost(){
        double cost = 0.00;
        // size judge
        if (size.equals("Small")){
            cost += 7.00;
        } else if (size.equals("Medium")){
            cost += 9.00;
        } else if (size.equals("Large")){
            cost += 11.00;
        }
        // cheese judge
        if (cheese.equals("Double")){
            cost += 1.50;
        } else if (cheese.equals("Triple")){
            cost += 3.00;
        }
        // pineapple judge
        if (pineapple.equals("Single")){
            cost += 1.50;
        }
        // green pepper judge
        if (greenpepper.equals("Single")){
            cost += 1.50;
        }
        // ham judge
        if (ham.equals("Single")){
            cost += 1.50;
        }
        return cost;
    } //end method getCost

    /**
     * The method of return information of pizza in String
     * the form is:
     * Medium vegetarian pizza, Double cheese. Cost: $10.50 each.
     * Small pizza, Single cheese, pineapple, green pepper, ham. Cost: $11.50 each.
     * Large pizza, Triple cheese, pineapple, ham. Cost: $17.00 each.
     * @param None
     * @return  the String form information of the pizza
     */
    public String toString(){
        double price = getCost();
        String description;
        description = size;

        //check attributes and put into the result
        if(vege){
            description += " vegetarian pizza";
        } else {
            description += " pizza";
        }

        //use switch here will be easier than use if
        switch (cheese) {
            case "Single":
                description += ", Single cheese";
                break;
            case "Double":
                description += ", Double cheese";
                break;
            case "Triple":
                description += ", Triple cheese";
                break;
        }

        if (pineapple.equals("Single")){
            description += ", pineapple";
        }

        if (greenpepper.equals("Single")){
            description += ", green pepper";
        }

        if (ham.equals("Single")){
            description += ", ham";
        }

        // add "." after included all the attributes
        description += ". ";
        String result_price = String.format("%.2f",price);
        description = description + "Cost: $" + result_price + " each.";
        return description;
    } //end method getString


    /**
     * rewrite the clone method in order to make the Object cloneable
     * @param None
     * @return piz the cloned object
     */
    @Override
    public Pizza clone(){
        Pizza piz = null;
        try{
            piz = (Pizza) super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return piz;
    }


    /**
     * rewrite the equals method in order to only compare the pizza attributes
     * @param o the pizza need to be compared
     * @return boolean if they are same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pizza)) return false;
        Pizza pizza = (Pizza) o;
        return size.equals(pizza.size) &&
                vege.equals(pizza.vege) &&
                cheese.equals(pizza.cheese) &&
                pineapple.equals(pizza.pineapple) &&
                greenpepper.equals(pizza.greenpepper) &&
                ham.equals(pizza.ham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, vege, cheese, pineapple, greenpepper, ham);
    }
}
