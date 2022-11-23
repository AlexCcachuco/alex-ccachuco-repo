package com.bosonit.block6personcontrollers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CiudadService extends Ciudad{

    ArrayList<Ciudad> listCity = new ArrayList<>();

    public void addCity(Ciudad ciudad){

        Ciudad c1 = new Ciudad();
        c1.setName("Pamplona");
        c1.setPopulation(125);

        Ciudad c2 = new Ciudad();
        c2.setName("Badajoz");
        c2.setPopulation(90);

        Ciudad c3 = new Ciudad();
        c3.setName("Teruel");
        c3.setPopulation(460);

        listCity.add(c1);
        listCity.add(c2);
        listCity.add(c3);

        listCity.add(ciudad);
    }


    public ArrayList<Ciudad> getAllCity(){
        return listCity;
    }
}
