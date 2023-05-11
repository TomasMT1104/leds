package co.edu.umanizales.leds.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class Led {
    private int cd;

    private boolean status;

    private LocalTime phaseOn;

    private LocalTime pasheOff;

    public Led(int cd, boolean status){
        this.cd = cd;
        this.status = status;
    }

}
