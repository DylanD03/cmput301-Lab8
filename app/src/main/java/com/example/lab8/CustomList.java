package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }


    /**
     * this gets size of the list
     * @return the size of the list
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * When given a city, return whether or not it belongs in the list
     *
     * @return True if the list has city, false if not
     */
    public boolean hasCities(City city){
        return cities.contains(city);
    }


    /**
     * this adds a city object to the list
     * for the first phase it will be
     * empty
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * this deletes a city object from the list
     * @param city
     */
    public void deleteCity(City city){
        cities.remove(city);
    }

    /**
     * this counts number of cities in the list
     */
    public int countCities(){
        return cities.size();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

}
