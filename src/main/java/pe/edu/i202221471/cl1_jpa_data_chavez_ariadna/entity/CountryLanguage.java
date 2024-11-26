package pe.edu.i202221471.cl1_jpa_data_chavez_ariadna.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "countrylanguage")
@NoArgsConstructor
public class CountryLanguage {

    @EmbeddedId
    private LanguagePk id;
    @ManyToOne
    @JoinColumn(name = "CountryCode")
    @MapsId("countryCode")
    private Country country;  // Relación bidireccional con Country
    private  String language;
    private String isOfficial;
    private Double percentage;

    public String getLanguage() {
        return language;
    }
}