package org.scrum.domain.repository;

import org.scrum.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepository {
    List<Project> findByproject_id(long id);


}
