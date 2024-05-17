package com.my.blog.api_myblog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.blog.api_myblog.Model.ProjectsEntity;

public interface ProjectsRepository extends JpaRepository<ProjectsEntity, Long> {
    List<ProjectsEntity> findByLanguageIgnoreCase(String language);
    List<ProjectsEntity> findByFrameworkIgnoreCase(String framework);
    List<ProjectsEntity> findByTypeProjectIgnoreCase(String project);  // Corrigido aqui
    List<ProjectsEntity> findByLinkProjectIgnoreCase(String link);
}
