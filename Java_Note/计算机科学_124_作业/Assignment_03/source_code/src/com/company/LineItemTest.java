package com.company;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LineItemTest {

    public Pizza pizza1;

    @BeforeEach
    public void setUp() throws Exception {
        pizza1 = new Pizza("Medium", "Single", "Single", "Single", "Single");
    }

    // Test with legal arguments.
    // Also testing all accessors and toString.
    // One parameter constructor.
    @Test
    public void testLineItemPizza() throws Exception {
        LineItem line1 = new LineItem(pizza1);
        assertEquals(pizza1, line1.getPizza());
        assertEquals(1, line1.getNumber());
        assertEquals(13.50, line1.getCost(), 0.01);
        assertEquals(" 1 " + pizza1.toString(), line1.toString());
    }

    // Two parameter constructor.
    @Test
    public void testLineItemIntPizza() throws Exception {
        LineItem line1 = new LineItem(1, pizza1);
        assertEquals(pizza1, line1.getPizza());
        assertEquals(1, line1.getNumber());
        assertEquals(13.50, line1.getCost(), 0.01);
        assertEquals(" 1 " + pizza1.toString(), line1.toString());
    }
    @Test
    public void testLineItemIntPizza1() throws Exception {
        LineItem line1 = new LineItem(100, pizza1);
        assertEquals(pizza1, line1.getPizza());
        assertEquals(100, line1.getNumber());
        assertEquals(0.85 * 13.50 * 100, line1.getCost(), 0.01);
        assertEquals("100 " + pizza1.toString(), line1.toString());
    }
    @Test
    public void testLineItemIntPizza2() throws Exception {
        LineItem line1 = new LineItem(10, pizza1);
        assertEquals(pizza1, line1.getPizza());
        assertEquals(10, line1.getNumber());
        assertEquals(0.9 * 13.50 * 10, line1.getCost(), 0.01);
        assertEquals("10 " + pizza1.toString(), line1.toString());
    }
    @Test
    public void testLineItemIntPizza3() throws Exception {
        LineItem line1 = new LineItem(50, pizza1);
        assertEquals(pizza1, line1.getPizza());
        assertEquals(50, line1.getNumber());
        assertEquals(0.85 * 13.50 * 50, line1.getCost(), 0.01);
        assertEquals("50 " + pizza1.toString(), line1.toString());
    }

    // Test with illegal arguments.
    // One parameter constructor.
    @Test
    public void testLineItemPizza1() throws Exception {
        assertThrows(IllegalPizza.class, () -> new LineItem(null));
    }

    // Two parameter constructor.
    @Test
    public void testLineItemIntPizza4() throws Exception {
        assertThrows(IllegalPizza.class, () -> new LineItem(-1, pizza1));
    }
    @Test
    public void testLineItemIntPizza5() throws Exception {
        assertThrows(IllegalPizza.class, () -> new LineItem(0, pizza1));
    }
    @Test
    public void testLineItemIntPizza6() throws Exception {
        assertThrows(IllegalPizza.class, () -> new LineItem(101, pizza1));
    }
    @Test
    public void testLineItemIntPizza7() throws Exception {
        assertThrows(IllegalPizza.class, () -> new LineItem(500, pizza1));
    }
    @Test
    public void testLineItemIntPizza8() throws Exception {
        assertThrows(IllegalPizza.class, () -> new LineItem(50, null));
    }

    // Legal arguments
    @Test
    public void testSetNumber() throws Exception {
        LineItem line1 = new LineItem(50, pizza1);
        line1.setNumber(1);
        assertEquals(1, line1.getNumber());
        line1.setNumber(100);
        assertEquals(100, line1.getNumber());
        line1.setNumber(50);
        assertEquals(50, line1.getNumber());
    }

    // Illegal arguments
    @Test
    public void testSetNumber1() throws Exception {
        LineItem line1 = new LineItem(50, pizza1);
        assertThrows(IllegalPizza.class, () -> line1.setNumber(-1));
        assertEquals(50, line1.getNumber());
    }
    @Test
    public void testSetNumber2() throws Exception {
        LineItem line1 = new LineItem(50, pizza1);
        assertThrows(IllegalPizza.class, () -> line1.setNumber(0));
        assertEquals(50, line1.getNumber());
    }
    @Test
    public void testSetNumber3() throws Exception {
        LineItem line1 = new LineItem(50, pizza1);
        assertThrows(IllegalPizza.class, () -> line1.setNumber(101));
        assertEquals(50, line1.getNumber());
    }
    @Test
    public void testSetNumber4() throws Exception {
        LineItem line1 = new LineItem(50, pizza1);
        assertThrows(IllegalPizza.class, () -> line1.setNumber(500));
        assertEquals(50, line1.getNumber());
    }

    @Test
    public void testCompareTo() throws Exception {
        LineItem same1 = new LineItem(1, new Pizza("Small", "Single", "None", "None", "Single")); // total cost $8.50
        LineItem same2 = new LineItem(1, new Pizza()); // total cost $8.50
        LineItem lower = new LineItem(2, new Pizza("Small", "Double", "None", "None", "None"));
        LineItem higher1 = new LineItem(2, new Pizza("Small", "Double", "None", "None", "Single"));
        LineItem higher2 = new LineItem(2, new Pizza("Medium", "Double", "None", "None", "Single"));
        LineItem highest = new LineItem(10, new Pizza("Small", "Double", "None", "None", "Single"));
        assertTrue(same1.compareTo(same1) == 0);
        assertTrue(same1.compareTo(same2) == 0, "Cost difference less than a dollar is considered equal.");
        assertTrue(same2.compareTo(same1) == 0, "Cost difference less than a dollar is considered equal.");
        assertTrue(higher1.compareTo(lower) < 0);
        assertTrue(lower.compareTo(higher1) > 0);
        assertTrue(higher2.compareTo(higher1) < 0);
        assertTrue(higher1.compareTo(higher2) > 0);
        assertTrue(highest.compareTo(higher2) < 0);
        assertTrue(higher2.compareTo(highest) > 0);
    }

    @Test
    public void testFileSave() throws Exception {
        String testFile = "OneItem.dat";
        LineItem line1 = new LineItem(pizza1);
        LineItem line2;
        try (ObjectOutputStream binFileOut = new ObjectOutputStream(new FileOutputStream(testFile))) {
            binFileOut.writeObject(line1);
        }
        try (ObjectInputStream binFileIn = new ObjectInputStream(new FileInputStream(testFile))) {
            line2 = (LineItem)binFileIn.readObject();
        }
        assertEquals(line1.toString(), line2.toString(), "Comparing object from file to object saved.");
    }

} // end LineItemTest