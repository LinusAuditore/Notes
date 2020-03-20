package com.company;

import java.io.Serializable;

public class WingNut implements Serializable {
    private Threads threads;
    private Materials.ThreadedMaterials materials;
    private Finishes.WingNutFinish finish;
    private double v;
    int i;

    public WingNut(Threads threads, Materials.ThreadedMaterials materials, Finishes.WingNutFinish finish, double v, int i) {
        this.threads = threads;
        this.materials = materials;
        this.finish = finish;
        this.v = v;
        this.i = i;
    }

    public void
}
