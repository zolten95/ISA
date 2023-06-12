package Isa.Isa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
@NoArgsConstructor
@javax.persistence.Entity
public class MedicinskiCentar extends Entitet{
    private String imeCentra;
    private String adresaCentra;
    private String opisCentra;
    @Nullable
    private long prosecnaOcena;
}
