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
public class OdgovorZalba extends Entitet {
    private String text;
    @ManyToOne
    private Zalba zalba;

}
