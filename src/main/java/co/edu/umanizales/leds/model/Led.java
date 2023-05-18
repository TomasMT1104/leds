package co.edu.umanizales.leds.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class Led {
    private int identification;
    private boolean state;
    private LocalTime phaseOn;
    private LocalTime phaseOff;

    public Led(int identification, boolean state) {
        this.identification = identification;
        this.state = state;
    }

}
