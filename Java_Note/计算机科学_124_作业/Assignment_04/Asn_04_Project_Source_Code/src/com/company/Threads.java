package com.company;

import java.io.Serializable;

// Supplied for your use in Assignment 4.

public final class Threads implements Serializable {

	private static final long serialVersionUID = -4262717086849844940L;
	private String thread;
	
	private Threads(String thread) {this.thread = thread; }
	
	public static final Threads T8_13 = new Threads("#8-13");
	public static final Threads T8_15 = new Threads("#8-15"); 
	public static final Threads T8_32 = new Threads ("#8-32"); 
	public static final Threads T10_13 = new Threads("#10-13"); 
	public static final Threads T10_24 = new Threads("#10-24"); 
	public static final Threads T10_32 = new Threads("#10-32"); 
	public static final Threads T1_4_20 = new Threads("1/4-20"); 
	public static final Threads T5_16_18 = new Threads("5/16-18"); 
	public static final Threads T3_8_16 = new Threads("3/8-16"); 
	public static final Threads T7_16_14 = new Threads("7/16-14");
	public static final Threads T1_2_13 = new Threads("1/2-13"); 
	public static final Threads T5_8_11 = new Threads("5/8-11"); 
	public static final Threads T3_4_10 = new Threads("3/4-10");

	public String toString() { return thread; }
}