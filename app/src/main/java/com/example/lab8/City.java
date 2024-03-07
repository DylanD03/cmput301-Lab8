package com.example.lab8;

public class City implements Comparable{

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * This function overrides the comparison operator of the city function
     * and now uses the city names for comparison
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // uses the Sting object compareTo
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }
}
