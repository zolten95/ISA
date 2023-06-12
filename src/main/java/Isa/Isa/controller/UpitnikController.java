package Isa.Isa.controller;

import Isa.Isa.model.DTO.UpitnikDTO;
import Isa.Isa.model.Upitnik;
import Isa.Isa.service.UpitnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/upitnik")
public class UpitnikController {

    @Autowired
    private UpitnikService upitnikService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody UpitnikDTO upitnikDTO){
        Upitnik upitnik = upitnikService.dodaj(upitnikDTO);

        if(upitnik == null){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(upitnik, HttpStatus.OK);
    }

    @GetMapping(path = "/getLastQuestionaire/{id}")
    public ResponseEntity<?> getLastQuestionaire(@PathVariable int id){
        Upitnik upitnik = upitnikService.getPoslednjiZaKorisnika(id);

        if (upitnik == null) {
            return new ResponseEntity<>("Nema ga" ,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(upitnik, HttpStatus.OK);

    }

}
