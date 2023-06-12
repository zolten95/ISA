package Isa.Isa.model.DTO;

import Isa.Isa.model.Zalba;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class ZalbaCentarDTO {
    private String text;
    private int medCentarID;
    private int pacijentID;


    public static Zalba convertToZalba(ZalbaCentarDTO dto)
    {
        Zalba zalba = new Zalba();

        zalba.setText(dto.getText());
        zalba.setMedicinskoOsoblje(null);

        return zalba;
    }
}
