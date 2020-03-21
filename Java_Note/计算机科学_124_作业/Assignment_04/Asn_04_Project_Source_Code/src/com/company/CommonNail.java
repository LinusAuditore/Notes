package com.company;

import java.io.Serializable;

public class CommonNail extends Fastener implements Serializable {
    private NailDesigns.CommonNailSizes sizes;
    private NailDesigns.CommonNailLengths lengths;
    private NailDesigns.CommonNailGauges gauges;
    private Finishes.CommonNailFinish finish;
    private double price;
    private int number;

    public CommonNail(NailDesigns.CommonNailSizes sizes, NailDesigns.CommonNailLengths lengths, NailDesigns.CommonNailGauges gauges, Finishes.CommonNailFinish finish, double price, int number) {
        super(sizes, lengths, gauges, finish, price, number);
        this.sizes = sizes;
        this.lengths = lengths;
        this.gauges = gauges;
        this.finish = finish;
        this.price = price;
        this.number = number;
    }

    public String toString(){
        String info = "Common Nail, ";
        info += sizes.toString();
        info += "size, ";
        info += lengths.toString();
        info += "\" long, ";
        info += gauges.toString();
        info += " gauge, ";
        info += "Steel, with a ";
        if (finish == Finishes.CommonNailFinish.Bright){
            info += "Bright finish. ";
        } else if (finish == Finishes.CommonNailFinish.Hot_Dipped_Galvanized){
            info += "Hot_Dipped_Galvanized finish. ";
        }
        info += number;
        info += " in a unit, $";
        info += price;
        info += " per unit.";
        return info;
    }
}

