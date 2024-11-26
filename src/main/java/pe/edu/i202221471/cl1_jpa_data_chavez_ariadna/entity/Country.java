package pe.edu.i202221471.cl1_jpa_data_chavez_ariadna.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
public class Country {
    @Id
    private String code;
    private String name;
    private String continent;
    private String region;
    private Double surfaceArea;
    private Short indepYear;
    private Integer population;
    private Double lifeExpectancy;
    private Double gnp;
    private Double gnpOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private Integer capital;
    private String code2;
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<City> cities;
    // Relación con los idiomas
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<CountryLanguage> languages;
    public List<CountryLanguage> getLanguages() {
        return languages;
    }
}