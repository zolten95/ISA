package Isa.Isa.controller;

import Isa.Isa.model.DTO.LoginDTO;
import Isa.Isa.model.DTO.LoginResDTO;
import Isa.Isa.model.DTO.RegistracijaDTO;
import Isa.Isa.model.Korisnik;
import Isa.Isa.security.TokenUtils;
import Isa.Isa.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/korisnik")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenUtils tokenUtils;

    @PostMapping(path = "/registracija")
    public ResponseEntity<?> Registracija(@RequestBody RegistracijaDTO registracijaDTO){
        if(registracijaDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Korisnik korisnik = korisnikService.Registruj(registracijaDTO);

        if (korisnik == null){
            return new ResponseEntity<>("Email je zauzet.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(korisnik, HttpStatus.OK);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfCurrentMonth = LocalDate.now().withDayOfMonth(1);
        Korisnik korisnik = korisnikService.GetByEmail(loginDTO.getEmail());

        if (korisnik == null){
            return new ResponseEntity<>( HttpStatus.UNAUTHORIZED);
        }
        if (korisnik != null && firstDayOfCurrentMonth.equals(today)) {
            korisnikService.smanjiPenale(korisnik);
        }
        String enkriptovana = passwordEncoder.encode(korisnik.getSifra());
        if(!passwordEncoder.matches(loginDTO.getSifra(), enkriptovana)) {
            return ResponseEntity.ok( HttpStatus.UNAUTHORIZED);
        }
        /*
        if (!korisnik.isPotvrdjen()){
            return  ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        */
        String token = tokenUtils.generateToken(korisnik.getEmail(), korisnik.getRole());
        LoginResDTO responseDTO = new LoginResDTO();
        responseDTO.setToken(token);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(path = "/getCurrentUser/{email}")
    public ResponseEntity<?> getCurrentUser(@PathVariable String email){
        if(email.equals("")){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        Korisnik korisnik = korisnikService.GetByEmail(email);

        if(korisnik == null){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(korisnik, HttpStatus.OK);
    }
}
