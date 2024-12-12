package adoption.animalannonce.services;


import adoption.animalannonce.services.dto.AnimalAnnonceDto;
import adoption.animalannonce.dao.entities.AnimalAnnonce;
import adoption.animalannonce.exception.FunctionalException;
import adoption.animalannonce.services.mappers.AnimalAnnonceMapper;
import adoption.animalannonce.dao.repository.AnimalAnnonceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnimalAnnonceService {

    @Autowired
    private  AnimalAnnonceRepository animalAnnonceRepository;

    @Autowired
    private  AnimalAnnonceMapper animalAnnonceMapper;

    // The directory where images will be saved
    @Value("${spring.image.storage.path}")
    private String imageStoragePath;

    // Method to save an image and return its path
    public String saveImage(MultipartFile file) throws IOException {
        // Ensure the directory exists
        Path storagePath = Paths.get(imageStoragePath);
        if (!Files.exists(storagePath)) {
            Files.createDirectories(storagePath);
        }

        // Generate a unique filename for the image
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String uniqueFilename = UUID.randomUUID().toString() + extension;

        // Determine the file's storage path
        Path destinationFile = storagePath.resolve(uniqueFilename);

        // Copy the file to the storage location
        Files.copy(file.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);

        // Return the path as a string
        return destinationFile.toString();
    }



    public AnimalAnnonceDto createAnimalAnnonce(AnimalAnnonceDto animalAnnonceDto) throws IOException {

        List<String> imagePaths = new ArrayList<>();
        for (MultipartFile file : animalAnnonceDto.getImageFiles()) {
            System.out.println("Processing file: " + file.getOriginalFilename());
            String imagePath = saveImage(file);
            imagePaths.add(imagePath);
        }

        AnimalAnnonce annonce = animalAnnonceMapper.toEntity(animalAnnonceDto, imagePaths);
        annonce.setDateCreated(LocalDateTime.now());
        AnimalAnnonce savedAnimalAnnonce = animalAnnonceRepository.save(annonce);

        return animalAnnonceMapper.toDto(savedAnimalAnnonce) ;
    }


    public AnimalAnnonceDto findAnimalAnnonceById(Long animalAnnonceId) throws FunctionalException {

        Optional<AnimalAnnonce> animalOptional = animalAnnonceRepository.findById(animalAnnonceId);

        if (animalOptional.isPresent()) {
            return animalAnnonceMapper.toDto(animalOptional.get());
        } else {
            throw new FunctionalException("L'Animal avec l'id " + animalAnnonceId + " n'existe pas.");
        }
    }

    public AnimalAnnonceDto updateAnimalAnnonce(Long id, AnimalAnnonceDto animalAnnonceDto) throws FunctionalException {
        // Récupérer l'annonce existante
        AnimalAnnonceDto existingAnnonceDto = findAnimalAnnonceById(id);

        // Mettre à jour les champs fixes
        animalAnnonceDto.setId(id);
        animalAnnonceDto.setDateCreated(existingAnnonceDto.getDateCreated());
        animalAnnonceDto.setDateUpdate(LocalDateTime.now());

        // Gérer les images
        List<String> imagePaths;
        if (animalAnnonceDto.getImageFiles() != null && !animalAnnonceDto.getImageFiles().isEmpty()) {
            imagePaths = new ArrayList<>();
            try {
                for (MultipartFile imageFile : animalAnnonceDto.getImageFiles()) {
                    String imagePath = saveImage(imageFile);
                    imagePaths.add(imagePath);
                }
            } catch (IOException e) {
                throw new FunctionalException("Échec de l'enregistrement des images.", e);
            }
        } else {
            imagePaths = existingAnnonceDto.getImages();
        }

        // Sauvegarder l'entité mise à jour
        AnimalAnnonce updatedAnnonce = animalAnnonceRepository.save(animalAnnonceMapper.toEntity(animalAnnonceDto, imagePaths));

        // Retourner l'annonce mise à jour sous forme de DTO
        return animalAnnonceMapper.toDto(updatedAnnonce);
    }



    public AnimalAnnonceDto updateAnimal_Annonce(Long id, AnimalAnnonceDto animalAnnonceDto) throws FunctionalException, IOException {
        Optional<AnimalAnnonce> existingAnnonceOptional = animalAnnonceRepository.findById(id);

        if (existingAnnonceOptional.isEmpty()) {
            throw new FunctionalException("L'annonce avec l'id " + id + " n'existe pas.");
        }

        AnimalAnnonce existingAnnonce = existingAnnonceOptional.get();

        // Mise à jour des champs
        existingAnnonce.setNom(animalAnnonceDto.getNom());
        existingAnnonce.setVaccin(animalAnnonceDto.getVaccin());
        existingAnnonce.setTypeVaccin(animalAnnonceDto.getTypeVaccin());
        existingAnnonce.setAge(animalAnnonceDto.getAge());
        existingAnnonce.setSexe(animalAnnonceDto.getSexe());
        existingAnnonce.setLocalisation(animalAnnonceDto.getLocalisation());
        existingAnnonce.setBesoinsSpecifiques(animalAnnonceDto.getBesoinsSpecifiques());
        existingAnnonce.setDescription(animalAnnonceDto.getDescription());
        existingAnnonce.setType(animalAnnonceDto.getType());
        existingAnnonce.setStatus(animalAnnonceDto.getStatus());
        existingAnnonce.setDateUpdate(LocalDateTime.now());

        // Gestion des nouvelles images
        if (animalAnnonceDto.getImageFiles() != null && !animalAnnonceDto.getImageFiles().isEmpty()) {
            List<String> imagePaths = new ArrayList<>();
            for (MultipartFile file : animalAnnonceDto.getImageFiles()) {
                String imagePath = saveImage(file);
                imagePaths.add(imagePath);
            }
            existingAnnonce.setImages(imagePaths);
        }

        AnimalAnnonce updatedAnnonce = animalAnnonceRepository.save(existingAnnonce);

        return animalAnnonceMapper.toDto(updatedAnnonce);
    }

    public void deleteAnimalAnnonce(Long id) throws FunctionalException {
        if (!animalAnnonceRepository.existsById(id)) {
            throw new FunctionalException("L'annonce avec l'id " + id + " n'existe pas.");
        }
        animalAnnonceRepository.deleteById(id);
    }

    public List<AnimalAnnonceDto> getAllAnimalAnnonces() {
        List<AnimalAnnonce> annonces = animalAnnonceRepository.findAll();
        List<AnimalAnnonceDto> annonceDtos = new ArrayList<>();
        for (AnimalAnnonce annonce : annonces) {
            annonceDtos.add(animalAnnonceMapper.toDto(annonce));
        }
        return annonceDtos;
    }

    public List<AnimalAnnonceDto> findAnimalAnnoncesByCriteria(String type, String localisation) {
        List<AnimalAnnonce> annonces = animalAnnonceRepository.findAll();
        List<AnimalAnnonceDto> filteredAnnonces = new ArrayList<>();
        for (AnimalAnnonce annonce : annonces) {
            if ((type == null || annonce.getType().equalsIgnoreCase(type)) &&
                    (localisation == null || annonce.getLocalisation().equalsIgnoreCase(localisation))) {
                filteredAnnonces.add(animalAnnonceMapper.toDto(annonce));
            }
        }
        return filteredAnnonces;
    }

    public AnimalAnnonceDto changeStatus(Long id, String newStatus) throws FunctionalException {
        AnimalAnnonce annonce = animalAnnonceRepository.findById(id)
                .orElseThrow(() -> new FunctionalException("L'annonce avec l'id " + id + " n'existe pas."));

        annonce.setStatus(newStatus);
        annonce.setDateUpdate(LocalDateTime.now());

        AnimalAnnonce updatedAnnonce = animalAnnonceRepository.save(annonce);

        return animalAnnonceMapper.toDto(updatedAnnonce);
    }

    public AnimalAnnonceDto removeImageFromAnnonce(Long id, String imagePath) throws FunctionalException {
        AnimalAnnonce annonce = animalAnnonceRepository.findById(id)
                .orElseThrow(() -> new FunctionalException("L'annonce avec l'id " + id + " n'existe pas."));

        List<String> updatedImagePaths = new ArrayList<>(annonce.getImages());
        if (!updatedImagePaths.remove(imagePath)) {
            throw new FunctionalException("L'image spécifiée n'existe pas dans cette annonce.");
        }

        annonce.setImages(updatedImagePaths);
        annonce.setDateUpdate(LocalDateTime.now());

        AnimalAnnonce updatedAnnonce = animalAnnonceRepository.save(annonce);

        return animalAnnonceMapper.toDto(updatedAnnonce);
    }





}