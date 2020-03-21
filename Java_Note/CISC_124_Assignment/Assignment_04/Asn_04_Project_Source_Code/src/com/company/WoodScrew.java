package com.company;

import java.io.Serializable;

public class WoodScrew extends Fastener implements Serializable{

    public WoodScrew(double length, Threads threads, Materials.ThreadedMaterials materials, Finishes.ScrewFinish finish, ScrewDesigns.ScrewHeads heads, ScrewDesigns.ScrewDrive drive, ScrewDesigns.WoodScrewPoints points, double price, int number) {
        super(length, threads, materials, finish, heads, drive, points, price, number);
    }
}

