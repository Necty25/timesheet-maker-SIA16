package org.scrum.domain.services;

import org.scrum.domain.entity.Project;
import org.scrum.domain.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    public ProjectRepository projectRepository;
    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getprojectbyid(long id){
        return projectRepository.findByproject_id(id);

    }
}