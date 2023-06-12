package Isa.Isa.controller;

import Isa.Isa.model.DonacijaKrvi;
import Isa.Isa.service.DonacijaKrviService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/donacijaKrvi")
public class DonacijaKrviController {

    @Autowired
    private DonacijaKrviService donacijaKrviService;

    @GetMapping("/{pacijentID}")
    public ResponseEntity<?> GetAllForPacijent(@PathVariable int pacijentID, @RequestParam String field, @RequestParam int pageNo,
                                           @RequestParam int pageSize, @RequestParam String sortMode){
        if(pacijentID < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Pageable paging;

        if(sortMode.equals("Ascending")) {
            paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, field));
        } else {
            paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, field));
        }

        Page<DonacijaKrvi> donacijeKrvi = donacijaKrviService.GetAllForPacijent(pacijentID, paging);

        if(donacijeKrvi == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(donacijeKrvi, HttpStatus.OK);

    }
}
