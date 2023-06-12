package Isa.Isa.model;

import Isa.Isa.model.enums.Pol;
import Isa.Isa.model.enums.TipKorisnika;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@javax.persistence.Entity
public class Korisnik extends Entitet{

    private String email;
    private String sifra;
    private String ime;
    private String prezime;
    private String adresa;
    private String grad;
    private String drzava;
    private String telefon;
    private int jmbg;
    private Pol pol;
    private String zanimanje;
    private String ustanova;
    private TipKorisnika tipKorisnika;
    @ManyToOne
    private MedicinskiCentar medicinskiCentar;
    private boolean potvrdjen = false;
    private String tokenZaPotvrdu;
    int penali = 0;

    public String getRole() { return tipKorisnika.toString(); }
}
