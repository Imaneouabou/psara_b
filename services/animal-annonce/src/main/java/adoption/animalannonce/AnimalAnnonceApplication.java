package adoption.animalannonce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EntityScan(basePackages = "adoption.animalannonce.dao.entities")
@EnableJpaRepositories(basePackages = "adoption.animalannonce.dao.repository")
public class AnimalAnnonceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalAnnonceApplication.class, args);
	}

}
