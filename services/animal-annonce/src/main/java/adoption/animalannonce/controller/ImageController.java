package adoption.animalannonce.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Value("${spring.image.storage.path}")
    private String imageStoragePath;

    @GetMapping("/{filename:.+}")
    public ResponseEntity<?> getImage(@PathVariable String filename) {
        try {
            // Résoudre le chemin complet de l'image
            Path filePath = Paths.get(imageStoragePath).resolve(filename).normalize();

            System.out.println("Chemin résolu de l'image : " + filePath);

            // Vérifier si le fichier existe
            if (!Files.exists(filePath)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Image not found: " + filename);
            }

            // Charger l'image en tant que ressource
            Resource resource = new UrlResource(filePath.toUri());
            if (!resource.exists() || !resource.isReadable()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Could not read file: " + filename);
            }

            // Obtenir le type MIME
            String contentType = Files.probeContentType(filePath);
            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            // Retourner l'image avec le type MIME correct
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .body(resource);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error loading image: " + e.getMessage());
        }
    }
}
