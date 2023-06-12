package Isa.Isa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Zalba extends Entitet{

    @ManyToOne
    private MedicinskiCentar medicinskiCentar;
    @ManyToOne
    private Korisnik medicinskoOsoblje;
    private String text;
    @ManyToOne
    private Korisnik pacijent;

}
