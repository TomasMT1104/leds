package co.edu.umanizales.leds.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class LedDTO {
    private int identification;
    private boolean status;
    private LocalTime phaseOn;
    private LocalTime phaseOff;

}

