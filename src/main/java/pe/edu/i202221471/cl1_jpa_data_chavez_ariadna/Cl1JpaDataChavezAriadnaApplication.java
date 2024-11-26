package pe.edu.i202221471.cl1_jpa_data_chavez_ariadna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202221471.cl1_jpa_data_chavez_ariadna.entity.Country;

import pe.edu.i202221471.cl1_jpa_data_chavez_ariadna.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataChavezAriadnaApplication implements CommandLineRunner {
	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataChavezAriadnaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Optional<Country> argentina = countryRepository.findById("ARG");
		argentina.ifPresentOrElse(
				// Si "ARG" se encuentra
				country -> {
					System.out.println("Lenguajes hablados en ARG:");
					country.getLanguages().forEach(language -> System.out.println(language.getLanguage()));
				},
				// Si "ARG" no se encuentra, buscamos "PER"
				() -> {
					Optional<Country> peru = countryRepository.findById("PER");
					peru.ifPresentOrElse(
							// Si "PER" se encuentra
							country -> {
								System.out.println("Lenguajes hablados en PER:");
								country.getLanguages().forEach(language -> System.out.println(language.getLanguage()));
							},
							// Si "PER" tampoco se encuentra
							() -> {
								System.out.println("No se encontraron datos para ARG ni para PER.");
							}
					);
				}
		);

		// Eliminar los países "COL" y "ARG" con eliminación en cascada
		countryRepository.deleteAllById(List.of("COL", "ARG"));
		System.out.println("Los países COL y ARG, junto con sus ciudades y lenguajes, han sido eliminados");

		// Volver a ejecutar la consulta
		Optional<Country> argentinaAfterDeletion = countryRepository.findById("ARG");
		argentinaAfterDeletion.ifPresentOrElse(
				// Si "ARG" se encuentra
				country -> {
					System.out.println("Lenguajes hablados en ARG (después de eliminación):");
					country.getLanguages().forEach(language -> System.out.println(language.getLanguage()));
				},
				// Si "ARG" no se encuentra, buscamos "PER"
				() -> {
					Optional<Country> peru = countryRepository.findById("PER");
					peru.ifPresentOrElse(
							// Si "PER" se encuentra
							country -> {
								System.out.println("Lenguajes hablados en PER (después de eliminación de ARG):");
								country.getLanguages().forEach(language -> System.out.println(language.getLanguage()));
							},
							// Si "PER" tampoco se encuentra
							() -> {
								System.out.println("No se encontraron datos para ARG ni para PER.");
							}
					);
				}
		);
	}
}
