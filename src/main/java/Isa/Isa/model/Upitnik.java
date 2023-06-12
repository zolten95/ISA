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
public class Upitnik extends Entitet{
    @ManyToOne
    public Korisnik pacijent;
    public Date datumPopunjavanja;
    public String pitanje1;
    public String pitanje2;
    public String pitanje3;
    public String pitanje4;
    public String pitanje5;
    public String pitanje6;
    public String pitanje7;
    public String pitanje8;
    public String pitanje9;
    public String pitanje10;
    public String pitanje11;
    public String pitanje12;
    public String pitanje13;
    public String pitanje14;
    public String pitanje15;
}
