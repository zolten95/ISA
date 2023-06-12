package Isa.Isa.controller;

import Isa.Isa.model.DTO.TerminDTO;
import Isa.Isa.model.Termin;
import Isa.Isa.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/termin")
public class TerminController {

    @Autowired
    private TerminService terminService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody TerminDTO terminDTO){
        Termin termin = terminService.add(terminDTO);

        if(termin == null){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(termin, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        if(id < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Termin> t = terminService.findById(id);

        if(t.isEmpty()){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }

        Termin termin = t.get();

        return new ResponseEntity<>(termin, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Termin> termini = terminService.getAll();

        if(termini == null){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(termini, HttpStatus.OK);
    }

    @GetMapping("/getTerminiZaCentar/{medId}")
    public ResponseEntity<?> getTerminiZaCentar(@PathVariable int medId){
        if(medId < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Termin> termini = terminService.getAllForSelektovaniCentar(medId);
        if(termini == null){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(termini, HttpStatus.OK);
    }

    @PostMapping("/rezervisiTermin/{terminId}/{korisnikId}")
    public ResponseEntity<?> reserveTerm(@PathVariable int terminId, @PathVariable int korisnikId){
        if(terminId < 0 || korisnikId < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Termin termin = terminService.rezervisiTermin(terminId, korisnikId);

        if(termin == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(termin, HttpStatus.OK);
    }

    @PostMapping("/otkaziTermin/{terminId}/{korisnikId}")
    public ResponseEntity<?> cancelTerm(@PathVariable int terminId, @PathVariable int korisnikId){
        if(terminId < 0 || korisnikId < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Termin termin = terminService.otkaziTermin(terminId, korisnikId);
        if(termin == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(termin, HttpStatus.OK);
    }

    @GetMapping("/getRezervisaniZaKorisnika/{korisnikId}")
    public ResponseEntity<?> getRezervisaniZaKorisnika(@PathVariable int korisnikId){
        if(korisnikId < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Termin> termini = terminService.getRezervisaniZaKorisnika(korisnikId);

        if(termini == null){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(termini, HttpStatus.OK);
    }
}
