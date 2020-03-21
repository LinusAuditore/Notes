package com.company;

import java.io.Serializable;

public class CarriageBolt extends Fastener implements Serializable {

    public CarriageBolt(double length, Threads threads, Materials.ThreadedMaterials materials, Finishes.BoltFinish finish, double price, int number) {
        super(length, threads, materials, finish, price, number);
    }
}
