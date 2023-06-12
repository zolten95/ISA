package Isa.Isa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor

@javax.persistence.Entity
public class TerminMedicinskiRadnik extends Entitet{
    @ManyToOne
    private Korisnik medicinskiRadnik;
    @ManyToOne
    private Termin termin;
}
