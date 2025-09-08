/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.neuvogreencyclingappst10472272;

import javax.swing.JOptionPane;

/**
 *
 * @author boitu
 */

//  Waste Item Classes 
class WasteItem {
    private final String name;
    private final String category;

    public WasteItem(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
}

class Recyclable extends WasteItem {
    public Recyclable(String name) { super(name, "Recycle Bin"); }
}

class Compostable extends WasteItem {
    public Compostable(String name) { super(name, "Compost Bin"); }
}

class GeneralWaste extends WasteItem {
    public GeneralWaste(String name) { super(name, "General Waste"); }
}

//  The Recycling Manager 
class RecyclingManager {
    public String categorizeItem(String item, String subType) {
        if (item == null || item.isEmpty()) return "Item not listed – check local rules.";

        // Plastic
        if (item.equals("Plastic")) {
            if (subType == null) return "Plastic type not specified.";
            switch (subType) {
                case "Plastic Bag": return "General Waste (Plastic Bag)";
                case "Plastic Bottle": return "Recycle Bin (Plastic Bottle)";
                case "Plastic Utensils": return "General Waste (Plastic Utensils)";
                case "Other": return "Check local recycling rules.";
            }
        }
        // Bottle
        if (item.equals("Bottle")) {
            if (subType == null) return "Bottle type not specified.";
            switch (subType) {
                case "Plastic Bottle": return "Recycle Bin (Plastic Bottle)";
                case "Milk Carton": return "Recycle Bin (Milk Carton)";
            }
        }
        // Glass
        if (item.equals("Glass")) {
            if (subType == null) return "Glass type not specified.";
            switch (subType) {
                case "Glass Window": return "Recycle Bin (Glass Window)";
                case "Mirror": return "General Waste (Mirror)";
                case "Tableware": return "General Waste (Tableware)";
                case "Light Bulb": return "General Waste (Light Bulb)";
            }
        }
        // Peels
        if (item.equals("Peels")) {
            if (subType == null) return "Peel type not specified.";
            switch (subType) {
                case "Banana Peel": return "Compost Bin (Banana Peel)";
                case "Orange Peel": return "Compost Bin (Orange Peel)";
                case "Potato Peel": return "Compost Bin (Potato Peel)";
                case "Carrot Peel": return "Compost Bin (Carrot Peel)";
                case "Pumpkin Peel": return "Compost Bin (Pumpkin Peel)";
            }
        }
        // General items
        switch (item) {
            case "Can": return "Recycle Bin (Can)";
            case "Paper": return "Recycle Bin (Paper)";
            case "Styrofoam": return "General Waste (Styrofoam)";
            case "Chips Packet": return "General Waste (Chips Packet)";
            case "Chocolate Wrapping": return "General Waste (Chocolate Wrapping)";
            case "News Paper": return "Recycle Bin (News Paper)";
            case "Chalk": return "General Waste (Chalk)";
        }

        return "Item not listed – check local rules.";
    }
}

// My Main Program 
public class NuevoGreenCyclingAppST10472272 {

    public static void main(String[] args) {
        RecyclingManager manager = new RecyclingManager();
        boolean running = true;

        JOptionPane.showMessageDialog(null, "Welcome to the NeuvoGreen Recycle Guide!");
        JOptionPane.showMessageDialog(null, "It is good to see you today!");

        while (running) {
            String[] mainOptions = {
                "Plastic", "Bottle", "Glass", "Peels",
                "Can", "Paper", "Styrofoam", "Chips Packet",
                "Chocolate Wrapping", "News Paper", "Chalk",
                "Exit"
            };

            // Main dropdown menu
            String selectedItem = (String) JOptionPane.showInputDialog(
                    null,
                    "Select an item:",
                    "NeuvoGreen Recycling Guide",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    mainOptions,
                    mainOptions[0]
            );

            if (selectedItem == null || selectedItem.equals("Exit")) {
                running = false;
                JOptionPane.showMessageDialog(null, "Goodbye! Thank you for keeping your environment clean.");
                break;
            }

            String subType = null;

            // Sub-dropdown menus for Items with more than one sub-type
            if (selectedItem.equals("Plastic")) {
                subType = showDropdown(new String[]{"Plastic Bag", "Plastic Bottle", "Plastic Utensils", "Other", "Back"}, "Plastic Options");
                if (subType == null || subType.equals("Back")) continue;
            } else if (selectedItem.equals("Bottle")) {
                subType = showDropdown(new String[]{"Plastic Bottle", "Milk Carton", "Back"}, "Bottle Options");
                if (subType == null || subType.equals("Back")) continue;
            } else if (selectedItem.equals("Glass")) {
                subType = showDropdown(new String[]{"Glass Window", "Mirror", "Tableware", "Light Bulb", "Back"}, "Glass Options");
                if (subType == null || subType.equals("Back")) continue;
            } else if (selectedItem.equals("Peels")) {
                subType = showDropdown(new String[]{"Banana Peel", "Orange Peel", "Potato Peel", "Carrot Peel", "Pumpkin Peel", "Back"}, "Peel Options");
                if (subType == null || subType.equals("Back")) continue;
            } 
            //  Direct items that do not have a subType menus
            else {
                subType = null;
            }

            // Displaying results
            String result = manager.categorizeItem(selectedItem, subType);
            JOptionPane.showMessageDialog(
                    null,
                    "Item: " + selectedItem + (subType != null ? " (" + subType + ")" : "") +
                            "\nDisposal: " + result
            );
        }
    }

    private static String showDropdown(String[] options, String title) {
        return (String) JOptionPane.showInputDialog(
                null,
                "Select an option:",
                title,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
    }
}