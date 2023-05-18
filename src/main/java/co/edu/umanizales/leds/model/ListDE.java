package co.edu.umanizales.leds.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class ListDE {
    private NodeDE head;
    private NodeDE tail;
    private int size;
    private List<Led> leds = new ArrayList<>();


    public void addLed(Led led) {
        if (head == null) {
            head = new NodeDE(led);
        } else {
            NodeDE newNode = new NodeDE(led);
            NodeDE current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setPrev(current);
        }
        size++;
    }

    public List <Led> print(){
        leds.clear();
        if (head != null){
            NodeDE temp = head;
            while (temp != null){
                leds.add(temp.getData());
                temp = temp.getNext();
            }
        }
        return leds;
    }

    public void reset(){
        NodeDE temp = head;
        while (temp != null){
            temp.getData().setState(false);
            temp.getData().setPhaseOff(null);
            temp.getData().setPhaseOn(null);

            temp = temp.getNext();
        }

    }

    public void addToStart(Led led)  {
        NodeDE newNode = new NodeDE(led);
        if (head != null) {
            head.setPrev(newNode);
            newNode.setNext(head);
        }
        head = newNode;
        size++;
    }

    public void addToEnd(Led led) {
        NodeDE newNode = new NodeDE(led);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    public  void turnOnLight(){
        if (head != null) {
            NodeDE temp = head;
            int pasos = 1;
            int medium;
            if ((size%2)!=0){
                medium = (size / 2) + 1;
                while (temp!= null){

                    if (pasos == medium){
                        NodeDE tempNext = temp;
                        temp.getData().setState(true);
                        temp.getData().setPhaseOn(LocalTime.from(LocalDateTime.now()));

                        while (tempNext.getNext() != null){

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            temp.getData().setState(false);
                            temp.getData().setPhaseOff(LocalTime.from(LocalDateTime.now()));
                            tempNext.getData().setState(false);
                            tempNext.getData().setPhaseOff(LocalTime.from(LocalDateTime.now()));

                            temp = temp.getPrev();
                            tempNext= tempNext.getNext();

                            temp.getData().setState(true);
                            temp.getData().setPhaseOn(LocalTime.from(LocalDateTime.now()));
                            tempNext.getData().setState(true);
                            tempNext.getData().setPhaseOn(LocalTime.from(LocalDateTime.now()));



                        }
                    }
                    pasos++;
                    temp= temp.getNext();


                }




            } else{
                medium = size/2;

                while (temp!= null){
                    if (pasos == medium){
                        NodeDE tempNext = temp.getNext();
                        temp.getData().setState(true);
                        temp.getData().setPhaseOn(LocalTime.from(LocalDateTime.now()));
                        tempNext.getData().setState(true);
                        tempNext.getData().setPhaseOn(LocalTime.from(LocalDateTime.now()));

                        while (tempNext.getNext() != null) {

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            temp.getData().setState(false);
                            temp.getData().setPhaseOff(LocalTime.from(LocalDateTime.now()));
                            tempNext.getData().setState(false);
                            tempNext.getData().setPhaseOff(LocalTime.from(LocalDateTime.now()));

                            temp = temp.getPrev();
                            tempNext = tempNext.getNext();

                            temp.getData().setState(true);
                            temp.getData().setPhaseOn(LocalTime.from(LocalDateTime.now()));
                            tempNext.getData().setState(true);
                            tempNext.getData().setPhaseOn(LocalTime.from(LocalDateTime.now()));


                        }
                    }
                    pasos++;
                    temp= temp.getNext();

                }

            }

        }

    }
}


