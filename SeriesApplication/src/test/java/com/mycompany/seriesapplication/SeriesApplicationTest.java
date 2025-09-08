/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seriesapplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 *
 * @author boitu
 */
public class SeriesApplicationTest {
    
public SeriesApplication app;

    @BeforeEach
    void setUp() {
        app = new SeriesApplication();
    }

    @Test
    void testFullUserFlow() {
        /*
        Simulated user input sequence:
        1 -> Capture Series
           ID: S10
           Name: Test Series
           Episodes: 5
           Age: 10
        2 -> Search Series (S10)
        5 -> Series Report
        4 -> Delete Series (S10)
           Confirm: yes
        6 -> Exit
        */
        String simulatedInput =
                "1\n" +          // showMenu: choose Capture Series
                "S10\n" +        // series ID
                "Test Series\n" +// series Name
                "5\n" +          // number of episodes
                "10\n" +         // age restriction
                "2\n" +          // showMenu: Search Series
                "S10\n" +        // search ID
                "5\n" +          // showMenu: Series Report
                "4\n" +          // showMenu: Delete Series
                "S10\n" +        // delete ID
                "yes\n" +        // confirm deletion
                "6\n";           // showMenu: Exit

        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        // Run the menu loop (this will process all inputs above)
        app.showMenu();

        // After the deletion, the series list should be empty
        assertEquals(0, app.seriesList.size());
    }
}

//============USED CHATGPT TO MANUALLY ADD THE TESTS ON THE POM.XML FILE AND COMPILE THESE TESTS=================
