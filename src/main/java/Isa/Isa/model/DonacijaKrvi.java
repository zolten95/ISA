package Isa.Isa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

@javax.persistence.Entity
public class DonacijaKrvi extends Entitet{
    @ManyToOne
    private Korisnik pacijent;
    private Date datum;
    private int trajanje;
    private double cena;
    private String imeMedicinskogCentra;
    @ManyToOne
    private MedicinskiCentar medicinskiCentar;
}
