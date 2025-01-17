package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    public City MockCity(){
        City mockCity = new City("Edmonton", "Alberta");
        return mockCity;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }


    // Test has cities
    @Test
    public void hasCityTest(){
        list = MockCityList();
        City mockCity = MockCity();
        // test method has cities works
        assertEquals(false,list.hasCities(mockCity));
        if (!list.hasCities(mockCity)) {
            list.addCity(mockCity);
        }
        assertEquals(true, list.hasCities(mockCity));

    }


    // Test delete cities
    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City mockCity = MockCity();
        // add city
        list.addCity(mockCity);
        // delete city
        list.deleteCity(mockCity);
        assertEquals(false, list.hasCities(mockCity));

    }

    // Test Count cities
    @Test
    public void countCityTest(){
        list = MockCityList();
        City mockCity = MockCity();
        // add city
        list.addCity(mockCity);
        // add city
        list.addCity(new City("Calgary", "Alberta"));
        // test count
        assertEquals(2, list.countCities());
        // delete city
        list.deleteCity(mockCity);
        assertEquals(1, list.countCities());

    }




}
