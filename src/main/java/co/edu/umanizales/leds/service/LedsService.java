package co.edu.umanizales.leds.service;

import co.edu.umanizales.leds.model.Led;
import co.edu.umanizales.leds.model.ListDE;
import co.edu.umanizales.leds.model.NodeDE;

import java.util.ArrayList;
import java.util.List;

public class LedsService {
    private ListDE leds;
    public List<Led> getLedsList () {
        List<Led> ledList = new ArrayList<>();
        NodeDE temp = leds.getHead();


        while (temp != null) {
            ledList.add(temp.getData());
            temp=temp.getNext();

        }
        return  ledList;
    }
}
