package adoption.usermanagementservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import adoption.usermanagementservice.services.dto.ResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FunctionalException.class)
    public ResponseEntity<ResponseDto> handleEntityNotFoundException(FunctionalException ex) {
        ResponseDto responseDto = new ResponseDto(ex.getMessage(), "error");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleGeneralException(Exception ex) {
        ResponseDto responseDto = new ResponseDto("Une erreur inattendue s'est produite.", "error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
    }
}
