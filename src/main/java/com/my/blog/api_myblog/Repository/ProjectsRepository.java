package com.my.blog.api_myblog.Repository;

import com.my.blog.api_myblog.Model.ProjectsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectsRepository extends JpaRepository<ProjectsEntity, Long> {
    List<ProjectsEntity> findByLanguageIgnoreCase(String language);
    List<ProjectsEntity> findByFrameworkIgnoreCase(String framework);
}