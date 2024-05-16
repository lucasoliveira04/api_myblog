package com.my.blog.api_myblog.DTO;

import com.my.blog.api_myblog.Model.ProjectsEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

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

    public static ProjectsDto fromEntity(ProjectsEntity entity) {
        ProjectsDto dto = new ProjectsDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setLanguage(entity.getLanguage());
        dto.setFramework(entity.getFramework());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}