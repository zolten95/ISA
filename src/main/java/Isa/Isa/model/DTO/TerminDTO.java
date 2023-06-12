package Isa.Isa.model.DTO;

import Isa.Isa.model.Termin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TerminDTO {

    private Date datumTermina;
    private int trajanje;
    private int medicinskiCentarID;
    private int korisnikID;


    public static Termin convertBack(TerminDTO dto){
        Termin termin = new Termin();

        termin.setDatumTermina(dto.getDatumTermina());
        termin.setTrajanje(dto.getTrajanje());
        return termin;
    }

}
