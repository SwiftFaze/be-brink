package fr.swiftfaze.brink.dao.repository;

import fr.swiftfaze.brink.dao.model.DbProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<DbProject, Long> {
    @Override
    List<DbProject> findAll();

    List<DbProject> findByCompanyId(long companyId);

    Optional<DbProject> findByIdAndCompanyId(long projectId, long companyId);


}
