package co.edu.umanizales.leds.controller;


import co.edu.umanizales.leds.controller.dto.ResponseDTO;
import co.edu.umanizales.leds.model.Led;
import co.edu.umanizales.leds.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/listdeleds")
public class ListDEController {
    @Autowired
    private ListDEService listDEService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getLed() {
        return new ResponseEntity<>(new ResponseDTO(
                200, listDEService.getLeds().print(), null), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> addLed(@PathVariable int identification){

        listDEService.getLeds().addLed(new Led(identification,false));
        return new ResponseEntity<>(new ResponseDTO(
                200, "La luz led fue añadida", null), HttpStatus.OK);

    }


    @GetMapping(path = "/reset")
    public ResponseEntity<ResponseDTO> reset(){

        listDEService.getLeds().reset();
        return new ResponseEntity<>(new ResponseDTO(
                200, "Las luces led reiniciaron su estado", null), HttpStatus.OK);

    }

    @GetMapping(path = "/addtostart")
    public ResponseEntity<ResponseDTO> addToStart(@RequestBody Led led){

        listDEService.getLeds().addToStart(led);
        return new ResponseEntity<>(new ResponseDTO(
                200, "La luz led fue añadida al inicio", null), HttpStatus.OK);

    }

    @GetMapping(path = "/addtoend")
    public ResponseEntity<ResponseDTO> addToEnd(@RequestBody Led led){

        listDEService.getLeds().addToEnd(led);
        return new ResponseEntity<>(new ResponseDTO(
                200, "La luz led fue añadida al final", null), HttpStatus.OK);

    }

    @GetMapping(path = "/turnonlight")
    public ResponseEntity<ResponseDTO> turnOnLight() {

        listDEService.getLeds().turnOnLight();

        return new ResponseEntity<>(new ResponseDTO(
                200, "Se encendieron las luces", null), HttpStatus.OK);
    }
}


