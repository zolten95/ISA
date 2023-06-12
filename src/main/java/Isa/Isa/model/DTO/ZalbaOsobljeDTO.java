package Isa.Isa.model.DTO;

import Isa.Isa.model.Zalba;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ZalbaOsobljeDTO {
    private String text;
    private int pacijentID;
    private int osobljeID;


    public static Zalba convertToZalba(ZalbaOsobljeDTO dto)
    {
        Zalba zalba = new Zalba();

        zalba.setText(dto.getText());
        zalba.setMedicinskiCentar(null);

        return zalba;
    }
}
