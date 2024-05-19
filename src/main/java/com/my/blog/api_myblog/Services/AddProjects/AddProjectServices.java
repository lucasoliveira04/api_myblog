package com.my.blog.api_myblog.Services.AddProjects;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.my.blog.api_myblog.DTO.ProjectsDto;
import com.my.blog.api_myblog.Model.ProjectsEntity;
import com.my.blog.api_myblog.Repository.ProjectsRepository;
import com.my.blog.api_myblog.Services.email.NotificationEmail;

@Service
public class AddProjectServices {

    private final ProjectsRepository projectsRepository;
    private final NotificationEmail notificationEmail;

    public AddProjectServices(ProjectsRepository projectsRepository, NotificationEmail notificationEmail) {
        this.projectsRepository = projectsRepository;
        this.notificationEmail = notificationEmail;
    }

    public String addProject(ProjectsDto dto) {
        try {
            ProjectsEntity newEntity = new ProjectsEntity();
            newEntity.setTitle(dto.getTitle());
            newEntity.setDescription(dto.getDescription());
            newEntity.setLanguage(dto.getLanguage());
            newEntity.setFramework(dto.getFramework());
            newEntity.setCreatedAt(LocalDateTime.now());
            newEntity.setLinkProject(dto.getLinkProject());
            newEntity.setTypeProject(dto.getTypeProject());
            newEntity.setImgUrl(dto.getImgUrl());
            projectsRepository.save(newEntity);
            notificationEmail.sendMail();
            return "Projeto adicionado com sucesso";
        } catch (Exception e) {
            return "Erro ao adicionar projeto: " + e.getMessage();
        }
    }
}
