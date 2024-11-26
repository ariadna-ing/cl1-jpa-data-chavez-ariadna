package pe.edu.i202221471.cl1_jpa_data_chavez_ariadna.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
public class LanguagePk{

    private String countryCode;
    private String language;


}
