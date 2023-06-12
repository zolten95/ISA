package Isa.Isa.model.DTO;


import Isa.Isa.model.OdgovorZalba;
import Isa.Isa.model.Zalba;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OdgvorenaZalbaDTO {
    private Zalba zalba;
    private OdgovorZalba odgovorZalba;


}
