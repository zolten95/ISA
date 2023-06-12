package Isa.Isa.controller;

import Isa.Isa.model.EmailDetails;
import Isa.Isa.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendMail(@RequestBody EmailDetails details)
    {
        String status = emailService.sendConfirmationMail(details);

        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/potvrdiNalog/{email}/{confirmToken}")
    public ResponseEntity<?> confirmMail(@PathVariable String email, @PathVariable String confirmToken){
        if(email.equals("") || confirmToken.equals("")){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        boolean confirmed = emailService.confirmMail(email, confirmToken);

        if(confirmed){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
    }
}
