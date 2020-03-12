import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestHierarchy {

	public static ArrayList<Fastener> db;
	
	@BeforeAll
	public static void oneTimeSetUp() throws Exception {
		db = new ArrayList<>();
	}

	// Legal instances
	@Test
	public void test0() throws Exception {
										// size, length, gauge, finish, price/unit, unit size
		CommonNail toAdd = new CommonNail(NailDesigns.CommonNailSizes.S16D, NailDesigns.CommonNailLengths.L3_5,
				NailDesigns.CommonNailGauges.G8, Finishes.CommonNailFinish.Bright, 174.29, 2450);
		assertNotNull(toAdd);
		db.add(toAdd);
	}
	@Test
	public void test1() throws Exception {
										// size, length, gauge, finish, price/unit, unit size
		CommonNail toAdd = new CommonNail(NailDesigns.CommonNailSizes.S10D, NailDesigns.CommonNailLengths.L3,
				NailDesigns.CommonNailGauges.G9, Finishes.CommonNailFinish.Bright, 21.69, 345);
		assertNotNull(toAdd);
		db.add(toAdd);
	}
	@Test
	public void test2() throws Exception {
										// size, length, gauge, finish, price/unit, unit size
		CommonNail toAdd = new CommonNail(NailDesigns.CommonNailSizes.S60D , NailDesigns.CommonNailLengths.L6,
				NailDesigns.CommonNailGauges.G2, Finishes.CommonNailFinish.Bright, 153.29, 550);
		assertNotNull(toAdd);
		db.add(toAdd);
	}
	@Test
	public void test3() throws Exception {
									// thread,  material, finish, price/unit, unit size
		WingNut toAdd = new WingNut(Threads.T1_4_20, Materials.ThreadedMaterials.Stainless_Steel,
				Finishes.WingNutFinish.Plain, 0.5528, 1);
		assertNotNull(toAdd);
		db.add(toAdd);
	}
	@Test
	public void test4() throws Exception {
									// thread,  material, finish, price/unit, unit size
		WingNut toAdd = new WingNut(Threads.T5_16_18, Materials.ThreadedMaterials.Steel,
				Finishes.WingNutFinish.Zinc, 0.5528, 1);
		assertNotNull(toAdd);
		db.add(toAdd);
	}
	@Test
	public void test5() throws Exception {
											// length, thread,  material, finish, price/unit, unit size
		CarriageBolt toAdd = new CarriageBolt(1.0, Threads.T3_8_16, Materials.ThreadedMaterials.Steel,
				Finishes.BoltFinish.Zinc, 0.2985, 1);
		assertNotNull(toAdd);
		db.add(toAdd);
	}
	@Test
	public void test6() throws Exception {
											// length, thread,  material, finish, price/unit, unit size
		CarriageBolt toAdd = new CarriageBolt(0.75, Threads.T1_4_20, Materials.ThreadedMaterials.Stainless_Steel,
				Finishes.BoltFinish.Plain, 0.2985, 1);
		assertNotNull(toAdd);
		db.add(toAdd);
	}
	@Test
	public void test7() throws Exception {
											// length, thread,  material, finish, price/unit, unit size
		CarriageBolt toAdd = new CarriageBolt(12.0, Threads.T1_2_13, Materials.ThreadedMaterials.Steel,
				Finishes.BoltFinish.Hot_Dipped_Galvanized, 0.2985, 1);
		assertNotNull(toAdd);
		db.add(toAdd);
	}
	@Test
	public void test8() throws Exception {
									// length, thread,  material, finish, head, drive, point, price/unit, unit size
		WoodScrew toAdd = new WoodScrew(2.0, Threads.T8_13, Materials.ThreadedMaterials.Steel, 
				Finishes.ScrewFinish.ACQ_1000_Hour, ScrewDesigns.ScrewHeads.Flat, ScrewDesigns.ScrewDrive.Philips,
				ScrewDesigns.WoodScrewPoints.Type_17, 44.10, 750);
		assertNotNull(toAdd);
		db.add(toAdd);
	}
	@Test
	public void test9() throws Exception {
									// length, thread,  material, finish, head, drive, point, price/unit, unit size
		WoodScrew toAdd = new WoodScrew(0.75, Threads.T8_15, Materials.ThreadedMaterials.Steel, 
				Finishes.ScrewFinish.Zinc, ScrewDesigns.ScrewHeads.Flat, ScrewDesigns.ScrewDrive.Square,
				ScrewDesigns.WoodScrewPoints.Sharp, 44.10, 750);
		assertNotNull(toAdd);
		db.add(toAdd);
	}
	@Test
	public void test10() throws Exception {
									// length, thread,  material, finish, head, drive, point, price/unit, unit size
		WoodScrew toAdd = new WoodScrew(3.0, Threads.T10_13, Materials.ThreadedMaterials.Steel, 
				Finishes.ScrewFinish.Zinc, ScrewDesigns.ScrewHeads.Flat, ScrewDesigns.ScrewDrive.Square,
				ScrewDesigns.WoodScrewPoints.Sharp, 44.10, 750);
		assertNotNull(toAdd);
		db.add(toAdd);
	}

	// Illegal instances
	@Test
	public void test11() throws Exception {
		// Unit price less than zero
		assertThrows(IllegalFastener.class, () -> new CommonNail(NailDesigns.CommonNailSizes.S10D, NailDesigns.CommonNailLengths.L3_5,
				NailDesigns.CommonNailGauges.G8, Finishes.CommonNailFinish.Bright, -174.29, 2450));
	}
	@Test
	public void test12() throws Exception {
		// Num per unit less than zero
		assertThrows(IllegalFastener.class, () -> new CommonNail(NailDesigns.CommonNailSizes.S10D, NailDesigns.CommonNailLengths.L3_5,
				NailDesigns.CommonNailGauges.G8, Finishes.CommonNailFinish.Bright, 174.29, -2450));
	}
	@Test
	public void test13() throws Exception {
		// Num per too high
		assertThrows(IllegalFastener.class, () -> new CommonNail(NailDesigns.CommonNailSizes.S10D, NailDesigns.CommonNailLengths.L3_5,
				NailDesigns.CommonNailGauges.G8, Finishes.CommonNailFinish.Bright, 174.29, 20450));
	}
	@Test
	public void test14() throws Exception {
		// Illegal length
		assertThrows(IllegalFastener.class, () -> new CarriageBolt(12.5, Threads.T1_2_13, Materials.ThreadedMaterials.Steel,
				Finishes.BoltFinish.Hot_Dipped_Galvanized, 0.2985, 1));
	}
	@Test
	public void test15() throws Exception {
		// Illegal length
		assertThrows(IllegalFastener.class, () -> new CarriageBolt(6.25, Threads.T1_2_13, Materials.ThreadedMaterials.Steel,
				Finishes.BoltFinish.Hot_Dipped_Galvanized, 0.2985, 1));
	}
	@Test
	public void test16() throws Exception {
		// Illegal length
		assertThrows(IllegalFastener.class, () -> new CarriageBolt(-6.0, Threads.T1_2_13, Materials.ThreadedMaterials.Steel,
				Finishes.BoltFinish.Hot_Dipped_Galvanized, 0.2985, 1));
	}
	@Test
	public void test17() throws Exception {
		// Illegal length
		assertThrows(IllegalFastener.class, () -> new CarriageBolt(25.0, Threads.T1_2_13, Materials.ThreadedMaterials.Steel,
				Finishes.BoltFinish.Hot_Dipped_Galvanized, 0.2985, 1));
	}
	@Test
	public void test18() throws Exception {
		// Illegal finish/material combination
		assertThrows(IllegalFastener.class, () -> new WingNut(Threads.T1_4_20, Materials.ThreadedMaterials.Stainless_Steel,
				Finishes.WingNutFinish.Zinc, 0.5528, 1));
	}
	@Test
	public void test19() throws Exception {
		// Illegal finish/material combination
		assertThrows(IllegalFastener.class, () -> new WingNut(Threads.T1_4_20, Materials.ThreadedMaterials.Brass,
				Finishes.WingNutFinish.Yellow_Zinc, 0.5528, 1));
	}
	@Test
	public void test20() throws Exception {
		// Illegal finish/material combination
		assertThrows(IllegalFastener.class, () -> new WoodScrew(3.0, Threads.T10_13, Materials.ThreadedMaterials.Brass, 
				Finishes.ScrewFinish.Zinc, ScrewDesigns.ScrewHeads.Flat, ScrewDesigns.ScrewDrive.Square,
				ScrewDesigns.WoodScrewPoints.Sharp, 44.10, 750));
	}
	@Test
	public void test21() throws Exception {
		// Illegal finish/material combination
		assertThrows(IllegalFastener.class, () -> new WoodScrew(3.0, Threads.T10_13, Materials.ThreadedMaterials.Stainless_Steel, 
				Finishes.ScrewFinish.Chrome, ScrewDesigns.ScrewHeads.Flat, ScrewDesigns.ScrewDrive.Square,
				ScrewDesigns.WoodScrewPoints.Sharp, 44.10, 750));
	}

	// This method will save the collection of legal Fastener objects to be used
	// by the FastenerOrderSystem class.
	@AfterAll
	public static void oneTimeTearDownAfterClass() throws Exception {
		String dbFile = "Database.dat";
		File dbFileObject = new File(dbFile);
		if (dbFileObject.exists())
			dbFileObject.delete();
		db.trimToSize();
		// Using a lambda function here:
		db.sort((Fastener f1, Fastener f2) -> f1.toString().compareToIgnoreCase(f2.toString()));
		for (Fastener item : db)
			System.out.println(item);
		// Save the ArrayList so it can be used by the order system class.
    	try (ObjectOutputStream binFileOut = new ObjectOutputStream(new FileOutputStream(dbFile))) {
            binFileOut.writeObject(db);
        }
	} // end oneTimeTearDownAfterClass method

}