package fr.swiftfaze.brink.business.mapper;

import fr.swiftfaze.brink.dao.model.DbProject;
import fr.swiftfaze.brink.rest.dto.AbletonProjectDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectMapper {

    private static final Logger logger = LoggerFactory.getLogger(ProjectMapper.class);

    public static AbletonProjectDto convert2Project(DbProject dbProject) {

        AbletonProjectDto project = new AbletonProjectDto();
        mappingProject(project, dbProject);

        return project;
    }

    private static void mappingProject(final AbletonProjectDto project, DbProject dbProject) {

    }





}
