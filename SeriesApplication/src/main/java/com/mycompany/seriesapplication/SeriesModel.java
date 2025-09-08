/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seriesapplication;
/**
 *
 * @author boitu
 */
public class SeriesModel {
     public String seriesId;
    public String seriesName;
    public String seriesAgeRestriction;
    public String seriesNumberOfEpisodes;
    
    public SeriesModel (String id, String name, String age, String episodes) {
        this.seriesId = id;
        this.seriesName = name;
        this.seriesAgeRestriction = age;
        this.seriesNumberOfEpisodes = episodes;
        
     }
}