package com.company;

public class Bolt extends Fastener {
    public Bolt(double length, Threads threads, Materials.ThreadedMaterials materials, Finishes.BoltFinish finish, double price, int number) {
        super(length, threads, materials, finish, price, number);
    }
}
