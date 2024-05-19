package com.my.blog.api_myblog.Services.AddProjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.my.blog.api_myblog.DTO.ProjectsDto;
import com.my.blog.api_myblog.Model.ProjectsEntity;
import com.my.blog.api_myblog.Repository.ProjectsRepository;
import com.my.blog.api_myblog.Services.mail.NotificationSenEmail;

@Service
public class AddProjectServices {

    private final ProjectsRepository projectsRepository;
    private final NotificationSenEmail notificationSenEmail;

    public AddProjectServices(ProjectsRepository projectsRepository, NotificationSenEmail notificationSenEmail) {
        this.projectsRepository = projectsRepository;
        this.notificationSenEmail = notificationSenEmail;
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
            
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String date = now.format(formatter);

            notificationSenEmail.SendEmailPaymentCongratulations(dto.getTitle(), dto.getDescription(), date);
            return "Projeto adicionado com sucesso";
        } catch (Exception e) {
            return "Erro ao adicionar projeto: " + e.getMessage();
        }
    }
}