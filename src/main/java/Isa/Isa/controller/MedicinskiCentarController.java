package Isa.Isa.controller;

import Isa.Isa.model.DTO.MedicinskiCentarDTO;
import Isa.Isa.model.MedicinskiCentar;
import Isa.Isa.service.MedicinskiCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicinskiCentar")
public class MedicinskiCentarController {

    @Autowired
    private MedicinskiCentarService medicinskiCentarService;

    @PostMapping("/dodajCentar")
    public ResponseEntity<?> dodajCentar(@RequestBody MedicinskiCentarDTO medicinskiCentarDTO){
        MedicinskiCentar medicinskiCentar = medicinskiCentarService.dodajCentar(medicinskiCentarDTO);

        if (medicinskiCentar == null){
            return new ResponseEntity<>("Bad reqeust", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(medicinskiCentar);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        if(id < 0){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);

        }
        Optional<MedicinskiCentar> med = medicinskiCentarService.findById(id);
        if(med.isEmpty()){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        MedicinskiCentar medicinskiCentar = med.get();


        return new ResponseEntity<>(medicinskiCentar, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<MedicinskiCentar> medicinskiCentri = medicinskiCentarService.getAll();

        return ResponseEntity.ok(medicinskiCentri);
    }

    @GetMapping(value = "/getAllSortirano")
    public ResponseEntity<?> getAllSortirano(@RequestParam String field, @RequestParam int pageNo,
                                          @RequestParam int pageSize, @RequestParam String sortMode){
        int page = pageNo - 1;
        Page<MedicinskiCentar> medicniskiCentri = medicinskiCentarService.getAllSortirano(field, page, pageSize, sortMode);

        if(medicniskiCentri == null){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(medicniskiCentri, HttpStatus.OK);
    }
}
