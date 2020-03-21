package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Fastener implements Serializable {
    private Threads threads;
    private Materials.ThreadedMaterials Nmaterials;
    private Finishes.WingNutFinish Nfinish;
    private double Clength;
    private Threads Cthreads;
    private Materials.ThreadedMaterials Cmaterials;
    private Finishes.BoltFinish Cfinish;
    private double Slength;
    private Threads Sthreads;
    private Materials.ThreadedMaterials Smaterials;
    private Finishes.ScrewFinish Sfinish;
    private ScrewDesigns.ScrewHeads Sheads;
    private ScrewDesigns.ScrewDrive Sdrive;
    private ScrewDesigns.WoodScrewPoints Spoints;
    private NailDesigns.CommonNailSizes Nizes;
    private NailDesigns.CommonNailLengths Nlengths;
    private NailDesigns.CommonNailGauges Ngauges;
    private Finishes.CommonNailFinish Nfinishs;
    private double price;
    private int number;

    // WingNuts
    public Fastener(Threads threads, Materials.ThreadedMaterials materials, Finishes.WingNutFinish finish, double price, int number) {
        this.threads = threads;
        if (materials == Materials.ThreadedMaterials.Brass || materials == Materials.ThreadedMaterials.Stainless_Steel){
            if (finish != Finishes.WingNutFinish.Plain){
                throw new IllegalFastener("Illegal Material and finish combination");
            }
        } else {
            this.Nmaterials = materials;
            this.Nfinish = finish;
        }
        if (price > 0){
            this.price = price;
        } else {
            throw new IllegalFastener("illegal price");
        }

        if (number > 0 && number < 10001) {
            this.number = number;
        } else {
            throw new IllegalFastener("Illegal number per unit");
        }
    }
    // CommonNail
    public Fastener (NailDesigns.CommonNailSizes sizes, NailDesigns.CommonNailLengths lengths, NailDesigns.CommonNailGauges gauges, Finishes.CommonNailFinish finish, double price, int number) {
        //this(sizes, lengths, gauges, finish, price, number);
        this.Nizes = sizes;
        this.Nlengths = lengths;
        this.Ngauges = gauges;
        this.Nfinishs = finish;

        if (price > 0){
            this.price = price;
        } else {
            throw new IllegalFastener("illegal price");
        }

        if (number > 0 && number < 10001) {
            this.number = number;
        } else {
            throw new IllegalFastener("Illegal number per unit");
        }
    }
    // WoodScrew
    public Fastener (double length, Threads threads, Materials.ThreadedMaterials materials, Finishes.ScrewFinish finish, ScrewDesigns.ScrewHeads heads, ScrewDesigns.ScrewDrive drive, ScrewDesigns.WoodScrewPoints points, double price, int number) {
        this.Sthreads = threads;
        if (length >= 0.5 && length <=6 && length % 0.25 == 0){
            this.Slength = length;
        } else if (length >= 6 && length <=11 && length % 0.5 == 0){
            this.Slength = length;
        } else if (length >= 11 && length <= 20 && length % 1 == 0){
            this.Slength = length;
        } else {
            throw new IllegalFastener("Illegal Size");
        }
        if (materials == Materials.ThreadedMaterials.Brass || materials == Materials.ThreadedMaterials.Stainless_Steel){
            if (finish != Finishes.ScrewFinish.Plain){
                throw new IllegalFastener("Illegal Material and finish combination");
            }
        } else {
            this.Smaterials = materials;
            this.Sfinish = finish;
        }
        this.Sheads = heads;
        this.Sdrive = drive;
        this.Spoints = points;
        if (price > 0){
            this.price = price;
        } else {
            throw new IllegalFastener("illegal price");
        }

        if (number > 0 && number < 10001) {
            this.number = number;
        } else {
            throw new IllegalFastener("Illegal number per unit");
        }
    }
    // CarriageBold
    public Fastener (double length, Threads threads, Materials.ThreadedMaterials materials, Finishes.BoltFinish finish, double price, int number) {
        this.threads = threads;
        if (length >= 0.5 && length <=6 && length % 0.25 == 0){
            this.Clength = length;
        } else if (length >= 6 && length <=11 && length % 0.5 == 0){
            this.Clength = length;
        } else if (length >= 11 && length <= 20 && length % 1 == 0){
            this.Clength = length;
        } else {
            throw new IllegalFastener("Illegal Size");
        }
        if (materials == Materials.ThreadedMaterials.Brass || materials == Materials.ThreadedMaterials.Stainless_Steel){
            if (finish != Finishes.BoltFinish.Plain){
                throw new IllegalFastener("Illegal Material and finish combination");
            }
        } else {
            this.Cmaterials = materials;
            this.Cfinish = finish;
        }

        if (price > 0){
            this.price = price;
        } else {
            throw new IllegalFastener("illegal price");
        }

        if (number > 0 && number < 10001) {
            this.number = number;
        } else {
            throw new IllegalFastener("Illegal number per unit");
        }
    }

    public double getOrderCost(int orderSize) {
        double t_price = price * orderSize;
        return t_price;
    }

}
