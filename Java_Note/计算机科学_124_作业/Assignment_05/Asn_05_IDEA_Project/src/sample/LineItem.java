package sample;
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



    public Pizza getPizza(){
        return thePizza;
    } //end method



    public int getNumber(){
        return quantity;
    } //end method



    public void setNumber(int newQuantity){
        //check if the new param is illegal
        if (newQuantity > 100 || newQuantity<=0){
            throw new IllegalPizza("Invalid order number");
        } else {
            quantity = newQuantity;
        }
    } //end method



    public String toString(){
        String lineString;
        if (quantity >= 10){
            lineString = quantity + " " + thePizza.toString();
        } else {
            lineString = " " + quantity + " " + thePizza.toString();
        }

        return lineString;
    } //end method



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
