package Isa.Isa.model.DTO;

import Isa.Isa.model.Korisnik;
import Isa.Isa.model.enums.Pol;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistracijaDTO {
    private String email;
    private String sifra;
    private String ime;
    private String prezime;
    private String adresa;
    private String grad;
    private String drzava;
    private String telefon;
    private int jmbg;
    private String pol;
    private String zanimanje;
    private String ustanova;

    public static Korisnik Konvertuj(RegistracijaDTO registracijaDTO){

        Korisnik korisnik = new Korisnik();

        korisnik.setEmail(registracijaDTO.getEmail());
        korisnik.setSifra(registracijaDTO.getSifra());
        korisnik.setIme(registracijaDTO.getIme());
        korisnik.setPrezime(registracijaDTO.getPrezime());
        korisnik.setAdresa(registracijaDTO.getAdresa());
        korisnik.setGrad(registracijaDTO.getGrad());
        korisnik.setDrzava(registracijaDTO.getDrzava());
        korisnik.setTelefon(registracijaDTO.getTelefon());
        korisnik.setJmbg(registracijaDTO.getJmbg());
        if (registracijaDTO.getPol().equals("Muski")){
            korisnik.setPol(Pol.Muski);
        } else {
            korisnik.setPol(Pol.Zenski);
        }
        korisnik.setZanimanje(registracijaDTO.getZanimanje());
        korisnik.setUstanova(registracijaDTO.getUstanova());

        return korisnik;
    }

}
