package Isa.Isa.model;

import Isa.Isa.model.enums.StatusTermina;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

@javax.persistence.Entity
public class Termin extends  Entitet{
    private Date datumTermina;
    private int trajanje;
    private StatusTermina statusTermina;
    @ManyToOne
    private MedicinskiCentar medicinskiCentar;
    @ManyToOne
    private Korisnik pacijent;
}
