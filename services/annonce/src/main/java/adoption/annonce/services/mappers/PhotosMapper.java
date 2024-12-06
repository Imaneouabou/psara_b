package adoption.annonce.services.mappers;

import adoption.annonce.dao.entities.Photos;
import adoption.annonce.services.dto.PhotosDto;
import org.springframework.stereotype.Component;

@Component
public class PhotosMapper {

    // Convertir un DTO en entité
    public Photos toEntity(PhotosDto photosDto) {
        if (photosDto == null) {
            return null;
        }

        Photos photos = new Photos();
        photos.setId(photosDto.getId());
        photos.setUrl(photosDto.getUrl());
        return photos;
    }

    // Convertir une entité en DTO
    public PhotosDto toDto(Photos photos) {
        if (photos == null) {
            return null;
        }

        PhotosDto photosDto = new PhotosDto();
        photosDto.setId(photos.getId());
        photosDto.setUrl(photos.getUrl());
        return photosDto;
    }
}
