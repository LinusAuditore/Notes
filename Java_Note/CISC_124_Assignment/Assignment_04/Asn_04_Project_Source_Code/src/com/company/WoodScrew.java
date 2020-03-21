package com.company;

import java.io.Serializable;

public class WoodScrew extends Fastener implements Serializable{
    private double length;
    private Threads threads;
    private Materials.ThreadedMaterials materials;
    private Finishes.ScrewFinish finish;
    private ScrewDesigns.ScrewHeads heads;
    private ScrewDesigns.ScrewDrive drive;
    private ScrewDesigns.WoodScrewPoints points;
    private double price;
    private int number;
    public WoodScrew(double length, Threads threads, Materials.ThreadedMaterials materials, Finishes.ScrewFinish finish, ScrewDesigns.ScrewHeads heads, ScrewDesigns.ScrewDrive drive, ScrewDesigns.WoodScrewPoints points, double price, int number) {
        super(length, threads, materials, finish, heads, drive, points, price, number);
        this.length = length;
        this.threads = threads;
        this.materials = materials;
        this.finish = finish;
        this.heads = heads;
        this.drive = drive;
        this.points = points;
        this.price = price;
        this.number = number;
    }

    public String toString() {
        String info = "Wood Screw, ";
        if (points == ScrewDesigns.WoodScrewPoints.Sharp){
            info += "Sharp point, ";
        } else if (points == ScrewDesigns.WoodScrewPoints.Type_17){
            info += "Type_17 point, ";
        } else if (points == ScrewDesigns.WoodScrewPoints.Double_Cut){
            info += "Double_Cut point, ";
        }
        if (heads == ScrewDesigns.ScrewHeads.Flat){
            info += "Flat head, ";
        } else if (heads == ScrewDesigns.ScrewHeads.Bugle){
            info += "Bugle head, ";
        } else if (heads == ScrewDesigns.ScrewHeads.Oval){
            info += "Oval head, ";
        } else if (heads == ScrewDesigns.ScrewHeads.Pan){
            info += "Pan head, ";
        } else if (heads == ScrewDesigns.ScrewHeads.Round){
            info += "Round head, ";
        }
        if (drive == ScrewDesigns.ScrewDrive.Six_Lobe){
            info += "Six_Lobe drive, ";
        } else if (drive == ScrewDesigns.ScrewDrive.Philips){
            info += "Philips drive, ";
        } else if (drive == ScrewDesigns.ScrewDrive.Slotted){
            info += "Slotted drive, ";
        } else if (drive == ScrewDesigns.ScrewDrive.Square){
            info += "Square drive, ";
        }
        info += length;
        info += "\" long, ";
        info = info + (threads.toString() + " thread, ");
        if (materials == Materials.ThreadedMaterials.Brass){
            info += "Brass, with a ";
        } else if (materials == Materials.ThreadedMaterials.Stainless_Steel){
            info += "Stainless_Steel, with a ";
        } else if (materials == Materials.ThreadedMaterials.Steel){
            info += "Steel, with a ";
        }
        if (finish == Finishes.ScrewFinish.Chrome){
            info += "Chrome finish. ";
        } else if (finish == Finishes.ScrewFinish.Hot_Dipped){
            info += "Hot_Dipped finish. ";
        }else if (finish == Finishes.ScrewFinish.Galvanized) {
            info += "Galvanized finish. ";
        }else if (finish == Finishes.ScrewFinish.Yellow_Zinc){
            info += "Yellow_Zinc finish. ";
        } else if (finish == Finishes.ScrewFinish.Plain){
            info += "Plain finish. ";
        } else if (finish == Finishes.ScrewFinish.Zinc){
            info += "Zinc finish. ";
        } else if (finish == Finishes.ScrewFinish.ACQ_1000_Hour){
            info += "ACQ_1000_Hour finish. ";
        }
        info += number;
        info += " in a unit, $";
        info += price;
        info += " per unit.";
        return info;
    }
}

