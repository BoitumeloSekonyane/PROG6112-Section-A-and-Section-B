/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.neuvogreencyclingappst10472272;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
/**
 *
 * @author boitu
 */

public class RecyclingManagerTest {
    
    @Test
    void testPlasticItems() {
        RecyclingManager manager = new RecyclingManager();
        assertEquals("General Waste (Plastic Bag)", manager.categorizeItem("Plastic", "Plastic Bag"));
        assertEquals("Recycle Bin (Plastic Bottle)", manager.categorizeItem("Plastic", "Plastic Bottle"));
        assertEquals("General Waste (Plastic Utensils)", manager.categorizeItem("Plastic", "Plastic Utensils"));
        assertEquals("Check local recycling rules.", manager.categorizeItem("Plastic", "Other"));
    }
    
    @Test 
    void testBottleItems () {
        RecyclingManager manager = new RecyclingManager();
        assertEquals("Recycle Bin (Plastic Bottle)", manager.categorizeItem("Bottle", "Plastic Bottle"));
        assertEquals("Recycle Bin (Milk Carton)", manager.categorizeItem("Bottle", "Milk Carton"));
    }
    
    @Test
    void testGlassItems () {
        RecyclingManager manager = new RecyclingManager();
        assertEquals("Recycle Bin (Glass Window)", manager.categorizeItem("Glass", "Glass Window"));
        assertEquals("General Waste (Mirror)", manager.categorizeItem("Glass", "Mirror"));
        assertEquals("General Waste (Tableware)", manager.categorizeItem("Glass", "Tableware"));
        assertEquals("General Waste (Light Bulb)", manager.categorizeItem("Glass", "Light Bulb"));
    }
    
    @Test
    void testPeelItems () {
        RecyclingManager manager = new RecyclingManager ();
        assertEquals("Compost Bin (Banana Peel)", manager.categorizeItem("Peels", "Banana Peel"));
        assertEquals("Compost Bin (Orange Peel)", manager.categorizeItem("Peels", "Orange Peel"));
        assertEquals("Compost Bin (Potato Peel)", manager.categorizeItem("Peels", "Potato Peel"));
        assertEquals("Compost Bin (Carrot Peel)", manager.categorizeItem("Peels", "Carrot Peel"));
        assertEquals("Compost Bin (Pumpkin Peel)", manager.categorizeItem("Peels", "Pumpkin Peel"));
    }
    
    @Test
    void testGeneralItems() {
        RecyclingManager manager = new RecyclingManager ();
        
        assertEquals("Recycle Bin (Can)", manager.categorizeItem("Can", null));
        assertEquals("Recycle Bin (Paper)", manager.categorizeItem("Paper", null));
        assertEquals("General Waste (Styrofoam)", manager.categorizeItem("Styrofoam", null));
        assertEquals("General Waste (Chips Packet)", manager.categorizeItem("Chips Packet", null));
        assertEquals("General Waste (Chocolate Wrapping)", manager.categorizeItem("Chocolate Wrapping", null));
        assertEquals("Recycle Bin (News Paper)", manager.categorizeItem("News Paper", null));
        assertEquals("General Waste (Chalk)", manager.categorizeItem("Chalk", null));
    }
    
    @Test
    void testInvalidItems() {
        RecyclingManager manager = new RecyclingManager();
        assertEquals("Item not listed – check local rules.", manager.categorizeItem("Unknown", null));
        assertEquals("Item not listed – check local rules.", manager.categorizeItem("", null));
        assertEquals("Item not listed – check local rules.", manager.categorizeItem(null, null));
    }
    
    @Test
    void testNullSubTypeForSubCategories() {
        RecyclingManager manager = new RecyclingManager();
        assertEquals("Plastic type not specified.", manager.categorizeItem("Plastic",null));
        assertEquals("Bottle type not specified.", manager.categorizeItem("Bottle",null));
        assertEquals("Glass type not specified.", manager.categorizeItem("Glass",null));
        assertEquals("Peel type not specified.", manager.categorizeItem("Peels",null));
    }
}