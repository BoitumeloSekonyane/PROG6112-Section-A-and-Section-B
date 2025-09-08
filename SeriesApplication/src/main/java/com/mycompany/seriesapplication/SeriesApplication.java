/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.seriesapplication;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author boitu
 */
public class SeriesApplication {
    public Scanner scanner = new Scanner (System.in);
    public ArrayList <SeriesModel> seriesList = new ArrayList<>();
    
    public static void main(String[] args) {
        SeriesApplication app = new SeriesApplication();
        Scanner scanner = new Scanner(System.in);
        //Prompting user to enter 1 for menu options
        
        while (true) {
            System.out.println("\nLATEST SERIES - 2025");
            System.out.println("*********************************");
            System.out.println("Enter (1) to launch the series Menu or any other key to exit");
            String input = scanner.nextLine();
            
            if (input.equals("1")) {
                app.showMenu(); //Shows the series menu for the user to select choices.
            } else {
                System.out.println("Exiting the Orbit. Goodbye!"); //The Orbit is the name of the application
                        break; // Exiting the loop and stopping the program
            }
        }
        
        scanner.close(); //Closing the scanner class after the loop
    }
    //Diplaying the menu for the user
    void showMenu() {
        while (true) {
            System.out.println("\n1. Capture Series");
            System.out.println("2. Search Series");
            System.out.println("3. Update Series");
            System.out.println("4. Delete Series");
            System.out.println("5. Series Report");
            System.out.println("6. Exit the Orbit");
            System.out.println("Enter choice: ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1" :
                    captureSeries();
                    break;
                case "2" :
                    searchSeries();
                    break;
                case "3" :
                    updateSeries();
                    break;
                case "4" :
                    deleteSeries();
                    break;
                case "5" :
                    seriesReport();
                    break;
                case "6" :
                    ExitSeriesApplication();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");

            }
        }
    }
    //Capturing the details of the user
    public void captureSeries() {
        System.out.println("Enter Series ID:");
        String id = scanner.nextLine();
        
        System.out.println("Enter Series Name:");
        String name = scanner.nextLine();
        
        String episodes;
        while (true) {
            System.out.println("Enter the number of Episodes: ");
            episodes = scanner.nextLine();
            if (episodes.matches("\\d+")){
                int numEpisodes = Integer.parseInt(episodes);
                if (numEpisodes >= 5) break;
                else System.out.println("Episodes Required.");
             } else {
                     System.out.println("Invalid input. Please enter a number.");
            }
        }
        String age;
        while (true) {
            System.out.println("Enter the Series Age Restriction:");
            age = scanner.nextLine();
            if (age.matches("\\d+")) {
                int numAge = Integer.parseInt(age);
                if (numAge >=2 && numAge <= 18) break;
                else System.out.println("You must be between 2 and 18 years to access this Series!");
            } else {
                System.out.println("Age invalid. Please enter a valid Age!");
            }
            
        }
        
        SeriesModel series = new SeriesModel (id,  name, age, episodes);
        seriesList.add(series);
        System.out.println("This series has been Successfully Added!");
    }
    //Searching for the Series that has been captured with its ID
    public void searchSeries() {
        System.out.println("Enter the Series ID to search:");
        String id = scanner.nextLine();
        
        for (SeriesModel series : seriesList) {
            if (series.seriesId.equals(id)) {
                display(series);
                return;
                
            }
        }
        System.out.println("No Series Found.");
    }
    //The User can update the Series details with this option
    public void updateSeries() {
        System.out.println("Enter Series ID to update:");
        String id = scanner.nextLine();
        
        for (SeriesModel series : seriesList) {
            if (series.seriesId.equals(id))   {
                System.out.println("Enter new Series Name:");
                series.seriesName = scanner.nextLine();
                
               
                String episodes;
                while (true) {
                    System.out.println("Enter new number of episodes (Minimum of 5 episodes): ");
                    episodes = scanner.nextLine();
                    if (episodes.matches("\\d+")) {
                       int numEpisodes = Integer.parseInt(episodes);
                       if (numEpisodes >= 5) break;
                       else System.out.println("Episodes must be a minimum of 5 per Series.");
                    }else{
                        System.out.println("Invalid Input. Please enter a number.");
                    }
                }
                series.seriesNumberOfEpisodes = episodes;
                
                System.out.println("Series has been Successfully Updated!");
                return;
            }
        }
        System.out.println("Series not Found!");
    }
    //If the User wants to delete the Series. Boolean condition used as a safety measure
    public void deleteSeries() {
    System.out.println("Enter Series ID to delete:");
    String id = scanner.nextLine();

    for (SeriesModel series : seriesList) {
        if (series.seriesId.equals(id)) {
            //  Show series details for user to know which series they are deleting
            System.out.println("You are about to delete:");
            System.out.println("Series ID: " + series.seriesId);
            System.out.println("Series Name: " + series.seriesName);
            System.out.println("Number of Episodes: " + series.seriesNumberOfEpisodes);
            System.out.println("Age Restriction: " + series.seriesAgeRestriction);

            System.out.println("Are you sure you want to delete this series? (yes/no): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                seriesList.remove(series);
                System.out.println("Series '" + series.seriesName + "' deleted successfully!");
            } else {
                System.out.println("Deletion Cancelled.");
            }
            return; // exit after handling
        }
    }

    System.out.println("Series not Found!");
}
    //Displays the reoprt of all Series that has been captured by the User
    public void seriesReport() {
       System.out.println("Series Report:");
       for (SeriesModel series : seriesList) {
           display(series);
       }
    }
    
    private void display(SeriesModel series) {
        System.out.println("SERIES ID: " +series.seriesId);
        System.out.println("SERIES NAME: " +series.seriesName);
        System.out.println("SERIES AGE RESTRICTION:" +series.seriesAgeRestriction);
        System.out.println("NUMBER OF EPISODES: " +series.seriesNumberOfEpisodes);
        System.out.println("--------------------------------------------------");
    }
    //Exiting the Program
    public void ExitSeriesApplication () {
        System.out.println("Thank you for visiting The Orbit. Goodbye!");
        System.exit(0);
    }
    
}
