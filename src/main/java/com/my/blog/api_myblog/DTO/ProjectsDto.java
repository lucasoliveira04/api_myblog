package com.my.blog.api_myblog.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.my.blog.api_myblog.Model.ProjectsEntity;

import lombok.Data;

/**
 * DTO for {@link com.my.blog.api_myblog.Model.ProjectsEntity}
 */
@Data
public class ProjectsDto implements Serializable {
    private Long id;
    private String title;
    private String description;
    private String language;
    private String framework;
    private LocalDateTime createdAt;
    private String linkProject;
    private String typeProject;

    public static ProjectsDto fromEntity(ProjectsEntity entity) {
        ProjectsDto dto = new ProjectsDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setLanguage(entity.getLanguage());
        dto.setFramework(entity.getFramework());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setLinkProject(entity.getLinkProject());
        dto.setTypeProject(entity.getTypeProject());
        return dto;
    }
}