package com.company;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

class PizzaTest {

    // Some legal argument tests:
    // Default constructor.
    // Also tests for toString and getCost.
    @Test
    public void testPizza() throws Exception {
        Pizza pizza1 = new Pizza();
        assertEquals("Small pizza, Single cheese, ham. Cost: $8.50 each.", pizza1.toString());
        assertEquals(8.50, pizza1.getCost(), 0.01);
    }

    // Five parameter constructor
    @Test
    public void testPizza1() throws Exception {
        Pizza pizza1 = new Pizza("Small", "Single", "None", "None", "None");
        assertEquals("Small pizza, Single cheese. Cost: $7.00 each.", pizza1.toString());
        assertEquals(7.00, pizza1.getCost(), 0.01);
    }
    @Test
    public void testPizza2() throws Exception {
        Pizza pizza1 = new Pizza("Medium", "Triple", "None", "None", "None");
        assertEquals("Medium pizza, Triple cheese. Cost: $12.00 each.", pizza1.toString());
        assertEquals(12.00, pizza1.getCost(), 0.01);
    }

    // Six parameter constructor
    @Test
    public void testPizza3() throws Exception {
        Pizza pizza1 = new Pizza("Large", false, "Double", "Single", "Single", "Single");
        assertEquals("Large pizza, Double cheese, pineapple, green pepper, ham. Cost: $17.00 each.", pizza1.toString());
        assertEquals(17.00, pizza1.getCost(), 0.01);
    }
    @Test
    public void testPizza4() throws Exception {
        Pizza pizza1 = new Pizza("Large", true, "Single", "Single", "None", "None");
        assertEquals("Large vegetarian pizza, Single cheese, pineapple. Cost: $12.50 each.", pizza1.toString());
        assertEquals(12.50, pizza1.getCost(), 0.01);
    }

    // Some illegal argument tests
    // Five parameter constructor
    @Test
    public void testPizza5() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza("bork", "Single", "Single", "Single", "Single"));
    }
    @Test
    public void testPizza6() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza("", "Single", "Single", "Single", "Single"));
    }
    @Test
    public void testPizza7() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza(null, "Single", "Single", "Single", "Single"));
    }
    @Test
    public void testPizza8() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza("Small", "bork", "Single", "Single", "Single"));
    }
    @Test
    public void testPizza9() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza("Small", "", "Single", "Single", "Single"));
    }
    @Test
    public void testPizza10() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza("Small", null, "Single", "Single", "Single"));
    }
    @Test
    public void testPizza11() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza("Small", "Single", "bork", "Single", "Single"));
    }
    @Test
    public void testPizza12() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza("Small", "Single", "", "Single", "Single"));
    }
    @Test
    public void testPizza13() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza("Small", "Single", null, "Single", "Single"));
    }
    @Test
    public void testPizza14() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza("Small", "Single", "Single", "bork", "Single"));
    }
    @Test
    public void testPizza15() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza("Small", "Single", "Single", "", "Single"));
    }
    @Test
    public void testPizza16() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza("Small", "Single", "Single", null, "Single"));
    }
    @Test
    public void testPizza17() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza("Small", "Single", "Single", "Single", "bork"));
    }
    @Test
    public void testPizza18() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza("Small", "Single", "Single", "Single", ""));
    }
    @Test
    public void testPizza19() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza("Small", "Single", "Single", "Single", null));
    }

    // Cannot have ham on a vegetarian
    @Test
    public void testPizza20() throws Exception {
        assertThrows(IllegalPizza.class, () -> new Pizza("Small", true, "Single", "Single", "None", "Single"));
    }

    @Test
    public void testEqualsObject() throws Exception {
        Pizza pizza1 = new Pizza("Large", "Single", "Single", "Single", "Single");
        Pizza pizza2 = new Pizza("Large", "Single", "Single", "Single", "Single");
        Pizza pizza3 = new Pizza("Medium", "Single", "Single", "Single", "Single");
        Pizza pizza4 = new Pizza("Large", "Double", "Single", "Single", "Single");
        Pizza pizza5 = new Pizza("Large", "Single", "None", "None", "Single");
        assertEquals(pizza1, pizza2);
        assertTrue(pizza1.equals(pizza2));
        assertFalse(pizza1.equals(pizza3));
        assertFalse(pizza1.equals(pizza4));
        assertFalse(pizza1.equals(pizza5));
        assertFalse(pizza1.equals("Hi! I am not a pizza! I am a string!"));
    }

    @Test
    public void testClone() throws Exception {
        Pizza pizza1 = new Pizza("Large", "Single", "Single", "Single", "Single");
        Pizza pizza2 = pizza1.clone();
        assertEquals(pizza1, pizza2);
    }

    @Test
    public void testFileSave() throws Exception {
        String testFile = "OnePizza.dat";
        Pizza pizza1 = new Pizza("Large", "Triple", "Single", "Single", "Single");
        Pizza pizza2;
        try (ObjectOutputStream binFileOut = new ObjectOutputStream(new FileOutputStream(testFile))) {
            binFileOut.writeObject(pizza1);
        }
        try (ObjectInputStream binFileIn = new ObjectInputStream(new FileInputStream(testFile))) {
            pizza2 = (Pizza)binFileIn.readObject();
        }
        assertEquals(pizza1, pizza2, "Comparing object from file to object saved.");
    }

} // end PizzaTest