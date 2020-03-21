package com.company;

import java.io.Serializable;

public class CarriageBolt extends Fastener implements Serializable {
    private double length;
    private Threads threads;
    private Materials.ThreadedMaterials materials;
    private Finishes.BoltFinish finish;
    private double price;
    private int number;
    public CarriageBolt(double length, Threads threads, Materials.ThreadedMaterials materials, Finishes.BoltFinish finish, double price, int number) {
        super(length, threads, materials, finish, price, number);
        this.length = length;
        this.threads = threads;
        this.materials = materials;
        this.finish = finish;
        this.price = price;
        this.number = number;
    }
    public String toString(){
        String info = "Carriage Bolt ";
        info += length;
        info += "\" long, ";
        info += threads.toString();
        info += " thread, ";
        if (materials == Materials.ThreadedMaterials.Brass){
            info += "Brass, with a ";
        } else if (materials == Materials.ThreadedMaterials.Stainless_Steel){
            info += "Stainless_Steel, with a ";
        } else if (materials == Materials.ThreadedMaterials.Steel){
            info += "Steel, with a ";
        }
        if (finish == Finishes.BoltFinish.Chrome){
            info += "Chrome finish. ";
        } else if (finish == Finishes.BoltFinish.Hot_Dipped_Galvanized){
            info += "Hot_Dipped_Galvanized finish. ";
        } else if (finish == Finishes.BoltFinish.Yellow_Zinc){
            info += "Yellow_Zinc finish. ";
        } else if (finish == Finishes.BoltFinish.Plain){
            info += "Plain finish. ";
        } else if (finish == Finishes.BoltFinish.Zinc){
            info += "Zinc finish. ";
        }
        info += number;
        info += " in a unit, $";
        info += price;
        info += " per unit.";
        return info;
    };
}
