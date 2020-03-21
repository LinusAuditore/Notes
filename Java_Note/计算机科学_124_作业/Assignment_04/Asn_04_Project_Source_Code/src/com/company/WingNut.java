package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class WingNut extends Fastener implements Serializable{
    private Threads threads;
    private Materials.ThreadedMaterials materials;
    private Finishes.WingNutFinish finish;
    private double price;
    private int number;

    public WingNut(Threads threads, Materials.ThreadedMaterials materials, Finishes.WingNutFinish finish, double price, int number) {
        super(threads, materials, finish, price, number);
        this.threads = threads;
        this.materials = materials;
        this.finish = finish;
        this.price = price;
        this.number = number;
    }

    public String toString() {
        String info = "Wing Nut ";
        info += threads.toString() + " thread, ";
        if (materials == Materials.ThreadedMaterials.Brass){
            info += "Brass, with a ";
        } else if (materials == Materials.ThreadedMaterials.Stainless_Steel){
            info += "Stainless_Steel, with a ";
        } else if (materials == Materials.ThreadedMaterials.Steel){
            info += "Steel, with a ";
        }
        if (finish == Finishes.WingNutFinish.Chrome){
            info += "Chrome finish. ";
        } else if (finish == Finishes.WingNutFinish.Hot_Dipped_Galvanized){
            info += "Hot_Dipped_Galvanized finish. ";
        } else if (finish == Finishes.WingNutFinish.Yellow_Zinc){
            info += "Yellow_Zinc finish. ";
        } else if (finish == Finishes.WingNutFinish.Plain){
            info += "Plain finish. ";
        } else if (finish == Finishes.WingNutFinish.Zinc){
            info += "Zinc finish. ";
        }
        info += number;
        info += " in a unit, $";
        info += price;
        info += " per unit.";
        return info;
    }
}
