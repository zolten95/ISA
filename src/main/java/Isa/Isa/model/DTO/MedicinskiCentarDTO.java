package Isa.Isa.model.DTO;

import Isa.Isa.model.MedicinskiCentar;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicinskiCentarDTO {

    private String imeCentra;
    private String adresaCentra;
    private String opisCentra;

    public static MedicinskiCentar konvertuj(MedicinskiCentarDTO medicinskiCentarDTO){
        MedicinskiCentar medicinskiCentar = new MedicinskiCentar();

        medicinskiCentar.setImeCentra(medicinskiCentarDTO.getImeCentra());
        medicinskiCentar.setAdresaCentra(medicinskiCentarDTO.getAdresaCentra());
        medicinskiCentar.setOpisCentra(medicinskiCentarDTO.getOpisCentra());

        return medicinskiCentar;
    }
}
