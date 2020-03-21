package com.company;

import java.io.Serializable;

// Supplied for your use in Assignment 4.

public final class ScrewDesigns implements Serializable {

	private static final long serialVersionUID = 1717801317815796211L;

	public enum ScrewDrive {Six_Lobe, Philips, Slotted, Square};

	public enum ScrewHeads {Bugle, Flat, Oval, Pan, Round};
	
	public enum WoodScrewPoints {Double_Cut, Sharp, Type_17};

}