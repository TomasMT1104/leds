package co.edu.umanizales.leds.controller.dto;

import lombok.Data;
import java.time.LocalTime;

@Data
public class LedDTO {
    private int identification;
    private boolean status;
    private LocalTime phaseOn;
    private LocalTime phaseOff;

}

