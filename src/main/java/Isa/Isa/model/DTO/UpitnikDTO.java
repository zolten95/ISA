package Isa.Isa.model.DTO;

import Isa.Isa.model.Korisnik;
import Isa.Isa.model.Upitnik;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UpitnikDTO {
    public int pacijentID;
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

    public static Upitnik konvertujUModel(UpitnikDTO dto) {
        Upitnik questionnaire = new Upitnik();

        questionnaire.setPitanje1(dto.getPitanje1());
        questionnaire.setPitanje2(dto.getPitanje2());
        questionnaire.setPitanje3(dto.getPitanje3());
        questionnaire.setPitanje4(dto.getPitanje4());
        questionnaire.setPitanje5(dto.getPitanje5());
        questionnaire.setPitanje6(dto.getPitanje6());
        questionnaire.setPitanje7(dto.getPitanje7());
        questionnaire.setPitanje8(dto.getPitanje8());
        questionnaire.setPitanje9(dto.getPitanje9());
        questionnaire.setPitanje10(dto.getPitanje10());
        questionnaire.setPitanje11(dto.getPitanje11());
        questionnaire.setPitanje12(dto.getPitanje12());
        questionnaire.setPitanje13(dto.getPitanje13());
        questionnaire.setPitanje14(dto.getPitanje14());
        questionnaire.setPitanje15(dto.getPitanje15());

        return  questionnaire;
    }
}
