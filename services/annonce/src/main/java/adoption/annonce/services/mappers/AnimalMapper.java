package adoption.annonce.services.mappers;

import adoption.annonce.dao.entities.Animal;
import adoption.annonce.services.dto.AnimalDto;
import org.springframework.stereotype.Component;

@Component
public class AnimalMapper {

    // Convertir un DTO en entité
    public Animal toEntity(AnimalDto animalDto) {
        if (animalDto == null) {
            return null;
        }

        Animal animal = new Animal();
        animal.setId(animalDto.getId());
        animal.setNom(animalDto.getNom());
        animal.setVaccin(animalDto.getVaccin());
        animal.setTypeVaccin(animalDto.getTypeVaccin());
        animal.setAge(animalDto.getAge());
        animal.setSexe(animalDto.getSexe());
        animal.setLocalisation(animalDto.getLocalisation());
        animal.setBesoinsSpecifiques(animalDto.getBesoinsSpecifiques());
        return animal;
    }

    // Convertir une entité en DTO
    public AnimalDto toDto(Animal animal) {
        if (animal == null) {
            return null;
        }

        AnimalDto animalDto = new AnimalDto();
        animalDto.setId(animal.getId());
        animalDto.setNom(animal.getNom());
        animalDto.setVaccin(animal.getVaccin());
        animalDto.setTypeVaccin(animal.getTypeVaccin());
        animalDto.setAge(animal.getAge());
        animalDto.setSexe(animal.getSexe());
        animalDto.setLocalisation(animal.getLocalisation());
        animalDto.setBesoinsSpecifiques(animal.getBesoinsSpecifiques());
        return animalDto;
    }
}
