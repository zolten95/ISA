package Isa.Isa.model.DTO;

import Isa.Isa.model.OdgovorZalba;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
@Setter
public class OdgovorDTO {
    private String text;


    public static OdgovorZalba ConvertToOdgovor(OdgovorDTO dto){
        OdgovorZalba odgovorZalba = new OdgovorZalba();

        odgovorZalba.setText(dto.getText());

        return odgovorZalba;
    }
}
