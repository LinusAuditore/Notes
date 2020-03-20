package com.company;

import java.io.Serializable;

// Supplied for your use in Assignment 4.

public final class Finishes implements Serializable {
    // Generate a new serialVersionUID after you have added the ScrewFinish Enum

	public enum BoltFinish {Chrome, Hot_Dipped_Galvanized, Plain, Yellow_Zinc, Zinc};

	public enum WingNutFinish {Chrome, Hot_Dipped_Galvanized, Plain, Yellow_Zinc, Zinc};
	
	public enum CommonNailFinish {Bright, Hot_Dipped_Galvanized};

	public enum ScrewFinish {Chrome, Hot_Dipped, Galvanized, Plain, Yellow_Zinc, Zinc};

	private static final long serialVersionUID = 3287198433875663480L;
}