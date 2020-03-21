package com.company;

public class Nail extends Fastener {
    public Nail(NailDesigns.CommonNailSizes sizes, NailDesigns.CommonNailLengths lengths, NailDesigns.CommonNailGauges gauges, Finishes.CommonNailFinish finish, double price, int number) {
        super(sizes, lengths, gauges, finish, price, number);
    }
}
