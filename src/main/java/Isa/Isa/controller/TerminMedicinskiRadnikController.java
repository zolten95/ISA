package Isa.Isa.controller;

import Isa.Isa.model.TerminMedicinskiRadnik;
import Isa.Isa.service.TerminMedicinskiRadnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/terminMedicinskiRadnik")
public class TerminMedicinskiRadnikController {
    @Autowired
    private TerminMedicinskiRadnikService terminMedicinskiRadnikService;

    @PostMapping(path = "/{terminID}/{korisnikID}")
    public ResponseEntity<?> add(@PathVariable int terminID, @PathVariable int korisnikID){
        if(terminID < 0 || korisnikID < 0){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        TerminMedicinskiRadnik terminMedicinskiRadnik = terminMedicinskiRadnikService.add(terminID, korisnikID);

        if(terminMedicinskiRadnik == null){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(terminMedicinskiRadnik, HttpStatus.OK);
    }
}
