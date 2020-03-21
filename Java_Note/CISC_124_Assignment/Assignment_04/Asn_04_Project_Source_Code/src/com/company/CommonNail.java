package com.company;

import java.io.Serializable;

public class CommonNail extends Fastener implements Serializable {


    public CommonNail(NailDesigns.CommonNailSizes sizes, NailDesigns.CommonNailLengths lengths, NailDesigns.CommonNailGauges gauges, Finishes.CommonNailFinish finish, double price, int number) {
        super(sizes, lengths, gauges, finish, price, number);
    }
}

