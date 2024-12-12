package adoption.animalannonce.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;





public class ImageStorageService {
/*
    // The directory where images will be saved
    @Value("${image.storage.path}")
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

 */
}
