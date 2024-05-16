package com.my.blog.api_myblog.Services.delete;

import com.my.blog.api_myblog.Repository.ProjectsRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteServices {

    private final ProjectsRepository projectsRepository;

    public DeleteServices(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    public void deleteProjectById(Long projectId) {
        if (projectsRepository.existsById(projectId)){
            projectsRepository.deleteById(projectId);
        } else {
            throw new IllegalArgumentException("Project with id " + projectId + " does not exist");
        }
    }
}
