package com.example.listview;

import java.util.List;
import java.util.ArrayList;

public class BeerExpert {
    List<String> getBrands (String color){
        List<String> brands = new ArrayList<String>();
        if (color.equals("amber")){
            brands.add("Jack amber");
            brands.add("Red moose");
        }
        if (color.equals("light")){
            brands.add("Gout Stout");
            brands.add("Jail Pale Ale");
        }
        if (color.equals("brown")){
            brands.add("Rượu nâu");
            brands.add("Rượu nâu 2");
        }
        if (color.equals("dark")){
            brands.add("Rượu dảk");
            brands.add("Dảk qá");
        }
        return  brands;
    }
}
