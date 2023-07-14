package fr.swiftfaze.brink.rest.controller;

import fr.swiftfaze.brink.business.service.AbletonProjectService;
import fr.swiftfaze.brink.rest.dto.AbletonProjectDto;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class AbletonProjectController {


    private static final Logger logger = LoggerFactory.getLogger(AbletonProjectController.class);

    private static final AbletonProjectService abletonProjectService = new AbletonProjectService();

    @GetMapping("/v1/test")
    public ResponseEntity<Void> getTest() throws GitAPIException {

        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/v1/convert")
    public ResponseEntity<AbletonProjectDto> convertAbletonProject(@RequestBody String xmlString) {
        logger.info("POST convert Ableton Project");
        AbletonProjectDto abletonProjectDto = abletonProjectService.convert2AbletonProject(xmlString);
        return new ResponseEntity<>(abletonProjectDto, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping("/v1/projects")
    public ResponseEntity<Void> createAbletonProject(@RequestBody String xmlString) {
        logger.info("POST Create new Ableton Project");
        String repoPath = "~/projects/ableton_test";
        abletonProjectService.createAbletonProject(xmlString, repoPath);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }


//    @PostMapping("/v1/upload")
//    public ResponseEntity<Void> uploadSession(@RequestParam("file") MultipartFile[] files) throws Exception {
//        logger.info("POST Upload Ableton Project");
//
//        if (files == null || files.length == 0) {
//            // Handle empty files error
//            return ResponseEntity.badRequest().build();
//        }
//
//        abletonProjectService.uploadSession(files);
//
//
//        String destinationFolder = "~/projects/ableton_test";
//
//        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
//    }

    @PostMapping("/v1/upload")
    public ResponseEntity<String> uploadFiles(MultipartHttpServletRequest request) {
        try {
            MultiValueMap<String, MultipartFile> multipartFilesMap = request.getMultiFileMap();

            for (Map.Entry<String, List<MultipartFile>> entry : multipartFilesMap.entrySet()) {
                String key = entry.getKey();
                List<MultipartFile> multipartFiles = entry.getValue();

                abletonProjectService.uploadSession(multipartFiles);
//                for (MultipartFile multipartFile : multipartFiles) {
//                    // Perform your desired operations on each file
//                    // For example, you can access the file's properties using methods like getOriginalFilename(), getSize(), etc.
//                    System.out.println("Key: " + key);
//                    System.out.println("Uploaded Filename: " + multipartFile.getOriginalFilename());
//                }
            }

            return ResponseEntity.ok("Files uploaded successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during file upload.");
        }
    }

}
