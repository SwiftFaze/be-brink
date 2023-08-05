package fr.swiftfaze.brink.rest.dto;

import org.springframework.core.io.ByteArrayResource;

public class AbletonProjectDownloadDataDto {

    private ByteArrayResource projectData;
    private String projectName;

    public ByteArrayResource getProjectData() {
        return projectData;
    }

    public void setProjectData(ByteArrayResource projectData) {
        this.projectData = projectData;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
