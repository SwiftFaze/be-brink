package fr.swiftfaze.brink.business.mapper;

import fr.swiftfaze.brink.dao.model.DbProject;
import fr.swiftfaze.brink.rest.dto.ProjectDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectMapper {

    private static final Logger logger = LoggerFactory.getLogger(ProjectMapper.class);

    public static ProjectDto convert2Project(DbProject dbProject) {

        ProjectDto project = new ProjectDto();
        mappingProject(project, dbProject);

        return project;
    }

    private static void mappingProject(final ProjectDto project, DbProject dbProject) {
        project.setId(dbProject.getId());
        project.setCaseNumber(dbProject.getCaseNumber());
        project.setCompanyId(dbProject.getCompanyId());
        project.setTitle(dbProject.getTitle());
        project.setPrefix(dbProject.getPrefix().toUpperCase());
        project.setOwner(dbProject.getOwner());
        project.setDescription(dbProject.getDescription());
        project.setCreationDate(dbProject.getCreationDate());
        project.setUpdatedDate(dbProject.getUpdatedDate());
    }





}
