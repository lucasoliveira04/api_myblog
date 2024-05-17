package com.my.blog.api_myblog.Services.ListAllProjects;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.my.blog.api_myblog.DTO.ProjectsDto;
import com.my.blog.api_myblog.Model.ProjectsEntity;
import com.my.blog.api_myblog.Repository.ProjectsRepository;

@Service
public class ListAllServices {
    private final ProjectsRepository projectsRepository;

    public ListAllServices(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    // Listando todos os projetos
    public List<ProjectsDto> getAllProjects() {
        List<ProjectsEntity> projectsEntities = projectsRepository.findAll();
        return projectsEntities.stream()
                .map(ProjectsDto::fromEntity)
                .collect(Collectors.toList());
    }

    // Listando projetos pela linguagem
    public List<ProjectsDto> getProjectsByName(String name) {
        List<ProjectsEntity> projectsEntities = projectsRepository.findByLanguageIgnoreCase(name);
        return projectsEntities.stream()
                .map(ProjectsDto::fromEntity)
                .collect(Collectors.toList());
    }

    // Listando projetos pelo framework
    public List<ProjectsDto> getFrameworkByName(String name) {
        List<ProjectsEntity> projectsEntities = projectsRepository.findByFrameworkIgnoreCase(name);
        return projectsEntities.stream()
                .map(ProjectsDto::fromEntity)
                .collect(Collectors.toList());
    }

    // Listando projetos pelo tipo de projeto
    public List<ProjectsDto> getProjectTypeProjects(String name) {
        List<ProjectsEntity> projectsEntities = projectsRepository.findByTypeProjectIgnoreCase(name);
        return projectsEntities.stream()
               .map(ProjectsDto::fromEntity)
               .collect(Collectors.toList());
    }

    // Listando projetos pelo link do projeto
    public List<ProjectsDto> getLinkProject(String name) {
        List<ProjectsEntity> projectsEntities = projectsRepository.findByLinkProjectIgnoreCase(name);
        return projectsEntities.stream()
               .map(ProjectsDto::fromEntity)
               .collect(Collectors.toList());
    }

}
