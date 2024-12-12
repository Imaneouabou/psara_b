package adoption.animalannonce.controller;


import adoption.animalannonce.exception.FunctionalException;
import adoption.animalannonce.services.Service1;
import adoption.animalannonce.services.dto.AnimalAnnonceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class ControllerTest {

    private final Service1 service1;

    @GetMapping("/")
    public String printResult() throws FunctionalException {
        return service1.test();
    }



}
