package fr.swiftfaze.brink.rest.controller;

import fr.swiftfaze.brink.business.service.AbletonProjectService;
import fr.swiftfaze.brink.rest.dto.AbletonProjectDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AbletonProjectController {



    private static final Logger logger = LoggerFactory.getLogger(AbletonProjectController.class);

    private static final AbletonProjectService abletonProjectService = new AbletonProjectService();

    @GetMapping("/v1/test")
    public ResponseEntity<String> getTest() {
        logger.info("GET all Projects");
        return new ResponseEntity<>("Hello world", new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/v1/projects")
    public ResponseEntity<AbletonProjectDto> convertAbletonProject(@RequestBody String xmlString) {
        logger.info("POST convert Ableton Project");
        AbletonProjectDto abletonProjectDto = abletonProjectService.convert2AbletonProject(xmlString);
        return new ResponseEntity<>(abletonProjectDto, new HttpHeaders(), HttpStatus.OK);
    }


}
