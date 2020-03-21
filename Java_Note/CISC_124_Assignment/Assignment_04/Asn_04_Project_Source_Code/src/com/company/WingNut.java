package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class WingNut extends Fastener implements Serializable{

    public WingNut(Threads threads, Materials.ThreadedMaterials materials, Finishes.WingNutFinish finish, double price, int number) {
        super(threads, materials, finish, price, number);
    }
}
