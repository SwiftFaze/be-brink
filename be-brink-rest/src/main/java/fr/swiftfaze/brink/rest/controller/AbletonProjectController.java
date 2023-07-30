package fr.swiftfaze.brink.rest.controller;

import fr.swiftfaze.brink.business.service.AbletonProjectService;
import fr.swiftfaze.brink.rest.dto.AbletonProjectDto;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
@RestController
public class AbletonProjectController {


    private static final Logger logger = LoggerFactory.getLogger(AbletonProjectController.class);
    private final AbletonProjectService abletonProjectService;

    public AbletonProjectController(AbletonProjectService abletonProjectService) {
        this.abletonProjectService = abletonProjectService;

    }

    @GetMapping("/v1/test")
    public ResponseEntity<Void> getTest() throws GitAPIException {

        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/v1/projects/convert")
    public ResponseEntity<AbletonProjectDto> convertAbletonProject(@RequestBody String xmlString) {
        logger.info("POST convert Ableton Project");
        AbletonProjectDto abletonProjectDto = this.abletonProjectService.convert2AbletonProject(xmlString);
        return new ResponseEntity<>(abletonProjectDto, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping("/v1/projects/upload")
    public ResponseEntity<Void> uploadFiles(MultipartHttpServletRequest request) throws Exception {
        this.abletonProjectService.uploadFiles(request);

        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("/v1/projects")
    public ResponseEntity<List<String>> getProjects() throws Exception {
        logger.info("GET Get all user projects");
        List<String> projectNameList = this.abletonProjectService.getUserProjectList();
        return new ResponseEntity<>(projectNameList, new HttpHeaders(), HttpStatus.OK);
    }


}


