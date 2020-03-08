package com.company;

import java.io.Serializable;

/**
 * This class include a LineItem object and its accessors
 *
 * @author Xinghao Zuo
 */
public class LineItem implements Serializable, Comparable<LineItem>{
    // First, instantiate the attributes of the pizza
    private Pizza thePizza;
    private int quantity;

    /**
     * Object 1st constructor LineItem include two information of the line item
     * It is the quantity and the Pizza's attributes
     * @param quantity is the number of the order
     * @param thePizza include Pizza attribute information
     * @throws IllegalPizza when the illegal param exist
     * @return None
     */
    public LineItem(int quantity, Pizza thePizza){
        //check if the para is illegal
        if (quantity >= 1 && quantity <=100){
            this.quantity = quantity;
        } else {
            throw new IllegalPizza("Invalid order number");
        }

        if (thePizza != null){
            this.thePizza = thePizza;
        } else {
            throw new IllegalPizza("Invalid pizza option");
        }
    } //end method


    /**
     * Object 1st constructor LineItem include one information of the line item
     * It is the Pizza's attributes.
     * @param thePizza include Pizza attribute information
     * @return None
     * @throws IllegalPizza when the illegal param exist
     */
    public LineItem(Pizza thePizza){
        //default quantity is 1
        this.quantity = 1;
        //check if the para is illegal
        if (thePizza != null){
            this.thePizza = thePizza;
        } else {
            throw new IllegalPizza("Invalid pizza option");
        }
    } //end method


    /**
     * getCost method is used to calculate the cost of all the whole order
     * @param None
     * @return theCost the cost of the whole order
     */
    public double getCost(){
        //get the price of each pizza
        double theCost = thePizza.getCost();

        if (quantity >= 10 && quantity <= 20){
            theCost = theCost * quantity * 0.9; //if quantity between 10 and 20, 10% off
        } else if (quantity > 20){
            theCost = theCost * quantity * 0.85; //if quantity > 20, 15% off
        } else {
            theCost = theCost *quantity; //otherwise is the original price
        }
        return theCost;
    } //end method


    /**
     * getPizza method is used to return the pizza information of the order
     * @param None
     * @return thePizza the Pizza information of the order
     */
    public Pizza getPizza(){
        return thePizza;
    } //end method


    /**
     * getNumber method is used to return the quantity information of the order
     * @param None
     * @return quantity the quantity of the pizza of the whole order
     */
    public int getNumber(){
        return quantity;
    } //end method


    /**
     * setNumber method is used to change the number of the pizza in the order
     * @param newQuantity the new number that be applied to change
     * @return None
     * @throws IllegalPizza when the illegal param exist
     */
    public void setNumber(int newQuantity){
        //check if the new param is illegal
        if (newQuantity > 100 || newQuantity<=0){
            throw new IllegalPizza("Invalid order number");
        } else {
            quantity = newQuantity;
        }
    } //end method


    /**
     * toString method is used to return a String that contain all the information of the order
     * @param None
     * @return lineString include the information of order's quantity and pizza's attributes
     */
    public String toString(){
        String lineString;
        if (quantity >= 10){
            lineString = quantity + " " + thePizza.toString();
        } else {
            lineString = " " + quantity + " " + thePizza.toString();
        }

        return lineString;
    } //end method


    /**
     * compareTo is used to compare the price difference between two orders
     * if difference is less than 1 dollar, than return 0.
     * @param o the order that need to be compared
     * @return the_difference
     */
    @Override
    public int compareTo(LineItem o) {
        double thePrice = getCost();
        double the_difference;
        if (thePrice - o.getCost() < 1.00 && thePrice - o.getCost() > -1.00){
            return 0;
        } else{
            //System.out.println(o.getCost() - thePrice);
            the_difference = (o.getCost() - thePrice);
            return (int) the_difference;}
    }
}
